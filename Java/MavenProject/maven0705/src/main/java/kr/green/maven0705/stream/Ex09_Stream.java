package kr.green.maven0705.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.checkerframework.checker.nullness.Opt;

/*
reduce () 연산은 스트림의 모든 요소를 ​​결합하여 단일 값을 생성합니다.
T  reduce(T identity, BinaryOperator<T> accumulator)
<U> U reduce(U identity, BiFunction<U,? super  T,U> accumulator, BinaryOperator<U> combiner)
Optional<T> reduce(BinaryOperator<T> accumulator)
 */
public class Ex09_Stream {
	public static void main(String[] args) {
		Optional<Integer> max = Stream.of(1, 2, 3, 4, 5).reduce(Integer::max);

		if (max.isPresent()) {
			System.out.println("max = " + max.get());
		} else {
			System.out.println("max is not defind.");
		}

		max = Stream.<Integer>empty().reduce(Integer::max);
		if (max.isPresent()) {
			System.out.println("max = " + max.get());
		} else {
			System.out.println("max is not defind.");
		}
		
		Optional<Employee> person = Employee.persons().stream()
				.reduce((p1,p2) -> p1.getIncome() > p2.getIncome() ? p1 : p2);
		if(person.isPresent()) {
			System.out.println("Highest earner : " + person.get());
		}else {
			System.out.println("Could not get the highest earner.");
		}
	}
}
