package kr.green.maven0707.network;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Ex06_HTMLParser {

	public static void main(String[] args) {
		Document doc;
		try {
			doc = Jsoup.connect("https://astro.kasi.re.kr/life/pageView/5").get();
			System.out.println(doc.title());
			
			Elements elements = doc.select("table tbody tr");
			System.out.println(elements.size() + "개");
			
			for(Element e :elements) {
				System.out.println("------------------------------------------");
				Elements e2 = e.select("td");
				System.out.println(e2.get(0).text());
				System.out.println(e2.get(1).text());
				System.out.println(e2.get(2).text());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
