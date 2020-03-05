package com.fuze.po.PurchaseOrderAppServices.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

/**
 * @author Bhajuram.c
 *
 */
@Aspect
@Component
public class LoggingService {

	private static final Logger LOGGER = LogManager.getLogger(LoggingService.class);

	/**
	 * @param proceedingJoinPoint
	 * @throws Throwable
	 */
	@Around("execution(* com.fuze.po.PurchaseOrderAppServices..*(..)))")
	public Object aroundLoggingService(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
		// Get intercepted method details
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		LOGGER.info("Execution of " + className + "." + methodName + " started");
		Object results = proceedingJoinPoint.proceed();
		LOGGER.info("Execution of " + className + "." + methodName + " ended");
		return results;
	}

}
