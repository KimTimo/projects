package kr.green.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.core.app.dao.SimpleDAO;

@Service("mariaService")
public class SimpleMariaService implements SimpleService{

	@Autowired
	SimpleDAO mariaDAO;
	
	@Override
	public String getNow() {
		return mariaDAO.getNow();
	}

	@Override
	public int getCalc(int num1, int num2) {
		return mariaDAO.getCalc(num1, num2);
	}

}
