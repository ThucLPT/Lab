package Problem2;

import java.io.*;

public class App {
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	public static void main(String[] args) throws IOException {
		System.out.print("Enter infix: ");
		System.out.flush();
		String infix = getString();
		InToPost inToPost = new InToPost(infix);
		String postfix = inToPost.doTrans();
		ParsePost parsePost = new ParsePost(postfix);
		int i = parsePost.doParse();
		System.out.println("Evaluates to " + i);
	}
}
