package ThreadTest;

public class TestA {
	
	private static TestA instance=new TestA();
	
	public static TestA getInstance(){
		return instance;
	}
	
	private TestA(){};
	
	public synchronized void a(){
		synchronized (this.getClass()) {
			int i=1;			
		}

	}
	public synchronized void b(){
		int i=1;
	}
	public static void c(){
		synchronized (TestA.class) {
		int i=1;
		}
	}
	
	public static void main(String[] args) throws InterruptedException{

		Thread t1=new Thread(){
			public void run(){
				TestA.getInstance().a();
				TestA.getInstance().c();
				System.out.println("t1");
			}
		};
		Thread t2=new Thread(){
			public void run(){
				System.out.println("t2-1");
				//TestA.getInstance().b();
				TestA.c();
				System.out.println("t2-2");
			}
		};
		t1.start();
		t2.start();
		Thread.sleep(1000);
		t1.start();
		t2.start();	
	}
}
