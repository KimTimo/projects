package kr.green.exam;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
공백을 제외한 글자수 세기
3
네이버 글자수세기 등 특정 글의 글자를 세는 프로그램은 일반적으로 공백을 제외한 글자수만을 세는 기능도 가지고 있다.
어떠한 문자열을 입력받았을 때 줄바꿈과 공백을 제외한 글자수만을 리턴하는 코드를 작성하시오.

입력 예시
공백을 제외한
글자수만을 세는 코드 테스트

출력 예시
18
 */

public class Ex04 {
	public static void main(String[] args) throws IOException {
		System.out.println(count("data.txt"));
		System.out.println(count("data2.txt"));
	}
	public static int count(String filename) throws IOException {
		// 파일읽기 : 뒤에 배움
        Path path = Paths.get(filename);
		String data = Files.readString(path, StandardCharsets.UTF_8);
		// 여기서 부터 개수세기
		int count=0;
		for(int i=0;i<data.length();i++) {
			// 줄바꿈, 공백, 탭, 캐리지리턴이 아니라면 개수 증가
			// if(data.charAt(i)!='\n' && data.charAt(i)!=' ' && data.charAt(i)!='\t' && data.charAt(i)!='\r') count++;
			// "문자열".contains(문자열) : 포함되어 있으면 참
			if(!"\n\t\r ".contains(data.charAt(i)+"")) count++;
		}
		return count;
	}
}
