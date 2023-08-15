package kr.green.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener, HttpSessionAttributeListener {
	// 세션이 생기면 : HttpSessionListener
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("새로운 세션이 생김");
    	
    	// 현재 접속자 수를 카운팅 하고 싶다......
    	// 1. 세션을 얻는다.
    	HttpSession session = se.getSession();
    	// 2. application객체를 얻는다. : session.getServletContext()
    	// 3. application객체에 현재 사용자수가 등록되어있는지 판단한다.
    	if(session.getServletContext().getAttribute("currCount")== null) {
    		// 없으면 1을 등록한다
    		session.getServletContext().setAttribute("currCount", 1);
    	}else {
    		// 있으면 읽어서 +1해주고 다시 저장한다.
    		int currCount = (int) session.getServletContext().getAttribute("currCount");
    		currCount++;
    		session.getServletContext().setAttribute("currCount", currCount);
    	}
    	System.out.println(session.getId() + "세션 생성");
    	System.out.println("현재 : " + ((int) session.getServletContext().getAttribute("currCount")) + "명");
    }
    // 세션이 종료되면 : HttpSessionListener
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("세션이 종료됨");
    	// 1. 세션을 얻는다.
    	HttpSession session = se.getSession();
    	// 2. application객체를 얻는다. : session.getServletContext()
    	// 3. application객체에 현재 사용자수가 등록되어있는지 판단한다.
    	if(session.getServletContext().getAttribute("currCount")!= null) {
    		// 있으면 읽어서 -1해주고 다시 저장한다.
    		int currCount = (int) session.getServletContext().getAttribute("currCount");
    		currCount--;
    		session.getServletContext().setAttribute("currCount", currCount);
    	}
    	System.out.println(session.getId() + "세션 소멸");
    	System.out.println("현재 : " + ((int) session.getServletContext().getAttribute("currCount")) + "명");
    }
    // 세션에 속성이 추가되면 : HttpSessionAttributeListener
    public void attributeAdded(HttpSessionBindingEvent se)  { 
    	System.out.println("세션에 속성이 추가되면");
    	// 로그인 중복을 제거 하려면 여기에서 로그인이 될때 로그인된 사용자의 세션을 application영역의 Map에 세션을 저장을 해준다.
    	// 저장할때 같은 아이디가 Map에 저장되어 있다면 중복으로 로그인하는 것이다.
    	// 그러면 application영역에 Map에 저장된 세션을 강제로 종료하고 현재 세션을 넣어주면 중복로그인 방지를 수행할 수 있다. 
    	
    }

    // 세션에 속성이 삭제되면 : HttpSessionAttributeListener
    public void attributeRemoved(HttpSessionBindingEvent se)  { 
    	System.out.println("세션에 속성이 삭제되면");
    	// 로그인 중복을 제거 하려면 여기에서 로그아웃 될때 로그인된 사용자의 세션을 application영역에 Map에 제거를 해준다.
    	
    }

    // 세션에 속성이 변경되면 : HttpSessionAttributeListener
    public void attributeReplaced(HttpSessionBindingEvent se)  { 
    	System.out.println("세션에 속성이 변경되면");
    }
	
}
