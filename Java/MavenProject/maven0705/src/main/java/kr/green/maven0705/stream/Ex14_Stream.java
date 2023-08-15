package kr.green.maven0705.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.checkerframework.checker.nullness.Opt;

/*
데이터를 그룹화하기 
 */
public class Ex14_Stream {
	public static void main(String[] args) {
		
		List<Employee> employees = Employee.persons();
		
		String names = employees.stream().map(Employee::getName).collect(Collectors.joining());
		System.out.println(names);
		
		names = employees.stream().map(Employee::getName).collect(Collectors.joining(","));
		System.out.println(names);
		
		names = employees.stream().map(Employee::getName).collect(Collectors.joining(",","Hello",". Goodbye."));
		System.out.println(names);
		
		
	}
}
