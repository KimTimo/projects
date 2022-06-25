package kr.green.mvc26.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import kr.green.mvc26.vo.TestVO;

public interface TestDAO {
	Date selectToday() throws SQLException;
	int selectSum(HashMap<String, Integer> hashMap) throws SQLException;
	int selectMul(HashMap<String, Integer> hashMap) throws SQLException;
	TestVO selectVO(TestVO testVO) throws SQLException;
}
