package kr.green.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

// Application Lifecycle Listener : 웹 어플리케이션이 시작되거나 종료될떄 자동으로 호출돠어 실행된다.
@WebListener // 이껏을 쓰면 web.xml에 등록해주지 않아도 자동으로 등록된다.
public class MyListener implements ServletContextListener {
    public MyListener() {
        // 생성자
    }
    // 웹 어플리케이션이 종료될때
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("웹 어플리케이션이 종료되었습니다.");
    }

	// 웹 어플리케이션이 시작될때
    public void contextInitialized(ServletContextEvent sce)  { 
    	System.out.println("웹 어플리케이션이 시작되었습니다.");
    }
	
}
