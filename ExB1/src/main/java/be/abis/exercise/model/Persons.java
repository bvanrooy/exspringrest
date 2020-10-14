package be.abis.exercise.model;

import java.util.ArrayList;
import java.util.List;

public class Persons {
	
	private List<Person> persons;

	public Persons() {
		persons = new ArrayList<>();
	}
	
	public Persons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	
	

}
