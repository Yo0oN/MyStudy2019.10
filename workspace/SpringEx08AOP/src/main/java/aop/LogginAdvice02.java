package aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogginAdvice02 {
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("LogginAdvice02 전처리");

		Object rtnObj = joinPoint.proceed();

		System.out.println("LogginAdvice02 후처리");

		return rtnObj;
	}
}
