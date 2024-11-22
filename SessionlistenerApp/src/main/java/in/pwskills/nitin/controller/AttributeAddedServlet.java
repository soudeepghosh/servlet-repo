package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.pwskills.nitin.listener.Dog;

/**
 * Servlet implementation class AttributeAddedServlet
 */
@WebServlet("/attribute")
public class AttributeAddedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		//attributes added to session
		session.setAttribute("name", "sachin");
		session.setAttribute("gender", "male");
		
		//attributes of useredefined type added to session
		session.setAttribute("d1", new Dog());
		session.setAttribute("d2", new Dog());
		
		
		//removing the attriubte of userdefined type
		session.removeAttribute("d1");
		
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red; text-align:center;'>SESSIONBINDINGLISTENER...</h1>");
	}

}
