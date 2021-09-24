package kr.green.batch;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import kr.green.batch.vo.ExamResult;
import kr.green.batch.vo.ExamResults;

public class AppMain2 {
	public static void main(String[] args) {
		// System.out.println("Hello World!!!!");
		// Marshalling : 자바 객체를 XML로 만드는것
		try {
			JAXBContext context = JAXBContext.newInstance(ExamResults.class);
			ExamResult examResult1 = new ExamResult("한사람", new Date(220, 9, 24), 45);
			ExamResult examResult2 = new ExamResult("두사람", new Date(220, 9, 24), 45);
			ExamResult examResult3 = new ExamResult("세사람", new Date(220, 9, 24), 45);
			ExamResult examResult4 = new ExamResult("네사람", new Date(220, 9, 24), 45);
			List<ExamResult> list = new ArrayList<>();
			list.add(examResult1);
			list.add(examResult2);
			list.add(examResult3);
			list.add(examResult4);
			ExamResults results = new ExamResults(list);

			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 들여쓰기 해서 표시해라
			marshaller.marshal(results, System.out); // 화면에 출력
			marshaller.marshal(results, new File("xml/examResults.xml")); // 파일로 저장
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		// UnMarshalling : XML을 자바 객체로 만드는것
		try {
			JAXBContext context = JAXBContext.newInstance(ExamResults.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			ExamResults examResults =  (ExamResults) unmarshaller.unmarshal( new File("xml/examResults.xml"));
			System.out.println(examResults);
		} catch (JAXBException e) {
			e.printStackTrace();
		}		
	}
}
