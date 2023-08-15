package kr.green.aop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.green.aop.vo.EmployeeVO;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Override
	public List<EmployeeVO> selectAllList() {
		System.out.println("selectAllList 호출");
		List<EmployeeVO> list = new ArrayList<EmployeeVO>();
		list.add(new EmployeeVO(1,"나사장"));
		list.add(new EmployeeVO(2,"나전무"));
		list.add(new EmployeeVO(3,"나상무"));
		list.add(new EmployeeVO(4,"나부장"));
		list.add(new EmployeeVO(5,"나과장"));
		return list;
	}

	@Override
	public EmployeeVO selectById(int employeeId) {
		System.out.println("selectById 호출");
		return new EmployeeVO(employeeId, "나직원");
	}

	@Override
	public EmployeeVO selectByName(String employeeName) {
		System.out.println("selectByName 호출");
		return new EmployeeVO(6, employeeName);
	}

	@Override
	public void insertEmployee(EmployeeVO vo) {
		System.out.println("insertEmployee 호출");
	}

	@Override
	public void updateEmployee(EmployeeVO vo) {
		System.out.println("updateEmployee 호출");
	}

	@Override
	public void deleteEmployee(EmployeeVO vo) {
		System.out.println("deleteEmployee 호출");
	}

	@Override
	public void deleteEmployee(int employeeId) throws Exception {
		throw new Exception("삭제하고자 하는 글번호가 없습니다.");
	}

}
