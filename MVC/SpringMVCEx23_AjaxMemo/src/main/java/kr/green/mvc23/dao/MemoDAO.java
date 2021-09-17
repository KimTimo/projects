package kr.green.mvc23.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import kr.green.mvc23.vo.MemoVO;

public interface MemoDAO {
	// SQL명령어 1개당 1개의 메서드
	// 맵퍼 파일의 태그 1개당 메서드 1개
	// 1. 개수 얻기
	public int selectCount() throws SQLException ;
	// 2. 1개 얻기
	public MemoVO selectByIdx(int idx) throws SQLException ;
	// 3. 1페이지 얻기
	public List<MemoVO> selectList(HashMap<String, Integer> map)  throws SQLException ;
	// 4. 저장하기
	public void insert(MemoVO memoVO) throws SQLException ;
	// 5. 수정하기
	public void update(MemoVO memoVO) throws SQLException ;
	// 6. 삭제하기
	public void delete(int idx) throws SQLException ;
	// 7. 모두 얻기
	public List<MemoVO> selectAll()  throws SQLException ;
	
}
