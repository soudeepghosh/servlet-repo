package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet1
 */
@WebServlet("/test1")
public class SessionServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		if (session.isNew()) {
			out.println("<h1 style='color:red; text-align:center';>New Session got created with the id ::"
					+ session.getId() + "</h1>");
		} else {

			out.println("<h1 style='color:red; text-align:center';>Existing Session only using with session id ::"
					+ session.getId() + "</h1>");
		}

		String name = request.getParameter("name");
		String value = request.getParameter("value");

		session.setAttribute(name, value);

		// 30seconds after which session object expired
		//session.setMaxInactiveInterval(30);
		
		RequestDispatcher rd = request.getRequestDispatcher("./index.html");
		rd.forward(request, response);

		out.close();
	}

}
