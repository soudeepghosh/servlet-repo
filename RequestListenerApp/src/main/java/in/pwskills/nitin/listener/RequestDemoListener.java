package in.pwskills.nitin.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class RequestDemoListener
 *
 */
@WebListener
public class RequestDemoListener implements ServletRequestListener {

	public static int count = 0;
	
	static {
		System.out.println("RequestDemoListener Loading :: RequestDemoListener.RequestDemoListener()");
	}

	/**
	 * Default constructor.
	 */
	public RequestDemoListener() {
		System.out.println("RequestDemoListener Instantiation .....\n");
	}

	/**
	 * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
	 */
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("RequestDemoListener.requestDestroyed() :: " + new java.util.Date());
	}

	/**
	 * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
	 */
	public void requestInitialized(ServletRequestEvent sre) {
		System.out.println("Request Object details are :: "+sre.hashCode());
		System.out.println("RequestDemoListener.requestInitialized() : object created at " + new java.util.Date());
		count++;
		System.out.println("The no of hits for the webapplication is :: "+count);
	}

}
