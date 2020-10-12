package be.abis.exercise.hellorest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.hellorest.model.Person;
import be.abis.exercise.hellorest.service.PersonService;

@RestController
public class ApiController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/person/{id}")
	public Person findPerson(@PathVariable("id")int id) {
		return personService.getPersonById(id);
	}
}
