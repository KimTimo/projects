package kr.green.maven0702.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ex03 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(new int[] {4,7,12}, new boolean[] {true,false,true}));
		System.out.println(solution.solution(new int[] {1,2,3}, new boolean[] {false,false,true}));
	}
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new int[] {4,7,12}, new boolean[] {true,false,true}), 9);
		assertEquals(solution.solution(new int[] {1,2,3}, new boolean[] {false,false,true}), 0);
	}
	static class Solution {
	    public int solution(int[] absolutes, boolean[] signs) {
	        int answer = 0;
	        for(int i=0;i<absolutes.length;i++) {
	        	answer += absolutes[i] * (signs[i] ? 1 : -1);
	        }
	        return answer;
	    }
	}
}
