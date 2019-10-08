import java.net.*;
import java.io.*;
import java.util.*;
public class main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String emailId = reader.readLine();
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		System.out.println(emailId);
		reader.close();
		URL personalPageURL = new URL("https://www.ecs.soton.ac.uk/people/" + emailId);
		BufferedReader urlReader = new BufferedReader(new InputStreamReader(personalPageURL.openStream()));
		String line="debugString";
		boolean isName = false;
		while (!isName) {
			line=urlReader.readLine();
			isName = line.indexOf("property=\"name\">") !=-1? true: false;
		}
		int subStart = line.indexOf("property=\"name\">") + 16;
		int subEnd = line.indexOf("<em property=\"honorific");
		String name = line.substring(subStart,subEnd);
		System.out.println(name);
	    urlReader.close();
	}

}
