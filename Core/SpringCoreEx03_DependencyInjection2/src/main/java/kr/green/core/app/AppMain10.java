package kr.green.core.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import kr.green.core.config.AppConfig3;
import kr.green.core.vo.Answer;
import kr.green.core.vo.Question;
import kr.green.core.vo.User;

public class AppMain10 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new AnnotationConfigApplicationContext(AppConfig3.class);
		
		Answer answer = context.getBean("answer1", Answer.class);
		System.out.println(answer);
		
		User user = context.getBean("user1", User.class);
		System.out.println(user);
		
		
		Question question = context.getBean("question", Question.class);
		System.out.println(question);
		
		context.close();
	}
}
