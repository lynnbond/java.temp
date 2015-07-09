package date;

import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String [] args){
		System.out.println(new Date(System.currentTimeMillis()));
		System.out.println(new Date(System.currentTimeMillis()+1));
		Calendar calendar= Calendar.getInstance();
		calendar.add(Calendar.DATE, -1);
		System.out.println(calendar.getTime());
	}
}
