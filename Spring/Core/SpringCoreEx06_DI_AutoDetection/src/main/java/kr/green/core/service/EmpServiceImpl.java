package kr.green.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.core.dao.EmpDAO;
import kr.green.core.vo.Employee;
import lombok.Data;

@Service("empService")
@Data
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpDAO empDAO;
	@Autowired
	private DateService dateService;
	
	@Override
	public void registerEmployee(Employee employee) {
		employee.setAssessmentDate(dateService.getNextAssessmentDate());
		empDAO.insert(employee);
		System.out.println("서비스에서 VO를 채우고 DAO를 불러 저장을 하자~~~");
	}
}
