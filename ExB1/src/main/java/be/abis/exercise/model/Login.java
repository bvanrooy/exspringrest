package be.abis.exercise.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Login {
	
	@NotBlank(message="email cannot be empty")
	@Email(message="email has to be valid")
	@JsonProperty("emailAddress")
	private String email;
	@NotBlank(message="password cannot be empty")
	private String password;
	

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

	

}
