package kr.green.maven0629.map;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
/*
 * Map : (키, 값) 형태로 저장하는 자료구조
 *       HashTabel, HashMap, TreeMap 등 구현 클래스를 사용한다.
 */
import java.util.TreeMap;

public class MapEx3 {

	public static void main(String[] args) {
		Map<Integer, String> map1 = new TreeMap<>(); // 정렬이 지원되는 맵
		// 넣기
		map1.put(1, "한사람");
		map1.put(2, "두사람");
		map1.put(3, "세사람");
		map1.put(4, "세사람");
		// 수정
		map1.put(1, "네사람");
		// 순서는 상관없다. 키는 Set 형식이다. (중복을 허용하지 않음)
		System.out.println(map1.size() + "개 : " + map1);
		// 꺼내기
		System.out.println(map1.get(4));
		System.out.println(map1.get(1));
		// 지우기
		map1.remove(3);
		System.out.println(map1.size() + "개 : " + map1);

		// 반복
		for (Integer key : map1.keySet()) {
			System.out.println(key + " : " + map1.get(key));
		}
		// 값만
		for (String value : map1.values())
			System.out.println(value);
		System.out.println();

		Set<Entry<Integer, String>> entrys = map1.entrySet();
		for (Entry<Integer, String> e : entrys)
			System.out.println(e + " : " + e.getKey() + "==>" + e.getValue());
		System.out.println();
		
		// 검색
		System.out.println(map1.containsKey(1) ? "1번 : " + map1.get(1) : "1번 없다");
		System.out.println(map1.containsKey(7) ? "7번 : " + map1.get(1) : "7번 없다");
		
		System.out.println(map1.containsValue("두사람") ? "있어요~" : "없다고~");
		System.out.println(map1.containsValue("낑사람") ? "있어요~" : "없다고~");
	}

}
