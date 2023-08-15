package kr.green.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import kr.green.dbcp.DBCPUtil;
import kr.green.memo.vo.MemoVO;

/*
SQL명령 1개당 1씩 메서드를 만들고 트랜잭션을 처리하기 위하여 첫번째 인수는 Connection을 받자!!!
싱글톤 클래스로 작성하자!!! -- 프로그램 실행 중에 객체를 1개만 만들어서 계속 재사용하는 방법
 */
public class MemoDAO {
	//--------------------------------------------------------------------------------------
	// 1. 자기 자신의 객체를 정적 멤버로 가진다. 
	private static MemoDAO instance = new MemoDAO();
	// 2. 외부에서 객체를 만들지 못하도록 생성자를 private으로 만든다.
	private MemoDAO() {
		;
	}
	// 3. 외부에서 객체를 얻을 수 있도록 메서드를 만들어 준다.
	public static MemoDAO getInstance() {
		return instance;
	}
	//--------------------------------------------------------------------------------------
	// 페이징 처리는 다음번에 하자
	// 1. 개수 구하기
	public int getCount(Connection conn) throws SQLException {
		int count = 0;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) from memo";
		
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		count = rs.getInt(1);
		
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);
		return count;
	}
	// 2. 전체 목록 구하기
	public List<MemoVO> selectAll(Connection conn) throws SQLException{
		List<MemoVO>  list = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		String sql = "select * from memo order by idx desc";
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			list = new ArrayList<>();
			do {
				// 행에서 데이터를 읽어 VO에 넣어준다.
				MemoVO memoVO = makeVO(rs);
				// vo를 리스트에 넣는다.
				list.add(memoVO);
			}while(rs.next());
		}
		
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);
		return list;
	}
	// 행에서 데이터를 읽어 VO에 넣어주는 메서드
	private MemoVO makeVO(ResultSet rs) throws SQLException {
		MemoVO memoVO = new MemoVO();
		memoVO.setIdx(rs.getInt("idx"));
		memoVO.setName(rs.getString("name"));
		memoVO.setPassword(rs.getString("password"));
		memoVO.setContent(rs.getString("content"));
		memoVO.setRegDate(rs.getTimestamp("regDate"));
		memoVO.setIp(rs.getString("ip"));
		return memoVO;
	}
	// 3. 글 1개 얻기
	public MemoVO selectByIdx(Connection conn, int idx) throws SQLException{
		MemoVO  memoVO = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from memo where idx=" + idx;
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		if(rs.next()) {
			memoVO = makeVO(rs);
		}
		DBCPUtil.close(rs);
		DBCPUtil.close(stmt);
		return memoVO;
	}
	// 4. 저장하기
	public int insert(Connection conn, MemoVO memoVO) throws SQLException {
		int count = 0;
		PreparedStatement stmt = null;
		String sql = "insert into memo (name, password,content,regdate,ip) values (?,?,?,now(),?)";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, memoVO.getName());
		stmt.setString(2, memoVO.getPassword());
		stmt.setString(3, memoVO.getContent());
		stmt.setString(4, memoVO.getIp());
		count = stmt.executeUpdate();
		DBCPUtil.close(stmt);
		return count;	
	}
	// 5. 수정하기
	public int update(Connection conn, MemoVO memoVO) throws SQLException {
		int count = 0;
		PreparedStatement stmt = null;
		String sql = "update memo set content=?, regdate=now(), ip=? where idx=?";
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, memoVO.getContent());
		stmt.setString(2, memoVO.getIp());
		stmt.setInt(3, memoVO.getIdx());
		count = stmt.executeUpdate();
		DBCPUtil.close(stmt);
		return count;	
	}
	// 6. 삭제하기
	public int delete(Connection conn, int idx) throws SQLException {
		int count = 0;
		PreparedStatement stmt = null;
		String sql = "delete from memo where idx=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, idx);
		count = stmt.executeUpdate();
		DBCPUtil.close(stmt);
		return count;	
	}
}
