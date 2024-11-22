package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.annotation.Resource;
import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class PooledServlet
 */
@WebServlet("/pool")
public class PooledServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SQL_INSERT_QUERY = "insert into employees(`ename`,`eaddress`,`eavg`) values(?,?,?)";

	@Resource(name = "JNDI")
	private DataSource datasource;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Creating a response
		PrintWriter out = response.getWriter();

		// collect the inputs
		String username = request.getParameter("username");
		String useraddr = request.getParameter("useraddr");
		String useravg = request.getParameter("useravg");

		ServletContext servletContext = getServletContext();
		String dsInfo = servletContext.getInitParameter("DSINFO");
		System.out.println(dsInfo);
		System.out.println(datasource);
		try (Connection connection = datasource.getConnection()) {
			if (connection != null) {
				System.out.println(connection);
				try (PreparedStatement pstmt = connection.prepareStatement(SQL_INSERT_QUERY)) {
					if (pstmt != null) {
						System.out.println(pstmt);
						pstmt.setString(1, username);
						pstmt.setString(2, useraddr);
						pstmt.setFloat(3, Float.parseFloat(useravg));

						int result = pstmt.executeUpdate();

						if (result == 0) {
							out.println("<h1 style='color:red;text-align:center;'>PROBLEM IN INSERTION</h1>");
						} else {
							out.println("<h1 style='color:green;text-align:center;'>REGISTARTION SUCCESSFULL</h1>");
						}
					}
				}
			}
		} catch (Exception e) {
			out.println("<h1 style='color:red;text-align:center;'>PROBLEM IN INSERTION</h1>");
			e.printStackTrace();
		}
		out.println("<h1 style='color:red;text-align:center;'><a href='./index.html'>|HOMEPAGE|</a></h1>");
		out.close();
	}

	@SuppressWarnings("unused")
	private Connection getPooledConnection(String dsInfo) throws Exception {
		// PERFORMING DEPENDANCY LOOKUP OPERATION
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource) context.lookup(dsInfo);
		Connection connection = ds.getConnection();
		return connection;
	}
}
