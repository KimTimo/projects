package kr.green.maven0628.set;

import java.util.HashSet;
import java.util.Set;

import kr.green.maven0628.set.PersonVO.Gender;

// 사용자가 작성한 클래스도 Set에 저장이 가능할까?
public class SetEx3 {
	public static void main(String[] args) {
		PersonVO vo1 = new PersonVO("한사람", 26, Gender.MALE);
		PersonVO vo2 = new PersonVO("두사람", 24, Gender.FEMALE);
		PersonVO vo3 = new PersonVO("안자몽", 6, Gender.FEMALE);
		Set<PersonVO> set = new HashSet<>();
		set.add(vo1);
		set.add(vo2);
		set.add(vo3);
		set.add(new PersonVO("안자몽" , 6, Gender.FEMALE));
		System.out.println(set.size() + "명 : " + set); // 중복됨
		// 내가 만든 클래스도 중복을 허용하지 않게하려면 반드시 equals 메소드를 오버라이딩 해야한다.
	}

}
