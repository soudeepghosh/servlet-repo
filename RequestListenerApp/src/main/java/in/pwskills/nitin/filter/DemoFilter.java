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

/**
 * Servlet Filter implementation class DemoFilter
 */
@WebFilter(dispatcherTypes = {DispatcherType.REQUEST }
					, urlPatterns = { "/target" })
public class DemoFilter extends HttpFilter implements Filter {
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	static {
		System.out.println("\nDemoFilterLoading : DemoFilter.DemoFilter()");
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
		System.out.println("\nDemoFilterRequestProcessing :: DemoFilter.doFilter()");
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("DemoFilterInitialization :: DemoFilter.init()\n");
	}

}
