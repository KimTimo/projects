package kr.green.poll.vo;

import java.util.List;

import lombok.Data;

@Data
public class PollVO {
	private String title;
	private List<String> item;
	private List<Integer> result;
	private String start;
	private String end;
	
	// 몇 개의 메서드를 추가하자!!!
	// 1. 총 투표수를 구하는 메서드
	public int getTotal() {
		int total = 0;
		for(int i=0;i<result.size();i++) total += result.get(i);
		return total;
	}
	// 2. 백분율을 구해주는 메서드
	public String getPercent(int index) {
		return String.format("%6.2f%%", (double)result.get(index)/getTotal()*100);
	}	
}
