package com.pwskills.nitin.controller;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

import com.pwskills.nitin.dataobjects.StudentDto;
import com.pwskills.nitin.dataobjects.StudentVo;
import com.pwskills.nitin.factory.StudentServiceFactory;
import com.pwskills.nitin.service.IStudentService;

public class StudentControllerImpl implements IStudentController {

	@Override
	public String insertRecord(StudentVo stdVo) {

		System.out.println();

		// Convert the VO into DTO and send it to Service Layer
		StudentDto studentDto = new StudentDto();

		studentDto.setSage(Integer.parseInt(stdVo.getSage()));
		studentDto.setSname(stdVo.getSname());
		studentDto.setSaddress(stdVo.getSaddress());

		System.out.println("*****SENDING DTO to SEERVICE LAYER******\n");
		IStudentService service = StudentServiceFactory.getStudentService();
		return service.insertRecord(studentDto);
	}

	@Override
	public StudentVo readRecord(String sid) {

		IStudentService service = StudentServiceFactory.getStudentService();

		StudentDto dto = null;
		StudentVo vo = null;

		dto = service.readRecord(Integer.parseInt(sid));

		if (dto == null) {
			return vo;
		} else {
			// convert dto to vo and send
			vo = new StudentVo();
			try {
				BeanUtils.copyProperties(vo, dto);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return vo;
		}
	}

	@Override
	public String deleteRecord(String sid) {
		IStudentService service = StudentServiceFactory.getStudentService();
		String status = service.deleteRecord(Integer.parseInt(sid));
		return status;
	}

	@Override
	public String updateRecord(StudentVo stdVo) {
		IStudentService service = StudentServiceFactory.getStudentService();

		// Convert the VO into DTO and send it to Service Layer
		StudentDto studentDto = new StudentDto();

		studentDto.setSid(Integer.parseInt(stdVo.getSid()));
		studentDto.setSage(Integer.parseInt(stdVo.getSage()));
		studentDto.setSname(stdVo.getSname());
		studentDto.setSaddress(stdVo.getSaddress());

		return service.updateRecord(studentDto);
	}
}
