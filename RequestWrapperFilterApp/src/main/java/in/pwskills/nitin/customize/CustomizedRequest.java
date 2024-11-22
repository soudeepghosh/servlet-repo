package in.pwskills.nitin.customize;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class CustomizedRequest extends HttpServletRequestWrapper {

	public CustomizedRequest(HttpServletRequest request) {
		super(request);
	}
	
	@Override
	public String getParameter(String word) {
		System.out.println("CustomizedRequest.getParameter()");
		String data = super.getParameter(word);
		System.out.println("Data enterd by the user is :: "+data);
		if (data.equals("java") || data.equals("jee")||data.equals("spring")) {
			return "SLEEPING";
		} else {
			return data;
		}	
	}
}
