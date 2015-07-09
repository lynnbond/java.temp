package classLoader;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class A {
	  public static void main( String[] args ) {
	    try {
	      //定义两个类装载器
	      MyClassLoader aa= new MyClassLoader();
	      MyClassLoader bb = new MyClassLoader();

	      //用类装载器aa装载testb.B类
	      Class clazz=aa.loadClass("testb. B");
	      Constructor constructor= 
	        clazz.getConstructor(new Class[]{Integer.class});
	      Object object = 
		    constructor.newInstance(new Object[]{new Integer(1)});
	      Method method = 
		    clazz.getDeclaredMethod("printB",new Class[0]);

	      //用类装载器bb装载testb.B类
	      Class clazz2=bb.loadClass("testb. B");
	      Constructor constructor2 = 
	        clazz2.getConstructor(new Class[]{Integer.class});
	      Object object2 = 
		    constructor2.newInstance(new Object[]{new Integer(2)});
	      Method method2 = 
		    clazz2.getDeclaredMethod("printB",new Class[0]);

	      //显示test.B中的静态变量的值 
	      method.invoke( object,new Object[0]);
	      method2.invoke( object2,new Object[0]);
	    } catch ( Exception e ) {
	      e.printStackTrace();
	    }
	  }
	}

