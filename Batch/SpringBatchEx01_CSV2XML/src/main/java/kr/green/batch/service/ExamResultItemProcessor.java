package kr.green.batch.service;

import org.springframework.batch.item.ItemProcessor;

import kr.green.batch.vo.ExamResult;

// 1개 처리할때마다 처리할 내용이 지정 : 데이터를 필터링 처리가 가능하다.
public class ExamResultItemProcessor implements ItemProcessor<ExamResult, ExamResult> {

	@Override
	public ExamResult process(ExamResult item) throws Exception {
		System.out.println("읽기 성공 : " + item);
		// 퍼셑트가 60이상만 처리하고 싶다면 다음의 코드를 추가해 주면 된다.
		if(item.getPercentage()<60) {
			return null;
		}
		return item;
	}

}
