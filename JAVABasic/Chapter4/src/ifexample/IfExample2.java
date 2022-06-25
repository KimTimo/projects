package ifexample;

public class IfExample2 {

	public static void main(String[] args) {

		int age = 26;
		int charge = 0;
		
		if(age < 8) {
			charge = 1000;
			System.out.println("미취학 아동입니다.");
		}
		else if(age < 14) {
			charge = 2000;
			System.out.println("잼민이 입니다.");
		}
		else if(age < 17) {
			charge = 3000;
			System.out.println("중딩 입니다.");
		}
		else if(age < 20) {
			charge = 4000;
			System.out.println("고딩 입니다.");
		}
		else {
			charge = 5000;
			System.out.println("성인 입니다.");
		}
		
		System.out.println("입장료는 " + charge +"원 입니다.");
		
	}

}
