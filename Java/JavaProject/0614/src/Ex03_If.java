import java.util.Scanner;

public class Ex03_If {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("점수를 입력하시오");
			int n = sc.nextInt();
			if(n<0) break;
			if(n>100) {
				System.out.println("0~100점 사이의 점수를 입력하세요.");
				continue;
			}
			String grade = "F";
			if(n>=90)
				grade = "A";
			else if(n>=80)
				grade = "B";
			else if(n>=70)
				grade = "C";
			else if(n>=60)
				grade = "D";
			// 5점 이상은 + 5점 미만은 -를 붙이자
			if(n==100)
				grade += "+";
			else if(n>=60) { // F뒤에는 +/-rk djqtek.
				if(n%10 >= 5 );
			}
			System.out.println(n + "의 학점은 \"" + grade + "\"입니다.");
		}

		sc.close();
	}

}
