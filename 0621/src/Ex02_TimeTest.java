import kr.green.vo.TimeDTO;

public class Ex02_TimeTest {

	public static void main(String[] args) {
		TimeDTO time1 =  new TimeDTO(); // 기본 생성자 호출
		time1.hour = 11;
		time1.minute = 12;
		time1.second = 13;
		
		int i = 100; // 기본타입은 생성과 동시에 초기화가 가능하다
		TimeDTO time2 = new TimeDTO(11,22,33); // 이렇게 객체를 생성과 동시에 초기화 하면 좋겠다..
		                               // 이때는 클래스에 생성자 메소드를 만들어 주면 된다.
		
		System.out.println("i = " + i); // 이렇게 출력이 가능하다.
		// 내가 만든 객체도 sout으로 출력할 수 있다면 좋을텐데,,
	    System.out.println("시간 : " + time1);
	    // 쥿같이 출력된다.
		
		// 내가 원하는 모양으로 출력하기 위해서는 toString() 메소드를 오버라이팅(재정의) 해주면 된다.
	    System.out.println("시간 : " + time1.toString());
	    
		System.out.println("시간 : " + time1.getClass().getName()+"@"+Integer.toHexString(time1.hashCode()));
		// 위의 결과로 미루어 볼때 객체를 출력하면 toString() 메소드가 자동으로 호출되고
		// toString() 메소드의 내용은 "클래스이름@해시코드" 라는 것을 알 수 있다.
		// 이제 toString() 메소드를 오버라이딩(재정의) 하면 내가 원하는 모양으로 출력이 가능하겠다라고 짐작이 가능하다.
	}
}
