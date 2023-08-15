package kr.green.maven0628.set;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
/*
 * 사용자가 작성한 클래스는 Set Collection 에서 사용하려면
 * 1. Equals And HashCode를 오버라이딩한다.
 * 2. Comparable 인터페이스를 구현한다.
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PersonVO implements Comparable<PersonVO>{
	enum Gender{
		MALE("남자"),
		FEMALE("여자");
		final String value;
		private Gender(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}
	private String name;
	private int age;
	private Gender gender;
	
	@Override
	public String toString() {
		return name + "(" + age + "세, " + gender.getValue() + ")";
	}

	@Override
	public int compareTo(PersonVO o) {
		// 내가 크면 양수, 같으면 0, 넘어온 놈이 크면 음수를 리턴하게 만든다.
		//return name.compareTo(o.name); // 이름 오름차순
		//return o.name.compareTo(name); // 이름 오름차순
		//return age - o.age; // 나이 오름차순
		//return o.age-age; // 나이 내림차순
		
		// 이름 내림차순에 나이 오름차순
		if(o.name.compareTo(name)==0) {
			return age-o.age;
		}else {
			return o.name.compareTo(name);
		}
		
	}

}
