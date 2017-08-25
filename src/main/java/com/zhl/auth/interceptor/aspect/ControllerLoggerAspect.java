package com.zhl.auth.interceptor.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerLoggerAspect{
    
    private Logger logs = LoggerFactory.getLogger(ControllerLoggerAspect.class);

    @Pointcut("execution(* com.zhl.auth.controller..*.*(..))")
    public void controllerLoggerAspect() {

    }

    @Before(value = "controllerLoggerAspect()")
    public void before(JoinPoint point) {
        logs.info("准备进入Controller...");
        logs.info("调用接口：" + point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName());
        logs.info("接口调用参数为：" + Arrays.toString(point.getArgs()));
    }

    @After(value = "controllerLoggerAspect()")
    public void after(JoinPoint joinPoint) {
        logs.info("Controller返回参数...");
    }

//    @AfterReturning(value = "controllerLoggerAspect()")
//    public void afterReturning() {
//        logs.info("方法执行完执行.....");
//    }
    @AfterReturning(returning="result", pointcut="execution(* com.zhl.auth.controller.*.*(..))")  
    public void afterReturn(JoinPoint joinPoint, Object result) {  
        String name = joinPoint.getSignature().getName();// 获得目标方法名  
        logs.info("<=============" + name + "方法--AOP 后置返回通知=============>");  
        logs.info(name + "方法返回参数：" + result);  
    }  
    
    
    
    
//
//    @AfterThrowing(value = "controllerLoggerAspect()")
//    public void throwss() {
//        logs.info("方法异常时执行.....");
//    }
//
//    @Around(value = "controllerLoggerAspect()")
//    public Object around(ProceedingJoinPoint pjp) {
//        logs.info("方法环绕start.....");
//        Object o = null;
//        try {
//            o = pjp.proceed();
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
//        logs.info("方法环绕end.....");
//        return o;
//    }

}
