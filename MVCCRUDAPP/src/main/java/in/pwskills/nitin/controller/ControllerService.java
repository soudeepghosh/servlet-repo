package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.pwskills.nitin.dataobjects.StudentDto;
import in.pwskills.nitin.factory.StudentServiceFactory;
import in.pwskills.nitin.service.IStudentService;

/**
 * Servlet implementation class ControllerService
 */
@WebServlet("/controller/*")
public class ControllerService extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		IStudentService stdService = StudentServiceFactory.getStudentService();

		System.out.println("Request URI :: " + request.getRequestURI());
		System.out.println("PathInfo    :: " + request.getPathInfo());

		// Requesting for :: addform
		if (request.getRequestURI().endsWith("addform")) {

			// Collecting the inputs
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddr");

			// Creating a dto to transfer to service layer
			StudentDto dto = new StudentDto();
			dto.setSaddress(saddress);
			dto.setSname(sname);
			dto.setSage(Integer.parseInt(sage));

			// requesting service layer to perform operation
			String status = stdService.insertRecord(dto);
			System.out.println(status);

			RequestDispatcher rd = null;

			// Redirecting to suitable pages based on the result
			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../success.html");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../failure.html");
				rd.forward(request, response);
			}
		}

		// Requesting for :: searchform
		if (request.getRequestURI().endsWith("searchform")) {
			String sid = request.getParameter("sid");
			PrintWriter out = response.getWriter();

			StudentDto dto = stdService.readRecord(Integer.parseInt(sid));

			if (dto != null) {
				out.println("<body>");
				out.println("<br/><br/><br/><br/>");
				out.println("<center>");
				out.println("<table border='1'>");
				out.println("<tr><th>SID</th><td>" + dto.getSid() + "</td></tr>");
				out.println("<tr><th>SNAME</th><td>" + dto.getSname() + "</td></tr>");
				out.println("<tr><th>SAGE</th><td>" + dto.getSage() + "</td></tr>");
				out.println("<tr><th>SADDRESS</th><td>" + dto.getSaddress() + "</td></tr>");
				out.println("</table>");
				out.println("</center>");
				out.println("</body>");

			} else {
				out.println("<h1 style='color:red; text-align:center;'>RECORD NOT FOUND FOR THE GIVEN ID :: " + sid
						+ "</h1>");
			}
			out.close();
		}

		// Requesting for :: deleteform
		if (request.getRequestURI().endsWith("deleteform")) {

			String sid = request.getParameter("sid");
			String status = stdService.deleteRecord(Integer.parseInt(sid));

			System.out.println(status);

			RequestDispatcher rd = null;

			// Redirecting to suitable pages based on the result
			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../deletesuccess.html");
				rd.forward(request, response);
			} else if (status.equals("failure")) {
				rd = request.getRequestDispatcher("../deletefailure.html");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../deletenotfound.html");
				rd.forward(request, response);
			}

		}

		// Requesting for :: editform
		if (request.getRequestURI().endsWith("editform")) {

			String sid = request.getParameter("sid");

			StudentDto stdDB = stdService.readRecord(Integer.parseInt(sid));
			PrintWriter out = null;
			if (stdDB != null) {
				// Display UI Page to render old details of the user
				out = response.getWriter();
				out.println("<body>");
				out.println("<center>");
				out.println("<form action='./controller/updateRecord' method='post'>");
				out.println("<table>");
				out.println("<tr><th>SID</th><td><input type='text' name='sid' value='" + stdDB.getSid()
						+ "' readonly/></td></tr>");
				out.println("<tr><th>SNAME</th><td><input type='text' name='sname' value='" + stdDB.getSname()+ "' /></td></tr>");
				out.println("<tr><th>SAGE</th><td><input type='text' name='sage' value='" + stdDB.getSage()+ "' /></td></tr>");
				out.println("<tr><th>SADDRESS</th><td><input type='text' name='saddress' value='" + stdDB.getSaddress()+ "' /></td></tr>");
				out.println("<tr><th></th><th><input type='submit' value='update'/></th></tr>");
				out.println("</table>");
				out.println("</form>");
				out.println("</center>");
				out.println("</body>");

			} else {
				// display updation not possible
				out = response.getWriter();
				out.println("<body>");
				out.println("<h1 style='color:red; text-align:center;'>Record not available for the given id ::" + sid
						+ "</h1>");
				out.println("</body>");
			}
		}
		
		
		//Request for :: updateRecord
		if (request.getRequestURI().endsWith("updateRecord")) {
			
			//Collect the inputs from UI Page
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddress");
			
			
			//Store the input to DTO
			StudentDto dto = new StudentDto();
			dto.setSid(Integer.parseInt(sid));
			dto.setSname(sname);
			dto.setSaddress(saddress);
			dto.setSage(Integer.parseInt(sage));
			
			//Calling the service to perform update operation
			String status = stdService.updateRecord(dto);
			System.out.println(status);

			RequestDispatcher rd = null;

			// Redirecting to suitable pages based on the result
			if (status.equals("success")) {
				rd = request.getRequestDispatcher("../../updatesuccess.html");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("../../updatefailure.html");
				rd.forward(request, response);
			}
			
			
		}
		
	}
}
