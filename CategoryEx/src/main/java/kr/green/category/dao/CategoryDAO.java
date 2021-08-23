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
}
