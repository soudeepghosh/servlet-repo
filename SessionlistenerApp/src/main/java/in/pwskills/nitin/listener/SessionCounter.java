package in.pwskills.nitin.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionCounter
 *
 */
@WebListener
public class SessionCounter implements HttpSessionListener {

	public static int count =0;
	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent se) {
		count++;
		System.out.println("SessionCounter.sessionCreated()");
		System.out.println("A NewSession is created with id :: " + se.getSession().getId());
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent se) {
		count--;
		System.out.println("SessionCounter.sessionDestroyed()");
		System.out.println("A Existing session is destroyed with the id :: " + se.getSession().getId()+"\n");
	}

}
