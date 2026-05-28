package de.tha.prog2.task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Retention(RetentionPolicy.RUNTIME	)
public @interface Bug {
	
	
	public String description();
	
	public Bug.Type type();
	
	public enum Type {
		
		INVALID,
		ENHANCEMENT,
		MINOR,
		SEVERE,
		CRITICAL;		
	}

}
