package kr.green.maven0630.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name = "Persons") // JAXB 에서 마샬/언마샬 할 수 있는 객체다 라고 표시(name속성은 루트 태그명이다. 생략시 클래스명이 된다.)
@XmlType(propOrder = { "name", "age", "gender" }) // 태그 순서를 지정한다.
@XmlAccessorType(XmlAccessType.FIELD) // 필드에 속성을 더한다.
public class Person {
	@XmlAttribute
	private int id;
	@XmlElement
	private String name;
	@XmlElement
	private int age;
	@XmlElement
	@XmlJavaTypeAdapter(GenderAdapter.class)
	private Boolean gender;

	// 데이터 타입을 변경하여 저장하고/읽기를 하려면 어뎁터 클래스를 만들어 주면 된다.
	public static class GenderAdapter extends XmlAdapter<String, Boolean> {

		@Override
		public Boolean unmarshal(String v) throws Exception {
			return v.equals("남자") ? true : false;
		}

		@Override
		public String marshal(Boolean v) throws Exception {
			return v ? "남자" : "여자";
		}

	}

}
