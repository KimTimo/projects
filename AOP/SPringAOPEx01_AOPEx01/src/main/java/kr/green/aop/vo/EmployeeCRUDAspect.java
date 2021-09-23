package kr.green.aop.vo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmployeeCRUDAspect {
	private long start, end;
	@Before("execution(* EmployeeManager.getEmployeeBy*(..))") // Point-Cut expression
	public void beforeLog(JoinPoint joinPoint) {
		// 메서드 실행 전에 로그를 출력
		System.out.println("실행 전 : " + joinPoint.getSignature().getName());
	}
	
	@After("execution(* EmployeeManager.getEmployee*(..))") // Point-Cut expression
	public void afterLog(JoinPoint joinPoint) {
		// 메서드 실행 후에 로그를 출력
		System.out.println("실행 후 : " + joinPoint.getSignature().getName());
	}
	
	@Before("execution(* EmployeeManager.getEmployee*(..))") // Point-Cut expression
	public void start(JoinPoint joinPoint) {
		//메서드 시작전에 시작시간을 저장
		start = System.currentTimeMillis();
	}
	@After("execution(* EmployeeManager.getEmployee*(..))") // Point-Cut expression
	public void end(JoinPoint joinPoint) {
		// 메서드 종료후에 종료시간을 출력
		end = System.currentTimeMillis(); // 메서드 시작전에 시작시간을 저장
		System.out.println("실행시간 : " + (end-start) + "ms");
	}
}
