package io.spring.rest.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.spring.rest.model.Student;

public class Driver {
	public static void main(String[] args) {
		
		// create object mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// read JSON file and map/convert to JAVA POJO
		Student student = null;
		try {
			 student = mapper.readValue(new File("src\\io\\spring\\rest\\data\\student.json"), Student.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// print first name and last name
		System.out.println("First Name: " + student.getFirstName());
		System.out.println("Last Name: " + student.getLastName());
	}
}
