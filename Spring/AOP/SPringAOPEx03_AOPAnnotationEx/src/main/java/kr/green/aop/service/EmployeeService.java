package kr.green.aop.service;

import java.util.List;

import kr.green.aop.vo.EmployeeVO;

public interface EmployeeService {
	// 1. 모두 얻기
	public List<EmployeeVO> selectAllList();
	// 2. 1개 얻기
	public EmployeeVO selectById(int employeeId);
	public EmployeeVO selectByName(String employeeName);
	// 3. 저장하기
	public void insertEmployee(EmployeeVO vo);
	// 4. 수정하기
	public void updateEmployee(EmployeeVO vo);
	// 5. 삭제하기
	public void deleteEmployee(EmployeeVO vo);
	public void deleteEmployee(int employeeId) throws Exception; // 예외발생
	
}
