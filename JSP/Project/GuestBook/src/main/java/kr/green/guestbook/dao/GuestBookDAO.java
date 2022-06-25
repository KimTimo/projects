package kr.green.guestbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.green.guestbook.vo.GuestBookVO;
import kr.green.jdbc.DBCPUtil;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GuestBookDAO {
	// -----------------------------------------------------------------------------------
	// 싱글톤으로 만들자
	// 1. 자기 자신의 객체를 정적멤버로 가진다.
	private static GuestBookDAO instance = new GuestBookDAO();
	// 2. 외부에서 객체를 생성하지 못하도록 생성자를 private으로 만든다.
	private GuestBookDAO() {}
	// 3. 만들어진 객체를 외부에서 얻어서 사요할 수 있도록 객체를 얻는 메서드를 만든다.
	public static GuestBookDAO getInstance() { return instance; }
	// -----------------------------------------------------------------------------------
	// SQL명령어 1개당 1개의 메서드로 ... 
	// 트랜잭션을 하기 위해서 첫번째인수로 COnnection을 받는다.
	
	// 1. 전체 개수 구하기
	public int selectCount(Connection conn) throws SQLException {
		log.debug(this.getClass().getName() + " selectCount(" + conn + ")호출");
		int count = 0;
		
		String sql = "select count(*) from guestbook";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) count = rs.getInt(1);
		DBCPUtil.close(rs);
		DBCPUtil.close(pstmt);
		
		log.debug(this.getClass().getName() + " selectCount 리턴 값 :  " + count);
		return count;
	}
	// 2. 한개  구하기
	public GuestBookVO selectByIdx(Connection conn, int idx) throws SQLException {
		log.debug(this.getClass().getName() + " selectByIdx(" + conn  + ", " + idx + ")호출");
		GuestBookVO guestBookVO = null;
		
		String sql = "select * from guestbook where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			guestBookVO = makeGuestBookVO(rs);
		}
		DBCPUtil.close(rs);
		DBCPUtil.close(pstmt);
		
		log.debug(this.getClass().getName() + " selectByIdx 리턴 값 :  " + guestBookVO);
		return guestBookVO;
	}
	// 3. 한 페이지 분량 구하기
	public List<GuestBookVO> selectList(Connection conn, int startNo, int pageSize) throws SQLException {
		log.debug(this.getClass().getName() + " selectList(" + conn  + ", " + startNo + ", " + pageSize + ")호출");
		List<GuestBookVO> list = null;

		String sql = "select * from guestbook order by idx desc limit ?, ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, startNo);
		pstmt.setInt(2, pageSize);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			list = new ArrayList<GuestBookVO>();
			do {
				GuestBookVO guestBookVO = makeGuestBookVO(rs);
				list.add(guestBookVO);
			}while(rs.next());
		}
		
		DBCPUtil.close(rs);
		DBCPUtil.close(pstmt);

		log.debug(this.getClass().getName() + " selectList 리턴 값 :  " + list);
		return list;
	}
	// ResultSet을 받아 GuestBookVO객체를 만들어 리턴하는 메서드
	private GuestBookVO makeGuestBookVO(ResultSet rs) throws SQLException {
		GuestBookVO guestBookVO = new GuestBookVO();
		guestBookVO.setIdx(rs.getInt("idx"));
		guestBookVO.setName(rs.getString("name"));
		guestBookVO.setPassword(rs.getString("password"));
		guestBookVO.setContent(rs.getString("content"));
		guestBookVO.setIp(rs.getString("ip"));
		guestBookVO.setRegDate(rs.getTimestamp("regDate"));
		return guestBookVO;
	}
	// 4. 저장
	public int insert(Connection conn, GuestBookVO guestBookVO) throws SQLException {
		log.debug(this.getClass().getName() + " insert(" + conn  + ", " + guestBookVO + ")호출");
		int count = 0;
		
		String sql = "insert into guestbook (name,password,content,ip) values (?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, guestBookVO.getName());
		pstmt.setString(2, guestBookVO.getPassword());
		pstmt.setString(3, guestBookVO.getContent());
		pstmt.setString(4, guestBookVO.getIp());
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		
		log.debug(this.getClass().getName() + " insert 리턴 값 :  " + count);
		return count;
	}
	// 5. 수정
	public int update(Connection conn, GuestBookVO guestBookVO) throws SQLException {
		log.debug(this.getClass().getName() + " update(" + conn  + ", " + guestBookVO + ")호출");
		int count = 0;
		
		String sql = "update guestbook set content=?, regdate=now(), ip=? where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, guestBookVO.getContent());
		pstmt.setString(2, guestBookVO.getIp());
		pstmt.setInt(3, guestBookVO.getIdx());
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		
		log.debug(this.getClass().getName() + " update 리턴 값 :  " + count);
		return count;
	}
	// 6. 삭제
	public int delete(Connection conn, int idx) throws SQLException {
		log.debug(this.getClass().getName() + " delete(" + conn  + ", " + idx + ")호출");
		int count = 0;
		
		String sql = "delete from guestbook where idx=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, idx);
		count = pstmt.executeUpdate();
		DBCPUtil.close(pstmt);
		
		log.debug(this.getClass().getName() + " delete 리턴 값 :  " + count);
		return count;
	}
}
