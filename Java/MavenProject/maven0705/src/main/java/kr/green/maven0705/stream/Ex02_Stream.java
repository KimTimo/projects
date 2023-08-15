package kr.green.maven0705.stream;

import java.util.Random;
import java.util.stream.Stream;

public class Ex02_Stream {

	public static void main(String[] args) {
		Stream.iterate(1, n -> n + 1).limit(5).forEach(System.out::println);

		Stream.iterate(1, n -> n + 1) // 1,2,3,4,5,6.... 스트림 만들기
				.limit(5) // 갯수 제한
				.filter(Ex02_Stream::isOdd) // isOdd메소드로 걸러주기
				.forEach(System.out::println);
		; // 최정연산 : 출력
		System.out.println();

		Stream.iterate(1, n -> n + 1) // 1,2,3,4,5,6.... 스트림 만들기
				.skip(100) // 100 건너띄기
				.limit(5) // 갯수 제한
				.filter(Ex02_Stream::isOdd) // isOdd메소드로 걸러주기
				.forEach(System.out::println);
		; // 최정연산 : 출력
		System.out.println();
		// generate(정적메소드)
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
		System.out.println();
		Stream.generate(Ex02_Stream::next).limit(10).forEach(System.out::println);
		System.out.println();
		Stream.generate(Ex02_Stream::rand).limit(10).forEach(System.out::println);
		System.out.println();
		Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);
		System.out.println();

		new Random().ints().limit(10).sorted().forEach(System.out::println);
		System.out.println();
	}

	static int i = 0;

	public static int next() {
		return ++i;
	}

	public static int rand() {
		return (int) (Math.random() * 100);
	}

	private static boolean isOdd(long n) {
		return n % 2 != 0;
	}
}
