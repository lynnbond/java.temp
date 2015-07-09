package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CalendarTest {
	public static void main(String[] args) {
		Calendar cl=Calendar.getInstance();
		cl.setTimeInMillis(1429200000000l);
/*		cl.set(Calendar.HOUR_OF_DAY, 24);
		cl.set(Calendar.HOUR_OF_DAY, 0);
		cl.set(Calendar.MINUTE, 0);
		cl.set(Calendar.SECOND, 0);
		cl.set(Calendar.MILLISECOND,0);*/
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(sdf.format(cl.getTime()));
		
	}
}
