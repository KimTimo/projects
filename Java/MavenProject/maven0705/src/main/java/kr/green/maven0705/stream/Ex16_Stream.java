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
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.checkerframework.checker.nullness.Opt;

/*
데이터를 그룹화하기 
 */
public class Ex16_Stream {
	public static void main(String[] args) {
		Map<Boolean, List<Employee>> map1 = Employee.persons().stream()
				.collect(Collectors.partitioningBy(Employee::isFemale));

		System.out.println(map1);

		for (boolean key : map1.keySet()) {
			System.out.println(key + " : " + map1.get(key));
		}
		System.out.println("--------------------------------------------");

		Map<Boolean, String> map2 = Employee.persons().stream()
				.collect(Collectors.partitioningBy(Employee::isFemale, Collectors.mapping(Employee::getName, Collectors.joining(","))));
		System.out.println(map2);

		for (boolean key : map2.keySet()) {
			System.out.println(key + " : " + map2.get(key));
		}
	}
}
