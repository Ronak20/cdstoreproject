package com.cdstore.restws;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * aspect to log methods of Cd store rest web service
 * 
 * @author Ronak Chaudhari
 *
 */
@Aspect
public class CdStoreRestWSLogger {

	// private Logger log =
	// Logger.getLogger(CdStoreRestWSLogger.class.getName());
	private static Logger logger = LogManager
			.getLogger(CdStoreRestWSLogger.class);

	@Around("execution(* com.cdstore.restws..*.*(..))")
	public Object restAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		logger.info(LogConstant.ENTERED + proceedingJoinPoint.getSignature()
				+ " method ");
		logger.info(LogConstant.PARAMETER + proceedingJoinPoint.getArgs().toString());

		Object value = null;
		try {
			value = proceedingJoinPoint.proceed();
		} catch (Throwable e) {
			logger.error(LogConstant.ERROR + "Exception thrown in Method : "
					+ proceedingJoinPoint.toString() + e.getMessage(), e);
		}
		logger.info(LogConstant.EXITED
				+ proceedingJoinPoint.getSignature().getName() + " method.");
		// Return value=" + value);
		return value;
	}

	@AfterThrowing("execution(* com.cdstore.restws..*.*(..))")
	public void logExceptions(JoinPoint joinPoint) {
		logger.fatal("Exception thrown in Method : " + joinPoint.toString());
	}
}