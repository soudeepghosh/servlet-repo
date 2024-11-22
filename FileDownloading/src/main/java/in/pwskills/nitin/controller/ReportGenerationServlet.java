package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ReportGenerationServlet
 */
@WebServlet("/showReport")
public class ReportGenerationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SQL_SELECT_QUERY = "select pid,pname,paddress,resumeloc,photoloc from person_profile";

	@Resource(name = "JNDI")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("ReportGenerationServlet.doGet()");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		try (Connection con = ds.getConnection()) {
			try (PreparedStatement pstmt = con.prepareStatement(SQL_SELECT_QUERY)) {
				try (ResultSet resultSet = pstmt.executeQuery()) {
					out.println("<h1 style='color:blue; text-align:center;'>REPORT GENERATION</h1>");
					out.println("<table border='1' align='center' bgcolor='cyan'>");
					out.println("<tr><th>PID</th><th>PNAME</th><th>PADDRESS</th><th>RESUME</th><th>PHOTO</th></tr>");

					while (resultSet.next()) {
						out.println("<tr>");
						out.println("<td>" + resultSet.getInt(1) + "</td>");
						out.println("<td>" + resultSet.getString(2) + "</td>");
						out.println("<td>" + resultSet.getString(3) + "</td>");
						out.println("<td><a href='./downloadurl?id=" + resultSet.getInt(1)+"&type=resume'>DOWNLOAD</a></td>");
						out.println("<td><a href='./downloadurl?id=" + resultSet.getInt(1)+"&type=photo'>DOWNLOAD</a></td>");
						out.println("</tr>");
					}
					out.println("</table>");
				}
			}
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
