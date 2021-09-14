package kr.green.mvc16.scheduler;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
public class AlarmTask {

	@Scheduled(cron = "*/5 * * * * *")
	public void alarm() {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		log.info("스케쥴실행 : {}", sdf.format(calendar.getTime()));
	}
}
