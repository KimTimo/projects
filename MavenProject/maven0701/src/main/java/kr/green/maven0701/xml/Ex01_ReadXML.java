package kr.green.maven0701.xml;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kr.green.maven0701.vo.Language;
import kr.green.maven0701.vo.ProgrammingLanguages;

public class Ex01_ReadXML {
	public static void main(String[] args) {
		try {
			// 1. create JAXB context : ProgrammingLanguages클래스를 이용하여 컨텍스트 객체 생성
			JAXBContext context = JAXBContext.newInstance(ProgrammingLanguages.class);
			
			// 2. 컨텍스트 객체를 이용하여 언마샬링 객체를 생성한다.
			Unmarshaller um = context.createUnmarshaller();
			
			// 3. 언마샬링(XML데이터를 자바 객체로 만든다.) 실행
			ProgrammingLanguages languages = (ProgrammingLanguages) um.unmarshal(new File("src/main/resources/sample.xml"));
			
			// 4. 읽은값 사용
			System.out.println(languages);
			for(Language l : languages.getLanguage()) {
				System.out.println(l.getName() + "(" + l.getCategory() + ")");
			}
			
		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
}
