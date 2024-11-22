package in.pwskills.nitin.repository;

import in.pwskills.nitin.dataobjects.StudentBO;

public interface IStudentRepo {
	public String insertRecord(StudentBO stdBo);
	public StudentBO readRecord(Integer sid);
	public String deleteRecord(Integer sid);
	public String updateRecord(StudentBO stdBo);

}
