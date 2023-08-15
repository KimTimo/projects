package kr.green.searches.api;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ApiEx{
	public static void main(String[] args) {
		String url="http://apis.data.go.kr/B553077/api/open/sdsc2/storeListInDong?serviceKey=4own5QYkTV6dh7gZ6tHhDl6hx5YFV9M5mF5ffbpQiNIiXZzvX85oRGTituzZkkTIDk9B%2B66ydvQLRTaFtH%2F2VQ%3D%3D&pageNo=1&numOfRows=100&divId=ctprvnCd&key=11&indsLclsCd=Q&indsMclsCd=Q12&indsSclsCd=Q12A01&type=json";

		try {
			Scanner sc = new Scanner(new URL(url).openStream());
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}