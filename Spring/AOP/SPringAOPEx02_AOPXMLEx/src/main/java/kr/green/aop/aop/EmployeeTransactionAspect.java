package kr.green.aop.aop;

import org.aspectj.lang.JoinPoint;

public class EmployeeTransactionAspect {
	public void selectByEmployeeId(JoinPoint joinPoint) {
		System.out.println("AOP 호출 : " + joinPoint.getSignature().getName());
	}
}
