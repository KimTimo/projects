package loopexample;

public class WhileExample2 {

	public static void main(String[] args) {

		int num = 1;
		int sum = 0;
		
		do {
			sum += num;
			num++;
		}while(num <= 0); //���ǽ��� ���߿� ����Ǳ� ������ �ڵ尡 �ѹ��� ����ȴ�. �׷��� ������� 1�� ��µ�.
		
		System.out.println("1���� 10������ ���� " +sum+ "�Դϴ�.");
	}

}
