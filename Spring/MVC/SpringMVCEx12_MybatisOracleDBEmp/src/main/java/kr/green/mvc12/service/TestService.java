package kr.green.mvc12.service;

import java.util.Date;

import kr.green.mvc12.vo.TestVO;

public interface TestService {
	Date selectToday();
	int selectSum(int num1, int num2);
	int selectMul(int num1, int num2);
	TestVO selectVO(TestVO testVO);
}
