package kr.green.ex0610;

public class OpEx06 {

	public static void main(String[] args) {

		int x, y, z;
		
		x = y = 10;
		z = x + y;
		System.out.printf("%d, %d, %d\n", x, y, z);
		
		x++; // 후위(후치)연산
		y++;
		z = x + y;
		System.out.printf("%d, %d, %d\n", x, y, z);
		
		++x; // 전위(전치)연산
		++y;
		z = x + y;
		System.out.printf("%d, %d, %d\n", x, y, z); // 12, 12, 24
		
		// 단독으로 사용시 전치/후치 상관없다.
		
		// 다른 연산자와 같이 사용할 경우
		z = x++ + ++y; // ++y; z = x + y; x++;
		System.out.printf("%d, %d, %d\n", x, y, z); // 13, 13, 25
		
		z = ++x + y++; // ++y; z = x + y; x++;
		System.out.printf("%d, %d, %d\n", x, y, z); // 14, 14, 27
	}

}
