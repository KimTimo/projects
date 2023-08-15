package kr.green.mvc21;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class SpcdeInfoServiceEx {
	public static void main(String[] args) {
		// 국경일 정보
		// String address="http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getHoliDeInfo";
		// 공휴일 정보
		// String address="http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getRestDeInfo";
		// 기념일 정보 조회
		// String address="http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getAnniversaryInfo";
		// 잡절정보
		// String address="http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/getSundryDayInfo";
		// 24절기 정보
		String address="http://apis.data.go.kr/B090041/openapi/service/SpcdeInfoService/get24DivisionsInfo";
		
		address +="?serviceKey=Z4uCridIALZt7Mtx3%2Fp2iKR3FCCLa1kLaCW2pLceTr%2F41ibB6PO3BZt4vfFJHLRrj7v0ACBEwptVEJV9bny1iA%3D%3D";
		//address +="&solYear=2021&solMonth=09";
		address +="&solYear=2021&numOfRows=1000";
		
		try {
			URL url = new URL(address);
			Scanner scanner = new Scanner(url.openStream(),"UTF-8");
			while(scanner.hasNextLine()) {
				System.out.println(scanner.nextLine());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
