import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		// 약수 : 나누어 떨어지는 수
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수 입력 : ");
		
		int n = sc.nextInt();
		int i = 1;
		System.out.println(n + "의 약수 : ");
		
		while(i<=n) { // 1~n 까지 반복
			if(n%i==0) System.out.print(i + " "); // 나누어 떨어지는 수는 약수이므로 출력
			i++;
		}
		System.out.println();
		
		n = sc.nextInt();
		i = 1;
		int count = 0; // 약수의 개수를 세어줄 변수
		while(i<=n) {
			if(n%i==0)	count++;
			i++;
		}
        System.out.println(n + "은 " + (count==2 ? "소수" : "합성수"));
		
	
		
		
		
		
		
		
		sc.close();
	}

}
