package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("RequestProcessing :: SecondServlet.doGet()");

		PrintWriter out = response.getWriter();
		out.println("<body align='center' bgcolor='green'>");
		out.println("<h1 style='text-align:center;'>SERVLETCONTEXT DATA::" + getServletContext() + "</h1>");
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>PARAMETERNAME</th><th>PARAMETERVALUE</th></tr>");

		ServletContext context = getServletContext();
		Enumeration<String> parameterNames = context.getInitParameterNames();

		while (parameterNames.hasMoreElements()) {
			out.println("<tr>");

			String parameterName = (String) parameterNames.nextElement();
			Object parameterValue = context.getInitParameter(parameterName);
			out.println("<td>" + parameterName + "</td>");
			out.println("<td>" + parameterValue + "</td>");

			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.close();

	}

}
