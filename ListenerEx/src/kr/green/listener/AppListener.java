package kr.green.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

// ServletContextAttributeListener : application영역에 변화가 있을떄 자동으로 작동된다.
@WebListener
public class AppListener implements ServletContextAttributeListener {
	// application영역에 속성이 추가될때
    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         System.out.println("application영역에 속성이 등록됨");
    }
    // application영역에 속성이 제거될때
    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	System.out.println("application영역에 속성이 삭제됨");
    }
    // application영역에 속성이 변경될때
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	System.out.println("application영역에 속성이 변경됨");
    }
}
