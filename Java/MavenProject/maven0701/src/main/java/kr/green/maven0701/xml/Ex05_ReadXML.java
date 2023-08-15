package kr.green.maven0701.xml;

import java.io.IOException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import kr.green.maven0701.vo.Rss;
import kr.green.maven0701.vo.Rss.Item;

public class Ex05_ReadXML {
	public static void main(String[] args) throws IOException {
		try {
			// 1. create JAXB context : Catalog클래스를 이용하여 컨텍스트 객체 생성
			JAXBContext context = JAXBContext.newInstance(Rss.class);
			// 2. 컨텍스트 객체를 이용하여 언마샬링 객체를 생성한다.
			Unmarshaller um = context.createUnmarshaller();
			// 3. 언마샬링(XML데이터를 자바 객체로 만든다.) 실행
			// URL url = new URL("https://rss.hankyung.com/feed/it.xml");
			URL url = new URL("https://rss.hankyung.com/feed/hei.xml");
			Rss rss = (Rss) um.unmarshal(url);
			// 4. 읽은값 사용
			// System.out.println(rss);
			System.out.println(rss.getChannel().getTitle());
			System.out.println(rss.getChannel().getLink());
			System.out.println(rss.getChannel().getCopyright());
			for(Item item : rss.getChannel().getItem()) {
				System.out.println(item.getTitle() + "(" + item.getAuthor() + ")");
			}
			
		} catch (JAXBException e) {

			e.printStackTrace();
		}
	}
}
