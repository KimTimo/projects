package kr.green.maven0707.network;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex05_HTMLParser {
	public static void main(String[] args) {
		Document doc;
		try {
			doc = Jsoup.connect("https://www.naver.com").get();
			System.out.println(doc.title()); // 제목 읽기
			
			Elements elements = doc.select("#gnb div");
			System.out.println(elements.size() + "개");
			
			for(Element e : elements) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println(e.text());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
