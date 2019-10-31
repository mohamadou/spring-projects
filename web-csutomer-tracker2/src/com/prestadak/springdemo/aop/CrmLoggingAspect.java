package com.prestadak.springdemo.aop;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CrmLoggingAspect {

	private Logger myLogger = Logger.getLogger(getClass().getName());
	//Poincut declarations
	
	// For controller package
	@Pointcut("execution(* com.prestadak.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// For service package
	@Pointcut("execution(* com.prestadak.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	// For dao package
	@Pointcut("execution(* com.prestadak.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	// for appFlow
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void appFlow(){}
	
	@Before("appFlow()")
	private void beforeLogging(JoinPoint theJoinPoint ) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n>>>>>>>>> @Before methode :"+ theMethod);
		
		Object[] args = theJoinPoint.getArgs();
		
		for(Object arg: args) {
			myLogger.info("====>> argument: "+ arg);
		}
		
		
	}
	
	@AfterReturning(pointcut="appFlow()", returning="theResult")
	private void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n>>>>>>>>> @AfterReturning methode :"+ theMethod);
	
		myLogger.info("====>> Result : "+ theResult);
		
	}
}
