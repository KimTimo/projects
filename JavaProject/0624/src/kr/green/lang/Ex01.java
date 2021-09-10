package kr.green.lang;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1. 입력");
		System.out.println("2. 계산");
		System.out.println("3. 조회");
		System.out.println("4. 인쇄");
		System.out.println("Q. 종료");
		String select = "";
		// 원하는 글자가 입력될 때까지 반복시키려고 한다. 어떻게 해야 할까요?
		do {
			System.out.print("원하시는 메뉴를 선택하세요.");
			select = sc.nextLine();
		}//while(!select.equals("1") && !select.equals("2") && !select.equals("3") && !select.equals("4") && !select.equalsIgnoreCase("Q"));
		while("1234q".contains(select));
		sc.close();
	}

}
