package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestParameterApp
 */
@WebServlet(description = "Working with RequestObject",
			urlPatterns = { "/input" }, 
			loadOnStartup = 5)
public class RequestParameterApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Loading:: RequestParameterApp.class file loading...");
	}
	
	public RequestParameterApp() {
		System.out.println("Instantiation :: RequestParameterApp()...");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("Initialization... :: init()-> Zero param");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("De-Instantiation :: destroy()");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcesing :: RequestParameterApp.doPost()...");

		// Collect the inputs from request object for processing
		String username = request.getParameter("username");
		String contactnumber = request.getParameter("contactnumber");
		String[] courses = request.getParameterValues("courses");
		String status = "Registration Succesfull";

		// Generate a table response to the enduser
		PrintWriter out = response.getWriter();
		out.println("<body align='center' bgcolor='cyan'>");
		out.println("<h1>STUDENT REGISTRATION STATUS</h1>");
		out.println("<table align='center' border='1'>");
		out.println("<tr><th>NAME</th><th>CONTACTNUMBER</th><th>COURSES</th><th>STATUS</th></tr>");
		out.println("<tr>");
		out.println("<td>" + username + "</td>");
		out.println("<td>" + contactnumber + "</td>");
		out.println("<td>");

		for (String course : courses) {
			course = course + "\n";
			out.println(course + "<br/>");
		}
		out.println("</td>");
		out.println("<td>" + status + "</td>");

		out.println("</tr>");
		out.println("</table>");
		out.println("</body>");

		// closing the writer object
		out.close();
	}
}
