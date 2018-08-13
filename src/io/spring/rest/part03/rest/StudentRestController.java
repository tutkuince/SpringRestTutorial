package io.spring.rest.part03.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.spring.rest.part03.model.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> studentList;

	// define @PostConstructor to load the student data. . . only once!
	@PostConstruct
	public void loadData() {
		// sample students
		studentList = new ArrayList<>();
		studentList.add(new Student("Tutku", "Ince"));
		studentList.add(new Student("Utku", "Ince"));
		studentList.add(new Student("Emin", "Koklu"));
		studentList.add(new Student("Ugur", "Batikan"));
	}

	// define endpoint for "/students" - return list of students
	@GetMapping("/students")
	public List<Student> getStudents() {
		return studentList;
	}

	// define endpoint for "/students/{studentId} - return Student object
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {

		// check the studentId against list size
		if ((studentId >= studentList.size()) || (studentId < 0))
			throw new StudentNotFoundException("Student id not found - " + studentId);

		return studentList.get(studentId);
	}
}
