package kr.green.category.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.category.dao.CategoryDAO;
import kr.green.category.vo.CategoryVO;
import kr.green.mybatis.MybatisApp;
/*
 * 과제 : 
 *  1) 대항목에 같은 카테고리가 존재하면 않된다.
 *  2) 동일한 참조의 같은 레벨에서 같은 카테고리가 존재하면 않된다.
 */
public class CategoryService {
	//----------------------------------------------------------------------------
	private static CategoryService instance = new CategoryService();
	private CategoryService() {}
	public static CategoryService getInstance() { return instance; }
	//----------------------------------------------------------------------------
	// 로직 1개당 메서드 1개씩 작성
	// 목록받기
	public List<CategoryVO> selectList() {
		List<CategoryVO> list = null;
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			list  = CategoryDAO.getInstance().selectList(sqlSession);
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
		return list;
	}
	// 대항목 저장하기
	public void insert(CategoryVO vo) {
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			CategoryDAO.getInstance().insert(sqlSession, vo);
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
	}
	// 하위 항목 저장하기
	public void insertrReply(CategoryVO vo) {
		SqlSession sqlSession = null;
		CategoryDAO categoryDAO = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			categoryDAO = CategoryDAO.getInstance();
			// -----------------------------------------------------------------------
			// 1) seq가 나보다 큰 값들을 모두 1씩 증가시킨다.
			categoryDAO.updateSeq(sqlSession, vo);
			// 2) ref는 그대로 seq와 lev는 +1 해서 저장하기 
			categoryDAO.insertrReply(sqlSession, vo);
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
	}
	public void updateItem(CategoryVO vo) {
		SqlSession sqlSession = null;
		CategoryDAO categoryDAO = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			categoryDAO = CategoryDAO.getInstance();
			// -----------------------------------------------------------------------
			categoryDAO.updateItem(sqlSession, vo);
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
	}
	public void deleteItem(CategoryVO vo) {
		SqlSession sqlSession = null;
		CategoryDAO categoryDAO = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			categoryDAO = CategoryDAO.getInstance();
			// -----------------------------------------------------------------------
			if(vo.getLev()==0) { // lev가 0이면 대항목
				categoryDAO.deleteItem(sqlSession, vo);
			} else {
				categoryDAO.deleteReply(sqlSession, vo);
			}
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
	}
}
