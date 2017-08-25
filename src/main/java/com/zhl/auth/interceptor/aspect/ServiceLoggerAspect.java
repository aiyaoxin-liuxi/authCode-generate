//package com.zhl.auth.interceptor.aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import com.zhl.auth.controller.SmsController;
//
//@Aspect
//@Component
//public class ServiceLoggerAspect {
//    
//    private Logger logs = LoggerFactory.getLogger(ServiceLoggerAspect.class);
//    
//
//    @Pointcut("execution(* com.zhl.auth.service.impl..*.*(..))")
//    public void serviceLoggerAspect() {
//
//    }
//
//    @Before(value = "serviceLoggerAspect()")
//    public void before() {
//        logs.info("方法执行前执行.....");
//    }
//
//    @AfterReturning(value = "serviceLoggerAspect()")
//    public void afterReturning() {
//        logs.info("方法执行完执行.....");
//    }
//
//    @AfterThrowing(value = "serviceLoggerAspect()")
//    public void throwss() {
//        logs.info("方法异常时执行.....");
//    }
//
//    @After(value = "serviceLoggerAspect()")
//    public void after() {
//        logs.info("方法最后执行.....");
//    }
//
//    @Around(value = "serviceLoggerAspect()")
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
//
//}
