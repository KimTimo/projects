package kr.green.cal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LunarUtil {
	public static void main(String[] args) {
		System.out.println(readLunarDate(2021, 7));
	}

	public static List<DateVO> readLunarDate(int year, int month) {
		List<DateVO> list = new ArrayList<DateVO>();
		String address = "https://astro.kasi.re.kr/life/pageView/5";
		address += String.format("?search_year=%04d&search_month=%02d", year, month);

		Document doc = null;
		try {
			doc = Jsoup.connect(address).get();              // 연결
			Elements trs = doc.select("table tbody tr");     // 날짜가 있는 tr태그를 모두 읽는다.
			for (Element tr : trs) {                         // 날짜를 반복
				DateVO vo = new DateVO();
				vo.setSolar(tr.select("td").get(0).text());  // 첫번째 td는 양력
				vo.setLunar(tr.select("td").get(1).text());  // 두번째 td는 음력
				vo.setGangi(tr.select("td").get(2).text());  // 세번째 td는 간지
				
				list.add(vo);                                // 리스트에 추가!!
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return list;
	}

}
