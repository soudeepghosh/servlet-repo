package com.pwskills.nitin;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.pwskills.nitin.controller.IStudentController;
import com.pwskills.nitin.dataobjects.StudentVo;
import com.pwskills.nitin.factory.StudentControllerFactory;

//UI PAGE :: standalone
public class MainApp {

	// main() : driver code
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		IStudentController controller = StudentControllerFactory.getStudentControllerObj();

		while (true) {
			System.out.println("*********WELCOMET TO STUDENT APPLICATION*****");
			System.out.println("1. INSERT");
			System.out.println("2. READ");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER YOUR CHOICE[1/2/3/4/5]:: ");
			String option = br.readLine();

			switch (option) {
			case "1":
				insertRecord(br, controller);
				break;
				
			case "2":
				readRecord(br, controller);
				break;
				
			case "3":
				updateRecord(br, controller);
				break;
				
			case "4":
				deleteRecord(br, controller);
				break;
				
			case "5":
				System.out.println("***THANKS FOR USING THE APPLICATION****");
				System.exit(0);
				
			default:
				break;
			}
		}
	}

	private static void updateRecord(BufferedReader br, IStudentController controller) throws Exception {
		System.out.print("Enter the id:: ");
		String id = br.readLine();

		StudentVo voDB = controller.readRecord(id);
		if (voDB != null) {

			// updation possible
			StudentVo voForUpdation = new StudentVo();

			// ID should not be altered :: PK
			System.out.println("STUDENT ID :: " + voDB.getSid());
			voForUpdation.setSid(voDB.getSid());

			// Asking for updation :: Name
			System.out.print("STUDENT OLDNAME IS :: " + voDB.getSname() + "  ENTER NEW NAME :: ");
			String newName = br.readLine();
			if (newName.equals("") || newName == "") {
				voForUpdation.setSname(voDB.getSname());
			} else {
				voForUpdation.setSname(newName);
			}

			// Asking for updation :: Age
			System.out.print("STUDENT AGE IS :: " + voDB.getSage() + "  ENTER NEW AGE :: ");
			String newAge = br.readLine();
			if (newAge.equals("") || newAge == "") {
				voForUpdation.setSage(voDB.getSage());
			} else {
				voForUpdation.setSage(newAge);
			}

			// Asking for updation :: Address
			System.out.print("STUDENT ADDRESS IS :: " + voDB.getSaddress() + "  ENTER NEW ADDRESS :: ");
			String newAddress = br.readLine();
			if (newAddress.equals("") || newAddress == "") {
				voForUpdation.setSaddress(voDB.getSaddress());
			} else {
				voForUpdation.setSaddress(newAddress);
			}
			System.out.println("Record sending for updation is :: "+voForUpdation);
			
			String status = controller.updateRecord(voForUpdation);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("Record updated succefully for the id :: " + id);
			} else {
				System.out.println(status);
			}

		} else {
			System.out.println("Record not available for updation :: " + id);
		}

	}

	private static void deleteRecord(BufferedReader br, IStudentController controller) throws Exception {
		System.out.print("Enter the id:: ");
		String id = br.readLine();

		String status = controller.deleteRecord(id);
		if (status.equalsIgnoreCase("success")) {
			System.out.println("Record deleted succesfully...");
		} else
			System.out.println(status);
	}

	private static void readRecord(BufferedReader br, IStudentController controller) throws Exception {

		System.out.print("Enter the id:: ");
		String id = br.readLine();
		StudentVo studentVo = controller.readRecord(id);

		if (studentVo != null) {
			System.out.println(studentVo);
		} else {
			System.out.println("Record not found for the given id :: " + id);
		}
	}

	private static void insertRecord(BufferedReader br, IStudentController controller) throws Exception {

		System.out.print("Enter the sname:: ");
		String sname = br.readLine();

		System.out.print("Enter the sage:: ");
		String sage = br.readLine();

		System.out.print("Enter the saddress:: ");
		String saddress = br.readLine();

		StudentVo stdVo = new StudentVo();
		stdVo.setSname(sname);
		stdVo.setSaddress(saddress);
		stdVo.setSage(sage);

		System.out.println("****SENDING VO TO CONTROLLER*****");
		String status = controller.insertRecord(stdVo);
		if (status.equalsIgnoreCase("success")) {
			System.out.println("Record inserted succesfully...");
		} else {
			System.out.println(status);
		}
	}
}
