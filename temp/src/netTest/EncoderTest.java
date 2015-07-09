package netTest;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncoderTest {

	public static void main(String[] args){
		String par="ÄãºÃ";
		String url=null;
		try {
			url=URLEncoder.encode(par, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(url);
	}
}
