package kr.green.poll.vo;

import lombok.Data;

@Data
public class PollVO {
	
	private String title;
	private String[] item;
	private int[] result;

	// 몇 개의 메서드를 추가하자!!
	// 1. 총 투표수를 구하는 메서드
	public int getTotal() {
		int total = 0;
		for(int i  = 0; i < result.length; i++) total += result[i];
		return total;
	}
	// 2. 백분율을 구해주는 메서드
	public String getPercent(int index) {
		return String.format("%6.2f%%", (double)result[index] / getTotal()*100);
	}
	
}
