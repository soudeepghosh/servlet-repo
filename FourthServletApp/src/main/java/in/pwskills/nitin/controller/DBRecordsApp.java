package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DBRecordsApp
 */
@WebServlet(urlPatterns = { "/record" }, initParams = {
		@WebInitParam(name = "driverName", value = "com.mysql.cj.jdbc.Driver"),
		@WebInitParam(name = "url", value = "jdbc:mysql:///pwskills_octbatch"),
		@WebInitParam(name = "username", value = "root"),
		@WebInitParam(name = "password", value = "root123") }, loadOnStartup = 1)

public class DBRecordsApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL_SELECT_QUERY = "select eid,ename,esal,eaddress from employees";

	static {
		System.out.println("Loading ::DBRecordsApp.class file is loading... ");
	}

	public DBRecordsApp() {
		System.out.println("Instantiation :: DBRecordsApp...");
	}

	Connection connection = null;
	Statement statement = null;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("Initialization :: DBRecordsApp.init()");
		try {
			Class.forName(getInitParameter("driverName"));
			connection = DriverManager.getConnection(getInitParameter("url"), getInitParameter("username"),
					getInitParameter("password"));
			if (connection != null) {
				statement = connection.createStatement();
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("\nRequestProcessing :: DBRecordsApp.doGet()");
		ResultSet resultSet = null;
		try {
			System.out.println("Connection Object :: " + connection);
			System.out.println("Statement  Object :: " + statement);
			
			if (statement != null) {
				resultSet = statement.executeQuery(SQL_SELECT_QUERY);
			}

			if (resultSet != null) {
				PrintWriter out = response.getWriter();

				out.println("<body align='center' bgcolor='cyan'>");
				out.println("<h1 style='color:red; text-align:center;'>EMPLOYEE INFORMATION</h1>");
				out.println("<table border='1' align='center'>");
				out.println("<tr><th>EID</th><th>ENAME</th><th>ESAL</th><th>EADDR</th></tr>");

				while (resultSet.next()) {
					out.println("<tr>");
					out.println("<td>" + resultSet.getInt(1) + "</td>");
					out.println("<td>" + resultSet.getString(2) + "</td>");
					out.println("<td>" + resultSet.getInt(3) + "</td>");
					out.println("<td>" + resultSet.getString(4) + "</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				out.println("</body>");
				out.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public void destroy() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
