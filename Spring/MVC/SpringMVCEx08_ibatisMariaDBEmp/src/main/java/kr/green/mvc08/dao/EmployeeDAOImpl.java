package kr.green.mvc08.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.green.mvc08.vo.EmployeeVO;

@Repository("employeeDAO")
public class EmployeeDAOImpl implements EmployeeDAO{

	@Autowired
	private SqlMapClient sqlMapClient;

	@Override
	public void insert(EmployeeVO employeeVO) throws SQLException {
		sqlMapClient.insert("emp.insert", employeeVO);
	}

	@Override
	public void update(EmployeeVO employeeVO) throws SQLException {
		sqlMapClient.update("emp.update", employeeVO);
	}

	@Override
	public void delete(int id) throws SQLException {
		sqlMapClient.delete("emp.delete", id);		
	}

	@Override
	public EmployeeVO selectById(int id) throws SQLException {
		return (EmployeeVO) sqlMapClient.queryForObject("emp.selectById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeVO> selectList() throws SQLException {
		return sqlMapClient.queryForList("emp.selectList");
	}
}
