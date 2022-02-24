package com.example.beanaoptest.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(public * com.example.beanaoptest.service..*.*(..))")
    public void beforeExec(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        System.err.println("aop in ..."+args[0]);
    }

}
