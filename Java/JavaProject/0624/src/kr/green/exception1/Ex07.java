package kr.green.exception1;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Ex07 {
	public static void main(String[] args) {
		// 외부 자원을 사용할 경우에는 대부분 try~catch를 반드시 써줘야 한다.
		// 지정 웹페이지의 소스를 읽어서 화면에 출력해보자
		String urlAddress = "https://www.naver.com";
		try {
			URL url = new URL(urlAddress);
			Scanner sc = new Scanner(url.openStream(),"UTF-8");
			while(sc.hasNextLine())
				System.out.println(sc.nextLine());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
