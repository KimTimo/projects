package kr.green.std3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.std3.dao.PeopleDAO;
import kr.green.std3.vo.PeopleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("peopleService")
public class PeopleServiceImpl implements PeopleService{
	
	@Autowired
	private PeopleDAO peopleDAO;

	@Override
	public PeopleVO getPeopleVOById(Long id) {
		log.info("{} getPeopleVOById 호출 : {}", this.getClass().getName(), id);
		PeopleVO peopleVO = peopleDAO.getPeopleVOById(id);
		log.info("{} getPeopleVOById 호출 결과 : {}", this.getClass().getName(), peopleVO);
		return peopleVO;
	}

	@Override
	public List<PeopleVO> getAllPeopleVO() {
		log.info("{}의 getAllPeopleVO 호출", this.getClass().getName());
		List<PeopleVO> list = peopleDAO.getAllPeopleVO();
		log.info("{} getPeopleVO 호출 결과: {}", this.getClass().getName(), list);
		return list;
	}

	@Override
	public boolean deletePerson(PeopleVO peopleVO) {
		log.info("{} deletePerson 호출 : {}", this.getClass().getName(), peopleVO);
		boolean result = peopleDAO.deletePerson(peopleVO);
		log.info("{} deletePerson 호출 결과 : {}", this.getClass().getName(), result);
		return result;
	}

	@Override
	public boolean updatePerson(PeopleVO peopleVO) {
		log.info("{} updatePerson 호출 : {}", this.getClass().getName(), peopleVO);
		boolean result = peopleDAO.updatePerson(peopleVO);
		log.info("{} updatePerson 호출 결과 : {}", this.getClass().getName(), result);
		return result;
	}

	@Override
	public boolean createPerson(PeopleVO peopleVO) {
		log.info("{} createPerson 호출 : {}", this.getClass().getName(), peopleVO);
		boolean result = peopleDAO.createPerson(peopleVO);
		log.info("{} createPerson 호출 결과 : {}", this.getClass().getName(), result);
		return result;
	}

}
