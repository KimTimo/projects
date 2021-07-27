package kr.green.jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import kr.green.jdbc.vo.SampleVO;

/*
 * DAO(Data Access Object) : 실질적으로 DB에 접근하는 객체
 * 1. SQL 명령어 1개당 1개의 메서드로 만든다.
 * 2. 트랜잭션을 위하여 Connection을 메서드의 인수로 전달한다.
 * 3. 객체를 1개 만들어 재사용하도록 싱글톤 패턴으로 작성한다.
 */
public interface SampleDAO {
	// 1. 개수얻기
	int getCount(Connection conn) throws SQLException;
	// 2. 1 페이지 분량 얻기
	List<SampleVO> selectList(Connection conn, int startNo, int pageSize) throws SQLException;
	// 3. 1 개 얻기 
	SampleVO selectByIdx(Connection conn, int idx) throws SQLException;
	// 4. 저장하기
	int insert(Connection conn, SampleVO vo) throws SQLException;
	// 5. 수정하기
	int update(Connection conn, SampleVO vo) throws SQLException;
	// 6. 삭제하기
	int delete(Connection conn, int idx) throws SQLException;

}
    //---------------------------------------------------------------------------------
	// 싱글톤 패턴으로 작성하기
	// 1. 자기 자신의 객체를 정적 멤버로 가진다.
	// 2. 외부에서 객체를 생성하지 못하도록 생성자를 private으로 만든다.
	// 3. 자신의 객체를 얻는 메서드를 작성한다. 대부분 getInstance() 이다.
	//---------------------------------------------------------------------------------