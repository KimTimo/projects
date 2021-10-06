package kr.green.guestbook.log;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LogEx02 {
	public static void main(String[] args) {
		log.debug("{}, {}, {}", "짝!!", "찍", "쪽");
		log.debug("짝!!, 찍, 쪽");
	}

}
