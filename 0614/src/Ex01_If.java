import java.util.Scanner;

public class Ex01_If {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		int score = sc.nextInt();
		System.out.println("입력값 : " + score + "점");
		System.out.println("-----------------------------");
		if(score >= 70) {
			System.out.println(score + "점으로 합격입니다.");
		}else {
			System.out.println(score + "점으로 불합격입니다.");
		}
		System.out.println("-----------------------------");
		//단순한 조건문은 삼항연산자로 대체가 가능.
		
		
		
		System.out.println(score + "점으로 당신은 " + (score>= 60 ? "합":"불합") + "격입니다.");
		//될 수 있으면 결과는 마지막에 한번의 출력으로 끝내자.
		String result = "";
		if(score >= 70) {
			result = "합격";
		}else {
			result = "불합격";
		}
		System.out.println(score + "점으로 당신은 " + result + "입니다.");
		sc.close();
	}

}
