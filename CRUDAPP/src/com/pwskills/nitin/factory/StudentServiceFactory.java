package com.pwskills.nitin.factory;

import com.pwskills.nitin.service.IStudentService;
import com.pwskills.nitin.service.StudentServiceImpl;

public class StudentServiceFactory {

	private static IStudentService studentService = null;

	private StudentServiceFactory() {

	}

	public static IStudentService getStudentService() {
		if (studentService == null) {
			studentService = new StudentServiceImpl();
		}
		return studentService;
	}

}
