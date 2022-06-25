package kr.green.maven0702.lambda;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex07_Lambda {
	public static void main(String[] args) {
		// 인수가 없고 리턴값만 있는 경우에 사용할 인터페이스
		Supplier<String> engError = () -> "Error!!!";
		Supplier<String> korError = () -> "에러!!!";

		System.out.println(engError.get());
		System.out.println(korError.get());

		// 매개 변수만 있고 반환값이 없다.
		Consumer<String> message = (str) -> System.out.println("♬" + str + "♬");

		message.accept("상오상오");
		message.accept("쨔몽쨔몽");
		message.accept("몽돌몽돌");

		// 1개의 인수에 반환값이 있다.
		Function<Integer, String> convert = (n) -> "" + n; // 정수를 스트링으로 만들어 리턴하는 함수
		System.out.println(convert.apply(26) + convert.apply(36));
		System.out.println("-------------------------------------------------------");

		Function<String, Double> convert2 = (str) -> Double.parseDouble(str); // 스트링을 실수로 만들어 리턴하는 함수
		System.out.println(2 * convert2.apply("3.14") + convert2.apply("7"));
		System.out.println("-------------------------------------------------------");

		Function<Integer, Integer> min2sec = (min) -> min * 60; // 분을 받아 초로 바꿔주는 함수
		System.out.println("5분은 " + min2sec.apply(10) + "초 입니다.");
		System.out.println("-------------------------------------------------------");

		Function<Integer, Integer> sqrt = (x) -> x * x;
		System.out.println("8의 제곱은 " + sqrt.apply(8) + "입니다.");
		System.out.println("-------------------------------------------------------");

		// 1개를 받아 boolean을 리턴한다.
		Predicate<Integer> isEven = (x) -> x % 2 == 0; // 짝수판단
		Predicate<Integer> isLeapYear = (year) -> year % 400 == 0 || year % 4 == 0 && year % 100 != 0; // 윤년판단
		System.out.println("7은 " + (isEven.test(7) ? "짝" : "홀") + "수 입니다.");
		System.out.println("78은 " + (isEven.test(7) ? "짝" : "홀") + "수 입니다.");

		System.out.println("2000년은 " + (isLeapYear.test(2000) ? "윤" : "평") + "년 입니다.");
		System.out.println("2002은 " + (isLeapYear.test(2002) ? "윤" : "평") + "년 입니다.");

		// 하나의 메소드만 호출하는 람다식은 메소드 참조 연산자(::)로 표현이 가능하다.
		Function<String, Integer> str2int = (str) -> Integer.parseInt(str);
		System.out.println(str2int.apply("123") * 2);
		// 위의 식을 아래처럼 간단하게 표현이 가능하다.
		Function<String, Integer> str2int2 = Integer::parseInt;
		System.out.println(str2int.apply("123") * 2);
		
		Function<Double, Double> root = Math::sqrt;
		System.out.println(root.apply(5.0));
		System.out.println(root.apply(2.0));

	}
}
