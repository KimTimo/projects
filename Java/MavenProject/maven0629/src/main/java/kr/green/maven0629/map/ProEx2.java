package kr.green.maven0629.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
/*
  HashTable<Object, Object> 타입의 맵을 만들어 이름을 Properties 라고 붙임
  환경설정 정보를 저장하거나 읽을 때 많이 사용!
 */
public class ProEx2 {

	public static void main(String[] args) {
		Properties prop1 = new Properties();
		
		prop1.setProperty("url", "http:// localhost");
		prop1.setProperty("id", "daehyunkim.kr");
		prop1.setProperty("pw", "123456789");
		
		System.out.println(prop1.size() + "개 : " + prop1);
		
		System.out.println("사용자 암호 : " + prop1.getProperty("pw"));
		
		// 파일로 쉽게 저장하거나 불러올 수도 있다.
		// 저장
		try {
			prop1.storeToXML(new FileOutputStream("prop.xml"), "나는 설명");
			Properties prop2 = new Properties();
			System.out.println(prop2);
			prop2.loadFromXML(new FileInputStream("prop.xml"));
			System.out.println(prop2);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
