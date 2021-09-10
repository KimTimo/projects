package kr.green.core;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.green.core.vo.HelloWorld;

public class AppMain1 {
	public static void main(String[] args) {
		// context : 이 어플리케이션에 대한 모든 정보를 가지고있는 컨테이너이다.
		AbstractApplicationContext context =
				// 클래스 패스에있는 xml 설정 파일을 읽어서 관리해라. 
				// 등록된 모든 객체를 context에 만들어 스프링 프레임 워크가 관리하게 된다.
				new ClassPathXmlApplicationContext("application.xml");
		
		// 사용자는 context에서 필요한 객체를 얻어서 로직을 수행하면 된다.
		HelloWorld helloWorld = context.getBean("helloWorld", HelloWorld.class);
		helloWorld.sayHello("한사람");
		System.out.println(helloWorld.hashCode());
		
		HelloWorld helloWorld2 = context.getBean("helloWorld", HelloWorld.class);
		helloWorld2.sayHello("두사람");
		System.out.println(helloWorld2.hashCode());
		
		// 두 객체의 해시코드가 같다. 결국 객체가 2개가 아니라 1개이다. 
		// 스프링은 기본적으로 객체를 싱글톤으로 관리한다.  
		
		// 닫기
		context.close();
	}
}
