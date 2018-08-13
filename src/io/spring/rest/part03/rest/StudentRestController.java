package io.spring.rest.part03.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.rest.part03.model.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// define endpoint for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {

		// sample students
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("Tutku", "Ince"));
		studentList.add(new Student("Utku", "Ince"));
		studentList.add(new Student("Emin", "Koklu"));
		studentList.add(new Student("Ugur", "Batikan"));

		return studentList;
	}
}
