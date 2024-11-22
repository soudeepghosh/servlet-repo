package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/test3")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("name");
		String userage = request.getParameter("age");
		String useraddress = request.getParameter("address");

		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:green;text-align:center;'>USER INFORMATION</h1>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>USERNAME</th><th>USERAGE</th><th>USERADDRESS</th></tr>");
		out.println("<tr>");
		out.println("<td>" + username + "</td>");
		out.println("<td>" + userage + "</td>");
		out.println("<td>" + useraddress + "</td>");
		out.println("</tr>");
		out.println("<table>");
		out.close();

	}

}
