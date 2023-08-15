package kr.green.mvc02.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.mvc02.dao.EmployeeDAO;
import kr.green.mvc02.vo.EmployeeVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDAO employeeDAO;

	@Override
	public void save(EmployeeVO employee) {
		log.debug(this.getClass().getName() + " save 호출 : " + employee);
		employeeDAO.save(employee);
	}
	
	@Override
	public EmployeeVO getById(int id) {
		log.debug(this.getClass().getName() + " getById 호출 : " + id);
		EmployeeVO employeeVO = employeeDAO.getById(id);
		log.debug(this.getClass().getName() + " getById 리턴 : " + employeeVO);
		return employeeVO;
	}

	@Override
	public void update(EmployeeVO employee) {
		log.debug(this.getClass().getName() + " update 호출 : " + employee);
		employeeDAO.update(employee);
	}

	@Override
	public void deleteById(int id) {
		log.debug(this.getClass().getName() + " deleteById 호출 : " + id);
		employeeDAO.deleteById(id);
	}

	@Override
	public List<EmployeeVO> getAll() {
		log.debug(this.getClass().getName() + " getAll 호출 : ");
		List<EmployeeVO> list = employeeDAO.getAll();
		log.debug(this.getClass().getName() + " getAll 리턴 : " + list);
		return list;
	}

}
