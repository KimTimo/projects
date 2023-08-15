package kr.green.board.service;

import java.sql.Connection;

import kr.green.board.dao.FreeBoardDAO;
import kr.green.board.dao.FreeBoardDAOImpl;
import kr.green.board.vo.FreeBoardVO;
import kr.green.board.vo.PagingVO;
import kr.green.jdbc.DBCPUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FreeBoardServiceImpl implements FreeBoardService {
	// ----------------------------------------------------------------------------------------
	private static FreeBoardServiceImpl instance = new FreeBoardServiceImpl();

	private FreeBoardServiceImpl() {
		;
	}

	public static FreeBoardServiceImpl getInstance() {
		return instance;
	}
	// ----------------------------------------------------------------------------------------

	@Override
	public PagingVO<FreeBoardVO> selectList(int currentPage, int pageSize, int blockSize) {
		log.debug("FreeBoardServiceImpl selectList({},{},{})", currentPage, pageSize, blockSize);
		PagingVO<FreeBoardVO> pagingVO = null;
		Connection conn = null;
		FreeBoardDAO dao = null;
		try {
			conn = DBCPUtil.getConnection();
			dao = FreeBoardDAOImpl.getInstance();
			conn.setAutoCommit(false);
			//--------------------------------------------------------------------------
			int totalCount = dao.selectCount(conn); // 전체 개수
			pagingVO = new PagingVO<FreeBoardVO>(currentPage, pageSize, blockSize, totalCount); // 페이지 계산
			pagingVO.setList(dao.selectList(conn, pagingVO.getStartNo(), pagingVO.getPageSize())); // 글목록 넣기
			//--------------------------------------------------------------------------
			conn.commit();
		}catch (Exception e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		log.debug("FreeBoardServiceImpl selectList return : {}", pagingVO);
		return pagingVO;
	}

	@Override
	public FreeBoardVO selectByIdx(int idx, boolean isHit) {
		log.debug("FreeBoardServiceImpl selectByIdx({},{})", idx, isHit);
		FreeBoardVO freeBoardVO = null;
		Connection conn = null;
		FreeBoardDAO dao = null;
		try {
			conn = DBCPUtil.getConnection();
			dao = FreeBoardDAOImpl.getInstance();
			conn.setAutoCommit(false);
			//--------------------------------------------------------------------------
			freeBoardVO = dao.selectByIdx(conn, idx); // 글 가져오기
			if(freeBoardVO!=null && isHit) { // 해당 글번호의 글이 존재하면서 죄회수 증가라면
				dao.hitUpdate(conn, idx); // 조회수 증가
			}
			//--------------------------------------------------------------------------
			conn.commit();
		}catch (Exception e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		log.debug("FreeBoardServiceImpl  selectByIdx return : {}", freeBoardVO);
		return freeBoardVO;
	}

	@Override
	public int insert(FreeBoardVO vo) {
		log.debug("FreeBoardServiceImpl insert({})", vo);
		int count = 0;
		Connection conn = null;
		FreeBoardDAO dao = null;
		try {
			conn = DBCPUtil.getConnection();
			dao = FreeBoardDAOImpl.getInstance();
			conn.setAutoCommit(false);
			//--------------------------------------------------------------------------
			if(vo!=null) {
				count = dao.insert(conn, vo);
			}
			//--------------------------------------------------------------------------
			conn.commit();
		}catch (Exception e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		log.debug("FreeBoardServiceImpl  insert return : {}", count);
		return count;
	}

	@Override
	public int update(FreeBoardVO vo) {
		log.debug("FreeBoardServiceImpl update({})", vo);
		int count = 0;
		Connection conn = null;
		FreeBoardDAO dao = null;
		try {
			conn = DBCPUtil.getConnection();
			dao = FreeBoardDAOImpl.getInstance();
			conn.setAutoCommit(false);
			//--------------------------------------------------------------------------
			if(vo!=null) {
				// DB의 비번과 넘어온 vo의 비번이 일치 할때만 수정을 수행한다.
				FreeBoardVO DBVO = selectByIdx(vo.getIdx(), false);
				if(DBVO!=null) { // 해당 글번호의 글이 있을때만
					if(DBVO.getPassword().equals(vo.getPassword())) {
						count = dao.update(conn, vo);
					}
				}
			}
			//--------------------------------------------------------------------------
			conn.commit();
		}catch (Exception e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		log.debug("FreeBoardServiceImpl  update return : {}", count);
		return count;
	}

	@Override
	public int delete(FreeBoardVO vo) {
		log.debug("FreeBoardServiceImpl delete({})", vo);
		int count = 0;
		Connection conn = null;
		FreeBoardDAO dao = null;
		try {
			conn = DBCPUtil.getConnection();
			dao = FreeBoardDAOImpl.getInstance();
			conn.setAutoCommit(false);
			//--------------------------------------------------------------------------
			if(vo!=null) {
				// DB의 비번과 넘어온 vo의 비번이 일치 할때만 수정을 수행한다.
				FreeBoardVO DBVO = selectByIdx(vo.getIdx(), false);
				if(DBVO!=null) { // 해당 글번호의 글이 있을때만
					if(DBVO.getPassword().equals(vo.getPassword())) {
						count = dao.delete(conn, vo.getIdx());
					}
				}
			}
			//--------------------------------------------------------------------------
			conn.commit();
		}catch (Exception e) {
			DBCPUtil.rollback(conn);
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		log.debug("FreeBoardServiceImpl  delete return : {}", count);
		return count;
	}

}
