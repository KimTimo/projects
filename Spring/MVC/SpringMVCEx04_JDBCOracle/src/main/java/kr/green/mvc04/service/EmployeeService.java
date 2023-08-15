package kr.green.mvc04.service;

import java.util.List;

import kr.green.mvc04.vo.EmployeeVO;

public interface EmployeeService {
	// Create
	public void save(EmployeeVO employee);

	// Read
	public EmployeeVO getById(int id);

	// Update
	public void update(EmployeeVO employee);

	// Delete
	public void deleteById(int id);

	// Get All
	public List<EmployeeVO> getAll();
}
