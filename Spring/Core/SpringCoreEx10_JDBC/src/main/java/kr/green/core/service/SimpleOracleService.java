package kr.green.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.core.app.dao.SimpleDAO;

@Service("oracleService")
public class SimpleOracleService implements SimpleService{

	@Autowired
	SimpleDAO oracleDAO;
	
	@Override
	public String getNow() {
		return oracleDAO.getNow();
	}

	@Override
	public int getCalc(int num1, int num2) {
		return oracleDAO.getCalc(num1, num2);
	}

}
