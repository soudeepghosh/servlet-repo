package in.pwskills.nitin.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LogFilter
 */
public class LogFilter extends HttpFilter implements Filter {

	private FilterConfig fconfig;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Logfilter Loading :: LogFilter.class file is loading...");
	}

	/**
	 * @see HttpFilter#HttpFilter()
	 */
	public LogFilter() {
		System.out.println("LogFilterInstantiaion :: LogFilter()");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		fconfig = null;
		System.out.println("LogFilterDeInstantiation :: LogFilter.destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("LogFilterRequestProcessing :: LogFilter.doFilter()");

		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:blue; text-align:center;'>ADDED BY LOG FILTER BEFORE REQUEST PROCESSING...</h1>");
		
		ServletContext context = fconfig.getServletContext();
		HttpServletRequest req = (HttpServletRequest) request;

		//server logs details....
		context.log("A request is coming from :: " + req.getRemoteHost() + " for URL ::" + req.getRequestURL()
				+ " at :: " + new java.util.Date());

		// pass the request along the filter chain
		chain.doFilter(request, response);
		out.println("<h1 style='color:blue; text-align:center;'>ADDED BY LOG FILTER AFTER REQUEST PROCESSING...</h1>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fconfig) throws ServletException {
		this.fconfig = fconfig;
		System.out.println("LogFilterInitialization :: LogFilter.init()");
	}

}
