package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AttributeAddedListener
 */
@WebServlet("/attribute")
public class AttributeAddedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	static {
		System.out.println("Loding-> AttributeAddedServlet.class file is loading...");
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttributeAddedServlet() {
       System.out.println("Instantiation -> AttributeAddedServlet Object is instantiated...");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Initialization -> AttributeAddedServlet.init()");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcessing-> AttributeAddedServlet.doGet()");
		
		//Adding the attriubtes to request object
		request.setAttribute("name", "sachin");
		request.setAttribute("gender", "male");
		request.setAttribute("ipl", "MI");
		
		//performing updation
		request.setAttribute("name", "dhoni");
		
		//performing deletion
		request.removeAttribute("ipl");
		
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red; text-align:center;'>PERFORMING OPERATIONS ON SERVLETREQUEST OBJECT(ATTRIBUTEDATA)</h1>");
		
	}
	
	/**
	 * @see HttpServlet#destroy
	 */
	@Override
	public void destroy() {
		System.out.println("DeInstantiation -> AttributeAddedServlet.destroy()");
	}

}
