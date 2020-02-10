package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class LogginAdviceEx02 implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		// pointcut(Aspect를 적용시킬 메소드) 이름을 가져온다.
		String methodName = invocation.getMethod().getName();
		System.out.println(methodName + " 호출 시작");

		StopWatch stopWatch = new StopWatch();
		stopWatch.start(methodName);

		Object rtnObj = invocation.proceed();

		stopWatch.stop();
		System.out.println(methodName + " 호출 끝");
		System.out.println("실행시간 : " + stopWatch.getTotalTimeSeconds() + "초");

		return rtnObj;
	}
}
