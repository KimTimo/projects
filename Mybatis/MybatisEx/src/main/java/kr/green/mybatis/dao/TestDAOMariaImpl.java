package kr.green.mybatis.dao;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.green.mybatis.vo.TestVO;

public class TestDAOMariaImpl implements TestDAO {
	//----------------------------------------------------------------------
	private static TestDAO instance = new TestDAOMariaImpl();
	private TestDAOMariaImpl() {
		;
	}
	public static TestDAO getInstance() {
		return instance;
	}
	//----------------------------------------------------------------------
	@Override
	public Date getToday(SqlSession sqlSession) throws SQLException {
		return sqlSession.selectOne("mariadb.test.today");
	}

	@Override
	public int getCalc(SqlSession sqlSession, HashMap<String, Integer> map) throws SQLException {
		return sqlSession.selectOne("mariadb.test.calc", map);
	}
	
	@Override
	public TestVO getVO(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		return sqlSession.selectOne("mariadb.test.calcVO", map);
	}
	@Override
	public HashMap<String, Object> getMap(SqlSession sqlSession, HashMap<String, String> map) throws SQLException {
		return sqlSession.selectOne("mariadb.test.calcMap", map);
	}
}
