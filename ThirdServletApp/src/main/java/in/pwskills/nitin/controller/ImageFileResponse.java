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
 * Servlet implementation class ImageFileResponse
 */
@WebServlet("/image")
public class ImageFileResponse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	static {
		System.out.println("Loading :: ImageFileResponse.class file is loading...");
	}

	public ImageFileResponse() {
		System.out.println("Instantiation :: ImageFileResponse-> Zero param...");
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		System.out.println("Initialization :: ImageFileResponse.init()...");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("DeInstantiation :: ImageFileResponse.destroy()...");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RequestProcessing :: ImageFileResponse.doGet()");

		// Setting MIME type
		response.setContentType("image/jpeg");

		// Getting the byte stream to send the response
		ServletOutputStream outputStream = response.getOutputStream();

		// Reading the video file through InputStream
		String path = getServletContext().getRealPath("nitin.JPG");
		System.out.println("Image located in :: " + path);
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
