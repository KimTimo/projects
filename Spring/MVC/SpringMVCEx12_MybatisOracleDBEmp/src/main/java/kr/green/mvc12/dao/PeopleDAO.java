package kr.green.mvc12.dao;

import java.sql.SQLException;
import java.util.List;

import kr.green.mvc12.vo.PeopleVO;

public interface PeopleDAO {
	void insert(PeopleVO peopleVO) throws SQLException;
	void update(PeopleVO peopleVO) throws SQLException;
	void delete(int id) throws SQLException;
	PeopleVO selectById(int id) throws SQLException;
	List<PeopleVO> selectList() throws SQLException;
}
