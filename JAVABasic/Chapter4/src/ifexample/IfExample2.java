package ifexample;

public class IfExample2 {

	public static void main(String[] args) {

		int age = 26;
		int charge = 0;
		
		if(age < 8) {
			charge = 1000;
			System.out.println("������ �Ƶ��Դϴ�.");
		}
		else if(age < 14) {
			charge = 2000;
			System.out.println("����� �Դϴ�.");
		}
		else if(age < 17) {
			charge = 3000;
			System.out.println("�ߵ� �Դϴ�.");
		}
		else if(age < 20) {
			charge = 4000;
			System.out.println("��� �Դϴ�.");
		}
		else {
			charge = 5000;
			System.out.println("���� �Դϴ�.");
		}
		
		System.out.println("������ " + charge +"�� �Դϴ�.");
		
	}

}
