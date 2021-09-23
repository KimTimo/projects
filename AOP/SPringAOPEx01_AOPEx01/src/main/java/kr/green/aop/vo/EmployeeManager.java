package kr.green.aop.vo;
import org.springframework.stereotype.Component;

@Component
public class EmployeeManager {
	public EmployeeVO getEmployeeById(int employeeId) {
		System.out.println("getEmployeeById 메서드 호출!!");
		return new EmployeeVO(employeeId, "나사장");
	}

	public EmployeeVO getEmployeeName(String employeeName) {
		System.out.println("getEmployeeByName 메서드 호출!!");
		return new EmployeeVO(101, employeeName);
	}
}
