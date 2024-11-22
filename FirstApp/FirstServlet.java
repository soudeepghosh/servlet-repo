import javax.servlet.*;
import java.io.*;

public class FirstServlet implements Servlet
{
	static{
		System.out.println("ServletLoading :: FirstServlet.class file is loading...");
	}

	public FirstServlet(){
		System.out.println("ServletInstantiation::FirstServlet Object got created...");
	}

	@Override
	public void init(ServletConfig config) throws ServletException{
		System.out.println("ServletInitialization:: init()");
	}

	@Override
	public  void service(ServletRequest request, ServletResponse response) throws				ServletException, IOException{

		System.out.println("RequestProcessingPhase:: service()");
		
		//Setting the response mime type
		response.setContentType("text/html");

		//Getting the writer object to write the response to browser
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><title>OUTPUT</title></head>");
		out.println("<body>");
		out.println("<h1 style='color:red; text-align:center;'>Welcome to the world of Advancedjava</h1>");
		out.println("</body>");
		out.println("</html>");
	
		out.close();
	}

	@Override
	public  ServletConfig getServletConfig(){
		return null;
	}

	@Override
	public  String getServletInfo(){
		return "Developed by Nitin";
	}

	@Override
	public  void destroy(){
		System.out.println("ServletDeInstantiation:: destroy()");
	}
	
}
