package kr.green.maven0701.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kr.green.maven0701.vo.Catalog;
import kr.green.maven0701.vo.Catalog.CD;

public class Ex04_ReadXML {
	public static void main(String[] args) {
		try {
			// 1. create JAXB context : Catalog클래스를 이용하여 컨텍스트 객체 생성
			JAXBContext context = JAXBContext.newInstance(Catalog.class);
			// 2. 컨텍스트 객체를 이용하여 언마샬링 객체를 생성한다.
			Unmarshaller um = context.createUnmarshaller();
			// 3. 언마샬링(XML데이터를 자바 객체로 만든다.) 실행
			Catalog catalog = (Catalog) um.unmarshal(new File("src/main/resources/sample2.xml"));
			// 4. 읽은값 사용
			System.out.println(catalog);
			for(CD c : catalog.getList()) {
				System.out.println(c.getTitle() + "(" + c.getPrice() + "원)");
			}
			
		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
}
