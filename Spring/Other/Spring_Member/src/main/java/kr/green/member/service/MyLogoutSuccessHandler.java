package kr.green.member.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import lombok.extern.slf4j.Slf4j;

// Spring Security에서 제공하는 logout에 성공한뒤, 항상 실행하기를 원하는 로직을 추가하기 위해
@Slf4j
public class MyLogoutSuccessHandler implements LogoutSuccessHandler{

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		log.info("{}의 onLogoutSuccess 호출", this.getClass().getName());
		HttpSession session = request.getSession();
		if(session.getAttribute("mvo")!=null) {
			session.removeAttribute("mvo");
		}
		try {
			response.sendRedirect(request.getContextPath() + "/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
