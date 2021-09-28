package kr.green.batch.service;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

// 처리 전후에 어떠한 작업을 하고 싶을때 감시자로 만든다.
public class HanjaVOJobListener implements JobExecutionListener{
	private long startTime, endTime;

	@Override
	public void beforeJob(JobExecution jobExecution) { // 전처리 작업
		startTime = System.currentTimeMillis();
		System.out.println("작업 시작 : " + startTime + "ms");
	}

	@Override
	public void afterJob(JobExecution jobExecution) { // 후처리 작업
		endTime = System.currentTimeMillis();
		System.out.println("작업 종료 : " + endTime + "ms");
		System.out.println("실행시간 : " + (endTime - startTime) + "ms");
		if(jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("작업성공!!!");
		}else if(jobExecution.getStatus() == BatchStatus.FAILED) {
			System.out.println("작업실패!!!");
			List<Throwable> exceptionList = jobExecution.getAllFailureExceptions();
			for(Throwable t : exceptionList) {
				System.out.println("예외 : " + t.getLocalizedMessage());
			}
		}
	}
}
