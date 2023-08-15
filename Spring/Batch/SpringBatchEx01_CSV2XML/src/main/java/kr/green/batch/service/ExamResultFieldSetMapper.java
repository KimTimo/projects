package kr.green.batch.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import kr.green.batch.vo.ExamResult;

// 1줄을 읽어서 객체로 맵핑해 주는 클래스
public class ExamResultFieldSetMapper implements FieldSetMapper<ExamResult> {

	@Override // 인수로 1줄의 데이터가 fieldSet으로 넘어온다
	public ExamResult mapFieldSet(FieldSet fieldSet) throws BindException {
		ExamResult examResult = null;
		try {
			examResult = new ExamResult(); //객체 만들고
			examResult.setName(fieldSet.readString(0).trim()); // 첫번째것 읽어서 name에 넣고
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			examResult.setDob(sdf.parse(fieldSet.readString(1).trim())); // 두번째것 읽어서 dob에 넣고
			examResult.setPercentage(fieldSet.readDouble(2)); // 세번째것 읽어서 Percentage에 넣고
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return examResult;
	}
}
