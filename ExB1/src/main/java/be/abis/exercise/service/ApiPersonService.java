package be.abis.exercise.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import be.abis.exercise.exception.PersonCanNotBeDeletedException;
import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;
import be.abis.exercise.model.Persons;

@Service
public class ApiPersonService implements PersonService {

	Logger logger = LoggerFactory.getLogger(ApiPersonService.class);
	
	@Autowired 
	private RestTemplate rt;

	private static final String BASEURI="http://localhost:8085/exercise/api/persons";
	
	@Override
	public ArrayList<Person> getAllPersons() {
		logger.info("getAllPersons");
		ResponseEntity<List<Person>> personsApi = rt.exchange(BASEURI, HttpMethod.GET,null, new ParameterizedTypeReference<List<Person>>() {});
		ArrayList<Person> personList = (ArrayList<Person>) personsApi.getBody();
		logger.info("getAllPersons : personList {}",personList != null ? personList.size() : "null");
		return personList;
	}

	@Override
	public Person findPerson(int id) {
		Person person = rt.getForObject(BASEURI +"/" + id,Person.class);
		return person;
	}

	@Override
	public Person findPerson(String emailAddress, String passWord) {
		Login login = new Login();
		login.setEmail(emailAddress);
		login.setPassword(passWord);
		logger.info("findPerson {} {}", emailAddress,  passWord );
		Person person = rt.postForObject(BASEURI +"/login",login,Person.class);
		logger.info("findPerson found {}",  person != null ? person.toString() : "not found");
		return person;
	}

	@Override
	public void addPerson(Person p) throws IOException {
		logger.info("addPerson {}", p != null ? p.toString() : "null");
		rt.postForObject(BASEURI , p, Void.class);

	}

	@Override
	public void deletePerson(int id) throws PersonCanNotBeDeletedException {
		// TODO Auto-generated method stub

	}

	@Override
	public void changePassword(Person p, String newPswd) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public Person login(Login login) {
		// TODO Auto-generated method stub
		return null;
	}

}
