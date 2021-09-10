package kr.green.mybatis.service;

import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.green.mybatis.MybatisApp;
import kr.green.mybatis.dao.TestDAO;
import kr.green.mybatis.dao.TestDAOMariaImpl;
import kr.green.mybatis.dao.TestDAOOracleImpl;
import kr.green.mybatis.vo.TestVO;

public class TestService {
	//----------------------------------------------------------------------
	private static TestService instance = new TestService();
	private TestService() {
		;
	}
	public static TestService getInstance() {
		return instance;
	}
	//----------------------------------------------------------------------

	public HashMap<String, Object> testOracle(){
		HashMap<String, Object> map = new HashMap<>();
		SqlSession sqlSession = null;
		TestDAO testDAO = null;
		try {
			sqlSession = MybatisApp.getOracleSessionFactory().openSession(false);
			testDAO = TestDAOOracleImpl.getInstance();
			//-------------------------------------------------------------------
			Date today = testDAO.getToday(sqlSession);
			HashMap<String, Integer> map2 = new HashMap<>();
			map2.put("num1", 22);
			map2.put("num2", 3);
			map2.put("num3", 5);
			int calc = testDAO.getCalc(sqlSession, map2);
			
			map.put("today", today);
			map.put("calc", calc);
			
			//-------------------------------------------------------------------
			HashMap<String, String> map3 = new HashMap<>();
			map3.put("num1", "11");
			map3.put("num2", "5");
			map3.put("num3", "4");
			map3.put("name", "한사람");
			TestVO testVO = testDAO.getVO(sqlSession, map3);
			HashMap<String, Object> hashMap = testDAO.getMap(sqlSession, map3);
						
			map.put("testVO", testVO);
			map.put("hashMap", hashMap);
			
			//-------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			try {
				if(sqlSession!=null)sqlSession.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}
	public HashMap<String, Object> testMaria(){
		HashMap<String, Object> map = new HashMap<>();
		SqlSession sqlSession = null;
		TestDAO testDAO = null;
		try {
			sqlSession = MybatisApp.getMariaSessionFactory().openSession(false);
			testDAO = TestDAOMariaImpl.getInstance();
			//-------------------------------------------------------------------
			Date today = testDAO.getToday(sqlSession);
			HashMap<String, Integer> map2 = new HashMap<>();
			map2.put("num1", 22);
			map2.put("num2", 3);
			map2.put("num3", 5);
			int calc = testDAO.getCalc(sqlSession, map2);
			
			map.put("today", today);
			map.put("calc", calc);
			
			//-------------------------------------------------------------------
			HashMap<String, String> map3 = new HashMap<>();
			map3.put("num1", "11");
			map3.put("num2", "5");
			map3.put("num3", "4");
			map3.put("name", "두사람");
			TestVO testVO = testDAO.getVO(sqlSession, map3);
			HashMap<String, Object> hashMap = testDAO.getMap(sqlSession, map3);
			
			map.put("testVO", testVO);
			map.put("hashMap", hashMap);
			//-------------------------------------------------------------------
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			try {
				if(sqlSession!=null)sqlSession.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}
}
