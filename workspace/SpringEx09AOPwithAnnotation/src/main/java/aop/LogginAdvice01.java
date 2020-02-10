package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
// Annotaion으로 AOP 적용해보기.

@Aspect
public class LogginAdvice01 {
	// execute 메소드의 이름을 myTarget이라 지어준다.
	// = 어느 메소드에 적용할지 정해주는 Pointcut
	@Pointcut("execution(* execute())")
	private void myTarget() {
	}

	// 이름을 myTarget이라고 붙여둔 메소드 전, 후에 실행한다.
	@Around("myTarget()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		// 전처리
		System.out.println("전처리");

		Object rtnObj = joinPoint.proceed();

		// 후처리
		System.out.println("후처리");

		return rtnObj;
	}
}
