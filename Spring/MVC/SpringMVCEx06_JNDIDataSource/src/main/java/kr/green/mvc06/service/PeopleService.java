package kr.green.mvc06.service;

import java.util.List;

import kr.green.mvc06.vo.PeopleVO;

public interface PeopleService {
	PeopleVO getPeopleVOById(Long id); //  1개얻기
	List<PeopleVO> getAllPeopleVO(); // 모두 얻기
	boolean deletePerson(PeopleVO peopleVO); // 삭제
	boolean updatePerson(PeopleVO peopleVO); // 수정
	boolean createPerson(PeopleVO peopleVO); // 저장
}
