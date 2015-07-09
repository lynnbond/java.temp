package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseDateTest {
	
	public static void main(String[] args){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	try {
		Date date = sdf.parse("0000-1-1");
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
