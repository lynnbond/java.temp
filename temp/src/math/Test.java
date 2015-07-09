package math;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Test {
	public String format(int size,double number){
		StringBuffer formatString = new StringBuffer("0");
		  if(size>0){
		   formatString.append(".");
		  }
		  for (int i = 0; i < size; i++) {
		   formatString.append("#");
		  }
		  DecimalFormat df = new DecimalFormat(formatString.toString());
		 return df.format(number);
		}
	
	public static void main(String[] args){

		DecimalFormat df = new DecimalFormat("0.##");
		System.out.print(df.format(13.245d));
		
		double i = 13.245d;
		System.out.println("四舍五入取整:("+i+")="
			     + new BigDecimal(i).setScale(2, BigDecimal.ROUND_HALF_UP));
		


	}
}
