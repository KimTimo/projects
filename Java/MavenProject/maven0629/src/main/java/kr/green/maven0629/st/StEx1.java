package kr.green.maven0629.st;

import java.util.StringTokenizer;

public class StEx1 {

	public static void main(String[] args) {
		String str1 = "한놈 두식이 석삼 너구리 오징어";
		String str2 = "한놈,두식이,석삼,너구리,오징어";
		String str3 = "한놈,두식이.석삼-너구리*오징어";
		
		StringTokenizer st1 = new StringTokenizer(str1);
		System.out.println(st1);
		System.out.println(st1.countTokens() + "개");
		while(st1.hasMoreTokens())
			System.out.println(st1.nextToken());
		System.out.println();
		
		StringTokenizer st2 = new StringTokenizer(str2, ",");
		System.out.println(st2);
		System.out.println(st2.countTokens() + "개");
		while(st2.hasMoreTokens())
			System.out.println(st2.nextToken());
		System.out.println();
		
		StringTokenizer st3 = new StringTokenizer(str3, ",.*-");
		System.out.println(st3);
		System.out.println(st3.countTokens() + "개");
		while(st3.hasMoreTokens())
			System.out.println(st3.nextToken());
		System.out.println();
	}

}
