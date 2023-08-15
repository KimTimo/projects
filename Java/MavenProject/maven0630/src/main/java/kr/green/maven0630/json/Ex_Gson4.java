package kr.green.maven0630.json;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.Gson;

import kr.green.maven0630.vo.BoxOffice;
import kr.green.maven0630.vo.BoxOffice2;
import kr.green.maven0630.vo.DailyBoxOffice;

public class Ex_Gson4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("일일 박스오피스 순위를 보려면 년월일을 공백으로 구분하여 입력하시오(년도 두자리)");
		int yy = sc.nextInt();
		int mm = sc.nextInt();
		int dd = sc.nextInt();

		// 원하는 날짜의 데이터를 얻도록 URL 주소를 만들어 주자
		String urlAddress = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		urlAddress += "?key=f5eef3421c602c6cb7ea224104795888";
		urlAddress += "&targetDt=" + String.format("%04d%02d%02d", yy, mm, dd);

		// System.out.println(urlAddress);

		try {
			URL url = new URL(urlAddress);
			Gson gson = new Gson();

			InputStreamReader isr = new InputStreamReader(url.openStream(), "UTF-8"); // 읽기 위해서 URL로 부터 리더 객체 생성
			//BoxOffice boxOffice = gson.fromJson(isr, BoxOffice.class); // 읽기
			BoxOffice2 boxOffice = gson.fromJson(isr, BoxOffice2.class);
			// System.out.println(boxOffice);
			for(BoxOffice2.BoxOfficeResult.DailyBoxOffice office : boxOffice.getBoxOfficeResult().getDailyBoxOfficeList()) {
				System.out.println(office.getRank() + ". ");
				System.out.println(office.getMovieNm() + "(개봉일 : ");
				System.out.println(office.getOpenDt() + ")");
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sc.close();
	}
}
