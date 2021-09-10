package kr.green.maven0628.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ListSortEx {

	public static void main(String[] args) {
		Random rnd = new Random();
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < 100; i++)
			list.add(rnd.nextInt(101)); // 난수로 10개 넣기
		
		System.out.println("정렬전 : " + list);
		
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 내가 크면 양수, 같으면 0, 넘어온 놈이 크면 음수를 리턴
				return o1-o2; // 오름차순
			}
		});
		System.out.println("오름차순 정렬 후 : " + list);
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// 내가 크면 양수, 같으면 0, 넘어온 놈이 크면 음수를 리턴
				return o2-o1; // 내림차순
			}
		});
		System.out.println("내림차순 정렬 후 : " + list);
		System.out.println();

		// 또다른 정렬방법
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o2-o1; // 내림차순
			}
		});
	  
		
	}

}
