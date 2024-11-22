package in.pwskills.nitin.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class DemoFilter
 */
public class DemoFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("DemoFilter Loading :: DemoFilter.class file is loading...");
	}

	/**
     * @see HttpFilter#HttpFilter()
     */
    public DemoFilter() {
    	System.out.println("DemoFilterInstantiation :: DemoFilter.DemoFilter()");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("DemoFilterDeInstantiation :: DemoFilter.destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		System.out.println("DemoFilterRequestProcessing :: DemoFilter.doFilter()");
		PrintWriter out = response.getWriter();
		out.println("<h1 style='color:red; text-align:center;'>ADDED BY DEMO FILTER BEFORE REQUEST PROCESSING...</h1>");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		out.println("<h1 style='color:red; text-align:center;'>ADDED BY DEMO FILTER AFTER REQUEST PROCESSING...</h1>");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("DemoFilterInitialization :: DemoFilter.init()");
	}

}
