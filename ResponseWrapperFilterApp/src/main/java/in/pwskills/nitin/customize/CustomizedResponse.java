package in.pwskills.nitin.customize;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class CustomizedResponse extends HttpServletResponseWrapper {

	HttpServletResponse response;

	public CustomizedResponse(HttpServletResponse response) {
		super(response);
		this.response = response;
	}

	@Override
	public PrintWriter getWriter() throws IOException {

		System.out.println("CustomizedResponse.getWriter()");
		PrintWriter out = response.getWriter();
		CustomizedWriter myWriter = new CustomizedWriter(out);
		return myWriter;
	}

}
