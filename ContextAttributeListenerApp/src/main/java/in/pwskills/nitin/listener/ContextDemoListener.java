package in.pwskills.nitin.listener;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class ContextDemoListener
 *
 */
@WebListener
public class ContextDemoListener implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("ContextDemoListener.contextDestroyed()");
		String path = sce.getServletContext().getRealPath("count.txt");
		PrintWriter out = null;
		try {
			out = new PrintWriter(path);
			out.println(RequestDemoListener.count);
			out.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally {
			if (out != null) {
				out.close();
			}
		}

	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("ContextDemoListener.contextInitialized()");

		// read the data from the file
		String path = sce.getServletContext().getRealPath("count.txt");
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new FileReader(path));
			String data = reader.readLine();
			if (data != null) {
				int count = Integer.parseInt(data);
				RequestDemoListener.count = count;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
