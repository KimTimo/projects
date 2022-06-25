package chapter2;

public class ExplicitConversion2 {

	public static void main(String[] args) {

		int iNum = 1000;
		byte bNum = (byte)iNum;
		
		System.out.println(iNum);
		System.out.println(bNum); // 1000이라는 숫자가 1byte 용량을 가지고 있는 byte형 변수로 변환이 이루어지면서 값이 손실되어 1000이 아닌 음수 -24로 출력됨
		
		double dNum = 3.14;
		iNum = (int)dNum;
		
		System.out.println(iNum); // int형 변수로 변환하여 정수 부분만 가져왔기 때문에 소수점값이 손실됨.
		float fNum = 0.9F;
		
		int num1 = (int)dNum + (int)fNum; // dNum 값 3.14를 정수형으로 변환하여 3 + fNum 값 0.9를 정수형으로 변환한 값 0 = 3
		int num2 = (int)(dNum + fNum); // dNum + fNum = 결과값을 정수형으로 변환하여 나온 값 4
		
		System.out.println(num1);
		System.out.println(num2);
		
	}

}
