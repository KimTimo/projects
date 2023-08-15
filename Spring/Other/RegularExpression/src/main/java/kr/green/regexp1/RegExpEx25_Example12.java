package kr.green.regexp1;

import java.util.Scanner;
import java.util.regex.Pattern;

public class RegExpEx25_Example12 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String menu = "";
		while(true) {
			System.out.print("뭐 먹을래(부타동,에비동,규동,.은 종료)  1개 주문해야 함.");
			menu = sc.nextLine();
			if(Pattern.matches("\\.", menu)) break;
			if(Pattern.matches("부타동|에비동|규동", menu)) {
				System.out.println(menu + "!! 주문입니다.");
			}else {
				System.out.println("없는 메뉴 입니다.");
			}
		}
		System.out.println("----------------------------------");
		while(true) {
			System.out.print("뭐 먹을래(부타동,에비동,규동,.은 종료) 1개 주문해야 함.");
			menu = sc.nextLine();
			if(Pattern.matches("\\.", menu)) break;
			if(Pattern.matches("(부타|에비|규)동", menu)) {
				System.out.println(menu + "!! 주문입니다.");
			}else {
				System.out.println("없는 메뉴 입니다.");
			}
		}
		System.out.println("----------------------------------");
		while(true) {
			System.out.print("뭐 먹을래(부타동,에비동,규동,.은 종료) 2개 이상 주문해야 함.");
			menu = sc.nextLine();
			if(Pattern.matches("\\.", menu)) break;
			if(Pattern.matches("(부타|에비|규)(동)([, ]*(부타|에비|규)(동))+", menu)) {
				System.out.println(menu + "!! 주문입니다.");
			}else {
				System.out.println("없는 메뉴 입니다.");
			}
		}
		System.out.println("----------------------------------");
		while(true) {
			System.out.print("뭐 먹을래(부타동,에비동,규동,.은 종료) 1개 이상 주문해야 함.");
			menu = sc.nextLine();
			if(Pattern.matches("\\.", menu)) break;
			if(Pattern.matches("(부타|에비|규)(동)([, ]*(부타|에비|규)(동))*", menu)) {
				System.out.println(menu + "!! 주문입니다.");
			}else {
				System.out.println("없는 메뉴 입니다.");
			}
		}
		System.out.println("----------------------------------");
		/*
		이 정규 표현식의 두 번째 그룹이 ‘(동)’이고, 그 이후에 ‘동’이 반복하여 나올 것이므로, 
		백슬래쉬와 몇 번째 그룹인지를 사용하면 그룹의 문자열을 역참조하여 해당 정규 표현식에서 사용할 수 있다. 
		여기서 주의해야 할 점은, 입력된 문장에서, 앞의 ‘(부타|에비|규)’에 해당하는 첫 번째 그룹에서 가츠가 
		나왔다면, 첫 번째 그룹은 ‘(부타|에비|규)’의 표현과 일치하는 것이 아니고 ‘가츠’로 정해진다.
		만약 여기서 ‘(부타|에비|규)’ 그룹을 순서에 포함시키고 싶지 않다면, 즉 캡쳐하고 싶지 않다면, 
		다음과 같이 정규표현식을 작성하면 된다. (?:regex)와 같은 그룹을 non-capturing group 이라고 한다.
			
		"(?:부타|에비|규)(동)([, ]*(부타|에비|규)(\\1))*"	
		
		*/
		while(true) {
			System.out.print("뭐 먹을래(부타동,에비동,규동,.은 종료) 1개 이상 주문해야 함.");
			menu = sc.nextLine();
			if(Pattern.matches("\\.", menu)) break;
			if(Pattern.matches("(부타|에비|규)(동)([, ]*(부타|에비|규)(\\2))*", menu)) {
				System.out.println(menu + "!! 주문입니다.");
			}else {
				System.out.println("없는 메뉴 입니다.");
			}
		}
		sc.close();
	}
}
