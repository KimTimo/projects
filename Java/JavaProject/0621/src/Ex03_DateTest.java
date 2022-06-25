import kr.green.vo.DateVO;

public class Ex03_DateTest {

	public static void main(String[] args) {

		// 생성자를 여러개 오버로딩하면 여러가지 형태로 객체생성이 가능하다.
		DateVO date1 = new DateVO();
		DateVO date2 = new DateVO(2021);
		DateVO date3 = new DateVO(2021, 8);
		DateVO date4 = new DateVO(2021, 6, 21);
		DateVO date5 = new DateVO(2021, 14, 36);
		DateVO date6 = new DateVO(2021, -12, -8);
		
		System.out.println(date1);
		System.out.println(date2);
		System.out.println(date3);
		System.out.println(date4);
		System.out.println(date5); // 존재할 수 없다
		System.out.println(date6); // 존재할 수 없다
		
		// 클래스는 자체적으로 데이터를 검증하는 코드가 있으면 좋다
		
		// 필드가 public 이면 어디에서든 접근이 가능하다.
		// 필드를 private으로 변경하면 외부에서 접근불가 하므로 에러발생
		
//		date6.year = -2011;
		date6.setYear(-2011);  // setter에 유효성 검증 코드를 추가하여 잘못된 데이터를 걸러준다.
//		date6.month = 24;
		date6.setMonth(24);
		date6.setDate(78);
		
		System.out.println(date6);
	}

}
