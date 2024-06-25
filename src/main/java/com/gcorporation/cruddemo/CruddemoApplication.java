package com.gcorporation.cruddemo;

import com.gcorporation.cruddemo.dao.StudentDAO;
import com.gcorporation.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			//	createStudent(studentDAO);

			// readStudent(studentDAO);

			// queryForStudents(studentDAO);

			updateStdent(studentDAO);
		};
	}

	private void updateStdent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "John"
		System.out.println("Updating student ...");
		myStudent.setFirstName("John");

		// update the student
		studentDAO.update((myStudent));

		//display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students

		List<Student> theStudents = studentDAO.findAll();

		// display list of students

		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student( "Prabhjot", "Singh", "gcorporation.com");

		// save the student Object
		System.out.println("Svaing the student ... ");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student. Generated id: " + theId);

		// retrieve student based on id: primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: " + myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student( "Paul", "Doe", "gcorporation.com");

		// save the student Object
		System.out.println("Svaing the student ... ");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: " + tempStudent.getId());
	}
}
