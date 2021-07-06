package kr.green.maven0705.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
public class Ex11_Stream {
	public static void main(String[] args) {
		List<String> names = Employee.persons().stream().map(Employee::getName).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(names);
		
		names = Employee.persons().stream().map(Employee::getName).collect(Collectors.toList());
		System.out.println(names);
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList()); // 배열을 리스트로
		System.out.println(list);
		
		Set<String> nemeSet = Employee.persons().stream().map(Employee::getName).collect(Collectors.toSet());
		System.out.println(nemeSet);
		
		nemeSet = Employee.persons().stream().map(Employee::getName).collect(Collectors.toCollection(TreeSet::new));
		System.out.println(nemeSet);
	}
}
