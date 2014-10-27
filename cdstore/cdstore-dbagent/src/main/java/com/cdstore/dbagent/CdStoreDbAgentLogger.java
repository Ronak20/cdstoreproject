/*package com.cdstore.dbagent;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

*//**
 * Aspect for logging in db agent
 * 
 * @author Ronak
 *
 *//*
@Aspect
public class CdStoreDbAgentLogger {

	private Logger log = Logger.getLogger(CdStoreDbAgentLogger.class.getName());

	@Around("execution(* com.cdstore.dbagent..*.*(..))")
	public Object dbAgentAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
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

	@AfterThrowing("execution(* com.cdstore.dbagent..*.*(..))")
	public void logExceptions(JoinPoint joinPoint) {
		log.severe("Exception thrown in Method : " + joinPoint.toString());
	}
}*/