package kr.green.ex0611;

public class Ex07 {

	public static void main(String[] args) {

		int i = 10;
		System.out.println(i);
		
		i++;
		System.out.println(i);
		
		++i;
		System.out.println(i);
		
		i = i +1;
		System.out.println(i);
		
		i += 1;
		System.out.println(i);
		
		i = 10;
		i *= 3 + 7; // i = i * (3 + 7) 과 같음 *연산순서주의*
		System.out.println(i); // 100 ===> 우측의 식이 완료 후 복합대입 연산이 실행됨. 느림
		
		i += 4;
		System.out.println(i);
		
		
		
		
	}

}
