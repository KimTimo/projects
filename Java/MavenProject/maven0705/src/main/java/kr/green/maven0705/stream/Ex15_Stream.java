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
public class Ex15_Stream {
	public static void main(String[] args) {
		// 성별 인원수
		Map<Employee.Gender, Long> countByGender = Employee.persons().stream()
				                                   .collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
		System.out.println(countByGender);
		// 성별로 이름을 , 로 구분해서 문자열로
		Map<Employee.Gender, String> nameByGender = Employee.persons().stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.joining(","))));
		System.out.println(nameByGender);
		// 성별로 구분해서 이름을 리스트로
		Map<Employee.Gender, List<String>> namesByGender = Employee.persons().stream()
				                                           .collect(Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
		System.out.println(namesByGender);
		// 성별로 구분해서 월별 맵으로
		Map<Employee.Gender, Map<Object,String>> map = Employee.persons().stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.groupingBy(p->p.getDob().getMonth()
				, Collectors.mapping(Employee::getName, Collectors.joining(",")))));
		System.out.println(map);
		// 성별로 구분해서 수입의 통계를 맵으로
		Map<Employee.Gender, DoubleSummaryStatistics> incomeStatsByGender = Employee.persons().stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.summarizingDouble(Employee::getIncome)));
		System.out.println(incomeStatsByGender);
	}
}
