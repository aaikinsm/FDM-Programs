package com.fdmgroup.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect2 {

	@Pointcut("execution(* com.fdmgroup.service.ShoppingCart.*(..))")
	private void emptyMethod(){}
	
	@Pointcut("execution(Integer com.fdmgroup.service.ShoppingCart.loop())")
	private void profiler(){}
	
	@Before("emptyMethod()")
	public void logBefore(JoinPoint jp){
		System.out.println("Logging before. "+jp.getSignature().getName()+"-->"+Arrays.toString(jp.getArgs()));
	}
	
	@After("emptyMethod()")
	public void logAfter(JoinPoint jp){
		System.out.println("Logging after. "+jp.getSignature().getName()+"-->"+Arrays.toString(jp.getArgs()));
	}
	
	@AfterThrowing("emptyMethod()")
	public void logAfterThrow(JoinPoint jp){
		System.out.println("Logging after throwing exception. "+jp.getSignature().getName()+"-->"+Arrays.toString(jp.getArgs()));
	}
	
	@Around("profiler()")
	public void logAround(ProceedingJoinPoint pjp){
		long startTime = System.nanoTime();
		try {
			Integer rVal = (Integer) pjp.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		long stopTime = System.nanoTime();
		
		System.out.println("Execution of "+pjp.getSignature().getName()+" with arguments "+Arrays.toString(pjp.getArgs())+" took "+(stopTime-startTime));
	}
}
