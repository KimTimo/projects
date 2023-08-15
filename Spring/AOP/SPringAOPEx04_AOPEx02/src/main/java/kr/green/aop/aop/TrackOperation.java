package kr.green.aop.aop;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class TrackOperation {
	public void before(JoinPoint jp){
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd hh:mm:ss");
		System.out.println(jp.getSignature() );
		System.out.println("호출시간 : " + sdf.format(new Date()));
	}
	
	public void after(JoinPoint jp){
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd hh:mm:ss");
		System.out.println(jp.getSignature() );
		System.out.println("종료시간 : " + sdf.format(new Date()));
	}
	
	public void returning(JoinPoint jp,Object result){  
        System.out.println("Method Signature: "  + jp.getSignature());  
        System.out.println("리턴된 값 : "+result);  
    }  
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable{  
        long start = System.currentTimeMillis();  
        
        Object obj=pjp.proceed();  
        
        long end = System.currentTimeMillis();  
        System.out.println("실행시간 : " + (end-start) + "ms");
        return obj;  
    } 
	
	public void throwsMethod(JoinPoint jp,Throwable error){  
        System.out.println("성인인증 과정 시작");  
        System.out.println("Method Signature: "  + jp.getSignature());  
        System.out.println("에러 : "+error);  
        System.out.println("엄마젖 더먹고 와라~~~");  
    }  
}