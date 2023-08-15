package kr.green.mvc19.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "Person") // 루트 태그 지정
@XmlType(propOrder = {"name","age","gender","birth"}) // 태그 순서
@XmlAccessorType(XmlAccessType.FIELD) // 요소를 필드에 적겠다.
public class PersonVO {
	@XmlElement // 태그로 하겠다
	private String 	name;
	// @XmlAttribute // 속성으로 하겠다.
	@XmlElement
	private int	 	age;
	@XmlJavaTypeAdapter(GenderAdapter.class) // 저장 읽기시 변경해주는 어뎁터 지정
	private Boolean gender;
	@XmlJavaTypeAdapter(BirthAdapter.class) // 저장 읽기시 변경해주는 어뎁터 지정
	private Date    birth;
}
