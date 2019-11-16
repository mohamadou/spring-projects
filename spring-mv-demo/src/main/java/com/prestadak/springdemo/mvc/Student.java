package com.prestadak.springdemo.mvc;

import java.util.Arrays;
import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Student {
	
	private String firstName;
	
	@NotNull
	@Size(min=1, message="Is required")
	private String lastName;
	
	private String favoriteLanguage;
	private LinkedHashMap<String, String> favoriteLanguageOptions;
	private String[] operatingSystems;
	
	public Student() {
		this.favoriteLanguageOptions = new LinkedHashMap<String, String>();
		this.favoriteLanguageOptions.put("Java", "Java");
		this.favoriteLanguageOptions.put("C#", "C#");
		this.favoriteLanguageOptions.put("PHP", "PHP");
		this.favoriteLanguageOptions.put("Python", "Python");
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

	public String getFavoriteLanguage() {
		return favoriteLanguage;
	}

	public void setFavoriteLanguage(String favoriteLanguage) {
		this.favoriteLanguage = favoriteLanguage;
	}

	public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
		return favoriteLanguageOptions;
	}

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	@Override
	public String toString() {
		return "Student [firstName=" + firstName + ", lastName=" + lastName + ", favoriteLanguage=" + favoriteLanguage
				+ ", favoriteLanguageOptions=" + favoriteLanguageOptions + ", operatingSystems="
				+ Arrays.toString(operatingSystems) + "]";
	}
	
	
	
	
	

	
}
