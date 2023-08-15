package kr.green.exam;
/*
1부터 20 사이의 어떤 수로도 나누어 떨어지는 가장 작은 수
1부터 10까지의 어떤 수로도 나누어 떨어지는 가장 작은 수는 2520입니다.
그렇다면 1부터 20까지의 어떤 수로도 나누어 떨어지는 가장 작은 수는 얼마입니까?

해결 : 1 ~ 20의 최소 공배수 구하는 것이다. 공식이 있기는 하다!!!! 귀찮다!!!! 
*/
public class Ex01 {
	public static void main(String[] args) {
		System.out.println(divider(10));
		System.out.println(divider(20));
	}
	// 1~n까지의 최소 공배수 구하는 메서드
	public static int divider(int n) {
		int i = n;
		boolean flag = true;
		while(true) {
			flag=true; // 일단은 모두 나누어 진다고 가정
			i += n; // n씩 증가
			for(int j=2;j<=n;j++) { // 2부터 n까지 반복
				if(i%j!=0) { // 나누어지지 않으면
					flag = false; // 거짓이라고 표시하고
					break; // 탈출
				}
			}
			if(flag) break; // flag가 참이라면 모두 나누어지는 수 이므로 탈출 아니면 반복
		}
		return i; // 리턴
	}
}
