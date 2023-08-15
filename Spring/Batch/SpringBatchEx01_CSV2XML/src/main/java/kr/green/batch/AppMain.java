package kr.green.batch;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import kr.green.batch.vo.ExamResult;

public class AppMain {
	public static void main(String[] args) {
		// System.out.println("Hello World!!!!");
		// Marshalling : 자바 객체를 XML로 만드는것
		try {
			JAXBContext context = JAXBContext.newInstance(ExamResult.class);
			ExamResult examResult = new ExamResult("한사람", new Date(220, 9, 24), 45);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 들여쓰기 해서 표시해라
			marshaller.marshal(examResult, System.out); // 화면에 출력
			marshaller.marshal(examResult, new File("xml/examResult.xml")); // 파일로 저장
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		// UnMarshalling : XML을 자바 객체로 만드는것
		try {
			JAXBContext context = JAXBContext.newInstance(ExamResult.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ExamResult examResult =  (ExamResult) unmarshaller.unmarshal( new File("xml/examResult.xml"));
			System.out.println(examResult);
		} catch (JAXBException e) {
			e.printStackTrace();
		}		
	}
}
