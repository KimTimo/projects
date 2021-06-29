package kr.green.maven0628.exam;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

public class Ex01 {

	public static void main(String[] args) {
		System.out.println(median(new int[] { 7, 9, 14 }));
		System.out.println(median(new int[] { 24, 31, 35, 49 }));
		System.out.println(median(new int[] { 17, 37, 37, 47, 57 }));

	}
	
	public void testmedian(int []ar) {
		assertEquals(median(new int[]{ 7, 9, 14 }), 9);
		assertEquals(median(new int[]{ 24, 31, 35, 49 }), 33);
		assertEquals(median(new int[]{ 17, 37, 37, 47, 57 }), 37);
	}

	public static int median(int[] ar) {
		int result = 0;
		// 정렬
		Arrays.sort(ar);
		if (ar.length % 2 == 0) {
			result = (ar[ar.length / 2-1] + ar[ar.length / 2])/2;
		} else {
			result = ar[ar.length / 2];
		}

		return result;
	}

}
