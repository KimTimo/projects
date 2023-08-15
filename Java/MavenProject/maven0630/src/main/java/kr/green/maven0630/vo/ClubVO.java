package kr.green.maven0630.vo;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlList;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;



@Data
@XmlRootElement
@XmlType(propOrder = { "name", "level1", "level2"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ClubVO {
	@XmlElement
	private String name; // 클럽이름
	@XmlTransient // 마샬/언마샬 에서 제외하겠다.
	private String nickName; // 별명
	@XmlElement
	private Date date;
	@XmlElementWrapper(name="members")
	@XmlElement
	private List<Person> level1; // 정회원
	@XmlList
	@XmlElement
	private List<Person> level2; // 준회원
	

}
