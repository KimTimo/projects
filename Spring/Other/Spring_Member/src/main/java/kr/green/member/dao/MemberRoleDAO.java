package kr.green.member.dao;

import java.util.List;

import kr.green.member.vo.MemberRoleVO;

public interface MemberRoleDAO {
	// <!-- 저장 -->
	void insert(MemberRoleVO memberRoleVO);
	// <!-- 수정 -->
	void update(MemberRoleVO memberRoleVO);
	// <!-- 삭제 -->
	void delete(int idx);
	// <!-- 1개얻기 -->
	MemberRoleVO selectByIdx(int idx);
	// <!-- username으로 얻기 -->
	List<MemberRoleVO> selectByUsername(String username);
	// <!-- 모두얻기 -->
	List<MemberRoleVO> selectList();
}
