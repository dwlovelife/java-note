package com.spring.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(2)
public class LogAspect {

    /**
     * 在方法开始的时候记录日志
     * 写切入点表达式:告诉AOP这个方法在哪些方法的哪个位置切入
     * 相当于是方法的全部描述
     */
    @Before(value = "execution(* com.spring.service.IUserService.*())")
    public void logStart(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("[AOP日志方法开始],方法名【" + name + "】,参数列表：" + Arrays.asList(args));
    }

    @After(value = "execution(* com.spring.service.IUserService.*())")
    public void logEnd() {
        System.out.println("[AOP日志]方法最终结束");
    }

    @AfterReturning(value = "execution(* com.spring.service.IUserService.*())", returning = "result")
    public void logReturn(JoinPoint joinPoint, Object result) {
        String name = joinPoint.getSignature().getName();

        System.out.println("[AOP日志]方法正常返回" + "方法名【" + name + "】,返回结果:" + result);
    }

    @AfterThrowing(value = "execution(* com.spring.service.IUserService.*())", throwing = "e")
    public void logException(JoinPoint joinPoint, Throwable e) {
        System.out.println("[AOP日志]方法出现异常[方法名：" + joinPoint.getSignature().getName() + "][异常对象：" + e + "]");
    }

}
