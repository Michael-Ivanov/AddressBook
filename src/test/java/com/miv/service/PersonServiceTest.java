package com.miv.service;

import com.miv.entity.Address;
import com.miv.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PersonServiceTest {

    private Person person;
    private Address address;
    @Autowired
    private PersonService personService;

    @BeforeEach
    public void shouldSavePersonAndAddress() {
        person = new Person();
        address = new Address();
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
        Person tempPerson = personService.savePerson(person);
        assertNotNull(tempPerson);
        assertEquals("Mike", tempPerson.getFirstName());
    }

    @Test
    public void shouldRetrieveNewPersonWithAddress() {

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