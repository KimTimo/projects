package kr.green.mvc19.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name="boxOfficeResult")
@XmlAccessorType(XmlAccessType.FIELD) // 속성을 필드에 지정
public class BoxOfficeResult2 {
	@XmlElement
	private String boxofficeType;
	@XmlElement
	private String showRange;
	@XmlElementWrapper(name="weeklyBoxOfficeList")
	@XmlElement(name="weeklyBoxOffice")
	List<WeeklyBoxOffice> weeklyBoxOffice;
}
