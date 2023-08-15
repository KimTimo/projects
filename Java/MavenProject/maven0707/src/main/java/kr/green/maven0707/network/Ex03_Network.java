package kr.green.maven0707.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class Ex03_Network {
	public static void main(String[] args) {
		try {
			String address = "https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=%EA%BD%83%EB%B0%B0%EB%8B%AC";
			URL url = new URL(address);
			
			System.out.println("네이버 소스보기 1");
			Scanner sc = new Scanner(url.openStream(),"UTF-8");
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
			
			System.out.println("=========================================================================");
			System.out.println("네이버 소스보기 2");
			URLConnection conn = url.openConnection();
			InputStream is = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String line="";
			while((line=br.readLine())!=null) {
				System.out.println(line);
			}
			
			is.close();
			br.close();
			
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
