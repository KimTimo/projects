package kr.green.mvc19.service;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Service;

import kr.green.mvc19.vo.BoxOfficeResult;
import kr.green.mvc19.vo.BoxOfficeResult2;


@Service
public class BoxOfficeService {
	// 일별 박스 오피스
	public static BoxOfficeResult readBoxOffice(String targetDt) {
		BoxOfficeResult boxOfficeResult = null;
		try {
			JAXBContext context = JAXBContext.newInstance(BoxOfficeResult.class);
			Unmarshaller um = context.createUnmarshaller();
			String key = "6b803ff71f1d520a64c87323bf16821a";
			String urlAddress = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.xml";
			urlAddress += "?key=" + key;
			urlAddress += "&targetDt=" + targetDt;
			URL url = new URL(urlAddress);
			InputStreamReader isr = new InputStreamReader(url.openStream(),"UTF-8");
			boxOfficeResult = (BoxOfficeResult) um.unmarshal(isr);
			System.out.println(boxOfficeResult);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return boxOfficeResult;
	}
	// 주간 박스 오피스 읽기
	public static BoxOfficeResult2 readBoxOffice2(String targetDt) {
		BoxOfficeResult2 boxOfficeResult2 = null;
		try {
			JAXBContext context = JAXBContext.newInstance(BoxOfficeResult2.class);
			Unmarshaller um = context.createUnmarshaller();
			String key = "6b803ff71f1d520a64c87323bf16821a";
			String urlAddress = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchWeeklyBoxOfficeList.xml";
			urlAddress += "?key=" + key;
			urlAddress += "&targetDt=" + targetDt;
			URL url = new URL(urlAddress);
			InputStreamReader isr = new InputStreamReader(url.openStream(),"UTF-8");
			boxOfficeResult2 = (BoxOfficeResult2) um.unmarshal(isr);
			System.out.println(boxOfficeResult2);
		} catch (JAXBException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return boxOfficeResult2;
	}
}
