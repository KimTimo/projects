package kr.green.mvc08.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.mvc08.dao.EmployeeDAO;
import kr.green.mvc08.vo.EmployeeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public void insert(EmployeeVO employeeVO) {
		log.debug("{}의 insert 호출 : {}", this.getClass().getName(), employeeVO);
		if(employeeVO!=null)
			try {
				employeeDAO.insert(employeeVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}

	@Override
	public void update(EmployeeVO employeeVO) {
		log.debug("{}의 update 호출 : {}", this.getClass().getName(), employeeVO);
		if(employeeVO!=null)
			try {
				employeeDAO.update(employeeVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	@Override
	public void delete(int id) {
		log.debug("{}의 delete 호출 : {}", this.getClass().getName(), id);
		try {
			employeeDAO.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	@Override
	public EmployeeVO selectById(int id) {
		log.debug("{}의 selectById 호출 : {}", this.getClass().getName(), id);
		EmployeeVO employeeVO = null;
		try {
			employeeVO = employeeDAO.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("{}의 selectById 리턴 : {}", this.getClass().getName(), employeeVO);
		return employeeVO;
	}

	@Override
	public List<EmployeeVO> selectList() {
		log.debug("{}의 selectList 호출", this.getClass().getName());
		List<EmployeeVO> list = null;
		try {
			list = employeeDAO.selectList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("{}의 selectList 리턴 : {} ", this.getClass().getName(), list);
		return list;
	}
}
