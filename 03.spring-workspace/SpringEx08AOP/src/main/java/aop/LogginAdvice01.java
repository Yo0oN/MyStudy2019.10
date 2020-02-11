package aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogginAdvice01 {
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {

		System.out.println("LogginAdvice01 전처리");

		Object rtnObj = joinPoint.proceed();

		System.out.println("LogginAdvice01 후처리");

		return rtnObj;
	}

	public void before() throws Throwable {
		System.out.println("LogginAdvice01 before 실행");
	}

	public void after() throws Throwable {
		System.out.println("LogginAdvice01 after 실행");
	}
}
