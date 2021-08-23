package kr.green.category.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.category.dao.CategoryDAO;
import kr.green.category.vo.CategoryVO;
import kr.green.mybatis.MybatisApp;

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
}
