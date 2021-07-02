package kr.green.maven0701.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


import lombok.Data;

@XmlRootElement(name="rss")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Rss {

	@XmlAttribute
	private double version;
	@XmlElement
	private Channel channel;
	
	
	@XmlRootElement(name="channel")
	@Data
	public static class Channel{
		private String title;
		private String link;
		private String copyright;
		private List<Item> item;
	}
	@XmlRootElement
	@Data
	public static class Item{
		private String title;
		private String link;
		private String image;
		private String author;
		private String pubDate;
	}
}
