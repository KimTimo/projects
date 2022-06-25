package kr.green.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.green.jdbc.JDBCUtil;
import kr.green.jdbc.vo.SampleVO;

/*
 * DAO란 Data Access Object의 약어로서 실질적으로 DB에 접근하는 객체
 * 1. SQL 명령어 1개당 1개의 메서드로 만든다.
 * 2. 트랜잭션을 위하여 Connection을 메서드의 인수로 전달한다.
 * 3. 객체를 1개만들어 재사용하도록 싱글톤 패턴으로 작성한다. 
 */
public class SampleDAOImpl implements SampleDAO {
   //-----------------------------------------------------------------------------------
   // 싱글톤 패턴으로 작성하기
   // 1. 자기 자신의 객체를 정적 멤버로 가진다.
	private static SampleDAO instance = new SampleDAOImpl();
   // 2. 외부에서객체를 생성하지 못하도록 생성자를 private으로 만든다.
	private SampleDAOImpl() {
		;
	}
   // 3. 자신의 객체를 얻는 메서드를 작성한다. 대부분 getInstance()이다.
	public static SampleDAO getInstance() {
		return instance;
	}
   //-----------------------------------------------------------------------------------	
	// 1. 개수 얻기
	@Override
	public int getCount(Connection conn) throws SQLException {
		int count = 0;
		String sql = "select count(*) from sample";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		rs.next();
		count = rs.getInt(1);
		JDBCUtil.close(rs);
		JDBCUtil.close(stmt);
		return count;
	}
	// 1페이지 분량얻기
	@Override
	public List<SampleVO> selectList(Connection conn, int startNo, int pageSize) throws SQLException {
		List<SampleVO> list = null;
		String sql = "select * from sample order by idx desc limit ?, ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startNo);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			list = new ArrayList<SampleVO>();
			do {
				SampleVO vo = makeVO(rs);
				list.add(vo);
			}while(rs.next());
		}
		JDBCUtil.close(rs);
		JDBCUtil.close(pstmt);
		return list;
	}
	
	private SampleVO makeVO(ResultSet rs) throws SQLException {
		SampleVO vo = new SampleVO();
		vo.setIdx(rs.getInt("idx"));
		vo.setName(rs.getString("name"));
		vo.setAge(rs.getInt("age"));
		vo.setGender(rs.getString("gender"));
		return vo;
	}
	// 1개 얻기
	@Override
	public SampleVO selectByIdx(Connection conn, int idx) throws SQLException {
		SampleVO vo = null;
		String sql = "select * from sample where idx = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			vo = makeVO(rs);
		}
		JDBCUtil.close(rs);
		JDBCUtil.close(pstmt);		
		return vo;
	}
	// 저장하기
	@Override
	public int insert(Connection conn, SampleVO vo) throws SQLException {
		int count = 0;
		String sql = "insert into sample (name, age, gender) values (?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setInt(2, vo.getAge());
		pstmt.setString(3, vo.getGender());
		count = pstmt.executeUpdate();
		JDBCUtil.close(pstmt);	
		return count;
	}
	// 수정하기
	@Override
	public int update(Connection conn, SampleVO vo) throws SQLException {
		int count = 0;
		String sql = "update sample set name=?, age=?, gender=? where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, vo.getName());
		pstmt.setInt(2, vo.getAge());
		pstmt.setString(3, vo.getGender());
		pstmt.setInt(4, vo.getIdx());
		count = pstmt.executeUpdate();
		JDBCUtil.close(pstmt);	
		return count;	
	}
	// 삭제하기
	@Override
	public int delete(Connection conn, int idx) throws SQLException {
		int count = 0;
		String sql = "delete from sample where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		count = pstmt.executeUpdate();
		JDBCUtil.close(pstmt);	
		return count;	
	}
	
}
