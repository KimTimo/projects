package kr.green.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 로그인 처리를 한다.....
		String userId = (String) request.getSession().getAttribute("userId");
		if(userId==null || userId.equals("")){
			response.sendRedirect(request.getContextPath() + "/login");
		}
		return super.preHandle(request, response, handler);
	}
	
	

}
