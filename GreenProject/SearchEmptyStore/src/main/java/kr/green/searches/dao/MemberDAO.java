package kr.green.searches.dao;

import java.util.HashMap;
import java.util.List;

import kr.green.searches.vo.MemberVO;

public interface MemberDAO {
	// <!-- 저장하기 : 회원 가입 -->
	void insert(MemberVO memberVO);
	
	// <!-- 수정하기 : 회원 정보 수정 -->
	void update(MemberVO memberVO);
	
	// <!-- 삭제하기 : 회원 탈퇴 -->
	MemberVO delete(int idx);
	
	// <!-- 1개얻기하기 : 수정/삭제/로그인 -->
	MemberVO selectByIdx(int idx);
	
	// <!-- 개수 얻기 : 관리자모드 -->
	int selectCount();
	
	// <!-- 모두 얻기 : 관리자모드 -->
	List<MemberVO> selectAll();
	
	// <!-- 동일한 아이디 개수세기 : 아이디 중복 확인 -->
	int selectCountByUserid(String userid);
	
	// <!-- 아이디로 찾기 -->
	MemberVO selectByUserid(String userid);
	
	// <!-- 이름으로 찾기 -->
	List<MemberVO> selectByUsername(String username);
	
	// <!-- 사용여부 변경하기 -->
	void updateEnabled(HashMap<String, String> map);
	
	// <!-- 비밀번호 변경하기 -->
	void updatePassword(HashMap<String, String> map);
	
}
