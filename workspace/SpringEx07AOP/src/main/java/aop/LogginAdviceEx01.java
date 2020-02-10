package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogginAdviceEx01 implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// Filter의 기본 기능과 비슷하다.
		// MethodInvocation.proceed()는 FilterChain.doFilter()와
		// 비슷하다.

		System.out.println("전처리용 공통사항");

		Object rtnObj = arg0.proceed();

		System.out.println("후처리용 공통사항");

		return rtnObj;
	}
}
