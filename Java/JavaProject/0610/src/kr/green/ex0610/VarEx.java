package kr.green.ex0610;

public class VarEx {

	int i;
	boolean gender;
	String name;
	
	public static void main(String[] args) {

		float var;
		
		VarEx ex = new VarEx();
		
		System.out.println("i = " + ex.i);
		System.out.println("name = " + ex.name);
		System.out.println("gender = " + ex.gender);
		ex.name = "김머현";
		System.out.println("name = " + ex.name);
		
		long l = 10L;
		float f = l; // 바이트 수가 적더라도 정수보다 실수가 저장 범위가 크기 때문에 에러가 아님.
		
		byte b = 111;
		int i = b; // 자동 형변환
		// b = i; // 큰 자료형을 형변환이 됨.
		b = (byte)i; // 강제 형변환
		System.out.println(b);
		
		
		i = 235; // 자동 형변환
		b = (byte)i; // 강제 형변환하면 데이터가 손실될 수 있음.
		System.out.println(b); // -21
		
		i = 0x11223344;
		System.out.println("i = " + i);
		b = (byte)i;
		System.out.println(b);
		System.out.println(Integer.toHexString(b)); // toHexString(10진수) : 16진수로 변경
		
		
	}

}
