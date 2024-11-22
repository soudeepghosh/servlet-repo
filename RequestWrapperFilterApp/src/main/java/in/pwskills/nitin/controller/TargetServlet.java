package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TargetServlet
 */
@WebServlet("/test")
public class TargetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("TargetServletLoading :: TargetServlet.TargetServlet()");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TargetServlet() {
		System.out.println("TargetServletInstantiation :: TargetServlet.TargetServlet()");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("TargetServletInstantiation :: TargetServlet.init()");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TargetServletRequestProcessing:: TargetServlet.doGet()");
		PrintWriter out = response.getWriter();
		
		//customized request :: getParamter(name)
		String name = request.getParameter("name");
		out.println("<h1 style='color:blue; text-align:center;'>ENTERED NAME IS :: " + name + "</h1>");
		out.close();
	}
	
	@Override
	public void destroy() {
		System.out.println("TargetServletDeInstantiation :: TargetServlet.destroy()");
	}

}
