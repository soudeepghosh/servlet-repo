package in.pwskills.nitin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.apache.commons.io.IOUtils;

/**
 * Servlet implementation class FileDownloading
 */
@WebServlet("/downloadurl")
public class FileDownloading extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "JNDI")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FileDownloading.doGet()");

		// collect input parameters
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String query = null;
		String fileLoc = null;

		if (type.equalsIgnoreCase("resume")) {
			query = "select resumeloc from person_profile where pid = ?";
		} else {
			query = "select photoloc from person_profile where pid = ?";
		}

		try (Connection con = ds.getConnection()) {
			try (PreparedStatement pstmt = con.prepareStatement(query)) {
				pstmt.setInt(1, Integer.parseInt(id));
				try (ResultSet resultSet = pstmt.executeQuery()) {
					if (resultSet.next()) {
						fileLoc = resultSet.getString(1);
						System.out.println(fileLoc);
					}
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// write file dowloading
		try {

			// AS perf fileLoc create a file object
			File file = new File(fileLoc); // resume.txt or nitin.JPG

			// 1 Set the content length
			response.setContentLengthLong(file.length());

			// 2.Set the content type :: MIME
			ServletContext context = getServletContext();
			String mimeType = context.getMimeType(fileLoc);
			mimeType = (mimeType == null) ? "application/octet-stream" : mimeType;
			System.out.println(mimeType);
			response.setContentType(mimeType);
			
			//3. Setting the responseheader about downloading information
			response.addHeader("Content-Disposition", "attachment;fileName="+file.getName());

			// sending the stream response
			FileInputStream fis = new FileInputStream(file);
			ServletOutputStream ostream = response.getOutputStream();
			IOUtils.copy(fis, ostream);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
