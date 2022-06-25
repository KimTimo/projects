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
import javax.servlet.http.HttpServletResponse;
@WebFilter("/member2/*")
public class LoginCheckFilter implements Filter {

	public void destroy() {}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 로그인 체크를 해서 로그인이 되어있지 않으면 로그인 화면으로 보내줘야 한다.
		// 형변환
		HttpServletRequest  req = (HttpServletRequest) request;
		// 세션객체 얻어 등록된 유저아이디 찾아 없으면
		if(req.getSession().getAttribute("userid")==null) {
			// 로그인 화면으로 보낸다.
			HttpServletResponse  res = (HttpServletResponse) response;
			res.sendRedirect( req.getContextPath() + "/list.jsp");
			return;
		}
		chain.doFilter(request, response);
	}
	
	public void init(FilterConfig fConfig) throws ServletException { }

}
