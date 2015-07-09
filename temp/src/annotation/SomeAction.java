package annotation;

public class SomeAction {
	
	@PAuthority(allGranted="a,b,c")
	public void doSomething(){ 
		System.out.println("do something.");
	}
}
