package kr.green.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.green.board.vo.BoardVO;
import kr.green.jdbc.DBCPUtil;

public class BoardDAO {
	private static BoardDAO instance = new BoardDAO();
	private BoardDAO() {}
	public static BoardDAO getInstance() { return instance; }
	//--------------------------------------------------------------
	// 1. 저장하기
	public int insert(Connection conn, BoardVO vo) throws SQLException {
		int count = 0;
		String sql = "insert into board (name, password, subject, content, ip) values (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getSubject());
		pstmt.setString(4, vo.getContent());
		pstmt.setString(5, vo.getIp());
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		return count;
	}
	// 2. 수정하기
	public int update(Connection conn, BoardVO vo) throws SQLException {
		int count = 0;
		String sql = "update board set subject=?, content=?, regDate=now(), ip=? where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getSubject());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getIp());
		pstmt.setInt(4, vo.getIdx());
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		return count;
	}
	// 3. 삭제하기
	public int delete(Connection conn, int idx) throws SQLException {
		int count = 0;
		String sql = "delete from board where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		return count;
	}
	// 4. 전체 개수얻기
	public int selectCount(Connection conn) throws SQLException {
		int count = 0;
		String sql = "select count(*) from board";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		count = rs.getInt(1);
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);
		return count;
	}
	// 5. 1개 얻기
	public BoardVO  selectByIdx(Connection conn, int idx) throws SQLException {
		BoardVO boardVO = null;
		String sql = "select * from board where idx=" + idx;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			boardVO = new BoardVO();
			boardVO.setIdx(rs.getInt("idx"));
			boardVO.setName(rs.getString("name"));
			boardVO.setPassword(rs.getString("password"));
			boardVO.setSubject(rs.getString("subject"));
			boardVO.setContent(rs.getString("content"));
			boardVO.setRegDate(rs.getTimestamp("regDate"));
			boardVO.setHit(rs.getInt("hit"));
			boardVO.setIp(rs.getNString("ip"));
		}
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);		
		return boardVO;
	}
	// 6. 1페이지 분량얻기
	public List<BoardVO>  selectList(Connection conn, int startNo, int pageSize) throws SQLException {
		List<BoardVO> list = null;
		String sql = "select * from board order by idx desc limit " + startNo + ", " + pageSize;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) { // 있으면
			list = new ArrayList<>(); // 리스트 만들고
			do {
				// VO를 만들어 채우고
				BoardVO boardVO = new BoardVO();
				boardVO.setIdx(rs.getInt("idx"));
				boardVO.setName(rs.getString("name"));
				boardVO.setPassword(rs.getString("password"));
				boardVO.setSubject(rs.getString("subject"));
				boardVO.setContent(rs.getString("content"));
				boardVO.setRegDate(rs.getTimestamp("regDate"));
				boardVO.setHit(rs.getInt("hit"));
				boardVO.setIp(rs.getNString("ip"));
				
				list.add(boardVO); // 리스트에 넣고
			}while(rs.next());
		}
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);		
		return list;
	}	
	// 7. 조회수 증가하기
	public int updateHit(Connection conn, int idx) throws SQLException {
		int count = 0;
		String sql = "update board set hit=hit+1 where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		return count;
	}
}
