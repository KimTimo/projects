package kr.green.maven0707.network;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;

public class Ex02_Network {
	public static void main(String[] args) {
		try {
			String address = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EA%BD%83%EB%B0%B0%EB%8B%AC";
			URL url = new URL(address);
			
			System.out.println(url.getProtocol());
			System.out.println(url.getHost());
			System.out.println(url.getPort());
			System.out.println(url.getPath());
			System.out.println(url.getFile());
			System.out.println(url.getQuery());
			// 주소중 인코딩된 값을 디코딩한다. : URLDecoder.decode(인코딩된 문자,케릭터셑)
			// 일반 문자를 인코딩 한다. : URLEncoder.encode(인코딩안된 문자,케릭터셑)
			System.out.println(URLDecoder.decode(url.getQuery(),"UTF-8"));
			
			String name = "한사람";
			System.out.println(URLEncoder.encode(name,"UTF-8"));
			System.out.println( URLDecoder.decode(URLEncoder.encode(name,"UTF-8"),"UTF-8"));
			
			// 요청 정보를 분석
			String queryString[] = url.getQuery().split("&");
			System.out.println(Arrays.toString(queryString));
			for(String query : queryString) {
				System.out.println("키 : " + query.split("=")[0] + ", 값 : " + query.split("=")[1] );
			}
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
	}
}
