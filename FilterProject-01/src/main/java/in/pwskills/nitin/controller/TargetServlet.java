package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TargetServlet
 */
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("\nLOADING :: TargetServlet.class file is loading...");
	}
	
	public TargetServlet() {
		System.out.println("INSTANTIATION :: TargetServlet.TargetServlet()");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("INITIALISATION :: TargetServlet.init()");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("REQUESTPROCESSING :: TargetServlet.doGet()");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:green; text-align:center;'>RESPONSE FROM TARGETSERVLET...</h1>");
	
	}
	@Override
	public void destroy() {
		System.out.println("DEINSTANTIATION :: TargetServlet.destroy()");
	}

}
