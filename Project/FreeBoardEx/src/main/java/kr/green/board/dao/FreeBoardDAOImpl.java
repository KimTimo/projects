package kr.green.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.green.board.vo.FreeBoardVO;
import kr.green.jdbc.DBCPUtil;

public class FreeBoardDAOImpl implements FreeBoardDAO{
	//----------------------------------------------------------------------------------------
	private static FreeBoardDAOImpl instance = new FreeBoardDAOImpl();
	private FreeBoardDAOImpl() {
		;
	}
	public static FreeBoardDAOImpl getInstance() {
		return instance;
	}
	//----------------------------------------------------------------------------------------

	@Override
	public int insert(Connection conn, FreeBoardVO vo) throws SQLException {
		int count = 0;
		String sql = "insert into freeboard (name, password, subject, content, ip) values (?,?,?,?,?)";
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

	@Override
	public int update(Connection conn, FreeBoardVO vo) throws SQLException {
		int count = 0;
		String sql = "update freeboard set subject=?, content=?, regDate=now(), ip=? where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getSubject());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getIp());
		pstmt.setInt(4, vo.getIdx());
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		return count;
	}

	@Override
	public int delete(Connection conn, int idx) throws SQLException {
		int count = 0;
		String sql = "delete from freeboard where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		return count;
	}

	@Override
	public int selectCount(Connection conn) throws SQLException {
		int count = 0;
		String sql = "select count(*) from freeboard";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		count = rs.getInt(1);
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);
		return count;
	}

	@Override
	public FreeBoardVO selectByIdx(Connection conn, int idx) throws SQLException {
		FreeBoardVO freeBoardVO = null;
		String sql = "select * from freeboard where idx=" + idx;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			freeBoardVO = new FreeBoardVO();
			freeBoardVO.setIdx(rs.getInt("idx"));
			freeBoardVO.setName(rs.getString("name"));
			freeBoardVO.setPassword(rs.getString("password"));
			freeBoardVO.setSubject(rs.getString("subject"));
			freeBoardVO.setContent(rs.getString("content"));
			freeBoardVO.setRegDate(rs.getTimestamp("regDate"));
			freeBoardVO.setHit(rs.getInt("hit"));
			freeBoardVO.setIp(rs.getNString("ip"));
		}
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);
		return freeBoardVO;
	}

	@Override
	public List<FreeBoardVO> selectList(Connection conn, int startNo, int PageSize) throws SQLException {
		List<FreeBoardVO> list = null;
		String sql = "select * from freeboard order by idx desc limit " + startNo + ", " + PageSize;
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) { // 있으면
			list = new ArrayList<>(); // 리스트 만들고
			do {
				// VO를 만들어 채우고
				FreeBoardVO freeBoardVO = new FreeBoardVO();
				freeBoardVO.setIdx(rs.getInt("idx"));
				freeBoardVO.setName(rs.getString("name"));
				freeBoardVO.setPassword(rs.getString("password"));
				freeBoardVO.setSubject(rs.getString("subject"));
				freeBoardVO.setContent(rs.getString("content"));
				freeBoardVO.setRegDate(rs.getTimestamp("regDate"));
				freeBoardVO.setHit(rs.getInt("hit"));
				freeBoardVO.setIp(rs.getNString("ip"));
				
				list.add(freeBoardVO); // 리스트에 넣고
			}while(rs.next());
		}
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);		
		return list;
	}

	@Override
	public int hitUpdate(Connection conn, int idx) throws SQLException {
		int count = 0;
		String sql = "update freeboard hit=hit+1 where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		return count;
	}

}
