package kr.green.test;

import java.util.Date;
import java.util.HashMap;
import org.apache.ibatis.session.SqlSession;

public class TestDAO {
	//----------------------------------------------------------------------------
	private static TestDAO instance = new TestDAO();
	private TestDAO() {}
	public static TestDAO getInstance() { return instance; }
	//----------------------------------------------------------------------------
	// SQL명령어 1개당 1개의 메서드
	// 맵퍼 파일의 태그 1개당 메서드 1개
	public Date getToday(SqlSession sqlSession) {
		return sqlSession.selectOne("oracledb.test.today");
	}
	public int getCalc(SqlSession sqlSession, HashMap<String, Integer> map) {
		return sqlSession.selectOne("oracledb.test.calc", map);
	}
	public TestVO getCalcVO(SqlSession sqlSession,HashMap<String, String> map) {
		return sqlSession.selectOne("oracledb.test.calcVO", map);
	}
	public HashMap<String, Object> getCalcMap(SqlSession sqlSession,HashMap<String, String> map) {
		return sqlSession.selectOne("oracledb.test.calcMap", map);
	}
}
