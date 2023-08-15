package kr.green.batch.vo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Data
public class HanjaVO {
	private int    idx;
	private String d;
	private String s;
	private String n;
	private String q;
	private String e1;
	private String e2;
	private String e3;
	private String e4;
	private String a;
	
}
