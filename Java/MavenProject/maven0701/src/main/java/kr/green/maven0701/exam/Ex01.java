package kr.green.maven0701.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
기계의 마라톤 기록
항상 일정한 속도로 달리는 기계가 있다고 합시다. 
이 기계의 100m 달리기 기록을 입력받으면 마라톤에서의 기록을 구하시면 됩니다. 
마라톤 경기에서 달리는 거리는 42.195km입니다. 
100m 달리기와 마라톤의 코스는 모두 직선이라고 합니다(회전 시 걸리는 시간을 고려하지 않습니다). 
기계의 파손 및 배터리 방전 시간도 고려하지 않습니다.
 */
public class Ex01 {
	public static void main(String[] args) {
		double time = getTime(10);
		System.out.println(getTime(10));
		System.out.printf("마라톤 기록 : %d시간 %d분 %d초\n", (int)(time/3600), (int)((time%3600)/60),(int)(time%60));
		time = getTime(20);
		System.out.println(getTime(20));
		System.out.printf("마라톤 기록 : %d시간 %d분 %d초\n", (int)(time/3600), (int)((time%3600)/60),(int)(time%60));
	}
	@Test
	public void test() {
		assertEquals((int)getTime(10), 4219);
		assertEquals((int)getTime(20), 8439);
	}
	public static double getTime(int velocity) {
		return 42.195*1000/100*velocity;
	}
}
