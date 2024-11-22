package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("username");
		String pwd = request.getParameter("userpwd");
		
		PrintWriter out = response.getWriter();
		
		//validation
		if (name.equalsIgnoreCase("sachin")&& pwd.equals("tendulkar")) {
			out.println("<h1 style='color:green; text-align:center;'>AVAIL THE SERVICES OF PWSKILLS....</h1>");
		} else {
			response.sendError(401);
		}
		
		out.close();
	}
}
