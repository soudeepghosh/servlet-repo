package in.pwskills.nitin.service;

import in.pwskills.nitin.dataobjects.StudentDto;

public interface IStudentService {
	public String insertRecord(StudentDto stdDto);
	public StudentDto readRecord(Integer sid);
	public String deleteRecord(Integer sid);
	public String updateRecord(StudentDto stdDto);

}
