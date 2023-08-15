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
public class Ex13_Stream {
	public static void main(String[] args) {
		
		Map<Long, String> map = Employee.persons().stream()
				.collect(Collectors.toMap(Employee::getId, Employee::getName));
		System.out.println(map);
		System.out.println(map.get(4L));
		
		Map<Employee.Gender, String> map2 = Employee.persons().stream()
				.collect(Collectors.toMap(Employee::getGender, Employee::getName, (oldValue, newValue) -> String.join(",",oldValue, newValue)));
		System.out.println(map2);
	}
}
