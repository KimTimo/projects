package chapter2;

public class ImplicitConversion {

	public static void main(String[] args) {

		byte bNum = 10;
		int num = bNum;
		
		System.out.println(num);
		
		long lNum = 10;
		float fNum = lNum;
		
		System.out.println(fNum);
		
		double dNum = fNum + num;
		System.out.println(dNum);
		
		double ddNum = 3.14;
		System.out.println((int)ddNum); // 명시적 형 변환으로 인해 소수점 값이 손실되었음.
	}

}
