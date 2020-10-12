package be.abis.exercise.hellorest.service;

import org.springframework.stereotype.Service;

import be.abis.exercise.hellorest.model.Person;

@Service
public class AbisPersonService implements PersonService {

	@Override
	public Person getPersonById(int id) {
		return new Person("Bart","Van Rooy");
	}

}
