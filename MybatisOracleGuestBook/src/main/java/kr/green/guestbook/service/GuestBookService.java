package kr.green.guestbook.service;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.guestbook.dao.GuestBookDAO;
import kr.green.guestbook.vo.GuestBookVO;
import kr.green.guestbook.vo.PagingVO;
import kr.green.mybatis.MybatisApp;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuestBookService {
	private static GuestBookService instance = new GuestBookService();

	private GuestBookService() {
	}

	public static GuestBookService getInstance() {
		return instance;
	}

	// ------------------------------------------------------------------
	// 1. 1개얻기
	public GuestBookVO selectByIdx(int idx) {
		log.debug("selectByIdx 인수 : {}", idx);
		GuestBookVO guestBookVO = null;
		// =====================================================================
		SqlSession sqlSession = null;
		GuestBookDAO dao = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = GuestBookDAO.getInstance();
			// -----------------------------------------------------------------
			guestBookVO = dao.selectByIdx(sqlSession, idx);
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================
		log.debug("selectByIdx 리턴 : {}", guestBookVO);
		return guestBookVO;
	}

	// 2. 1페이지 얻기
	public PagingVO<GuestBookVO> selectList(int currentPage, int pageSize, int blockSize) {
		log.debug("selectList 인수 : {}, {}, {}", currentPage, pageSize, blockSize);
		PagingVO<GuestBookVO> pagingVO = null;
		// =====================================================================
		SqlSession sqlSession = null;
		GuestBookDAO dao = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = GuestBookDAO.getInstance();
			// -----------------------------------------------------------------
			int totalCount = dao.selectCount(sqlSession);
			pagingVO = new PagingVO<GuestBookVO>(currentPage, pageSize, blockSize, totalCount);
			if(pagingVO.getTotalCount()>0) {
				HashMap<String, Integer> map = new HashMap<>();
				map.put("startNo", pagingVO.getStartNo());
				map.put("endNo", pagingVO.getEndNo());
				List<GuestBookVO> list = dao.selectList(sqlSession, map);
				
				pagingVO.setList(list);
			}
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================
		log.debug("selectList 리턴 : {}", pagingVO);
		return pagingVO;
	}
	// 3. 저장
	public void insert(GuestBookVO guestBookVO) {
		log.debug("insert 인수 : {}", guestBookVO);
		// =====================================================================
		SqlSession sqlSession = null;
		GuestBookDAO dao = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = GuestBookDAO.getInstance();
			// -----------------------------------------------------------------
			if(guestBookVO!=null) {
				dao.insert(sqlSession, guestBookVO);
			}
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================		
	}
	// 4. 수정
	public void update(GuestBookVO guestBookVO) {
		log.debug("update 인수 : {}", guestBookVO);
		// =====================================================================
		SqlSession sqlSession = null;
		GuestBookDAO dao = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = GuestBookDAO.getInstance();
			// -----------------------------------------------------------------
			if(guestBookVO!=null) {
				GuestBookVO dbVO = dao.selectByIdx(sqlSession, guestBookVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(guestBookVO.getPassword())) {
					dao.update(sqlSession, guestBookVO);
				}
			}
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================		
	}
	// 5. 삭제
	public void delete(GuestBookVO guestBookVO) {
		log.debug("delete 인수 : {}", guestBookVO);
		// =====================================================================
		SqlSession sqlSession = null;
		GuestBookDAO dao = null;
		try {
			sqlSession = MybatisApp.getSqlSessionFactory().openSession(false);
			dao = GuestBookDAO.getInstance();
			// -----------------------------------------------------------------
			if(guestBookVO!=null) {
				GuestBookVO dbVO = dao.selectByIdx(sqlSession, guestBookVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(guestBookVO.getPassword())) {
					dao.delete(sqlSession, guestBookVO.getIdx());
				}
			}
			// -----------------------------------------------------------------
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		// =====================================================================		
	}
}
