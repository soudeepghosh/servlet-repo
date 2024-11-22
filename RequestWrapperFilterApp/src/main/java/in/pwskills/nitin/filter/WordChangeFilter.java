package in.pwskills.nitin.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import in.pwskills.nitin.customize.CustomizedRequest;

/**
 * Servlet Filter implementation class WordChangeFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/test" })
public class WordChangeFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("WordChangeFilterLoading:: WordChangeFilter.enclosing_method()");
	}

	/**
     * @see HttpFilter#HttpFilter()
     */
    public WordChangeFilter() {
       System.out.println("WordChangeFilterInstantiation :: WordChangeFilter.WordChangeFilter()");
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println("WordChangeFilterDeInstantiation :: WordChangeFilter.destroy()");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("WordChangeFilterRequestProcessing :: WordChangeFilter.doFilter()");
		
		CustomizedRequest req = new CustomizedRequest((HttpServletRequest) request);
		
		// pass the request along the filter chain
		chain.doFilter(req, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("WordChangeFilterInitialization :: WordChangeFilter.init()");
	}

}
