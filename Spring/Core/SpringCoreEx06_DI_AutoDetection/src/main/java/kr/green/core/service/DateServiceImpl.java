package kr.green.core.service;

import org.joda.time.LocalDate;
import org.springframework.stereotype.Service;

@Service("dateService")
public class DateServiceImpl implements DateService {
	@Override
	public LocalDate getNextAssessmentDate() {
		return new LocalDate(2021, 9, 8);
	}
}
