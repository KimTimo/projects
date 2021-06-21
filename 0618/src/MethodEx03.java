
public class MethodEx03 {

	public static void main(String[] args) {

		int tot = 1+2+3 + 1+2+3+4+5 + 1+2+3+4+5+6+7+8+9+10;
		System.out.println("합계 : " + tot);
		System.out.println("합계 : " + (sum(3) + sum(5) + sum(10)));
		tot = sum(3) + sum(5) + sum(10);
		System.out.println("합계 : " + tot);
		
		System.out.println("5는 " + (isOdd(5) ? "홀수":"짝수"));
		System.out.println("5는 " + (isOdd(4) ? "홀수":"짝수"));
	}
	
	// 메서드 선언 형식 : []는 생략 가능하다는 것이다.
	// [접근지정자] [static] 리턴타입 메서드명([매개변수...]){몸체...}
	
	// 1 ~ n 까지 합계를 구하는 메서드
	
	public static int sum(int n) {
		int s = 0;
		for(int i = 1; i <= n; i++) s += i;
		return s;
	}
	
	// 홀수인지를 판단해주는 메소드
	/*public static boolean isOdd(int n) { // 리턴은 여러번 나올 수 있다. return을 만나면 그 자리에서 메서드가 종료된다.
		if(n%2==0)                       // 좋지 않은 코드이다. return은 마지막에 한번만 쓰는것을 권장한다.
			return false;
		else
			return true;
	}
	*/
	
	/*public static boolean idOdd(int n) { // return을 마지막에 1번 쓰는 방법
		boolean is = true;
		if(n%2==0) is = false;
		return is;
	}
	*/
	public static boolean isOdd(int n) {
		return n%2 != 0;
	}
	
	
	
	
	
	

}
