package in.pwskills.nitin.factory;

import in.pwskills.nitin.repository.IStudentRepo;
import in.pwskills.nitin.repository.StudentRepoImpl;

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
