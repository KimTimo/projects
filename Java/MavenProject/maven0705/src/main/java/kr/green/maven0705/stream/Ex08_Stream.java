package kr.green.maven0705.stream;

import java.util.Arrays;
import java.util.List;
/*
reduce () 연산은 스트림의 모든 요소를 ​​결합하여 단일 값을 생성합니다.
T  reduce(T identity, BinaryOperator<T> accumulator)
<U> U reduce(U identity, BiFunction<U,? super  T,U> accumulator, BinaryOperator<U> combiner)
Optional<T> reduce(BinaryOperator<T> accumulator)
 */
public class Ex08_Stream {
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		int sum = list.stream().reduce(0, Integer::sum);
		System.out.println("합계 : " + sum);
		
		double sum2 = Employee.persons().stream().map(Employee::getIncome).reduce(0.0, Double::sum);
		System.out.println("수입 합계 : " + sum2);
		
		sum2 = Employee.persons()
		       .stream()
		       .reduce(0.0, (partialSum, person) -> partialSum + person.getIncome(), Double::sum); 
		System.out.println("수입 합계 : " + sum2);
		
		sum2 = Employee.persons().stream()
			   .reduce(0.0, (Double partialSum, Employee employee)->{
				   double accumulated = partialSum + employee.getIncome();
				   System.out.println(Thread.currentThread().getName() + 
						   " - Accumulator: partialSum  = " + partialSum + 
						   ", employee = " + employee +
						   ", " + accumulated);
				   return accumulated;
			   },
				(a,b) -> {
					double combined = a + b;
					System.out.println(Thread.currentThread().getName() + 
							   " - Combiner a = " + a + ", b = " + b +  
							   ", combined  = " + combined);
					return combined;
				});
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(sum2);
		
		sum2 = Employee.persons().parallelStream()
				.reduce(0.0, (Double partialSum, Employee employee)->{
					double accumulated = partialSum + employee.getIncome();
					System.out.println(Thread.currentThread().getName() + 
							" - Accumulator: partialSum  = " + partialSum + 
							", employee = " + employee +
							", " + accumulated);
					return accumulated;
				},
				(a,b) -> {
					double combined = a + b;
					System.out.println(Thread.currentThread().getName() + 
							" - Combiner a = " + a + ", b = " + b +  
							", combined  = " + combined);
					return combined;
				});
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
}
