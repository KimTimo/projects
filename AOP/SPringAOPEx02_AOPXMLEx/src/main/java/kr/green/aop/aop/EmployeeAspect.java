package kr.green.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class EmployeeAspect {
	long startTime, endTime;
	public void beforeLog(JoinPoint joinPoint) {
		startTime = System.nanoTime(); // 시작
		System.out.println("EmployeeAspect.beforeLog() 실행 : " + joinPoint.getSignature().getName());
	}

	public void afterLog(JoinPoint joinPoint) {
		System.out.println("EmployeeAspect.afterLog() 실행 : " + joinPoint.getSignature().getName());
		endTime = System.nanoTime(); // 종료
		System.out.println(joinPoint.getSignature().getName() + "의 실행시간 : " + (endTime-startTime) + "ns"); // 실행시간 출력
	}

	public void afterReturingLog(Object returnValue) {
		System.out.println("EmployeeAspect.afterReturingLog() 실행 : " + returnValue);
	}
	
	public void afterThrowingLog(Exception exception) {
		System.out.println("EmployeeAspect.afterThrowingLog() 실행 : " + exception);
	}

	public void afterAllLog(JoinPoint joinPoint) {
		System.out.println("EmployeeAspect.afterAllLog() 실행 : " + joinPoint.getSignature().getName());
	}
	
	// Around일 경우에는 반드시 ProceedingJoinPoint을 인수로 받고
	// 전과 후 사이에 반드시 ProceedingJoinPoint의 proceed() 메서드를 호출해 줘야 한다.
	public void aroundAllLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("EmployeeAspect.aroundAllLog() 선행 *************");

		proceedingJoinPoint.proceed();
		
		System.out.println("EmployeeAspect.aroundAllLog() 후행 *************");
	}
	
	// 서비스 클래스의 모든 메서드들의 실행 시간을 출력하고 싶다.
	// 이 기능을 around를 이용하여 적용시켜 보시오!!!!
	public void aroundTimeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long start = System.nanoTime();	
		
		proceedingJoinPoint.proceed();
		
		System.out.println(proceedingJoinPoint.getSignature().getName() + "메서드의 실행시간 : " + (System.nanoTime()-start) + "ns");
	}
	
}
