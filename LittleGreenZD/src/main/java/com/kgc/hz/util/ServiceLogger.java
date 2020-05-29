package com.kgc.hz.util;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;


/**
 * AOP
 * 增强处理工具类
 */
@Aspect
public class ServiceLogger {
    private static Logger logger = Logger.getLogger(ServiceLogger.class);

    /**
     * 前置增强
     * @param joinPoint
     *//*
    @Before("execution(* com.kgc.hz.service..*.*(..))")
    public void before(JoinPoint joinPoint){
        logger.info("前置增强调用："+joinPoint.getTarget()+"的"+joinPoint.getSignature().getName()
                +"方法。方法入参："+ Arrays.toString(joinPoint.getArgs()));
    }

    *//**
     * 后置增强
     * @param jp
     * @param result
     *//*
    @AfterReturning(value = "execution(* com.kgc.hz.service..*.*(..))",
            returning = "result")
    public void  afterReturning(JoinPoint jp,Object result){
        logger.info("后置增强调用："+jp.getTarget()+"的"+jp.getSignature().getName()
                +"方法。方法返回值："+result);
    }

    *//**
     * 抛出异常增强
     * @param jp
     * @param e
     *//*
    @AfterThrowing(value="execution(* com.kgc.hz.service..*.*(..))",
            throwing = "e")
    public void afterThrowing(JoinPoint jp,RuntimeException e){
        logger.info("异常抛出增强调用："+jp.getTarget()+"的"
                +jp.getSignature().getName()+"方法，方法抛出的异常："+e);
    }

    *//**
     * 最终增强
     * @param jp
     *//*
    @After("execution(* com.kgc.hz.service..*.*(..))")
    public void afterFinally(JoinPoint jp){
        logger.info("最终增强调用完："+jp.getTarget()+"的"
                +jp.getSignature().getName()+"方法");
    }*/

    /**
     * 环绕增强
     * @param joinPoint
     */
    @Around("execution(* com.kgc.hz.service..*.*(..))")
    public Object round(ProceedingJoinPoint joinPoint){
        logger.info("r:前置增强调用："+joinPoint.getTarget()+"的"+joinPoint.getSignature().getName()
                +"方法。方法入参："+ Arrays.toString(joinPoint.getArgs()));
        try {
            Object result = joinPoint.proceed();
            logger.info("r:后置增强调用："+joinPoint.getTarget()+"的"+joinPoint.getSignature().getName()
                    +"方法。方法返回值："+result);
            return result;
        } catch (Throwable throwable) {
            throwable.printStackTrace();

            logger.info("r:异常抛出增强调用："+joinPoint.getTarget()+"的"
                    +joinPoint.getSignature().getName()+"方法，方法抛出的异常："+throwable);
            throw new RuntimeException();
        }finally {
            logger.info("r:最终增强调用完："+joinPoint.getTarget()+"的"
                    +joinPoint.getSignature().getName()+"方法");
        }
    }
}
