package kr.green.core.app;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.Answer;
import kr.green.core.vo.Question;
import kr.green.core.vo.User;

public class AppMain9 {
	public static void main(String[] args) {
		AbstractApplicationContext context = 
				new ClassPathXmlApplicationContext("app7.xml");
		
		Answer answer = context.getBean("answer1", Answer.class);
		System.out.println(answer);
		
		User user = context.getBean("user1", User.class);
		System.out.println(user);
		
		
		Question question = context.getBean("question", Question.class);
		System.out.println(question);
		
		context.close();
	}
}
