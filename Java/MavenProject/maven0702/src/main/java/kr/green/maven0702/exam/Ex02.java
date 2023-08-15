package kr.green.maven0702.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Ex02 {
	
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.solution(new int[] {1,2,3,4}));
		System.out.println(solution.solution(new int[] {1,2,7,6,4}));
	}
	
	@Test
	public void test() {
		Solution solution = new Solution();
		assertEquals(solution.solution(new int[] {1,2,3,4}), 1);
		assertEquals(solution.solution(new int[] {1,2,7,6,4}), 4);
	}
	
	static class Solution {
	    public boolean isPrime(int n) {
	        for (int i = 2; i*i <= n; i++) {
	            if (n % i == 0) return false;
	        }
	        return true;
	    }

	    public int solution(int[] nums) {
	        int answer = 0;

	        // 세 수의 합 구하기
	        for (int i = 0; i < nums.length; i++) {
	            for (int j = i+1; j < nums.length; j++) {
	                for (int k = j+1; k < nums.length; k++) {
	                    int sum = nums[i] + nums[j] + nums[k];
	                    if (isPrime(sum)) answer++;
	                }
	            }
	        }
	        return answer;
	    }
	}
}
