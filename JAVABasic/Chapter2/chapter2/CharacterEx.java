package chapter2;

public class CharacterEx {

	public static void main(String[] args) {

		char ch = 'A';
		
		System.out.println(ch);
		System.out.println((int)ch); // A�� �������ִ� �� 65�� ���
		
		ch = 66; // ch�� ���� 66���� �ʱ�ȭ
		
		System.out.println(ch); // 66�� ������ �ִ� �� B�� ���
		System.out.println((int)ch); // char�� ������ int�� ������ ĳ���� ���� 66�� ���
		
		int ch2 = 67;
		System.out.println(ch2);
		System.out.println((char)ch2); // int�� ������ char�� ������ ĳ���� ���� C�� ��µ�
		
		
	}

}
