package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet1
 */
@WebServlet("/test2")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);

		if (session == null) {
			out.println("<h1 style='color:red; text-align:center;'>No session information is available</h1>");
		} else {
			Enumeration<String> attributeNames = session.getAttributeNames();
			out.println("<h1 style='color:red; text-align:center;'>SESION INFORMATION</h1>");
			out.println("<table align='center' border='1'>");
			out.println("<tr><th>ATTRIBUTENAME</th><th>ATTRIBUTEVALUE</th></tr>");
			while (attributeNames.hasMoreElements()) {
				out.println("<tr>");
				String attributeName = (String) attributeNames.nextElement();
				Object value = session.getAttribute(attributeName);

				out.println("<td>" + attributeName + "</td>");
				out.println("<td>" + value + "</td>");

				out.println("</tr>");
			}
			out.println("</table>");
		}

		out.close();
	}

}
