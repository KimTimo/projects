package kr.green.maven0701.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;


@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalog {
	@XmlElement(name="CD")
	List<CD> list = new ArrayList<>();
	
	public static class CD{
		@XmlElement(name="TITLE")
		private String title;
		@XmlElement(name="ARTIST")
		private String artist;
		@XmlElement(name="COUNTRY")
		private String country;
		@XmlElement(name="COMPANY")
		private String company;
		@XmlElement(name="PRICE")
		private double price;
		@XmlElement(name="YEAR")
		private int year;
		
	}

}
