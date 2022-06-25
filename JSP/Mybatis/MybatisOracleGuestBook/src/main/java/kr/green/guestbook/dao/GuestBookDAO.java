package kr.green.guestbook.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.guestbook.vo.GuestBookVO;

public class GuestBookDAO {
	private static GuestBookDAO instance = new GuestBookDAO();
	private GuestBookDAO() {}
	public static GuestBookDAO getInstance() {
		return instance;
	}
	//------------------------------------------------------------------
	public int selectCount(SqlSession sqlSession) {
		return sqlSession.selectOne("guest.selectCount");
	}
	public GuestBookVO selectByIdx(SqlSession sqlSession, int idx) {
		return sqlSession.selectOne("guest.selectByIdx", idx);
	}
	public List<GuestBookVO> selectList(SqlSession sqlSession, HashMap<String, Integer> map){
		return sqlSession.selectList("guest.selectList", map);
	}
	public void insert(SqlSession sqlSession, GuestBookVO guestBookVO) {
		sqlSession.insert("guest.insert", guestBookVO);
	}
	public void update(SqlSession sqlSession, GuestBookVO guestBookVO) {
		sqlSession.update("guest.update", guestBookVO);
	}
	public void delete(SqlSession sqlSession, int idx) {
		sqlSession.delete("guest.delete", idx);
	}
}
