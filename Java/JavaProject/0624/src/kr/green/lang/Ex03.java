package kr.green.lang;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		String week = "일월화수목금토";
		String[] weeks = week.split("");                  // 1글자씩 잘라서 배열로 만든다
		System.out.println(Arrays.toString(weeks));
		String week2 = "일월화수목금토요일";
		String[] weeks2 = week2.split("", 7);
		System.out.println(Arrays.toString(weeks2));      // 1글자씩 잘라서 7개의 배열로 만든다.
		
		String week3 = "일 월 화 수 목 금 토 요 일";
		String[] weeks3 = week3.split(" ");               // 공백으로 잘라서 배열로 만든다.
		System.out.println(Arrays.toString(weeks3));
		
		String week4 = "일,월,화,수,목-금.토-요, 일";
		String[] weeks4 = week4.split(",");               // 공백으로 잘라서 배열로 만든다.
		System.out.println(Arrays.toString(weeks4));
		
		
		// 문제 : 2021-11-04 (육림의날)
		String t = "2021-11-04 (육림의날)";
		// 년만
		System.out.println(t.split("-")[0]);
		// 월만
		System.out.println(t.split("-")[1]);
		// 일만
		System.out.println(t.split("-")[2].split(" ")[0]);
		// 문자열만
		System.out.println(t.split("-")[2].split(" ")[1]);
		System.out.println(t.split(" ")[1]);
	}
}
