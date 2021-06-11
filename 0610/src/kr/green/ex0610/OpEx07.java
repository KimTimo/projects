package kr.green.ex0610;

public class OpEx07 {

	public static void main(String[] args) {

		int x, y, z;
		
		x = y = 10;
		z = x + y;
		System.out.printf("%d, %d, %d\n", x, y, z);
		
		z = x==y ? x++ : ++y; // x==y 가 true이기 때문에 ++y는 연산에서 제외된다.
		System.out.printf("%d, %d, %d\n", x, y, z);
		
		z = (x==++y || ++x==++y) ? x : y;
		// OR연산의 경우 앞의 식이 참이면 뒤의 식은 계산되지 않음.
		System.out.printf("%d, %d, %d\n", x, y, z); // 11, 11, 11
		
		z = (x!=++y && ++x==++y) ? x : y;
		System.out.printf("%d, %d, %d\n", x, y, z); // 
		
	}

}
