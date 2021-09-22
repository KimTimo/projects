package kr.green.std3.service;

import java.util.List;

import kr.green.std3.vo.PeopleVO;

public interface PeopleService {
	PeopleVO getPeopleVOById(Long id);
	List<PeopleVO> getAllPeopleVO();
    boolean deletePerson(PeopleVO peopleVO);
    boolean updatePerson(PeopleVO peopleVO);
    boolean createPerson(PeopleVO peopleVO);
}
