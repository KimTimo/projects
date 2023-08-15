import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = 1, m = 1;

		while (!(m == 0 && n == 0)) { // 존건 자체에 true/false 를 사용하는 것은 좋지 않은 프로그램 습관이다.
			System.out.println("총건수(m), 한 페이지에 보여줄 게시물수(n)를 입력 (0은 종료)");
			m = sc.nextInt();
			n = sc.nextInt();
			if (m == 0 && n == 0)
				continue;

			System.out.println(m + " " + n + " " + ((m-1)/n+1)); // 전체페이지 수 = (총개수-1)/페이지당개수 + 1

			int page = m / n;
			if (m % n != 0) // 18번라인 괄호식과 같은 뜻.
				page++;
			System.out.println(m + " " + n + " " + page);
		}

		sc.close();
	} // close main

} // close class
