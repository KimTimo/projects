package kr.green.mvc19.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement(name="persons")
@XmlType(propOrder = {"name","list"})
@XmlAccessorType(XmlAccessType.FIELD)
public class MemberList {
	@XmlElement
	private String name;
	@XmlElementWrapper(name="회원목록") // 리스트를 한번 더 태그로 감싸주겠다.
	@XmlElement(name="person")
	private List<PersonVO> list;
}
