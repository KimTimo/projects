package kr.green.memo.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

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
	// 1. 개수 구하기
	public int getCount(SqlMapClient sqlMapClient) throws SQLException {
		return (int) sqlMapClient.queryForObject("memo.getCount");
	}
	// 2. 1페이지 분량의 데이터 자져오기
	public List<MemoVO> selectList(SqlMapClient sqlMapClient,int startNo, int pageSize) throws SQLException{
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("startNo", startNo);
		map.put("pageSize", pageSize);
		return (List<MemoVO>)sqlMapClient.queryForList("memo.selectList", map);
	}
	// 3. 글 1개 얻기
	public MemoVO selectByIdx(SqlMapClient sqlMapClient, int idx) throws SQLException{
		return (MemoVO) sqlMapClient.queryForObject("memo.selectByIdx", idx);
	}
	// 4. 저장하기
	public void insert(SqlMapClient sqlMapClient, MemoVO memoVO) throws SQLException {
		sqlMapClient.insert("memo.insert", memoVO);
	}
	// 5. 수정하기
	public void update(SqlMapClient sqlMapClient, MemoVO memoVO) throws SQLException {
		sqlMapClient.update("memo.update", memoVO);
	}
	// 6. 삭제하기
	public void delete(SqlMapClient sqlMapClient, int idx) throws SQLException {
		sqlMapClient.delete("memo.delete", idx);
	}
}
