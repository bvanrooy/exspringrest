package be.abis.exercise.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.service.PersonService;

@RestController
public class PersonController {

	@Autowired
	PersonService personService;
	
	@GetMapping("/persons/{id}")
	public Person findPerson(@PathVariable("id") int id) {
		return personService.findPerson(id);
	}
	
	@PostMapping("/persons")
	public void addPerson(@RequestBody Person person) throws IOException {
		personService.addPerson(person);
	}
	
	@GetMapping("/persons")
	public List<Person> getAllPersons(){
		return personService.getAllPersons();
	}
	
	@PutMapping("/persons/{id}")
	public void changePassword(@PathVariable("id") int id, @RequestBody Person person) throws Exception {
		Person personFound = personService.findPerson(id);
		if(personFound.getPersonId()==person.getPersonId()) {
			String newPswd = person.getPassword(); 
			personService.changePassword(person,newPswd);
		}
		else {
			throw new Exception("In correct data");
		}
	}
	
	@DeleteMapping("/persons/{id}")
	public void deletePerson(@PathVariable("id") int id) throws PersonCanNotBeDeletedException {
		personService.deletePerson(id);
	}
	
		
	@PostMapping("/persons/login")
	public Person login(@RequestBody Login login) {
		return personService.login(login);
	}
}
