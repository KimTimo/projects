package kr.green.maven0705.stream;

import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex07_Stream {
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 10)
		.map(n->n*n)
		.forEach(n -> System.out.print(n + " "));
		System.out.println("\n------------------------------------------------------");
		
		Employee.persons().stream().map(Employee::getName).forEach(n -> System.out.print(n + " "));
		System.out.println("\n------------------------------------------------------");
		
		Stream.of(1,2,3,4,5).flatMap(n->Stream.of(n, n+1)).forEach(n->System.out.print(n + " "));
		System.out.println("\n------------------------------------------------------");
		
		Stream.of("XML","JAVA","HTML","CSS")
		.map(name->name.chars())
		.flatMap(intStream -> intStream.mapToObj(n->(char)n))
		.forEach(n -> System.out.println(n + " "));
		
		
	}
}
