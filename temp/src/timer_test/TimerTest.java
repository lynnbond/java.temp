package timer_test;

import java.util.Timer;

public class TimerTest {
	public static void main(String[] args){
		Timer timer=new Timer();
		timer.schedule(new Task1(), 1,1000);
		timer.schedule(new Task2(), 1000,5000);
	}

	
}
