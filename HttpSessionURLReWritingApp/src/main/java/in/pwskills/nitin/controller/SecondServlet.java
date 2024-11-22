package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		String uname = request.getParameter("name");
		String msg = "";

		LocalDateTime time = LocalDateTime.now();
		int hour = time.getHour();
		if (hour < 12) {
			msg += "Good Morning :: " + uname;
		} else if (hour < 16) {
			msg += "Good Afternoon :: " + uname;
		} else if (hour < 20) {
			msg += "Good Evening :: " + uname;
		} else
			msg += "Good Night :: " + uname;

		out.println("<h1 style='color:green; text-align:center;'>" + msg + "</h1>");

		out.close();
	}

}
