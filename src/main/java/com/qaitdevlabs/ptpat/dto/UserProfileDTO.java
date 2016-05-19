package com.qaitdevlabs.ptpat.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.qaitdevlabs.ptpat.validator.FieldMatch;

@FieldMatch.List({ @FieldMatch(first = "password", second = "confirmPassword", message = "Password doesn\'t match with confirm password") })
public class UserProfileDTO {

	@Email(message = "Please enter a valid Email Address.")
	@NotEmpty(message = "This field is required")
	private String username;

	@Length(min = 6, message = "Please enter atleast 6 characters")
	private String password;

	@Length(min = 6, message = "Please enter atleast 6 characters")
	private String confirmPassword;

	@NotEmpty(message = "This field is required.")
	private String firstName;

	@NotEmpty(message = "This field is required.")
	private String lastName;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
