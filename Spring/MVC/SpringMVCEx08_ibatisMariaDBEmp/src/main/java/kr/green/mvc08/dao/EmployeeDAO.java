package kr.green.mvc08.dao;

import java.sql.SQLException;
import java.util.List;

import kr.green.mvc08.vo.EmployeeVO;

public interface EmployeeDAO {
	void insert(EmployeeVO employeeVO) throws SQLException;
	void update(EmployeeVO employeeVO) throws SQLException;
	void delete(int id) throws SQLException;
	EmployeeVO selectById(int id) throws SQLException;
	List<EmployeeVO> selectList() throws SQLException;
}
