package kr.green.file.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.file.vo.FileBoardVO;

public class FileBoardDAO {
	private static FileBoardDAO instance = new FileBoardDAO();
	private FileBoardDAO() { }
	public static FileBoardDAO getInstance() {
		return instance;
	}
	//---------------------------------------------------------------------------
	// <!-- 1. 개수얻기 -->
	public int selectCount(SqlSession sqlSession) {
		return sqlSession.selectOne("board.selectCount");
	}
	// <!-- 2. 1개 얻기 -->
	public FileBoardVO selectByIdx(SqlSession sqlSession, int idx) {
		return sqlSession.selectOne("board.selectByIdx", idx);
	}
	// <!-- 3. 1페이지 얻기 -->
	public List<FileBoardVO> selectList(SqlSession sqlSession, HashMap<String, Integer> map){
		return sqlSession.selectList("board.selectList", map);
	}
	// <!-- 4. 저장하기 -->
	public void insert(SqlSession sqlSession, FileBoardVO vo) {
		sqlSession.insert("board.insert", vo);
	}
	// <!-- 5. 수정하기 -->
	public void update(SqlSession sqlSession, FileBoardVO vo) {
		sqlSession.update("board.update", vo);
	}
	// <!-- 6. 삭제하기 -->
	public void delete(SqlSession sqlSession, int idx) {
		sqlSession.delete("board.delete", idx);
	}
}
