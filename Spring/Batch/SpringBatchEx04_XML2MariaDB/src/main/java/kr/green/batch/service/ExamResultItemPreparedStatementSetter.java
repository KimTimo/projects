package kr.green.batch.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import kr.green.batch.vo.ExamResult;

// SQL명령의 ? 에 대하여 매칭을 시켜주는 클래스
public class ExamResultItemPreparedStatementSetter implements ItemPreparedStatementSetter<ExamResult>{
	@Override
	public void setValues(ExamResult item, PreparedStatement ps) throws SQLException {
		ps.setString(1, item.getStudentName());
		ps.setDate(2, new Date(item.getDob().toDate().getTime()));
		ps.setDouble(3, item.getPercentage());
	}

}
