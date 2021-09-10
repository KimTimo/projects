package kr.green.mvc07.dao;

import java.sql.SQLException;

import kr.green.mvc07.vo.TestVO;

public interface TestDAO {
	String today() throws SQLException;
	int sum(int num1, int num2) throws SQLException;
	int mul(int num1, int num2) throws SQLException;
	TestVO getTestVO(TestVO testVO) throws SQLException;
}
