package kr.green.mvc08.dao;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.green.mvc08.vo.PeopleVO;

@Repository("peopleDAO")
public class PeopleDAOImpl implements PeopleDAO{

	@Autowired
	private SqlMapClient sqlMapClient;

	@Override
	public void insert(PeopleVO peopleVO) throws SQLException {
		sqlMapClient.insert("people.insert", peopleVO);
	}

	@Override
	public void update(PeopleVO peopleVO) throws SQLException {
		sqlMapClient.update("people.update", peopleVO);
	}

	@Override
	public void delete(int id) throws SQLException {
		sqlMapClient.delete("people.delete", id);		
	}

	@Override
	public PeopleVO selectById(int id) throws SQLException {
		return (PeopleVO) sqlMapClient.queryForObject("people.selectById", id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<PeopleVO> selectList() throws SQLException {
		return sqlMapClient.queryForList("people.selectList");
	}
}
