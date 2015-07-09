package exception;

public class TestException {
	public void throwExc(){
		System.out.println("===============1================");
		try {
			throwExc2();
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			System.out.println("===============3================");
			System.out.println(e.getMessage());

			e.printStackTrace();

			System.out.println("===============4================");
		}
	}
	public void throwExc2(){

		System.out.println("===============2================");
		String.valueOf(null);
	}
	
	public static void main(String[] args) {
		TestException te=new TestException();
		te.throwExc();
	}

}
