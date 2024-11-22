import javax.servlet.*;
import java.io.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns={"/test"},loadOnStartup=10)
public class FirstServlet extends HttpServlet
{
	static{
		System.out.println("ServletLoading :: FirstServlet.class file is loading...");
	}

	public FirstServlet(){
		System.out.println("ServletInstantiation::FirstServlet Object got created...");
	}

	@Override
	public void init(){
		System.out.println("ServletInitialization :: init()-> zero argument");
	}

	@Override
	public  void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			//setting the MIME type
			response.setContentType("text/html");

			//Getting the PrintWriter to write the response
			PrintWriter out = response.getWriter();

			out.println("<html><head><title>POST</title></head>");
			out.println("<body><h1>Request from :: "+request.getMethod()+"</h1></body>");
			out.println("</html>");

			out.close();
	}

	@Override
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws	ServletException, IOException{
		//Default MIME type :: text/html

		//Getting the PrintWriter to write the response
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>GET</title></head>");
		out.println("<body><h1>Request from :: "+request.getMethod()+"</h1></body>");
		out.println("</html>");

		out.close();
	}
}
