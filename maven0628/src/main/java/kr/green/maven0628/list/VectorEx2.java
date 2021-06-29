package kr.green.maven0628.list;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

/*
 * List : 입력된 순서가 중요할때 사용
 *        Generic으로 만들어져 있다.
 *        Vector, ArrayList, LinkedList, Stack .........
 *        Vector와 ArrayList는 같다. 멀티스레드 지원여부에 따라 사용
 */
public class VectorEx2 {
	public static void main(String[] args) {
		List<Integer> v1 = new ArrayList<>();      // 기본 10개의 용량
		info(v1);
		Vector<Integer> v2 = new Vector<>(30);    // 숫자 1개를 넘기면 최초 용량이 된다.
		info(v2);
		
		for(int i = 0; i < 5; i++) v1.add(i); // 5개 추가
		info(v1);
		for(int i = 0; i < 10; i++) v1.add(i); // 10개 추가
		info(v1);
		
		// 삽입 : 몇번째에 삽입해라
		v1.add(0,99);      // 0번째에 99를 집어넣어라
		v1.add(0,88);      // 마찬가지로 0번째에 88을 집어 넣어라.
		info(v1);
		
		// 수정 : 몇번째 값을 고쳐라
		v1.set(0, 77);    // 0번째에 있는 놈을 77로 바꿔라
		v1.set(5, 66);    // 5번째에 ......
		info(v1);
		
		// 삭제
		v1.remove(4);     // 몇번째 것 지워라 
		//v1.remove(88);
		info(v1);
		
		// 순회
		for(int i : v1) {
			System.out.print(i + " ");
		}
		System.out.println();
		// element가 붙은 메소드들은 틀딱이다
//		Enumeration<Integer> em = v1.elements();
//		while(em.hasMoreElements()) {
//			System.out.print(em.nextElement() + " ");
//		}
//		System.out.println();
		// Enumeration 이후 속도를 향상 시킨것이 Iterater이다.
		Iterator<Integer> it = v1.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();
		// Iterator는 단방향, ListIterator는 양방향 검색이 가능.
		ListIterator<Integer> lit = v1.listIterator(0);
		while(lit.hasNext()) {
			System.out.print(lit.next() + " ");
		}
		System.out.println();
		System.out.println(lit.previous());
		System.out.println(lit.previous());
		System.out.println(lit.previous());
		System.out.println();
		System.out.println(v1.get(10));
		System.out.println(v1.get(1));
		
	}

	private static void info(List<Integer> v1) {
		//System.out.println("용량 : " + v1.capacity());
		System.out.println("크기 : " + v1.size());
		System.out.println("내용 : " + v1);
		System.out.println("-----------------------------");
	}

}
