package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/oracle")
public class OracleCode extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Loading :: OracleCode.class file is loading...");
	}

	public OracleCode() {
		System.out.println("Instantiation :: OracleCode-> Zero param...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("Initialization :: OracleCode-> init() Zero param...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("RequestProcessing :: OracleCode.doGet()");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red; text-align:center;'>Welcome to the world of Oracle Services...</h1>");
		out.close();
	}
}
