package kr.green.searches.api;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/B553077/api/open/sdsc2/storeListInUpjong"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=4own5QYkTV6dh7gZ6tHhDl6hx5YFV9M5mF5ffbpQiNIiXZzvX85oRGTituzZkkTIDk9B%2B66ydvQLRTaFtH%2F2VQ%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 현재 요청 페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /* 최대 1000*/
        urlBuilder.append("&" + URLEncoder.encode("divId","UTF-8") + "=" + URLEncoder.encode("indsLclsCd", "UTF-8")); /* 대분류는 indsLclsCd, 중분류는 indsMclsCd, 소분류는 indsSclsCd를 사용*/
        urlBuilder.append("&" + URLEncoder.encode("key","UTF-8") + "=" + URLEncoder.encode("Q", "UTF-8")); /* 대분류는 대분류코드값, 중분류는 중분류코드값, 소분류는 소분류코드값을 사용*/
        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /* xml / json*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}
