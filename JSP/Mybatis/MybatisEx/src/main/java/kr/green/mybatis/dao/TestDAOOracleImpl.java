package kr.green.mybatis.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.green.mybatis.vo.TestVO;

public class TestDAOOracleImpl implements TestDAO {
	//----------------------------------------------------------------------
	private static TestDAO instance = new TestDAOOracleImpl();
	private TestDAOOracleImpl() {
		;
	}
	public static TestDAO getInstance() {
		return instance;
	}
	//----------------------------------------------------------------------
	@Override
	public Date getToday(SqlSession sqlSession) throws SQLException {
		return sqlSession.selectOne("oracledb.test.today");
	}

	@Override
	public int getCalc(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
		return sqlSession.selectOne("oracledb.test.calc", map);
	}
	
	@Override
	public TestVO getVO(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		return sqlSession.selectOne("oracledb.test.calcVO", map);
	}
	@Override
	public HashMap<String, Object> getMap(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		return sqlSession.selectOne("oracledb.test.calcMap", map);
	}
}
