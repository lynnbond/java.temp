package test;

import java.util.*;
import java.io.*;

class StreamGobbler extends Thread {
	InputStream is;
	String type;

	StreamGobbler(InputStream is, String type) {
		this.is = is;
		this.type = type;
	}

	public void run() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line = null;
			while ((line = br.readLine()) != null){
				System.out.println(type + ">" + line);
				//System.out.println("~~~~~~~~~~~ OUT ~~~~~~~~~~~:");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
