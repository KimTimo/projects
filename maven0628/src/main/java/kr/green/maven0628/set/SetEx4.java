package kr.green.maven0628.set;

import java.util.Set;
import java.util.TreeSet;

// 사용자가 작성한 클래스도 Set에 저장이 가능할까?
public class SetEx4 {
	public static void main(String[] args) {
		// 중복을 허용하지 않고 정렬을 지원하는 Set은 TreeSet이다.
		Set<String> set = new TreeSet<>();
		set.add("한사람");
		set.add("두사람");
		set.add("세사람");
		set.add("네사람");
		System.out.println(set.size() + "명 : " + set);
		set.add("한사람");
		set.add("두사람");
		set.add("세사람");
		set.add("네사람");
		System.out.println(set.size() + "명 : " + set);
	}

}
