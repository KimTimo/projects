package kr.green.board.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.green.board.vo.FreeBoardVO;

public interface FreeBoardDAO {
	// 저장
	int insert(Connection conn, FreeBoardVO vo) throws SQLException;
	// 수정
	int update(Connection conn, FreeBoardVO vo) throws SQLException;
	// 삭제
	int delete(Connection conn, int idx) throws SQLException;
	// 전체 개수 얻기
	int selectCount(Connection conn) throws SQLException;
	// 1개 얻기
	FreeBoardVO selectByIdx(Connection conn, int idx) throws SQLException;
	// 1페이지 얻기
	List<FreeBoardVO> selectList(Connection conn, int startNo, int PageSize) throws SQLException;
	// 조회수 증가하기
	int hitUpdate(Connection conn, int idx) throws SQLException;
}
