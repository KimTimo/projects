package kr.green.member.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.green.member.vo.MemberVO;

public class MemberDAO {
	private static MemberDAO instance = new MemberDAO();
	private MemberDAO() {}
	public static MemberDAO getInstance() { return instance; }
	//----------------------------------------------------------------
	// <!-- 저장 -->
	public void insert(SqlSession sqlSession, MemberVO memberVO) {
		sqlSession.insert("member.insert", memberVO);
	}
	// <!-- 수정 -->
	public void update(SqlSession sqlSession, MemberVO memberVO) {
		sqlSession.update("member.update", memberVO);
	}
	// <!-- 완전삭제 -->
	public void delete(SqlSession sqlSession, int idx) {
		sqlSession.delete("member.delete", idx);
	}
	// <!-- 인증여부 수정 : // 0 : 가입미인증, 1: 인증, 2:휴먼계정, 3:탈퇴 ..... 여러분이 맘대로 결정한다.-->
	public void updateUse(SqlSession sqlSession,HashMap<String, Integer> map) {
		sqlSession.update("member.updateUse", map);
	}
	// <!-- 아이디 중복확인 -->
	public int countUserID(SqlSession sqlSession, String userID) {
		return sqlSession.selectOne("member.countUserID", userID);
	}
	// <!-- 회원목록 : 관리자만 사용 -->
	public List<MemberVO> selectList(SqlSession sqlSession){
		return sqlSession.selectList("member.selectList");
	}
	// <!-- idx로 1개얻기 -->
	public MemberVO selectByIdx(SqlSession sqlSession, int idx) {
		return sqlSession.selectOne("member.selectByIdx", idx);
	}
	// <!-- userid로 1개얻기 -->
	public MemberVO selectByUserid(SqlSession sqlSession, String userid) {
		return sqlSession.selectOne("member.selectByUserID", userid);
	}
	// <!-- 비밀번호 수정 -->
	public void updatePassword(SqlSession sqlSession, MemberVO memberVO) {
		sqlSession.update("member.updatePassword", memberVO);
	}
	
}
