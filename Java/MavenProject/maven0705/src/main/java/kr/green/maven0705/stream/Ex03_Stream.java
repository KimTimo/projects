package kr.green.maven0705.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex03_Stream {
	public static void main(String[] args) {
		// 스트림은 읽기만 할 뿐 변경하지는 모담.
		List<Integer> list = Arrays.asList(3, 1, 5, 4, 2);
		List<Integer> sorteList = list.stream().sorted().collect(Collectors.toList()); // collect : 맨드러라
		System.out.println(list);
		System.out.println(sorteList);

		// 스트림은 1회용이다. 필요하면 다시 스트림을 만들어야한다.
		Stream<String> strStream = Stream.of("한놈,두식이,석삼,너구리,오징어".split(","));
		strStream.forEach(System.out::println);
		// 예외 발생 : java.lang.IllegalStateException: stream has already been operated
		// upon or closed
		// 한번 썼는데 또 사용하였기 때문에 에러가 발생
		// long count = strStream.count(); // 최종연산

		// 메소드체인기법(.을 연결해서 사용하는 기법)
		// 최종 연산 전까지 중산연산이 수행되지 않는다. -- 지연된 연산
		// 로또 번호 자동 생성기
		IntStream intStream = new Random().ints(1, 46); // 1~45 범위의 무한 스트림 생성
		intStream.distinct() // 중복제거 -- 중간연산
				.limit(6) // 개수제한 -- 중간연산
				.sorted() // 정렬 -- 중간연산
				.forEach(i -> System.out.print(i + " ")); // 중간연산
		System.out.println();
	}
}
