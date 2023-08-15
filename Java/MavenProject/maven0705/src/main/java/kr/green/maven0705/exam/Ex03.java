package kr.green.maven0705.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex03 {
	public static void main(String[] args) {
		// ArrayList의 합집합/차집합/교집합
		array1();
		array2();
		array3();
		array4();
	}

	private static void array1() {
		List<String> arrayList1 = new ArrayList<String>(Arrays.asList("C", "A", "B"));
		List<String> arrayList2 = new ArrayList<String>(Arrays.asList("E", "A", "B", "D", "E", "F"));
		System.out.println(arrayList1 + " : " + arrayList1.size());
		System.out.println(arrayList2 + " : " + arrayList2.size());
		// 합집합
		arrayList1.addAll(arrayList2);
		System.out.println("합집합 : " + arrayList1);
	}

	private static void array2() {
		List<String> arrayList1 = new ArrayList<String>(Arrays.asList("C", "A", "B"));
		List<String> arrayList2 = new ArrayList<String>(Arrays.asList("E", "A", "B", "D", "E", "F"));
		// 차집합
		arrayList1.removeAll(arrayList2);
		System.out.println("차집합 : " + arrayList1);
	}

	private static void array3() {
		List<String> arrayList1 = new ArrayList<String>(Arrays.asList("C", "A", "B"));
		List<String> arrayList2 = new ArrayList<String>(Arrays.asList("E", "A", "B", "D", "E", "F"));
		List<String> arrayList3 = new ArrayList<String>(Arrays.asList("B", "D", "F"));

		// 부분집합
		boolean isVal = arrayList1.containsAll(arrayList2);
		boolean isVal2 = arrayList2.containsAll(arrayList3);
		System.out.println("isVal: " + isVal);
		System.out.println("isVal2: " + isVal2);
	}

	private static void array4() {
		List<String> arrayList1 = new ArrayList<String>(Arrays.asList("C", "A", "B"));
		List<String> arrayList2 = new ArrayList<String>(Arrays.asList("E", "A", "B", "D", "E", "F"));

		// 교집합
		arrayList1.retainAll(arrayList2);
		System.out.println("교집합 : " + arrayList1);
	}

}
