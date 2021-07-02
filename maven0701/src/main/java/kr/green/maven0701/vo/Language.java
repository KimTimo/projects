package kr.green.maven0701.vo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Language {
	private String name;
	private String category;
	private String developer;
}
