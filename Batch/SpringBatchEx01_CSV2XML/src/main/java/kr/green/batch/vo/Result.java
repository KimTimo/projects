package kr.green.batch.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
@XmlRootElement // 클래스 이름을 루트 태그로 쓰겠다
@XmlType(propOrder = {"name","dob","percentage"}) // XL에 저장되는 태그 순서 지정 
@XmlAccessorType(XmlAccessType.FIELD) // 설정 사항을 필드에 직접 쓰겠다
public class Result {
	@XmlElement // 태그로 쓰겠다
	private String name;
	@XmlElement // 태그로 쓰겠다
	@XmlJavaTypeAdapter(DateAdapter2.class) // 일기/쓰기시 DateAdapter 클래스를 이용하여 변환 하겠다.
	private Date   dob;
	@XmlElement // 태그로 쓰겠다
	private double percentage;
}
