package com.miv.controller;

import com.miv.entity.Person;
import com.miv.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private PersonService personService;

    @Autowired
    public HomeController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String displayHomePage(Model model) {
        List<Person> personList = personService.getAll();
        model.addAttribute(personList);
        return "home";
    }

    @GetMapping("/simple")
    public String simpleTest() {
        return "simple-test";
    }
}
