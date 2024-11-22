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
		System.out.println("TargetServletLoading :: TargetServlet.class file is loading...");
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TargetServlet() {
       System.out.println("TargetServletInstantiaion :: TargetServlet.TargetServlet()");
    }

    
    @Override
    public void init() throws ServletException {
    	System.out.println("TargetServletInstantiation :: TargetServlet.init()");
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("TargetServletRequestProcessing :: TargetServlet.doGet()");
    	
    	PrintWriter out = response.getWriter();
    	out.println("<h1 style='color:green; text-align:center;'>RESPONSE FROM TARGET SERVLET</h1>");  	
    }
    
    @Override
    public void destroy() {
    	System.out.println("TargetServletDeInstantiation :: TargetServlet.destroy()");
    }

}
