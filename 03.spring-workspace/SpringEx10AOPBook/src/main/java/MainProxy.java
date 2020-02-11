import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import di.AppCtx;
import spring.Calculator;
import spring.ExeTimeCalculator;
import spring.ImpeCalculator;
import spring.RecCalculator;

public class MainProxy {

	public static void main(String[] args) {
		// ImpeCalculator와 ReCalculator는 핵심기능,
		// 계산 시간을 측정하는 ExeTimeCalculator는 공통기능이다.

		// ImpeCalculator는 반복문을 이용하여 factorial을 실행하였다.
		ExeTimeCalculator ttCal1 = new ExeTimeCalculator(new ImpeCalculator());
		System.out.println(ttCal1.factorial(20));

		// ReCalculator는 재귀함수를 이용하여 factorial을 실행하였다.
		ExeTimeCalculator ttCal2 = new ExeTimeCalculator(new RecCalculator());
		System.out.println(ttCal2.factorial(20));

		System.out.println("=====================");

		// AOP를 이용하여 공통기능 사용하기
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		/*Calculator recCal = ctx.getBean("recCalculator", RecCalculator.class);
		Calculator impeCal = ctx.getBean("impeCalculator", ImpeCalculator.class);
		
		long recFiveFact = recCal.factorial(5);
		// ReCalculator의 핵심기능 실행
		System.out.println("reCal.factorial(5) = " + recFiveFact);
		// 공통기능 실행
		System.out.println(recCal.getClass().getName());
		
		long impeFiveFact = impeCal.factorial(5);
		System.out.println("impeCal.factorial(5) = " + impeFiveFact);
		System.out.println(impeCal.getClass().getName());*/
		
		Calculator recCal = ctx.getBean("recCalculator", Calculator.class);
		
		long fiveFact = recCal.factorial(5);
		System.out.println("cal.facotorial(5) = " + fiveFact);
		System.out.println(recCal.getClass().getName());

		Calculator impeCal = ctx.getBean("impeCalculator", ImpeCalculator.class);
		
		ctx.close();
	}
}
