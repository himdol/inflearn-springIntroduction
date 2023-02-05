package com.example.infleanintroduction.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {

  @Around("execution(* com.example..*(..))")
  public Object excute(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    long start = System.currentTimeMillis();
    System.out.println("START : " + proceedingJoinPoint.toString());
    try {

      return proceedingJoinPoint.proceed();

    } finally {
      long finish = System.currentTimeMillis();
      long timeMs = finish - start;
      System.out.println("END : " + proceedingJoinPoint.toString() + " " + timeMs + "ms");
    }
  }

}
