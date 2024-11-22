package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "Working with GET and POST methods", urlPatterns = { "/test" }, loadOnStartup = 10)
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Loading :: FirstServlet.class file is loading...");
	}

	public FirstServlet() {
		System.out.println("Instantiation :: FirstServlet Object created...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Initialization :: init()-> Zero param...");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet.doGet()....");
		PrintWriter out = response.getWriter();
		out.println("<h1>RequestProcessing :: GET METHOD...</h1>");
		out.close();
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FirstServlet.doPost()....");
		PrintWriter out = response.getWriter();
		out.println("<h1>RequestProcessing :: POST METHOD...</h1>");
		out.close();
	}
}

