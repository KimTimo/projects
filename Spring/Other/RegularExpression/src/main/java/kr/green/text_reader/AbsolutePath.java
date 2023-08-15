package kr.green.text_reader;

import java.io.File;

public class AbsolutePath {
	public static void main(String[] args) {
		File curDir = new File("");
		System.out.println("현재 프로젝트 절대 경로 : " + curDir.getAbsolutePath());
		curDir = new File("src/main/resources/NationalAnthem.txt");
		System.out.println("현재 프로젝트 안의 파일 절대 경로 : " + curDir.getAbsolutePath());
	}
}
