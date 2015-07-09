package annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class PAuthorityTest {
	
	public static void main(String[] args) throws Exception{
//		SomeAction sa=new SomeAction();
//		sa.doSomething();
		
		Class clazz=Class.forName("annotation.SomeAction");
		for(Method m: clazz.getDeclaredMethods()){
			
			for(Annotation a:m.getAnnotations()){
				System.out.println(a.annotationType());
				PAuthority pa=(PAuthority)a;
				System.out.println(pa.allGranted());
				pa=m.getAnnotation(PAuthority.class);
				System.out.println(pa.anyGranted());
			}
			
		}
	}
}
