package chapter2;

public class ExplicitConversion2 {

	public static void main(String[] args) {

		int iNum = 1000;
		byte bNum = (byte)iNum;
		
		System.out.println(iNum);
		System.out.println(bNum); // 1000�̶�� ���ڰ� 1byte �뷮�� ������ �ִ� byte�� ������ ��ȯ�� �̷�����鼭 ���� �սǵǾ� 1000�� �ƴ� ���� -24�� ��µ�
		
		double dNum = 3.14;
		iNum = (int)dNum;
		
		System.out.println(iNum); // int�� ������ ��ȯ�Ͽ� ���� �κи� �����Ա� ������ �Ҽ������� �սǵ�.
		float fNum = 0.9F;
		
		int num1 = (int)dNum + (int)fNum; // dNum �� 3.14�� ���������� ��ȯ�Ͽ� 3 + fNum �� 0.9�� ���������� ��ȯ�� �� 0 = 3
		int num2 = (int)(dNum + fNum); // dNum + fNum = ������� ���������� ��ȯ�Ͽ� ���� �� 4
		
		System.out.println(num1);
		System.out.println(num2);
		
	}

}
