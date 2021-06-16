import java.util.Scanner;

/*
 * JDK 1.5에 추가된 향상된 for 반복문
 * ----------------------------------
 * for(변수 : 컬렉션){
 *     컬렉션의 내용이 1개씩 변수로 복사되어 끝날때까지 반복
 *     }
 * Collection : 자료들의 집합
 */

 

public class Ex20_for {
	public static void main(String[] args) {
		for(int i : new int[] {1,2,3,4,5,6,7,8,9}) {
			System.out.println(i);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		for(char c : "재미없는 자바".toCharArray()) {
			System.out.println(c);
		}
		System.out.println("~~~~~~~~~~~~~~~~~~~");
		for(char c : "342567".toCharArray()) {
			System.out.println(c);
		}
		
		
		
		
		
		
		
		
	} // close main
} // close class