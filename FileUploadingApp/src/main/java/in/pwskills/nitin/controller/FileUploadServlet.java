package in.pwskills.nitin.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadException;
import javazoom.upload.UploadParameters;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/upload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String SQL_INSERT_QUERY = "insert into person_profile(`pname`,`paddress`,`resumeloc`,`photoloc`) values(?,?,?,?)";

	@Resource(name = "JNDI")
	private DataSource ds;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("FileUploadServlet.doPost()");

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String resumeLocation = "D:\\upload\\resumes\\";
		String photoLocation = "D:\\upload\\photos\\";

		boolean uploadFlag = false;

		String username = null, useraddr = null, resumeFilePath = null, photoFilePath = null;

		try {
			// collecting request object which holds resume and photo as streams
			MultipartFormDataRequest nreq = new MultipartFormDataRequest(request);

			// Getting text data from request object
			username = nreq.getParameter("username");
			useraddr = nreq.getParameter("useraddr");

			System.out.println(username);
			System.out.println(useraddr);

			// Using UploadBean to work with FileSystem
			UploadBean upb = new UploadBean();
			System.out.println(upb);
			upb.setMaxfiles(15);
			upb.setOverwrite(true);
			upb.setBlacklist("install.exe,setup.exe");

			// Specify the location of server machine where file needs to uploaded
			upb.setFolderstore(resumeLocation);
			upb.store(nreq, "userresume");// completes resume uploading

			// Specify the location of server machine where file needs to uploaded
			upb.setFolderstore(photoLocation);
			upb.store(nreq, "userphoto");// completes photo uploading

			// Get all the uploaded filenames
			@SuppressWarnings("rawtypes")
			Vector vector = upb.getHistory();
			resumeFilePath = resumeLocation + ((UploadParameters) vector.get(0)).getFilename();
			System.out.println(resumeFilePath);
			photoFilePath = photoLocation + ((UploadParameters) vector.get(1)).getFilename();
			System.out.println(photoFilePath);

			uploadFlag = true;
			out.println("<h1 style='color:green; text-align:center;'>UPLOADING THE FILE INTO SERVER....</h1>");

		} catch (UploadException | IOException e) {
			System.out.println(e);
		}

		// Perform peristence operation
		if (uploadFlag) {
			// JDBC CODE
			try (Connection con = ds.getConnection()) {

				try (PreparedStatement pstm = con.prepareStatement(SQL_INSERT_QUERY)) {
					// set the values collected from the user
					pstm.setString(1, username);
					pstm.setString(2, useraddr);
					pstm.setString(3, resumeFilePath);
					pstm.setString(4, photoFilePath);

					int rowCount = pstm.executeUpdate();
					if (rowCount == 0) {
						out.println("<h1 style='color:red;text-align:center;'>REGISTRATION FAIlED</h1>");
					} else {
						out.println("<h1 style='color:green;text-align:center;'>REGISTRATION COMPLETED</h1>");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
				out.println("<h1 style='color:red;text-align:center;'>REGISTRATION FAIlED</h1>");
			}

		} else {
			out.println("<h1 style='color:green; text-align:center;'>UPLOADING THE FILE INTO SERVER....</h1>");
		}
		out.println("<h1 style='text-align:center;'><a href='./index.html'>|HOMEPAGE|</a></h1>");

	}
}
