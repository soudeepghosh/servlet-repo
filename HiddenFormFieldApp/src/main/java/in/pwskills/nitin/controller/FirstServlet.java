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
@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("name");

		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:cyan; text-align:center;'>Welcome ::" + username + "</h1>");
		out.println("<h1 style='color:cyan; text-align:center;'>PLZ ENTER YOUR AGE</h1>");
		out.println("<form method='get' action='./test2'>");
		out.println("<table align='center'>");
		out.println("<input type='hidden' name='name' value='" + username + "' />");

		out.println("<tr><th>ENTER AGE</th><td><input type='number' name='age'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='continue'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.close();

	}

}
