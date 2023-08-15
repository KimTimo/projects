package kr.green.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterEx2 implements Filter {

	// 생성자
    public FilterEx2() {
       System.out.println( this.getClass().getName() + "생성자 호출");
    }
    // 필터 객체가 소멸될때 자동으로 호출되는 메서드
	public void destroy() {
		 System.out.println( this.getClass().getName() + "의 destroy 호출");
	}
	// 요청이 있을때 마다 작동되는 메서드
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 요청을 변경한다.
		System.out.println(this.getClass().getName() + "의 doFilter 호출 : 전처리 작업(요청을 변경할때 사용)");
		
		chain.doFilter(request, response); // 다음 필터로 연결
		
		// 응답을 변경한다.
		System.out.println(this.getClass().getName() + "의 doFilter 호출 : 후처리 작업(응답을 변경할때 사용)");
	}
	// 필터 객체가 로드될때 자동으로 호출되는 메서드
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println( this.getClass().getName() + "의 init 호출");
	}

}
