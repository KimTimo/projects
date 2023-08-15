package kr.green.mvc19.vo;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import lombok.Data;

@Data
@XmlRootElement
@XmlType(propOrder = {"rank","movieNm","openDt"})
public class DailyBoxOffice {
	private String rank;
	private String movieNm;
	private String openDt;
}
