package kr.green.maven0705.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

import org.checkerframework.checker.nullness.Opt;

/*
reduce () 연산은 스트림의 모든 요소를 ​​결합하여 단일 값을 생성합니다.
T  reduce(T identity, BinaryOperator<T> accumulator)
<U> U reduce(U identity, BiFunction<U,? super  T,U> accumulator, BinaryOperator<U> combiner)
Optional<T> reduce(BinaryOperator<T> accumulator)

Optional<T> 결과를 래핑하거나 결과가 없는 경우 사용됩니다.

숫자 스트림에서 합계, 최대, 최소, 평균 등을 계산하려면
숫자가 아닌 스트림을 숫자 스트림 유형(IntStream, LonStream 또는 DoubleStream)으로 메핑한 다음 특수 메소드를 사용할 수 있습니다.
 */
public class Ex10_Stream {
	public static void main(String[] args) {
		double totalIncome = Employee.persons().stream().mapToDouble(Employee::getIncome).sum();
		System.out.println("수입 합계 : " + totalIncome);
		
		Optional<Employee> person = Employee.persons().stream().max(Comparator.comparingDouble(Employee::getIncome));
		if(person.isPresent())
			System.out.println("최고 수입 사원 : " + person.get());
		
		OptionalDouble income = Employee.persons().stream().mapToDouble(Employee::getIncome).max();
		if(income.isPresent())
			System.out.println("최고 수입 사원 : " + income.getAsDouble());
		
		// count() : 스트림의 요소 수를 long 으로 반환하는 count() 메소드를 통해 카운트 작업을 지원합니다.
		long count = Employee.persons().stream().count();
		System.out.println("총 사원수 : " + count);
		
		count = Employee.persons().stream().mapToLong(p->1L).sum();
		System.out.println("총 사원수 : " + count);
		
		count = Employee.persons().stream().map(p->1L).reduce(0L, Long::sum);
		System.out.println("총 사원수 : " + count);
		
		
	}
}
