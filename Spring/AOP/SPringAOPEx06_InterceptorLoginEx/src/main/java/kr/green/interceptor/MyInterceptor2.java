package kr.green.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
// HandlerInterceptorAdapter클래스를 상속 받을 경우에는 필요한 메소드만 오버라이딩한다.
public class MyInterceptor2 extends HandlerInterceptorAdapter {
	/**
	* Logger for this class
	*/
	private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

//	@Override
//	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
//			throws Exception {
//		
//			logger.info("afterCompletion() 메서드는 클라이언트의 요청을 처리한 뒤, 즉 뷰를 통해서 클라이언트에 응답을 전송한 뒤에 실행된다.");
//			logger.info("컨트롤러가 처리하는 도중이나 뷰를 생성하는 과정에 예외가 발생해도 afterCompletion() 메서드는 실행된다.");
//			logger.info("afterCompletion() 메서드 역시 preHandle() 메서드의 실행 순서와 반대로 수행된다. \n");
//		
//	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
		logger.info("**************************************************************");
		logger.info("postHandle() 메서드는 컨트롤러가 요청을 처리한 뒤에 호출된다. ");
		logger.info("**************************************************************");
		
	}

//	@Override
//	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//
//		logger.info("***************************************************************************");
//		logger.info("preHandle() 메서드는 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출된다.");
//		logger.info("***************************************************************************");
//
//		return true;
//	}

}
