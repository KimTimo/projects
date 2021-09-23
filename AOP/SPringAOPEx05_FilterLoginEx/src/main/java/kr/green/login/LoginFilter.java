package kr.green.login;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		// 요청을 받았을때 실행....
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String userId = (String)req.getSession().getAttribute("userId");
		if(userId==null || userId.trim().equals("")){
			res.sendRedirect("/login/login");
		}
		// 다음 필터로 전달....
		filterChain.doFilter(request, response);
		// 응답을 할때 실행.....
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
