package kr.green.selenium;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapUtil {

	public static List<String> getImageList(String driverPath) {
		List<String> imageList = new ArrayList<>();
		log.debug(driverPath);
		// WebDriver 경로 설정
		System.setProperty("webdriver.chrome.driver", driverPath);
		// WebDriver 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // 전체화면으로 실행
		options.addArguments("--disable-popup-blocking"); // 팝업 무시
		options.addArguments("--disable-default-apps"); // 기본앱 사용안함
		options.addArguments("--headless"); // Browser를 띄우지 않음
		// WebDriver 객체 생성
		ChromeDriver driver = new ChromeDriver(options);
		// 웹페이지 요청
		driver.get("http://www.event-tv.co.kr/core/newsninfo/festivarbooklet");
		// 웹페이지 소스 출력
		String html = driver.getPageSource();
		// ------------------------------------------------------------------------------------------------------
		// HTML 파싱
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("map#Map area");
		System.out.println(elements.size() + "개!!!");
		System.out.println("----------------------------------------");
		for (Element e : elements) {
			if (!e.attr("coords").equals("undefined")) {
				imageList.add(e.attr("img"));
			}
		}
		// ------------------------------------------------------------------------------------------------------
		// 종료
		driver.close();
		// 1초 후에 WebDriver 종료
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// WebDriver 종료
			driver.quit();
		}

		return imageList;
	}
	
	public static List<MapVO> getMap(String driverPath) {
		List<MapVO> mapList = new ArrayList<>();
		log.debug(driverPath);
		// WebDriver 경로 설정
		System.setProperty("webdriver.chrome.driver", driverPath);
		// WebDriver 옵션 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // 전체화면으로 실행
		options.addArguments("--disable-popup-blocking"); // 팝업 무시
		options.addArguments("--disable-default-apps"); // 기본앱 사용안함
		options.addArguments("--headless"); // Browser를 띄우지 않음
		// WebDriver 객체 생성
		ChromeDriver driver = new ChromeDriver(options);
		// 웹페이지 요청
		driver.get("http://www.event-tv.co.kr/core/newsninfo/festivarbooklet");
		// 웹페이지 소스 출력
		String html = driver.getPageSource();
		// ------------------------------------------------------------------------------------------------------
		// HTML 파싱
		Document doc = Jsoup.parse(html);
		Elements elements = doc.select("map#Map area");
		System.out.println(elements.size() + "개!!!");
		System.out.println("----------------------------------------");
		mapList.add(new MapVO("", "", "전국지도", "map", "/img/sub/map.gif"));
		for (Element e : elements) {
			if (!e.attr("coords").equals("undefined")) {
				String shape = e.attr("shape");
				String coords = e.attr("coords");
				String area = e.attr("area");
				String key = e.attr("key");
				String img = e.attr("img");
				mapList.add(new MapVO(shape, coords, area, key, img));
			}
		}
		System.out.println(mapList); // 매번 읽기를 수행하지 않으려면 파일로 저장
		System.out.println("----------------------------------------");
		// ------------------------------------------------------------------------------------------------------
		// 종료
		driver.close();
		// 1초 후에 WebDriver 종료
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// WebDriver 종료
			driver.quit();
		}
		
		return mapList;
	}
}
