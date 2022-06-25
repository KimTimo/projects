package kr.green.maven0701.exam;

import java.util.Random;

/*
업앤다운 UP&Down 숫자맞추기 게임
컴퓨터가 1~100 숫자(정수 범위) 중 하나를 랜덤으로 정합니다. (이를 알려주지 않습니다.)
사용자는 이 숫자를 맞추어야 합니다.
입력한 숫자보다 정답이 크면 → "UP" 출력,
입력한 숫자보다 정답이 작으면 → "DOWN" 출력.
정답을 맞추면 → "정답"을 출력하고, 지금까지 숫자를 입력한 횟수를 알려줍니다.
코딩 초보자라도 if 함수와 while함수, 랜덤 모듈 정도까지만 배워도 재미있게 풀 수 있는 문제입니다.

(예시)
컴퓨터가 1~100 중 랜덤 숫자 하나를 정합니다.
이 숫자를 맞춰주세요.
1~100 숫자 입력:50
DOWN
1~100 숫자 입력:25
UP
1~100 숫자 입력:38
DOWN
1~100 숫자 입력:32
UP
1~100 숫자 입력:35
UP
1~100 숫자 입력:37
DOWN
1~100 숫자 입력:36
정답입니다! 7회 만에 맞췄어요.
 */
public class Ex05 {
	public static void main(String[] args) throws InterruptedException {
		int num = new Random().nextInt(100)+1; // 컴퓨터가 1~100 중 랜덤 숫자 하나를 정합니다.
		int count = 0, start=1, end=100;
		int n = (end+start)/2 ;
		while(n!=num) {
			System.out.println(num + " : " + n + ", " + start + ", " + end);
			count++;
			if(n==num) 
				continue;
			else if(num<n)
				end = n-1; 
			else
				start = n+1;
			n = (end+start)/2;
		}
		System.out.println(num + " : " + n);
		System.out.println("정답입니다. " + count + "회 만에 맞췄어요.");
	}
}
