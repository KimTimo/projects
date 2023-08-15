package kr.green.std3.dao;

import java.util.List;

import kr.green.std3.vo.PeopleVO;

public interface PeopleDAO {
	PeopleVO getPeopleVOById(Long id);  // 1개 얻기
	List<PeopleVO> getAllPeopleVO(); // 모두 얻기
	boolean deletePerson(PeopleVO peopleVO); // 삭제
	boolean updatePerson(PeopleVO peopleVO); // 수정
	boolean createPerson(PeopleVO peopleVO); // 저장

}
