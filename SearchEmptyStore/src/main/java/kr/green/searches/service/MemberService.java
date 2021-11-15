package kr.green.searches.service;

import java.util.List;
import kr.green.searches.vo.MemberVO;

public interface MemberService {
	// 회원 가입
	void insert(MemberVO memberVO);
	// 회원 정보 수정
	void update(MemberVO memberVO);
	// 회원 탈퇴
	MemberVO delete(MemberVO memberVO);
	// 로그인
	void login(MemberVO memberVO);
	// 로그아웃
	void logout();
	// 회원 목록 보기
	List<MemberVO> selectList();
	// 이메일 인증
	MemberVO emailConfirm(MemberVO memberVO);
	// 아이디 중복 검사
	int idCheck(String userid);
	// 아이디찾기
	MemberVO useridSearch(MemberVO memberVO);
	// 비번찾기
	MemberVO passwordSearch(MemberVO memberVO);
	// 비밀번호 바꾸기
	MemberVO changePassword(MemberVO memberVO);
	
	// 1개얻기
	MemberVO selectByIdx(int idx);
	MemberVO selectByUserid(String userid);
}
