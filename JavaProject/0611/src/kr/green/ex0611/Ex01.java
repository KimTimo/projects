package kr.green.ex0611;

public class Ex01 {

	public static void main(String[] args) {

		int x = 3, y = 5;
		
		int z = x | y;
		System.out.println(x + " | " + y + " = " + z);
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(y));
		System.out.println(Integer.toBinaryString(z));
		
		z = x & y;
		System.out.println(x + " & " + y + " = " + z);
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(y));
		System.out.println(Integer.toBinaryString(z));
		
		
		z = x ^ y;
		System.out.println(x + " ^ " + y + " = " + z);
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(y));
		System.out.println(Integer.toBinaryString(z));

		
		z = x ^ y;
		System.out.println(x + " ^ " + y + " = " + z);
		System.out.println(Integer.toBinaryString(x));
		System.out.println(Integer.toBinaryString(y));
		System.out.println(Integer.toBinaryString(z));
	}

}
