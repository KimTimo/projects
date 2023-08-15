package kr.green.login;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class LoginCheckAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoginCheckAspect.class);

	@Around("@annotation(kr.green.login.LoginCheckBeforeFunctionStart)")
	public Object loginCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("login check 시작");
		// 애플리케이션에서 Request 객체를 읽어옴
        HttpServletRequest request = 
        		((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String userId =(String)request.getSession().getAttribute("userId");
        logger.info("아이디 : " + userId);
		if(userId!=null){
			logger.info("login success");
			Object object = joinPoint.proceed();
			return object;
		}else{
			return "redirect:/login";
		}
		/*
        for ( Object o : joinPoint.getArgs() ){
			if ( o instanceof HttpServletRequest ) { 
				String userId =(String)((HttpServletRequest) o).getSession().getAttribute("userId");
				logger.info("아이디 : " + userId);
				if(userId!=null){
					logger.info("login success");
					Object object = joinPoint.proceed();
					return object;
				}
			}
		}
        return "redirect:/login";
		*/
 	}
}