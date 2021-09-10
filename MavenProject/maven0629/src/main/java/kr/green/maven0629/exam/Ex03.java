package kr.green.maven0629.exam;
/*
n의 배수 판정법
어떤 수 x와 n이 주어졌을때 조건에 따라 x가 n의 배수인지 판별하는 코드를 작성하라.
x는 0 이상의 정수이며 조건에 맞지 않는 입력은 주어지지 않는다.
여기서 하나의 함수인지 여러 함수인지는 본인이 선택하면 된다.
단 절대 산술연산자 중 %와 /는 코드에 없도록 한다.
그리고 divmod() 함수를 쓰는것도 금지한다
코드는 창의적으로 하는 것을 목적으로 한다. 속도는 크게 중점을 두지 않는다.
n의 종류는 2,3,5,7,11,13이다.
원하는 n만 선택해서 풀 수도 있다.

입력
432 	2
4 		3
635 	5
421 	7
122 	11
143 	13

출력
1
0
1
0
0
1
*/
public class Ex03 {
	public static void main(String[] args) {
		System.out.println(multiple(432, 2));
		System.out.println(multiple(4, 3));
		System.out.println(multiple(635, 5));
		System.out.println(multiple(421, 7));
		System.out.println(multiple(122, 11));
		System.out.println(multiple(143, 13));
	}
	// x에서 n을 계속 빼다보면 0이나오면 배수이고 음수나오면 배수가 아니다.
	public static int multiple(int x, int n) {
		// 빼기를 0 이하의 숫자가 나올때까지 반복한다.
		while(x>0) {
			x -= n;
		}
		return x==0 ? 1 : 0;
	}
}






