package kr.green.maven0628.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ex02 {
	
	@Test
	public void testCount() {
		assertEquals(getCount(new int[] {3,4,5,6,7}), "홀수 3개, 짝수 2개");
		assertEquals(getCount(new int[] {12,16,22,24,29}), "홀수 1개, 짝수 4개");
		assertEquals(getCount(new int[] {41,43,45,47,79}), "홀수 5개, 짝수 0개");
	}

	public static String getCount(int[]ar) {
		int oddCount = 0, evenCount = 0;
		for(int t : ar) {
			if(t%2==0)
				evenCount++;
			else
				oddCount++;
		}
		return String.format("홀수 %d개, 짝수 %d개",oddCount, evenCount);
	}
}
