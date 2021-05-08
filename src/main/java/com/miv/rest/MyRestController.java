package com.miv.rest;

import com.miv.entity.Address;
import com.miv.entity.Person;
import com.miv.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private PersonService personService;

    @Autowired
    public MyRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/addresses/{id}")
    public List<Address> getAddresses(@PathVariable("id") int id) {
        System.out.println("Somebody just made a request to the rest api...");
        Person person = personService.getById(id);
        List<Address> addresses = person.getAddresses();
        System.out.println("Person addresses: " + addresses);
        return addresses;
    }
}
