/*
  자주사용하는 코드를 별도로 만들어놓고 필요할 때마다 불러서 사용하는것
  데이터를 저장하는것은 변수지만 메소드는 데이터를 가공하는 기능을 담당한다.
  C언어에선 함수라고 부른다.
 */
public class MethodEx02 {

	public static void main(String[] args) {
		System.out.println("쌉노잼");
		line();
		System.out.println("개노잼");
		line(22);
		System.out.println("ㄹㅇ노잼");
		line(24);
		line("~");
		line("^");
		line("^", 24);
		line(24, "@");
		System.out.println("핵노잼");
		line();
	}

	
	// 메소드 오버로딩 : 메소드의 이리ㅡㅁ을 동일하게 여러개 만들어서 사용한다.
	
	// 매개변수가 없는 메소드
	private static void line() {
		for (int i = 0; i < 80; i++)
			System.out.print("-");
		System.out.println();
	}

	// 매개변수가 있는 메소드
	private static void line(int count) {
		for (int i = 0; i < count; i++)
			System.out.print("-");
		
		System.out.println();
	
	}
	// 매개변수가 있는 메소드
	private static void line(String str) {
		for (int i = 0; i < 80; i++)
			System.out.print(str);
		System.out.println();
	}
	// 매개변수가 있는 메소드
	private static void line(String str, int count) {
		for (int i = 0;i < count; i++)
			System.out.print(str);
		System.out.println();
	}
	
	private static void line(int count, String str) {
		for (int i = 0; i < count; i++)
			System.out.print(str);
		System.out.println();
	}
}
