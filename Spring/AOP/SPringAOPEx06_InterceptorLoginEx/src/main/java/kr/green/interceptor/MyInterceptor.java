package kr.green.interceptor;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyInterceptor implements HandlerInterceptor {
	/**
	* Logger for this class
	*/
	private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception)
			throws Exception {
		
			logger.info("afterCompletion() 메서드는 클라이언트의 요청을 처리한 뒤, 즉 뷰를 통해서 클라이언트에 응답을 전송한 뒤에 실행된다.");
			logger.info("컨트롤러가 처리하는 도중이나 뷰를 생성하는 과정에 예외가 발생해도 afterCompletion() 메서드는 실행된다.");
			logger.info("afterCompletion() 메서드 역시 preHandle() 메서드의 실행 순서와 반대로 수행된다. \n");
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		
		logger.info("postHandle() 메서드는 컨트롤러가 요청을 처리한 뒤에 호출된다. ");
		logger.info("postHandle() 메서드는 preHandle() 메서드의 실행 순서와 반대로 수행된다. ");
		logger.info("예를 들어 체인에 1, 2, 3 순서가 명시되어 있을 경우 postHandle() 메서드는 3, 2, 1 순서로 실행된다.");
		logger.info("컨트롤러 실행 도중 예외가 발생하면 postHandle() 메서드는 실행되지 않는다.\n ");
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		logger.info("preHandle() 메서드는 클라이언트의 요청을 컨트롤러에 전달하기 전에 호출된다.");
		logger.info("3번째 파라미터 handler 객체에는 컨트롤러 객체가 전달된다.");
		logger.info("preHandle() 메서드가 false 를 리턴하게 되면 다음 체인의 HandlerInterceptor와 Controller를 실행하지 않고 요청 처리를 종료한다.\n");

		return true;
	}

}
