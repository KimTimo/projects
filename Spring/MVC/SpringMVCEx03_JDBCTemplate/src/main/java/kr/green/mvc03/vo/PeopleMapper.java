package kr.green.mvc03.vo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

// 레코드 1개의 내용을 읽어서 VO로 만들어 리턴하는 메서두 구현
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
