package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test1")
public class CookieFirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String name = request.getParameter("name");
		String value = request.getParameter("value");

		Cookie c1 = new Cookie(name, value);
		
		// cookie available only for 30 seconds
		c1.setMaxAge(30);
		
		response.addCookie(c1);
		out.println("<h1 style='color:green; text-align:center;'>Cookie added succesfuly...</h1>");

		RequestDispatcher rd = request.getRequestDispatcher("./index.html");
		rd.forward(request, response);

		out.close();
	}

}
