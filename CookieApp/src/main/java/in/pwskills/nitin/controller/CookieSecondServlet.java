package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class CookieSecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		Cookie[] cookies = request.getCookies();
		if (cookies==null) {
			out.println("<h1 style='color:red; text-align:center;'>NO COOKIES ARE ASSOICATED WITH REQUEST OBJECT</h1>");
		} else {
			out.println("<h1 style='color:green; text-align:center;'>COOKIE INFORMATION</h1>");
			out.println("<table border='1' align='center'>");
			out.println("<tr><th>COOKIENAME</th><th>COOKIEVALUE</th></tr>");
			for (Cookie cookie : cookies) {
				out.println("<tr>");
				String name = cookie.getName();
				String value = cookie.getValue();
				out.println("<td>"+name+"</td>");
				out.println("<td>"+value+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");	
		}
		out.close();
	}

}
