package kr.green.maven0705.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.checkerframework.checker.nullness.Opt;

public class Ex17_Stream {
	public static void main(String[] args) {
		List<Employee> list = Employee.persons();
		
		List<String> list1 = Employee.persons().stream()
				             .map(Employee::getName)
				             .collect(Collectors.collectingAndThen(Collectors.toList(), result->Collections.unmodifiableList(result)));
		System.out.println(list1);
		System.out.println("-------------------------------------------------------------");
		
		Optional<Employee> anyFemale = list.stream().filter(Employee::isFemale).findAny();
		if(anyFemale.isPresent()) {
			System.out.println("any Female : " + anyFemale.get());
		}else {
			System.out.println("엄슴~");
		}
		
	}
}
