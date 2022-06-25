package kr.green.maven0628.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Set : 입력된 순서는 중요하지 않고 중복을 허용하지 않는 컬렉션
//       구현 클래스로는 HashSet, TreeSet 등이 있다. Generic으로 만들어져 있다.

public class SetEx2 {
	public static void main(String[] args) {
		String[] names = "김머현, 안공주, 김상어, 안자몽, 안몽쉘, 김방어, 완짜모이, 짜크모이, 머찌찌, 김방어, 안빵댕, 안자몽, 안공주, 안짜몽, 완몽쉘".split(",");
		List<String> list = Arrays.asList(names); // 배열을 리스트로 만들기
		System.out.println(list.size() + "개 : " + list);

		// 중복을 제거한 이름을 출력하세요.
		Set<String> set = new HashSet<>(list); // 리스트를 Set으로 만들기 : 중복 제거
		System.out.println(list.size() + "개 : " + set);

		// 중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.
		List<String> list2 = new ArrayList<>(set);
		list2.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2); // 오름차순
			}

		});
		System.out.println(list2.size() + "개 : " + list2);
		list2.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1); // 내림차순
			}

		});
		System.out.println(list2.size() + "개 : " + list2);
	}

}
