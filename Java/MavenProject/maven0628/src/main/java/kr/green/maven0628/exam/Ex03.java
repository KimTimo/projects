package kr.green.maven0628.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ex03 {
	@Test
	public void testCheck() {
		assertEquals(check(new int[] {60, 60, 60}), "예각삼각형");
		assertEquals(check(new int[] {30, 60, 90}), "직각삼각형");
		assertEquals(check(new int[] {20, 40, 120}), "둔각삼각형");
		assertEquals(check(new int[] {0, 90, 90}), "삼각형이 아니다");
		assertEquals(check(new int[] {60, 70, 80}), "삼각형이 아니다");
		assertEquals(check(new int[] {40, 40, 50, 50}), "삼각형이 아니다");
	}
	public static String check(int[] ar) {
		String result="";
		if(ar.length!=3 || ar[0]+ar[1]+ar[2] != 180 || ar[0]<= 0 || ar[1] <=0 || ar[2]<=0) {
			result="삼각형이 아니다";
		}else if(ar[0]== 90 || ar[1]==90 || ar[2]==90) {
			result="직각삼각형";
		}else if(ar[0]> 90 || ar[1]>90 || ar[2]>90) {
			result="둔각삼각형";
		}else {
			result="예각삼각형";
		}
		return result;
	}

}
