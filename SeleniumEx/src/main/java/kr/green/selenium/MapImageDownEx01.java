package kr.green.selenium;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MapImageDownEx01 {

	public static void main(String[] args) {
		// 현재 package의 workspace 경로, Windows는 [ chromedriver.exe ]
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe"); // 현재 package의
		log.debug(path.toString());
		// WebDriver 경로 설정
		System.setProperty("webdriver.chrome.driver", path.toString());
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
				//System.out.println(e.attr("shape"));
				//System.out.println(e.attr("coords"));
				//System.out.println(e.attr("area"));
				//System.out.println(e.attr("key"));
				System.out.println(e.attr("img"));
				System.out.println("----------------------------------------");
			}
		}

		// ------------------------------------------------------------------------------------------------------
		// 종료
		driver.close();
		// 5초 후에 WebDriver 종료
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// WebDriver 종료
			driver.quit();
		}
	}
}
