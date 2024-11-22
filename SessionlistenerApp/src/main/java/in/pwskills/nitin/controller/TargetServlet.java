package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pwskills.nitin.listener.SessionCounter;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/target")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60);//destroy session object after 60seconds

		out.println("<h1 style='color:red; text-align:center;'>The no of users in a session is ::"
				+ SessionCounter.count + "</h1>");
		out.close();

	}

}
