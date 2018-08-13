package io.spring.rest.part01.main;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.spring.rest.part01.model.Address;
import io.spring.rest.part01.model.Student;

public class Driver {
	public static void main(String[] args) {
		
		// create object mapper
		ObjectMapper mapper = new ObjectMapper();
		
		// read JSON file and map/convert to JAVA POJO
		Student student = null;
		try {
			 student = mapper.readValue(new File("src\\io\\spring\\rest\\part01\\data\\student.json"), Student.class);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// print first name and last name
		System.out.println("First Name: " + student.getFirstName());
		System.out.println("Last Name: " + student.getLastName());
		
		// print out address: street and city
		Address address = student.getAddress();
		
		System.out.println("Street: " + address.getStreet());
		System.out.println("City: " + address.getCity());
	}
}
