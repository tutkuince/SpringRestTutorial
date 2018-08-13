package io.spring.rest.part03.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
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

	// Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc) {

		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

	// add another exception handler . . . to catch any exception (catch all)
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc) {

		// create a StudentErrorResponse
		StudentErrorResponse error = new StudentErrorResponse();

		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());

		// return ResponseEntity
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
