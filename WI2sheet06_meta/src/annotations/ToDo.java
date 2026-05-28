package annotations;

import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// annotation with named attributes
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ToDo {
    String what();
    int count(); 
}

