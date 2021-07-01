package kr.green.maven0630.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import kr.green.maven0630.vo.Person;

public class Ex_xml01 {
	public static void main(String[] args) {
		try {
			// 1. create JAXB context : Person클래스를 이용하여 컨텍스트 객체 생성
			JAXBContext context = JAXBContext.newInstance(Person.class);
			
			// xml로 저장할 자바 객체를 생성
			Person kimc = new Person(123, "김종서", 33, true);
			
			// 2. 컨텍스트 객체를 이용하여 마샬링 객체를 생성한다.
			Marshaller m = context.createMarshaller();
			// 마샬링할때 이쁘게 들여쓰기해서 만들어라라는 옵션지정
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 3. 마샬링 수행을 한다. 첫번째 인수는 마샬링할 객체, 두번째 인수가 방향(위치) 
			m.marshal(kimc, System.out); // 화면 출력
			m.marshal(kimc, new File("kimc.xml")); // 파일출력(저장)
			
		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
}
