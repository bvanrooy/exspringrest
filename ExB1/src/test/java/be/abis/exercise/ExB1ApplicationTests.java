package be.abis.exercise;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import be.abis.exercise.model.Login;
import be.abis.exercise.model.Person;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ExB1ApplicationTests {

	@Autowired
	private RestTemplate rt;
	
	private static final String BASEURI="http://localhost:8085/exercise/api/persons";
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testLogin() {
		Login login = new Login();
		Person person;
		
		login.setEmail("jdoe@abis.be");
		login.setPassword("def456");
		person = rt.postForObject(BASEURI +"/login",login,Person.class);
		
		assertNotNull(person);
	}

}
