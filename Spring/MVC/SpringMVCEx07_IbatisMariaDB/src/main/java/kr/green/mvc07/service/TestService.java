package kr.green.mvc07.service;

import kr.green.mvc07.vo.TestVO;

public interface TestService {
	String today();
	int sum(int num1, int num2);
	int mul(int num1, int num2);
	TestVO getTestVO(TestVO testVO);
}
