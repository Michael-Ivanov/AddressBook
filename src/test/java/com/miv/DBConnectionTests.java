package com.miv;

import com.miv.entity.Address;
import com.miv.entity.Person;
import com.miv.repository.PersonRepository;
import com.miv.service.PersonService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestMethod;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DBConnectionTests {

    private Person person;
    private Address address;

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PersonService personService;

    @BeforeEach
    private void createPersonAndAddress() {
        person = new Person();
        address = new Address();
    }

    @Test
    public void shouldConnectToDb() throws SQLException {
        assertNotNull(dataSource.getConnection());
    }

    @Test
    @Transactional
    public void shouldSaveAndRetrieveNewPersonWithAddressFromDB() {

        address.setId(999);
        address.setCountry("UK");
        address.setZipCode(55436);
        address.setCity("Oxford");
        address.setStreet("Great Clarendon St 55");

        person.setId(999);
        person.setFirstName("Mike");
        person.setLastName("Smith");
        person.setBirthday(Date.valueOf("1984-10-02"));
        person.setPhoneNumber("+7234234444333");
        person.addAddress(address);
        personService.savePerson(person);

        Person testPerson = personService.getById(999);
        System.out.println("test output >>> " + testPerson.getAddresses());
        assertEquals("Mike", testPerson.getFirstName());
        assertEquals("Smith", testPerson.getLastName());
        assertEquals("+7234234444333", testPerson.getPhoneNumber());

        Address testAddress = testPerson.getAddresses().get(0);
        assertEquals("Oxford", testAddress.getCity());
        assertEquals(55436, testAddress.getZipCode());
    }

}
