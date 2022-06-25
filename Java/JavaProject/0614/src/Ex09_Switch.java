import java.util.Scanner;

public class Ex09_Switch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("점수를 입력하시오");
			int n = sc.nextInt();
			if(n<0) break;
			if(n>100) {
				System.out.println("0~100점 사이의 점수를 입력하세요.");
				continue;
			} // 여기까지 내려왔다는것은 0~100점 사이라는 것이다.
			String grade = "F";
			switch(n/10) {
			case 10:
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
			}
			// 5점 이상은 + 미만은 -
			if(n==100) // 예외사항 처리
				grade += "+";
			else if(n >= 60) { // F에는 +/-가 없다.
				if(n % 10 >= 5)
					grade += "+";
				else
					grade += "-";
			}
			System.out.println(n + "의 학점은 \"" + grade + "\"입니다.");
		} // end while
		sc.close();
	} // end main
} // end class
