package kr.green.exam;
/*
어느 숫자가 중간값을 가지는 숫자일까?
3개의 숫자를 입력으로 받고 3개의 숫자 중에 중간값을 가지는 숫자를 출력하세요. 
ex1) 2, 5, 3 => 3 
ex2) 4, 6, 4 => 4
*/
public class Ex02 {
	public static void main(String[] args) {
		System.out.println(middle(2, 5, 3));
		System.out.println(middle(4, 6, 4));
		System.out.println(middle(1, 2, 3));
		System.out.println(middle(3, 2, 1));
		System.out.println(middle(3, 1, 2));
	}
	public static int middle(int a, int b, int c) {
		if(a>b) { // 첫번째와 두번째를 비교하여 첫번째가 크면 교환 
			a = a ^ b;			b = a ^ b;			a = a ^ b;
		}
		if(b>c) {// 두번째와 세번째를 비교하여 두번째가 크면 교환 --- 여기까지하면 제일 큰수가 c에 담긴다.
			b = b ^ c;			c = b ^ c;			b = b ^ c;	
		}
		if(a>b) { // 첫번째와 두번째를 비교하여 첫번째가 크면 교환 --- 여기까지하면 a, b, c순서로 숫자가 정렬된다.
			a = a ^ b;			b = a ^ b;			a = a ^ b;
		}
		return b; // 가운데 수 b를 리턴
	}
}
