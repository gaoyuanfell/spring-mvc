package moka.basic.annotation;

import java.lang.annotation.*;

/**不需要切面注解
 * Created by moka on 2017/4/18 0018.
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NotAspect {

}
