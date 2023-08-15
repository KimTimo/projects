package kr.green.maven0701.exam;

import java.util.Arrays;

/*
배열에 최대값, 최소값 , 중간값을 출력해보기
숫자형 배열을 선언한후
for문과 if,else문만 사용해서 제일 큰값,제일 작은값, 중간값을 추출하기

예시) int [] array= {1,2,3,4,5}
■출력예시:
제일 큰 값은 5 입니다.
제일 작은 값은 1입니다.
중간값은 3입니다.
*/
public class Ex03 {
	public static void main(String[] args) {
		// int[] ar = new int[] {1,2,3,4,5};
		// int[] ar = new int[] {5,4,3,2,1};
		int[] ar = new int[] {5,1,3,4,2};
		// 정렬
		for(int i=0;i<ar.length-1;i++) {
			boolean flag = true;
			for(int j=0;j<ar.length-1-i;j++) {
				if(ar[j]>ar[j+1]) {
					ar[j] = ar[j] ^ ar[j+1];
					ar[j+1] = ar[j] ^ ar[j+1];
					ar[j] = ar[j] ^ ar[j+1];
					flag=false;
				}
			}
			if(flag) break;
		}
		System.out.println(Arrays.toString(ar));
		System.out.println("제일 큰 값은 " + ar[ar.length-1] + " 입니다.");
		System.out.println("제일 작은 값은 " + ar[0] + " 입니다.");
		System.out.println("중간값은 " + ar[ar.length/2] + " 입니다.");
	}
}
