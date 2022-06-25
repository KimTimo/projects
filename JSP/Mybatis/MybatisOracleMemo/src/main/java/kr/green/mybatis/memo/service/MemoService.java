package kr.green.mybatis.memo.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.mybatis.MybatisApp;
import kr.green.mybatis.memo.dao.MemoDAO;
import kr.green.mybatis.memo.vo.MemoVO;
import kr.green.mybatis.memo.vo.PagingVO;

public class MemoService {
	//----------------------------------------------------------------------------
	private static MemoService instance = new MemoService();
	private MemoService() {}
	public static MemoService getInstance() { return instance; }
	//----------------------------------------------------------------------------
	// 로직 1개당 메서드 1개씩 작성
	// 1. 1개 얻기
	public MemoVO selectByIdx(int idx) {
		MemoVO memoVO = null;
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			memoVO = MemoDAO.getInstance().selectByIdx(sqlSession, idx);
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
		return memoVO;
	}
	// 2. 1페이지 얻기
	public PagingVO<MemoVO> selectList(int currentPage, int pageSize, int blockSize){
		PagingVO<MemoVO> pagingVO = null;
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			int totalCount = MemoDAO.getInstance().selectCount(sqlSession);
			pagingVO = new PagingVO<MemoVO>(currentPage, pageSize, blockSize, totalCount);
			if(pagingVO.getTotalCount()>0) {
				HashMap<String, Integer> map = new HashMap<>();
				map.put("startNo", pagingVO.getStartNo());
				map.put("endNo", pagingVO.getEndNo());
				List<MemoVO> list = MemoDAO.getInstance().selectList(sqlSession, map);
				pagingVO.setList(list);
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
		return pagingVO;
	}
	
	// 아래 3개는 1개로 합칠 수 있다.
	// 3. 저장하기
	public void insert(MemoVO memoVO) {
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			if(memoVO!=null) {
				MemoDAO.getInstance().insert(sqlSession, memoVO);
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
	// 4. 수정하기
	public void update(MemoVO memoVO) {
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			if(memoVO!=null) {
				MemoVO dbVO = MemoDAO.getInstance().selectByIdx(sqlSession, memoVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(memoVO.getPassword())) {
					MemoDAO.getInstance().update(sqlSession, memoVO);
				}
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
	
	// 5. 삭제하기
	public void delete(MemoVO memoVO) {
		SqlSession sqlSession = null;
		try{
			// false 는 autoCommit 하지 않겠다는 의미.
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			// -----------------------------------------------------------------------
			if(memoVO!=null) {
				MemoVO dbVO = MemoDAO.getInstance().selectByIdx(sqlSession, memoVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(memoVO.getPassword())) {
					MemoDAO.getInstance().delete(sqlSession, memoVO.getIdx());
				}
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
