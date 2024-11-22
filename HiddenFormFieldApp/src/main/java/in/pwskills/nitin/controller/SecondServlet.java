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
@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("name");
		String userage = request.getParameter("age");
		

		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:cyan; text-align:center;'>Welcome  ::" + username + "</h1>");
		out.println("<h1 style='color:cyan; text-align:center;'>YOUR AGE ::" + userage + "</h1>");
		out.println("<h1 style='color:cyan; text-align:center;'>PLZ ENTER YOUR ADDRESS</h1>");
		out.println("<form method='get' action='./test3'>");
		out.println("<table align='center'>");
		out.println("<input type='hidden' name='name' value='" + username + "' />");
		out.println("<input type='hidden' name='age' value='"  + userage + "' />");

		out.println("<tr><th>ENTER ADDRESS</th><td><input type='text' name='address'/></td></tr>");
		out.println("<tr><th></th><td><input type='submit' value='display'/></td></tr>");
		out.println("</table>");
		out.println("</form>");
		out.close();

	}

}
