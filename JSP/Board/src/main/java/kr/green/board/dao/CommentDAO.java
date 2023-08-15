package kr.green.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.green.board.vo.CommentVO;
import kr.green.jdbc.DBCPUtil;

public class CommentDAO {
	private static CommentDAO instance = new CommentDAO();
	private CommentDAO() {}
	public static CommentDAO getInstance() { return instance; }
	//--------------------------------------------------------------
	// 1. 해당글번호의 댓글 개수를 구하는 메서드
	public int selectCount(Connection conn, int ref) throws SQLException {
		int count = 0;
		String sql = "select count(*) from comment where ref=" + ref;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		count = rs.getInt(1);
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);
		return count;
	}
	// 2. 해당글번호의 댓글 목록을 구하는 메서드
	public List<CommentVO> selectList(Connection conn, int ref) throws SQLException {
		List<CommentVO> commentList = null;
		String sql = "select * from comment where ref=" + ref + " order by idx desc";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			commentList = new ArrayList<CommentVO>();
			do {
				commentList.add(makeVO(rs));
			}while(rs.next());
		}
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);
		return commentList;
	}
	// RS를 받아 데이터를 읽어서 VO를 만들어 리턴하는 메서드
	private CommentVO makeVO(ResultSet rs) throws SQLException {
		CommentVO vo = new CommentVO();
		vo.setIdx(rs.getInt("idx"));
		vo.setRef(rs.getInt("ref"));
		vo.setName(rs.getString("name"));
		vo.setPassword(rs.getString("password"));
		vo.setContent(rs.getString("content"));
		vo.setRegDate(rs.getTimestamp("regdate"));
		vo.setIp(rs.getString("ip"));
		return vo;
	}
	// 3. 1개얻기
	public CommentVO selectByIdx(Connection conn, int idx) throws SQLException {
		CommentVO commentVO = null;
		String sql = "select * from comment where idx=" + idx;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			commentVO = makeVO(rs);
		}
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);
		return commentVO;
	}
	// 4. 저장
	public int insert(Connection conn, CommentVO vo) throws SQLException {
		int count = 0;
		String sql = "insert into comment (ref, name,password,content,ip) values (?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, vo.getRef());
		pstmt.setString(2, vo.getName());
		pstmt.setString(3, vo.getPassword());
		pstmt.setString(4, vo.getContent());
		pstmt.setString(5, vo.getIp());
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		return count;
	}
	// 5. 수정
	public int update(Connection conn, CommentVO vo) throws SQLException {
		int count = 0;
		String sql = "update comment set content=?, regDate=now(), ip=? where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getContent());
		pstmt.setString(2, vo.getIp());
		pstmt.setInt(3, vo.getIdx());

		count = pstmt.executeUpdate();
		
		DBCPUtil.close(pstmt);		
		return count;
	}
	// 6. 삭제
	public int delete(Connection conn, int idx) throws SQLException {
		int count = 0;
		String sql = "delete from comment where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);

		count = pstmt.executeUpdate();
		
		DBCPUtil.close(pstmt);		
		return count;
	}
}
