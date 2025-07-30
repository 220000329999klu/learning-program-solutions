package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.example.service.*.*(..))")
    public void beforeMethod(JoinPoint jp) {
        System.out.println("[LOG] Starting method: " + jp.getSignature());
    }

    @After("execution(* org.example.service.*.*(..))")
    public void afterMethod(JoinPoint jp) {
        System.out.println("[LOG] Completed method: " + jp.getSignature());
    }
}