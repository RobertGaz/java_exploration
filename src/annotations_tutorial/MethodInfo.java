package annotations_tutorial;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    String author();
    int creationDate() default 2022;
    String description() default "";
}
