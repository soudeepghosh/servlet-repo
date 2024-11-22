package in.pwskills.nitin.customize;

import java.io.PrintWriter;

public class CustomizedWriter extends PrintWriter {

	PrintWriter out;

	public CustomizedWriter(PrintWriter out) {
		super(out);
		this.out = out;
	}

	@Override
	public void println(String data) {
		System.out.println("CustomizedWriter.println()");
		if (!data.startsWith("<")) {
			// reverse and prin
			StringBuffer sb = new StringBuffer(data);
			out.println(sb.reverse());

		} else {
			// print the data
			out.println(data);
		}
	}
}
