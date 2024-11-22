package com.pwskills.nitin.factory;

import com.pwskills.nitin.controller.IStudentController;
import com.pwskills.nitin.controller.StudentControllerImpl;

public class StudentControllerFactory {

	private static IStudentController controller = null;

	public static IStudentController getStudentControllerObj() {
		if (controller == null) {
			controller = new StudentControllerImpl();
		}
		return controller;
	}

}
