package kr.green.file.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.file.vo.FileBoardFileVO;

public class FileBoardFileDAO {
	private static FileBoardFileDAO instance = new FileBoardFileDAO();
	private FileBoardFileDAO() { }
	public static FileBoardFileDAO getInstance() {
		return instance;
	}
	//---------------------------------------------------------------------------
	// <!-- 1. 첨부파일 저장 -->
	public void insert(SqlSession sqlSession, FileBoardFileVO vo) {
		sqlSession.insert("file.insert", vo);
	}
	// <!-- 2. 첨부파일 삭제 -->
	public void delete(SqlSession sqlSession, int idx) {
		sqlSession.delete("file.deleteByIdx", idx);
	}
	// <!-- 3. 원본글의 첨부파일 모두 읽기 -->
	public List<FileBoardFileVO> selectList(SqlSession sqlSession, int ref){
		return sqlSession.selectList("file.selectList", ref);
	}
	// <!-- 4. 원본글의 첨부파일 모두 삭제하기 -->
	public void deleteByRef(SqlSession sqlSession, int ref){
		sqlSession.delete("file.deleteByRef", ref);
	}
}
