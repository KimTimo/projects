package kr.green.guestbook.service;

import java.util.Date;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.green.guestbook.dao.TestDAO;
import kr.green.guestbook.vo.TestVO;
import kr.green.mybatis.MybatisApp;

public class TestService {
	//----------------------------------------------------------------------------
	private static TestService instance = new TestService();
	private TestService() {}
	public static TestService getInstance() { return instance; }
	//----------------------------------------------------------------------------
	// 로직 1개당 메서드 1개씩 작성
	// 현재 시간이 뭐니?
	public Date getToday() {
		Date today = null;
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			today = TestDAO.getInstance().getToday(sqlSession);
			// -----------------------------------------------------------------------
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			try {
				if(sqlSession!=null) sqlSession.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return today;
	}
	// 계산 결과가 뭐니?
	public int getCalc(int n1, int n2, int n3) {
		int result = 0;
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			HashMap<String, Integer> map = new HashMap<>();
			map.put("num1", n1);
			map.put("num2", n2);
			map.put("num3", n3);
			result = TestDAO.getInstance().getCalc(sqlSession, map);
			// -----------------------------------------------------------------------
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			try {
				if(sqlSession!=null) sqlSession.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return result;
	}
	// VO로 받아지니?
	public TestVO getTestVO(int n1, int n2, int n3, String name) {
		TestVO testVO = null;
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			HashMap<String, String> map = new HashMap<>();
			map.put("num1", n1 + "");
			map.put("num2", n2 + "");
			map.put("num3", n3 + "");
			map.put("name", name);
			testVO = TestDAO.getInstance().getCalcVO(sqlSession, map);
			// -----------------------------------------------------------------------
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			try {
				if(sqlSession!=null) sqlSession.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return testVO;
	}
	// Map으로 받아지니?
	public HashMap<String, Object> getHashMap(int n1, int n2, int n3, String name) {
		HashMap<String, Object> map = null;
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			HashMap<String, String> map2 = new HashMap<>();
			map2.put("num1", n1 + "");
			map2.put("num2", n2 + "");
			map2.put("num3", n3 + "");
			map2.put("name", name);
			map = TestDAO.getInstance().getCalcMap(sqlSession, map2);
			// -----------------------------------------------------------------------
			sqlSession.commit();
		}catch(Exception e){
			sqlSession.rollback();
			e.printStackTrace();
		}finally{
			try {
				if(sqlSession!=null) sqlSession.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}		
		return map;
	}
	
}
