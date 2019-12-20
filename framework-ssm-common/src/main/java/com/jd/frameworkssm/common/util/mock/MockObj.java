package com.jd.frameworkssm.common.util.mock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/8/8 14:19
 * @ see
 * @since
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface MockObj {
    Class<?> value();
}
