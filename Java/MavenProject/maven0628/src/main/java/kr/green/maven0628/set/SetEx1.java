package kr.green.maven0628.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

// Set : 입력된 순서는 중요하지 않고 중복을 허용하지 않는 컬렉션
//       구현 클래스로는 HashSet, TreeSet 등이 있다. Generic으로 만들어져 있다.

public class SetEx1 {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		// 추가
		set.add(1);
		set.add(2);
		set.add(3);
		// 사이즈 확인
		System.out.println(set.size() + "개 : " + set);
		// 추가
		set.add(77);
		set.add(88);
		set.add(66);
		// 사이즈 확인
		System.out.println(set.size() + "개 : " + set);
		// 추가
		set.add(77);
		set.add(88);
		set.add(66);
		// 사이즈 확인
		System.out.println(set.size() + "개 : " + set);
		// 삭제
		set.remove(77);
		System.out.println(set.size() + "개 : " + set);
		// 반복
		for(int i : set) {
			System.out.println(i);
		}
		System.out.println();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
