package kr.green.maven0705.stream;

import java.util.stream.Stream;

public class Ex05_Stream {
	public static void main(String[] args) {
		int sum = Stream.of(1,2,3,4,5,6,7,8,9,10)
				.peek(e -> System.out.println("가져오기 : " + e))
				.filter(n->n%2==1)
				.peek(e -> System.out.println("거르기 : " + e))
				.map(n -> n*n)
				.peek(e -> System.out.println("변환 : " + e))
				.reduce(0, Integer::sum);
		
		System.out.println("합계 : " + sum);
	}
}
