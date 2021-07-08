package kr.green.maven0707.exam;

import java.util.Arrays;

public class Ex03 {
	public static void main(String[] args) {
		String str = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
		System.out.println(str);
		
		str = erase(str);
		System.out.println(str);
		
		String [] ar = str.split("},");
		System.out.println(ar.length + " : " + Arrays.toString(ar));
		
		for(int i=0;i<ar.length;i++) {
			ar[i] = ar[i].substring(1);
		}
		System.out.println();
		
		for(int i=0;i<ar.length;i++) {
			System.out.println(ar[i].length() + " : " + ar[i]);
		}
		
	}
	static public String erase(String t) {
		int len = t.length();
		return t.substring(1,len-1);
	}
}
