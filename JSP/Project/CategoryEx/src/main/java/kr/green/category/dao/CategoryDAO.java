package kr.green.category.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.category.vo.CategoryVO;

public class CategoryDAO {
	//----------------------------------------------------------------------------
	private static CategoryDAO instance = new CategoryDAO();
	private CategoryDAO() {}
	public static CategoryDAO getInstance() { return instance; }
	//----------------------------------------------------------------------------
	// SQL명령어 1개당 1개의 메서드
	// 맵퍼 파일의 태그 1개당 메서드 1개
	
	// 리스트 얻기
	public List<CategoryVO> selectList(SqlSession sqlSession){
		return sqlSession.selectList("category.selectList");
	}
	// 대항목 추가
	public void insert(SqlSession sqlSession, CategoryVO vo) {
		sqlSession.insert("category.insert", vo);
	}
	// 하위 항목 추가
	// 1) seq가 나보다 큰 값들을 모두 1씩 증가시킨다.
	public void updateSeq(SqlSession sqlSession, CategoryVO vo) {
		sqlSession.update("category.updateSeq", vo);
	}
	// 2) ref는 그대로 seq와 lev는 +1 해서 저장하기 
	public void insertrReply(SqlSession sqlSession, CategoryVO vo) {
		sqlSession.insert("category.insertrReply", vo);
	}
	//----------------------------------------------------------------------------
	// <!-- 아이템 수정 -->
	public void updateItem(SqlSession sqlSession, CategoryVO vo) {
		sqlSession.update("category.updateItem", vo);
	}
	
	
}
