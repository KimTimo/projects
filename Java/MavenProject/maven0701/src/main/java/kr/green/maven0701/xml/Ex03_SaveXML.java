package kr.green.maven0701.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import kr.green.maven0701.vo.Language;
import kr.green.maven0701.vo.ProgrammingLanguages;


public class Ex03_SaveXML {
	public static void main(String[] args) {
		try {
			// 1. create JAXB context : Person클래스를 이용하여 컨텍스트 객체 생성
			JAXBContext context = JAXBContext.newInstance(ProgrammingLanguages.class);
			
			// xml로 저장할 자바 객체를 생성
			Language language = new Language();
			language.setName("Java");
			language.setCategory("응용프로래밍");
			language.setDeveloper("오라클");
			
			Language language1 = new Language();
			language1.setName("C++");
			language1.setCategory("응용프로래밍");
			language1.setDeveloper("오라클");
			
			ProgrammingLanguages programmingLanguages = new ProgrammingLanguages();
			programmingLanguages.getLanguage().add(language);
			programmingLanguages.getLanguage().add(language1);
			
			// 2. 컨텍스트 객체를 이용하여 마샬링 객체를 생성한다.
			Marshaller m = context.createMarshaller();
			// 마샬링할때 이쁘게 들여쓰기해서 만들어라라는 옵션지정
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 3. 마샬링 수행을 한다. 첫번째 인수는 마샬링할 객체, 두번째 인수가 방향(위치) 
			m.marshal(programmingLanguages, System.out); // 화면 출력
			m.marshal(programmingLanguages, new File("src/main/resources/programmingLanguages.xml")); // 파일출력(저장)
			
		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
}
