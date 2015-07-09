package annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface PAuthority {
	String anyGranted() default ""; 
	String allGranted() default ""; 
	String notGranted() default ""; 
}
