package annotation.anno;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.FIELD,ElementType.METHOD})
public @interface Put {

    boolean isId() default false;

    int value() default 0;

    String name() default "";

    String desc() default "";

}
