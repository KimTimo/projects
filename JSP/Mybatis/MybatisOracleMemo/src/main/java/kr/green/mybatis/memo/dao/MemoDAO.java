package kr.green.mybatis.memo.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.mybatis.memo.vo.MemoVO;

public class MemoDAO {
	//----------------------------------------------------------------------------
	private static MemoDAO instance = new MemoDAO();
	private MemoDAO() {}
	public static MemoDAO getInstance() { return instance; }
	//----------------------------------------------------------------------------
	// SQL명령어 1개당 1개의 메서드
	// 맵퍼 파일의 태그 1개당 메서드 1개
	// 1. 개수 얻기
	public int selectCount(SqlSession sqlSession) {
		return sqlSession.selectOne("memo.selectCount");
	}
	// 2. 1개 얻기
	public MemoVO selectByIdx(SqlSession sqlSession, int idx) {
		return sqlSession.selectOne("memo.selectByIdx", idx);
	}
	// 3. 1페이지 얻기
	public List<MemoVO> selectList(SqlSession sqlSession, HashMap<String, Integer> map) {
		return sqlSession.selectList("memo.selectList", map); 
	}
	// 4. 저장하기
	public void insert(SqlSession sqlSession, MemoVO memoVO) {
		sqlSession.insert("memo.insert", memoVO);
	}
	// 5. 수정하기
	public void update(SqlSession sqlSession, MemoVO memoVO) {
		sqlSession.update("memo.update", memoVO);
	}
	// 6. 삭제하기
	public void delete(SqlSession sqlSession, int idx) {
		sqlSession.delete("memo.delete", idx);
	}
}
