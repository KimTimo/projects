package kr.green.batch.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import kr.green.batch.vo.LicenseVO;

public class LicenseVOItemPreparedStatementSetter implements ItemPreparedStatementSetter<LicenseVO> {

	@Override
	public void setValues(LicenseVO result, PreparedStatement ps) throws SQLException {
		ps.setInt(1, result.getIdx());
		ps.setInt(2, result.getType());
		ps.setString(3, result.getQuestion());
		ps.setString(4, result.getAns1());
		ps.setString(5, result.getAns2());
		ps.setString(6, result.getAns3());
		ps.setString(7, result.getAns4());
		ps.setString(8, result.getAns5());
		ps.setInt(9, result.getCor1());
		ps.setInt(10, result.getCor2());
		ps.setString(11, result.getDesc());
		ps.setString(12, result.getContents());
	}

}
