package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowBalanceServlet
 */
@WebServlet("/showBalance")
public class ShowBalanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println(
				"<h1 style='color:red; text-align:center;'>Authentication Mode :: " + request.getAuthType() + "</h1>");
		out.println("<h1 style='color:red; text-align:center;'>Logged Username :: " + request.getUserPrincipal() + "</h1>");
		out.println("<h1 style='color:red; text-align:center;'>Account balance is :: " + new Random().nextInt(200000)
				+ "</h1>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
