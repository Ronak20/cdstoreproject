package com.cdstore.restws;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class CdStoreRestWSLogger {

	private Logger log = Logger.getLogger(CdStoreRestWSLogger.class.getName());

	@Around("execution(* com.cdstore.restws..*.*(..))")
	public Object restAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		log.info("Before invoking " + proceedingJoinPoint.getSignature()
				+ " method");
		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		log.info("After invoking "
				+ proceedingJoinPoint.getSignature().getName() + " method.");// Return
																				// value="
																				// +
																				// value);
		return value;
	}

	@AfterThrowing("execution(* com.cdstore.restws..*.*(..))")
	public void logExceptions(JoinPoint joinPoint) {
		log.severe("Exception thrown in Method : " + joinPoint.toString());
	}
}