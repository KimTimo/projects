package kr.green.maven0630.xml;

import java.io.File;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import kr.green.maven0630.vo.ClubVO;
import kr.green.maven0630.vo.Person;

public class Ex_xml03 {
	public static void main(String[] args) {
		try {
			// 1. create JAXB context : ClubVO클래스를 이용하여 컨텍스트 객체 생성
			JAXBContext context = JAXBContext.newInstance(ClubVO.class);
			
			// xml로 저장할 자바 객체를 생성
			ClubVO club = new ClubVO();
			club.setName("판자놀");
			club.setNickName("놀자판");
			club.setDate(new Date(2001, 7, 22));
			club.getLevel1().add(new Person(1, "한사람", 22, true));
			club.getLevel1().add(new Person(2, "두사람", 32, true));
			club.getLevel1().add(new Person(3, "세사람", 42, true));
			club.getLevel1().add(new Person(4, "네사람", 52, false));
			
			club.getLevel2().add(new Person(1, "한인간", 22, true));
			club.getLevel2().add(new Person(4, "네인간", 52, false));
			
			System.out.println(club);
			
			// 2. 컨텍스트 객체를 이용하여 마샬링 객체를 생성한다.
			Marshaller m = context.createMarshaller();
			// 마샬링할때 이쁘게 들여쓰기해서 만들어라라는 옵션지정
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			// 3. 마샬링 수행을 한다. 첫번째 인수는 마샬링할 객체, 두번째 인수가 방향(위치) 
			m.marshal(club, System.out); // 화면 출력
			m.marshal(club, new File("club.xml")); // 파일출력(저장)
			
		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
}
