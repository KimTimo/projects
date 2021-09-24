package kr.green.batch;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import kr.green.batch.vo.ExamResults;
import kr.green.batch.vo.Result;
import kr.green.batch.vo.Results;

public class AppMain3 {
	// csv파일을 읽어서 객체로 만들어 리스트에 넣고 XML로 변환해보자
	public static void main(String[] args) {
		Scanner sc  = null;
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		try {
			// CSV파일을 읽어 자바 객체로 변환
			sc = new Scanner(new File("src/main/resources/Result.csv"));
			List<Result> list = new ArrayList<>();
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				// System.out.println(line);
				String[] lines = line.split("\\|");
				//System.out.println(Arrays.toString(lines));
				Result result = new Result();
				result.setName(lines[0].trim());
				result.setDob(sdf.parse(lines[1].trim()));
				result.setPercentage(Double.parseDouble(lines[2].trim()));
				list.add(result);
			}
			// System.out.println(list);
			Results results = new Results(list);
			// System.out.println(results);
			//-----------------------------------------------------------------------
			// 자바 객체를 XML로 변환
			JAXBContext context = JAXBContext.newInstance(Results.class);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // 들여쓰기 해서 표시해라
			marshaller.marshal(results, System.out); // 화면에 출력
			marshaller.marshal(results, new File("xml/Results.xml")); // 파일로 저장
			// XML을 읽어 자바 객체로 변환
			Unmarshaller unmarshaller = context.createUnmarshaller();
			results =  (Results) unmarshaller.unmarshal( new File("xml/Results.xml"));
			System.out.println(results);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (JAXBException e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
		
	}
}
