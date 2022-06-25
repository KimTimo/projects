package kr.green.std3.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PeopleMapper implements RowMapper<PeopleVO>{

	@Override
	public PeopleVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PeopleVO peopleVO = new PeopleVO();
		peopleVO.setId(rs.getInt("id"));
		peopleVO.setName(rs.getString("name"));
		peopleVO.setAge(rs.getInt("age"));
		return peopleVO;
	}

}
