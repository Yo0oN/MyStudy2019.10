package spring;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

// AOP
// Aspect 어노테이션은 Advice(언제)와 Pointcut(어디서)을 제공해준다.
@Aspect
public class ExeTimeAspect {
	// 공통기능을 스프링 AOP로 + Annotation으로 구현하기

	// Poincout 어노테이션은 어디서(=어느메소드에서) 실행할 지 정해준다.
	@Pointcut("execution(public * spring..*(..))")
	private void publicTarget() {
	}

	// Around 어노테이션은 Around Advice로 
	// 실행 지점(publicTarget)의 전에 실행하는지, 후에 실행하는지 정할 때 사용한다.
	@Around("publicTarget()")
	// ProceedingJoinPoint는 프록시 대상 객체의 메서드를 호출할 때 사용한다.
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			System.out.println("전처리");
			
			// procced메서드는 실제 대상 객체를 호출하여,
			// 대상 객체의 메서드를 실행시킨다.
			Object result = joinPoint.proceed();
			
			System.out.println("후처리");
			
			return result;
		} finally {
			long finish = System.nanoTime();
			Signature sig = joinPoint.getSignature();
			System.out.printf("%s.%s(%s) 실행시간 : %d ns\n", joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(), Arrays.toString(joinPoint.getArgs()), (finish - start));
		}
	}
}
