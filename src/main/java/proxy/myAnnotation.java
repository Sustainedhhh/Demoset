package proxy;


import java.lang.annotation.*;


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface myAnnotation {

    String value() default "myAnnotation";

}
