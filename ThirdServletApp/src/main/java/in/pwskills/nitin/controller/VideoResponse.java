package in.pwskills.nitin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VideoResponse
 */
@WebServlet(description = "Response of VideoType", urlPatterns = { "/video" })
public class VideoResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Loading :: VideoResponse.class file is loading...");
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoResponse() {
		System.out.println("Instantiation :: VideoResponse.VideoResponse()...");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("Initialization :: VideoResponse.init()...");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("DeInstantiation :: VideoResponse.destroy()...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Setting MIME Type
		response.setContentType("video/mp4");

		// Getting the byte stream to send the response
		ServletOutputStream outputStream = response.getOutputStream();

		// Reading the video file through InputStream
		String path = getServletContext().getRealPath("video.mp4");
		System.out.println("Video located in :: " + path);
		File file = new File(path);
		FileInputStream inputStream = new FileInputStream(file);
		byte[] b = new byte[(int) file.length()];
		inputStream.read(b);

		outputStream.write(b);
		outputStream.flush();

		outputStream.close();
		inputStream.close();

	}
}
