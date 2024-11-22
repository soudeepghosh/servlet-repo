package in.pwskills.nitin.factory;

import in.pwskills.nitin.service.IStudentService;
import in.pwskills.nitin.service.StudentServiceImpl;

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
