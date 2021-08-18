package kr.green.mybatis.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.green.mybatis.vo.TestVO;

public interface TestDAO {
	Date getToday(SqlSession sqlSession) throws SQLException;
	int getCalc(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException;
	
	TestVO getVO(SqlSession sqlSession, HashMap<String, String> map) throws SQLException;
	HashMap<String, Object> getMap(SqlSession sqlSession, HashMap<String, String> map) throws SQLException;
}
