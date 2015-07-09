package url;

import java.io.UnsupportedEncodingException;

public class UrlTest {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String   mytext   =   java.net.URLEncoder.encode("&",   "utf-8");
		  
		  System.out.println(mytext);
	}
}
