package kr.green.mvc12.service;

import java.util.List;

import kr.green.mvc12.vo.EmployeeVO;

public interface EmployeeService {
	void insert(EmployeeVO employeeVO);
	void update(EmployeeVO employeeVO);
	void delete(int id);
	EmployeeVO selectById(int id);
	List<EmployeeVO> selectList();
}
