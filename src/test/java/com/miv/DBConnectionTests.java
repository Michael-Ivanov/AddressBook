package com.miv;

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

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PersonService personService;

    @Test
    public void shouldConnectToDb() throws SQLException {
        assertNotNull(dataSource.getConnection());
    }

    @Test
    @Transactional
    public void shouldSaveAndRetrieveNewPersonFromDB() {
        Person person = new Person(
                999,
                "Mike",
                "Smith",
                Date.valueOf("1984-10-02"),
                "+7234234444333");
        personService.savePerson(person);

        Person testPerson = personService.getById(999);
        assertEquals("Mike", testPerson.getFirstName());
        assertEquals("Smith", testPerson.getLastName());
        assertEquals("+7234234444333", testPerson.getPhoneNumber());
    }


}
