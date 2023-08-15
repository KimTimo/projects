import kr.green.vo.DateVO;

public class Ex04_DateTest2 {

	public static void main(String[] args) {

		// 생성자를 여러개 오버로딩하면 여러가지 형태로 객체 생성이 가능하다.
		DateVO date1 = new DateVO();
		DateVO date2 = new DateVO();

		System.out.println(date1);
		System.out.println(date2);
		// 위의 두개는 내용이 같다.
		System.out.println(date1 == date2 ? "같다" : "다르다");
		// 다르단다
		
		System.out.println(date1.equals(date2)? "같다" : "다르다");
		// 그래도 다르단다 왜?
		// 해시코드 : JVM은 객체들을 구분하기 위하여 객체마다 고유한 번호를 붙여준다.
		//            해시코드값이 다르면 다른 객체로 인식을 한다.
		// 그렇다면 내용이 같으면 같은 객체로 인식하도록 해주고 싶다면 어떻게 해야 할까?
		// equals()와 hashcode()를 오버라이딩 해주면 된다.
		System.out.println(date1.hashCode());
		System.out.println(date2.hashCode());
	}

}
