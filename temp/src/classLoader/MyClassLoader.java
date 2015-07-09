package classLoader;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class MyClassLoader extends URLClassLoader{
	  private static File file = new File("c:\\classes ");
	  //��·�������class B������û��class A

	  public MyClassLoader() {
	    super(getUrl());
	  }

	  public static URL[] getUrl() {
	    try {
	      return new URL[]{file.toURL()};
	    } catch ( MalformedURLException e ) {
	      return new URL[0];
	    }
	  }
	}
