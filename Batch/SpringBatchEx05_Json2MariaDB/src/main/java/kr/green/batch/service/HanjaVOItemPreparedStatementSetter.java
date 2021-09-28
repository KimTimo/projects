package kr.green.batch.service;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import kr.green.batch.vo.HanjaVO;

public class HanjaVOItemPreparedStatementSetter implements ItemPreparedStatementSetter<HanjaVO> {

	@Override
	public void setValues(HanjaVO item, PreparedStatement ps) throws SQLException {
		ps.setString(1, item.getD());		
		ps.setString(2, item.getS());		
		ps.setString(3, item.getN());		
		ps.setString(4, item.getQ());		
		ps.setString(5, item.getE1());		
		ps.setString(6, item.getE2());		
		ps.setString(7, item.getE3());		
		ps.setString(8, item.getE4());		
		ps.setString(9, item.getA());		
	}

}
