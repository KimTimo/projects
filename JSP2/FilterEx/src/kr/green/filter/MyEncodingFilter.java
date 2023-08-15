package kr.green.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
@WebFilter(
		urlPatterns = { "/*" }, 
		initParams = { 
				@WebInitParam(name = "charSet", value = "UTF-8", description = "문자 인코딩값")
		})
public class MyEncodingFilter implements Filter {
	
	private String charSet;
	
	public void destroy() { }
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청 변경
		request.setCharacterEncoding(charSet);
		
		chain.doFilter(request, response);
		
		
	}
	public void init(FilterConfig fConfig) throws ServletException {
		// 초기화 파라메터 값을 읽는다.
		charSet = fConfig.getInitParameter("charSet");
	}

}
