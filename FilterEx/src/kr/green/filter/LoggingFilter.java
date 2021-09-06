package kr.green.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

// @WebFilter("/*")
public class LoggingFilter implements Filter {

	public void destroy() { }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 1. 시작 전에 시간을 저장한다.
		long startTime = System.currentTimeMillis();
		
		chain.doFilter(request, response);

		// 3. 종료시간을 구한다.
		long endTime = System.currentTimeMillis();
		System.out.println( ((HttpServletRequest)request).getRequestURI() + " 실행시간 : " + (endTime - startTime) + "ms");
	}
	public void init(FilterConfig fConfig) throws ServletException { }

}
