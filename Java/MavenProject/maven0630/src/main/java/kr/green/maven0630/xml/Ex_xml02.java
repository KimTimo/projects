package kr.green.maven0630.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kr.green.maven0630.vo.Person;

public class Ex_xml02 {
	public static void main(String[] args) {
		try {
			// 1. create JAXB context : Person클래스를 이용하여 컨텍스트 객체 생성
			JAXBContext context = JAXBContext.newInstance(Person.class);
			
			// 2. 컨텍스트 객체를 이용하여 언마샬링 객체를 생성한다.
			Unmarshaller um = context.createUnmarshaller();
			
			// 3. 언마샬링(XML데이터를 바바 객체로 만든다.) 실행
			Person kimc = (Person) um.unmarshal(new File("kimc.xml"));
			
			// 4. 읽은값 사용
			System.out.println(kimc);
			
		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
}
