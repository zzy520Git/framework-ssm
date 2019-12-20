package com.jd.frameworkssm.common.annotation;

import com.jd.frameworkssm.common.result.ResponseResult;
import com.jd.frameworkssm.common.util.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Description：
 *
 * @author zhouzhongyi1
 * @date 2019/7/8 9:18
 * @ see
 * @since
 */
@Aspect
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class JUmp {
    private static final Logger log = LoggerFactory.getLogger(JUmp.class);

    @Pointcut("@annotation(com.jd.frameworkssm.common.annotation.Ump)")
    public void JUmpPoint() {
    }

    private Method getMethod(JoinPoint jp) {
        try {
            MethodSignature msig = (MethodSignature)jp.getSignature();
            Method realMethod = jp.getTarget().getClass().getDeclaredMethod(msig.getName(),
                    msig.getMethod().getParameterTypes()) ;
            return realMethod;
        } catch (Throwable e) {
            log.error("{}", e);
        }
        return null;
    }

    @Around("JUmpPoint()")
    public Object execJUmp(ProceedingJoinPoint jp) throws Throwable {
        Method method = this.getMethod(jp);
        if(method == null) {
            return jp.proceed();
        }
        String methodDesc = "";
        boolean rethrow = false;
        Object result = null;
        Object caller = null;
        try {
            Ump monitor = method.getAnnotation(Ump.class) ;
            if(monitor != null) {
                methodDesc = monitor.desc();
                rethrow = monitor.rethrow();
                String umpKey = jp.getTarget().getClass().getName() + "." + jp.getSignature().getName();
                if(StringUtils.isBlank(methodDesc)) {
                    methodDesc = umpKey;
                }
                caller = umpKey;
                log.error(umpKey);
            }
            result = jp.proceed();
            if(result == null) {
                log.error("null,入参={}", JsonUtil.toJSONString(jp.getArgs()));
                return null;
            }
            if(result instanceof ResponseResult) {
                ResponseResult res = (ResponseResult)result;
                if(!res.isSuccess()) {
                    log.error("入参={}，出参={}", JsonUtil.toJSONString(jp.getArgs()), JsonUtil.toJSONString(result));
                }
            }
        } catch (Throwable e) {
            //加入ip和pin和调用链
            log.error(JsonUtil.toJSONString(jp.getArgs()));
            log.error("error,a={},b={},c={}" + methodDesc,
                    e.getMessage());
            caller = "error";
            Class clazz = method.getReturnType();
            if(rethrow || (clazz != null && clazz.isPrimitive())) {
                throw e;
            }
            if(clazz == Map.class) {
                return Collections.emptyMap();
            }
            if(clazz == List.class) {
                return Collections.emptyList();
            }
            if(clazz == ResponseResult.class) {
                String msg = e.getMessage();
                String ip = "127.0.0.1";
                return ResponseResult.systemError();
            }
        } finally {
            log.error("end");
            caller = "end";
        }
        return result ;
    }

}
