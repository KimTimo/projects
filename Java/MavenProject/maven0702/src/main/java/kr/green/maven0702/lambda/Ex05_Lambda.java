package kr.green.maven0702.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex05_Lambda {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("머현이", "곤듀", "상어", "자몽이", "몽쉘이");
		System.out.println(list);
		
		// 정렬
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("오름차순 : " + list);
		
		Collections.sort(list, new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println("내림차순 : " + list);
		System.out.println("------------------------------------------------------------");
		
		// 위의 식을 람다로 표현이 가능하다.
		Comparator<String> asc = (x,y)->x.compareTo(y);
		Comparator<String> desc = (x,y)->y.compareTo(x);
		Collections.sort(list, asc);
		System.out.println("오름차순 : " + list);
		Collections.sort(list, desc);
		System.out.println("내림차순 : " + list);
		System.out.println("------------------------------------------------------------");
		
		list.sort(asc);
		System.out.println("오름차순 : " + list);
		list.sort(desc);
		System.out.println("내림차순 : " + list);
	}
}
