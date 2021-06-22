import kr.green.vo.PersonVO;

public class Ex01_PersonTest {

	public static void main(String[] args) {
		// 내가만든 클래스라도 패키지가 다르면 import해서 사용한다.
		PersonVO kimc = new PersonVO();
		// 필드(속성, 멤버변수)에 접근할때는 .(멤버연산자)를 사용
		kimc.name = "김벌처";
		kimc.age = 26;
		kimc.gender = true;
		viewPersonVO(kimc); // 메소드로 객체 전달
		// 메소드를 호출
		kimc.viewPerson();
		
		
		kimc.age = 30;
		viewPersonVO(kimc);
		kimc.viewPerson();
		
		PersonVO ahnc = new PersonVO();
		ahnc.name =  "안공주";
		ahnc.age =  24;
		ahnc.gender =  true;
		viewPersonVO(ahnc);
		ahnc.viewPerson();
	}

	private static void viewPersonVO(PersonVO kimc) {
		System.out.print(kimc.name + "(" + kimc.age + "세, ");
		System.out.println((kimc.gender ? "남" : "여") + ")");
	}

}
