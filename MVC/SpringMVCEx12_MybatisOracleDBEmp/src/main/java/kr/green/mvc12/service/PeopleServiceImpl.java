package kr.green.mvc12.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.mvc12.dao.PeopleDAO;
import kr.green.mvc12.vo.PeopleVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service("peopleService")
public class PeopleServiceImpl implements PeopleService{

	@Autowired
	private PeopleDAO peopleDAO;

	@Override
	public void insert(PeopleVO peopleVO) {
		log.debug("{}의 insert 호출 : {}", this.getClass().getName(), peopleVO);
		if(peopleVO!=null)
			try {
				peopleDAO.insert(peopleVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}

	@Override
	public void update(PeopleVO peopleVO) {
		log.debug("{}의 update 호출 : {}", this.getClass().getName(), peopleVO);
		if(peopleVO!=null)
			try {
				peopleDAO.update(peopleVO);
			} catch (SQLException e) {
				e.printStackTrace();
			}		
	}
	@Override
	public void delete(int id) {
		log.debug("{}의 delete 호출 : {}", this.getClass().getName(), id);
		try {
			peopleDAO.delete(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	@Override
	public PeopleVO selectById(int id) {
		log.debug("{}의 selectById 호출 : {}", this.getClass().getName(), id);
		PeopleVO peopleVO = null;
		try {
			peopleVO = peopleDAO.selectById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("{}의 selectById 리턴 : {}", this.getClass().getName(), peopleVO);
		return peopleVO;
	}

	@Override
	public List<PeopleVO> selectList() {
		log.debug("{}의 selectList 호출", this.getClass().getName());
		List<PeopleVO> list = null;
		try {
			list = peopleDAO.selectList();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		log.debug("{}의 selectList 리턴 : {} ", this.getClass().getName(), list);
		return list;
	}
}
