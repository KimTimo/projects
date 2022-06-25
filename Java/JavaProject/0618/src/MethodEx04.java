
public class MethodEx04 {

	public static void main(String[] args) {

		int tot = 2+3 + 3+4+5 + 21+22+23;
		System.out.println("합계 : " + tot);
		
		tot = sum(2, 3) + sum(3, 5) + sum(7, 10) + sum(21, 23);
		System.out.println("합계 : " + tot);

		
		tot = sum(1, 10) + sum(10, 1);
		System.out.println("합계 : " + tot);
		
		
		for(int i = 1; i <= 10; i++)
			System.out.println(i + "! = " + factorial(i));
		
	}
	
	// 메서드 선언 형식 : []는 생략 가능하다는 것이다.
	// [접근지정자] [static] 리턴타입 메서드명([매개변수...]){몸체...}
	
	// x의 y승을 구하는 메서드를 작성하시오
	public static long power(int x, int y) {
		int result = 1;
		while(y>0) {
			result *= x;
			--y;
		}
		return x;
	}
	
	// n! 을 구해주는 메서드
	public static long factorial(int n) {
		long l = n;
		while(n > 0) {
			l *= --n;
		}
		return l;
	}	
	
	// n ~ m 까지 합계를 구하는 메서드
	
	public static int sum(int n, int m) {
		int s = 0;
		
		// 이부분을 추가하면 큰수 ~ 적은수 까지도 가능하다.
		if(n>m) {
			int t = n;
			n = m;
			m = t;
			}
		for(int i = 1; i <= m; i++) s += i;
		return s; // return 값 : 처리 결과를 호출한 곳으로 되돌려준다.
	}
	
	
	
	
	
	
	
	
	

}
