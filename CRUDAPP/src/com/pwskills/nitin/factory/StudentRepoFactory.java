package com.pwskills.nitin.factory;

import com.pwskills.nitin.repository.IStudentRepo;
import com.pwskills.nitin.repository.StudentRepoImpl;

public class StudentRepoFactory {

	private static StudentRepoImpl studentRepo = null;

	private StudentRepoFactory() {

	}

	// Singleton pattern
	public static IStudentRepo getStudentRepo() {
		if (studentRepo == null) {
			studentRepo = new StudentRepoImpl();
		}
		return studentRepo;
	}
}
