package javaframe.test;

import org.apache.log4j.Logger;

public class Log4jTest {
	private static Logger logger=Logger.getLogger("operation");
	
	public static void testLog(){
		logger.info("info mssage!");
	}
	public static void main(String[] agrs){
		Log4jTest.testLog();
	}
	
}
