package kr.green.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class EmployeeAspect {
	
	@Before("execution(* kr.green.aop.service.EmployeeServiceImpl.select*(..))")
	public void beforeLog(JoinPoint joinPoint) {
		System.out.println("EmployeeAspect.beforeLog() 실행 : " + joinPoint.getSignature().getName());
	}

	@After("execution(* kr.green.aop.service.EmployeeServiceImpl.select*(..))")
	public void afterLog(JoinPoint joinPoint) {
		System.out.println("EmployeeAspect.afterLog() 실행 : " + joinPoint.getSignature().getName());
	}

	public void afterReturingLog(Object returnValue) {
		System.out.println("EmployeeAspect.afterReturingLog() 실행 : " + returnValue);
	}
	
	public void afterThrowingLog(Exception exception) {
		System.out.println("EmployeeAspect.afterThrowingLog() 실행 : " + exception);
	}
	
	@After("execution(* kr.green.aop.service.EmployeeServiceImpl.*(..))")
	public void afterAllLog(JoinPoint joinPoint) {
		System.out.println("EmployeeAspect.afterAllLog() 실행 : " + joinPoint.getSignature().getName());
	}
	
	// Around일 경우에는 반드시 ProceedingJoinPoint을 인수로 받고
	// 전과 후 사이에 반드시 ProceedingJoinPoint의 proceed() 메서드를 호출해 줘야 한다.
	@Around("execution(* kr.green.aop.service.EmployeeServiceImpl.*(..))")
	public void aroundAllLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		System.out.println("EmployeeAspect.aroundAllLog() 선행 *************");

		proceedingJoinPoint.proceed();
		
		System.out.println("EmployeeAspect.aroundAllLog() 후행 *************");
	}
	
	@Around("execution(* kr.green.aop.service.EmployeeServiceImpl.*(..))")
	public void aroundTimeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		long startTime = System.nanoTime();
		
		proceedingJoinPoint.proceed();
		
		long endTime = System.nanoTime();
		System.out.println( proceedingJoinPoint.getSignature().getName() +  "의 실행시간 : " + (endTime-startTime) + "ns");
	}
	
}
