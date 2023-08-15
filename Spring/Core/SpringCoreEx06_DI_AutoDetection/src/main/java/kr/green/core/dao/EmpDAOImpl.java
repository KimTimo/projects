package kr.green.core.dao;

import org.springframework.stereotype.Repository;

import kr.green.core.vo.Employee;

@Repository("empDAO")
public class EmpDAOImpl implements EmpDAO{
	@Override
	public void insert(Employee employee) {
		System.out.println(employee + "를 저장했습니다.");
	}

}
