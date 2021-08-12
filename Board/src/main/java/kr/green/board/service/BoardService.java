package kr.green.board.service;

import java.sql.Connection;
import java.util.List;

import kr.green.board.dao.BoardDAO;
import kr.green.board.dao.CommentDAO;
import kr.green.board.vo.BoardVO;
import kr.green.board.vo.CommentVO;
import kr.green.board.vo.PagingVO;
import kr.green.jdbc.DBCPUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BoardService{
	private static BoardService instance = new BoardService();
	private BoardService() {}
	public static BoardService getInstance() { return instance; }
	//--------------------------------------------------------------

	// 1. 목록보기
	public PagingVO<BoardVO> selectList(int currentPage, int pageSize, int blockSize){
		log.debug("서비스 selectList 인수 : {}, {}, {}", currentPage, pageSize, blockSize);
		PagingVO<BoardVO> pagingVO = null;
		Connection conn = null;
		BoardDAO   boardDAO = null;
		CommentDAO commentDAO = null;
		try {
			conn = DBCPUtil.getConnection();
			boardDAO = BoardDAO.getInstance();
			commentDAO = CommentDAO.getInstance();
			conn.setAutoCommit(false); // 트랜젝션시작
			//--------------------------------------------------
			int totalCount = boardDAO.selectCount(conn); // 전체 개수 구하기
			pagingVO = new PagingVO<BoardVO>(currentPage, pageSize, blockSize, totalCount); // 페이지 계산
			// 글목록을 얻어온다
			List<BoardVO> list = boardDAO.selectList(conn, pagingVO.getStartNo(), pagingVO.getPageSize());
			// 글목록에 댓글의 개수를 추가로 넣어준다. ---- 이 부분이 추가된다.
			if(list!=null) {
				for(BoardVO vo : list) {
					vo.setCommentCount(commentDAO.selectCount(conn, vo.getIdx()));
				}
			}
			// 글목록을 페이징 객체에 넣어준다.
			pagingVO.setList(list);
			//--------------------------------------------------
			conn.commit(); // DB에 적용
		}catch (Exception e) {
			DBCPUtil.rollback(conn); // 에러나면 DB에 취소
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		log.debug("서비스 selectList 리턴값 : {}", pagingVO);
		return pagingVO;
	}
	// 2. 1 --> 새글쓰기
	public int insert(BoardVO boardVO) {
		log.debug("서비스 insert 인수 : {}", boardVO);
		int count = 0;
		Connection conn = null;
		BoardDAO   boardDAO = null;
		try {
			conn = DBCPUtil.getConnection();
			boardDAO = BoardDAO.getInstance();
			conn.setAutoCommit(false); // 트랜젝션시작
			//--------------------------------------------------
			if(boardVO!=null) {
				count = boardDAO.insert(conn, boardVO);
			}
			//--------------------------------------------------
			conn.commit(); // DB에 적용
		}catch (Exception e) {
			DBCPUtil.rollback(conn); // 에러나면 DB에 취소
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		
		log.debug("서비스 insert 리턴값 : {}", count);
		return count;
	}
	
	// 3. 1 -- > 내용보기 
	public BoardVO selectByIdx(int idx, boolean isHit) {
		log.debug("서비스 selectByIdx 인수 : {}, {}", idx, isHit);
		BoardVO boardVO = null;
		Connection conn = null;
		BoardDAO   boardDAO = null;
		CommentDAO commentDAO = null;
		try {
			conn = DBCPUtil.getConnection();
			boardDAO = BoardDAO.getInstance();
			commentDAO = CommentDAO.getInstance();
			conn.setAutoCommit(false); // 트랜젝션시작
			//--------------------------------------------------
			boardVO = boardDAO.selectByIdx(conn, idx);
			if(boardVO!=null && isHit) {
				boardDAO.updateHit(conn, idx); // 조회수 증가
				// 읽은 데이터에는 조회수가 증가되지 않았다!!!!
				boardVO.setHit(boardVO.getHit()+1); // 조회수를 수종으로 증가 시킨다.
			}
			// 댓글들을 읽어서 boardVO에 저장을 한다.
			List<CommentVO> list = commentDAO.selectList(conn, boardVO.getIdx());
			boardVO.setList(list);
			//--------------------------------------------------
			conn.commit(); // DB에 적용
		}catch (Exception e) {
			DBCPUtil.rollback(conn); // 에러나면 DB에 취소
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		
		log.debug("서비스 selectByIdx 리턴값 : {}", boardVO);
		return boardVO;
	}
	// 4. 3 --> 댓글쓰기
	public int commentInsert(CommentVO commentVO) {
		log.debug("서비스 commentInsert 인수 : {}", commentVO);
		int count = 0;
		Connection conn = null;
		CommentDAO commentDAO = null;
		try {
			conn = DBCPUtil.getConnection();
			commentDAO = CommentDAO.getInstance();
			conn.setAutoCommit(false); // 트랜젝션시작
			//--------------------------------------------------
			if(commentVO!=null) {
				count = commentDAO.insert(conn, commentVO);
			}
			//--------------------------------------------------
			conn.commit(); // DB에 적용
		}catch (Exception e) {
			DBCPUtil.rollback(conn); // 에러나면 DB에 취소
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}		
		log.debug("서비스 commentInsert 리턴값 : {}", count);
		return count;
	}
	// 5. 3 --> 댓글 수정
	public int commentUpdate(CommentVO commentVO) {
		log.debug("서비스 commentUpdate 인수 : {}", commentVO);
		int count = 0;
		Connection conn = null;
		CommentDAO commentDAO = null;
		try {
			conn = DBCPUtil.getConnection();
			commentDAO = CommentDAO.getInstance();
			conn.setAutoCommit(false); // 트랜젝션시작
			//--------------------------------------------------
			if(commentVO!=null) {
				CommentVO dbVO = commentDAO.selectByIdx(conn, commentVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(commentVO.getPassword())) {
					count = commentDAO.update(conn, commentVO);
				}
			}
			//--------------------------------------------------
			conn.commit(); // DB에 적용
		}catch (Exception e) {
			DBCPUtil.rollback(conn); // 에러나면 DB에 취소
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}		
		log.debug("서비스 commentUpdate 리턴값 : {}", count);
		return count;
	}
	// 6. 3 --> 댓글 삭제
	public int commentDelete(CommentVO commentVO) {
		log.debug("서비스 commentDelete 인수 : {}", commentVO);
		int count = 0;
		Connection conn = null;
		CommentDAO commentDAO = null;
		try {
			conn = DBCPUtil.getConnection();
			commentDAO = CommentDAO.getInstance();
			conn.setAutoCommit(false); // 트랜젝션시작
			//--------------------------------------------------
			if(commentVO!=null) {
				CommentVO dbVO = commentDAO.selectByIdx(conn, commentVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(commentVO.getPassword())) {
					count = commentDAO.delete(conn, commentVO.getIdx());
				}
			}
			//--------------------------------------------------
			conn.commit(); // DB에 적용
		}catch (Exception e) {
			DBCPUtil.rollback(conn); // 에러나면 DB에 취소
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}				
		log.debug("서비스 commentDelete 리턴값 : {}", count);
		return count;
	}
	// 7. 3 --> 원본 수정 하기 
	public int update(BoardVO boardVO) {
		log.debug("서비스 update 인수 : {}", boardVO);
		int count = 0;
		Connection conn = null;
		BoardDAO   boardDAO = null;
		try {
			conn = DBCPUtil.getConnection();
			boardDAO = BoardDAO.getInstance();
			conn.setAutoCommit(false); // 트랜젝션시작
			//---------------------------------------------------------------
			if(boardVO!=null) { // 넘어온데이터가 있어야 되고
				// DB에 저장된 비번과 넘어온 비번이 일치할때만 수정해 준다.
				BoardVO dbVO = boardDAO.selectByIdx(conn, boardVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(boardVO.getPassword())){
					count = boardDAO.update(conn, boardVO);
				}
			}
			//---------------------------------------------------------------
			conn.commit(); // DB에 적용
		}catch (Exception e) {
			DBCPUtil.rollback(conn); // 에러나면 DB에 취소
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}
		
		log.debug("서비스 update 리턴값 : {}", count);
		return count;
	}
	// 8. 3 --> 원본 삭제 하기
	public int delete(BoardVO boardVO) {
		log.debug("서비스 delete 인수 : {}", boardVO);
		int count = 0;
		Connection conn = null;
		BoardDAO   boardDAO = null;
		try {
			conn = DBCPUtil.getConnection();
			boardDAO = BoardDAO.getInstance();
			conn.setAutoCommit(false); // 트랜젝션시작
			//---------------------------------------------------------------
			if(boardVO!=null) { // 넘어온데이터가 있어야 되고
				// DB에 저장된 비번과 넘어온 비번이 일치할때만 삭제해 준다.
				BoardVO dbVO = boardDAO.selectByIdx(conn, boardVO.getIdx());
				if(dbVO!=null && dbVO.getPassword().equals(boardVO.getPassword())){
					count = boardDAO.delete(conn, boardVO.getIdx());
				}
			}
			//---------------------------------------------------------------
			conn.commit(); // DB에 적용
		}catch (Exception e) {
			DBCPUtil.rollback(conn); // 에러나면 DB에 취소
			e.printStackTrace();
		} finally {
			DBCPUtil.close(conn);
		}		
		log.debug("서비스 delete 리턴값 : {}", count);
		return count;
	}

}