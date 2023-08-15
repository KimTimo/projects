package kr.green.std3.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.green.std3.vo.PeopleMapper;
import kr.green.std3.vo.PeopleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository("peopleDAO")
public class PeopleDAOImpl implements PeopleDAO{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("deprecation")
	@Override
	public PeopleVO getPeopleVOById(Long id) {
		log.info("{} getPeopleVOById 호출 : {}", this.getClass().getName(), id);
		PeopleVO peopleVO = jdbcTemplate.queryForObject("select * from people where id=?", new Object[] {id}, new PeopleMapper());
		log.info("{} getPeopleVOById 호출 결과 : {}", this.getClass().getName(), peopleVO);
		return peopleVO;
	}

	@Override
	public List<PeopleVO> getAllPeopleVO() {
		List<PeopleVO> list = jdbcTemplate.query("select * from people order by id desc", new PeopleMapper());
		log.info("{} getPeopleVO 호출 결과: {}", this.getClass().getName(), list);
		return list;
	}

	@Override
	public boolean deletePerson(PeopleVO peopleVO) {
		log.debug("{} deletePerson 호출 : {}", this.getClass().getName(), peopleVO);
		boolean result = jdbcTemplate.update("delete from people where id=?", peopleVO.getId())>0;
		log.debug("{} deletePerson 호출 결과 : {}", this.getClass().getName(), result);
		return result;
	}

	@Override
	public boolean updatePerson(PeopleVO peopleVO) {
		log.debug("{} updatePerson 호출 : {}", this.getClass().getName(), peopleVO);
		boolean result = jdbcTemplate.update("update people set name=?, age=? where id=?", peopleVO.getName(), peopleVO.getAge(), peopleVO.getId())>0;
		log.debug("{} updatePerson 호출 결과 : {}", this.getClass().getName(), result);
		return result;
	}

	@Override
	public boolean createPerson(PeopleVO peopleVO) {
		log.debug("{} createPerson 호출 : {}", this.getClass().getName(), peopleVO);
		boolean result = jdbcTemplate.update("insert into people (name,age) values (?,?)", peopleVO.getName(), peopleVO.getAge())>0;
		log.debug("{} createPerson 호출 결과 : {}", this.getClass().getName(), result);
		return result;
	}

}
