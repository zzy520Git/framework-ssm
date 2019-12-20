package com.jd.frameworkssm.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/7/8 9:16
 * @ see
 * @since
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Ump {
    String desc() default "";
    boolean rethrow() default false;
}
