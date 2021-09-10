package kr.green.mvc07.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.mvc07.dao.TestDAO;
import kr.green.mvc07.vo.TestVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("testService")
public class TestServiceImpl implements TestService{

	@Autowired
	private TestDAO testDAO;

	@Override
	public String today() {
		log.info("{}의 today() 호출", this.getClass().getName());
		String today = null;
		try {
			today = testDAO.today();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("{}의 today() 리턴값 : {}", this.getClass().getName(), today);
		return today;
	}

	@Override
	public int sum(int num1, int num2) {
		log.info("{}의 sum() 호출 : {}", this.getClass().getName(), num1 + " + " + num2);
		int  result = 0;
		try {
			result = testDAO.sum(num1, num2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("{}의 sum() 리턴값 : {}", this.getClass().getName(), result);
		return result;
	}

	@Override
	public int mul(int num1, int num2) {
		log.info("{}의 mul() 호출 : {}", this.getClass().getName(), num1 + " * " + num2);
		int  result = 0;
		try {
			result = testDAO.mul(num1, num2);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("{}의 mul() 리턴값 : {}", this.getClass().getName(), result);
		return result;
	}

	@Override
	public TestVO getTestVO(TestVO testVO) {
		log.info("{}의 getTestVO() 호출 : {}", this.getClass().getName(), testVO);
		TestVO  resultVO = null;
		try {
			resultVO = testDAO.getTestVO(testVO);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.info("{}의 mul() 리턴값 : {}", this.getClass().getName(), resultVO);
		return resultVO;
	}
}
