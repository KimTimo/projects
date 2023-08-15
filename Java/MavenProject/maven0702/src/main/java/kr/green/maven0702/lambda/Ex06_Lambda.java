package kr.green.maven0702.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex06_Lambda {
	public static void main(String[] args) {
		Integer[] ar = {3,2,6,8,9,4,1,5};
		List<Integer> list = Arrays.asList(ar);
		System.out.println(list);
		
		// 정렬
		Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		System.out.println("오름차순 : " + list);
		
		Collections.sort(list, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		});
		System.out.println("내림차순 : " + list);
		System.out.println("------------------------------------------------------------");
		
		// 위의 식을 람다로 표현이 가능하다.
		Comparator<Integer> asc = (x,y)->x-y;
		Comparator<Integer> desc = (x,y)->y-x;
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
