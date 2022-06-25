package kr.green.mvc08.service;

import java.util.List;

import kr.green.mvc08.vo.PeopleVO;

public interface PeopleService {
	void insert(PeopleVO peopleVO);
	void update(PeopleVO peopleVO);
	void delete(int id);
	PeopleVO selectById(int id);
	List<PeopleVO> selectList();
}
