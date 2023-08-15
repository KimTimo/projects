package kr.green.ex0611;

import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;

// 주민번호 자동 생성기를 만들자.(난수를 이용하자)

public class CreateJuminNo2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while(true){
			System.out.print("몇명분을 만들까요(0은 종료)\n");
			int count = scan.nextInt();
			if(count==0) break;
			for(int i=0;i<count;i++){
				String juminNo = createNo();
				System.out.println(juminNo + " : " + (checkNo(juminNo) ? "맞는번호" : "틀린번호"));
			}
		}
		scan.close();
	}

	private static boolean checkNo(String juminNo) {
		juminNo = juminNo.substring(0,6) + juminNo.substring(7); // 중간에 - 없애기
		int sum=0;
		// 1. 각각의 자리에 2 3 4 5 6 7 8 9 2 3 4 5를 곱한 합을 구한다.
		for(int i=0;i<juminNo.length()-1;i++){
			// char형을 숫자로 바꾸는 방법 : '1' - '0' = 1, '5'-'0' = 5
			// 숫자를 char형으로 바꾸는 방법 : 1 + '0' = '1' , 7 + '0' = '7'
			sum += (juminNo.charAt(i)-'0') * (i<8 ? i+2 : i-6); 
		}
		// 2. 합을 11로 나눈 나머지를 구한다.
		// 3. 11에서 나머지를 뺀다.
		// 4. 위의결과를 1으로 나눈 나머지를 구한다.
		sum = (11 - sum%11)%10;
		return juminNo.charAt(12)-'0' == sum;
	}

	private static String createNo() {
		String juminNo="";
		Random rnd = new Random();

		// 1. 년도를 만들자. 년도는 00~99까지를 가질 수 있다.
		int t = rnd.nextInt(100); // 0 ~ 99 사이의 난수
		juminNo += (t<10) ? "0"+t : t;

		// 2. 월을 만들자. 01 ~ 12 사이를 가질 수 있다.
		t = rnd.nextInt(12) + 1; // 01 ~ 12 사이의 난수
		juminNo += (t<10) ? "0" + t : t;

		// 3. 일을 만들자. 01 ~ 마지막날짜(28,29,30,31)까지를 가질 수 있다.
		//    먼저 마지막 날짜를 구해야 한다. 그렇다면 연도가 필요하다.
		int yy = Integer.parseInt(juminNo)/100; // 이미 생성된 4자리중 앞 두자리만 숫자로 취한다.
										        // char를 숫자로 만들경우는 -'0'이지만 String을 숫자로 만들 경우는 
										        // Integer.parseInt(문자열) 이다.
		// 구해진 년도가 올해보다 적으면 2000년대이고 크면 1900년대이다.
		// System.out.println( t + " : " + Calendar.getInstance().get(Calendar.YEAR)%100 );
		int year = ( yy >= Calendar.getInstance().get(Calendar.YEAR)%100) ? yy + 1900 : yy + 2000;
		// 월을 구하자
		int month = Integer.parseInt(juminNo)%100;
		// 년도를 구했으니 마지막 날짜를 구하자.
		int lastday = 31;
		switch(month){
		case 2:
			lastday = (year%400==0||year%4==0&&year%100!=0) ? 29 : 28;
			break;
		case 4: case 6: case 9: case 11:
			lastday = 30;
		}
		// 일을 만들자.
		t = rnd.nextInt(lastday) + 1; // 1 ~ lastday까지 난수 발생
		juminNo += (t<10) ? "0" + t : t;

		// 4. 성별을 만들자.
		t = rnd.nextInt(2) + (year<=2000 ? 1 : 3); // 1900년대는 1,2이고 2000년대는 3,4이다.
		juminNo += "-" + t;

		// 5. 나머지 5자리는 그냥 넣자(0~9)
		for(int i=0;i<5;i++) juminNo += rnd.nextInt(10);

		// 6. 마지막 자리만 계산해서 넣는다.
		String tt = juminNo.substring(0,6) + juminNo.substring(7); // 중간에 - 없애기
		t=0; 
		for(int i=0;i<tt.length();i++) t += (tt.charAt(i)-'0') * (i<8 ? i+2 : i-6); 
		t = (11 - t%11)%10;
		juminNo += t;
		return juminNo;
	}
}
