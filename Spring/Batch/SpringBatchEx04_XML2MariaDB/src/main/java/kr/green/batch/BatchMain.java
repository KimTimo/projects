package kr.green.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BatchMain {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("batch-context.xml");
		
		JobLauncher jobLauncher = context.getBean("jobLauncher", JobLauncher.class); // 배치처리 실행기
		Job job = context.getBean("examResultJob", Job.class);// 실제 처리할 일
		
		try {
			JobExecution execution = jobLauncher.run(job, new JobParameters()); // 일을 실행해라
			System.out.println("실행 상태 : " + execution.getStatus());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			System.out.println("실패~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			e.printStackTrace();
		} 
		context.close();
	}
}
