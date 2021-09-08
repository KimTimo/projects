package kr.green.core.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.green.core.vo.Answer;
import kr.green.core.vo.Question;
import kr.green.core.vo.User;

@Configuration
public class AppConfig3 {

	// <!-- Answer객체 등록 -->
	@Bean("answer1")
	public Answer answer1() {
		return new Answer(1, "자바프로그램", new Date(121, 1, 23));
	}
	@Bean("answer2")
	public Answer answer2() {
		return new Answer(1, "스프링프로그램", new Date(121, 0, 21));
	}
	// <!-- User 객체 등록 -->
	@Bean("user1")
	public User user1() {
		return new User(1, "한사람", "root@xxx.xom");
	}
	@Bean("user2")
	public User user2() {
		return new User(1, "이사람", "admin@xxx.xom");
	}
	// <!-- Question 객체 등록 -->
	@Bean("question")
	public Question question() {
		return new Question(1,"문제1 : 가장재미있는 프로그램언어는?", map());
	}
	
	@Bean("map")
	public Map<Answer, User> map(){
		Map<Answer, User> map = new HashMap<>();
		map.put(answer1(), user1());
		map.put(answer2(), user2());
		return map;
	}
	
}
