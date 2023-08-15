package kr.green.selenium;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ex06 {
	
	public static void main(String[] args) {
		// 현재 프로젝트의 절대 경로를 알아낸다.
		Path path = Paths.get(System.getProperty("user.dir"), "src/main/resources/chromedriver.exe");
		log.debug(System.getProperty("user.dir")); // 현재 사용자의 위치를 알아낸다. 
		log.debug(path.toString()); // 크롬드라이버의 위치를 알아낸다.
		
		// 1. 웹드라이버의 경로를 지정해 주어야 한다.
		System.setProperty("webdriver.chrome.driver", path.toString());
		
		// 2. 웹드라이버의 옵션을 설정
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");			// 전체화면으로 실행
		options.addArguments("--disable-popup-blocking");	// 팝업창 무시
		options.addArguments("--disable-default-apps");		// 기본앱 사용하지 않겠다.
		/*
        options.addArguments("--headless");                 // Browser를 띄우지 않음
        options.addArguments("--disable-gpu");              // GPU를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
        options.addArguments("--no-sandbox");               // Sandbox 프로세스를 사용하지 않음, Linux에서 headless를 사용하는 경우 필요함.
		*/
		
		// 3. 크롭 웹드라이버 생성
		ChromeDriver driver = new ChromeDriver(options);
		
		//========================================================================================================
		// 4. 웹드라이버 사용
		String urlAddress = "https://www.naver.com";
		// 웹페이지 연결
		driver.get(urlAddress);
		
		// 요소 찾기 : 로그인 버튼 찾기
		// WebElement loginBtn = driver.findElement(By.className("link_login"));
		WebElement loginBtn = driver.findElementByClassName("link_login");
		loginBtn.click();
				
		/*
		// 자바스크립트를 실행한다.
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("document.getElementById('id').value='사용자 아이디';");
		js.executeScript("document.getElementById('pw').value='사용자 비번';");
		*/

		// 크롬 드라이버로 변경하고 나면 다음과 같이 사용 가능하다.
		driver.executeScript("document.getElementById('id').value='사용자 아이디';");
		driver.executeScript("document.getElementById('pw').value='사용자 비번';");
		
		WebElement submitBtn = driver.findElement(By.id("log.login"));
		submitBtn.submit();		
		//========================================================================================================
		/*
		// 5. 웹드라이버 닫기
		driver.close();
		
		// 6. 5초 후 웹드라이버 종료
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			// 웹드라이버 종료
			driver.quit();
		}
		*/
	}
}
