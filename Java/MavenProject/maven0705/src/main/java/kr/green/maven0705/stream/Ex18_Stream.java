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

public class Ex18_Stream {
	public static void main(String[] args) {
		List<Employee> list = Employee.persons();
		for(Employee e : list)
			System.out.println(e);
		boolean allFemale = list.stream().allMatch(Employee::isFemale);
		System.out.println("allMatch : " + allFemale);
		
		boolean year1971 = list.stream().allMatch(p->p.getDob().getYear()==1971);
		System.out.println("1971년 : " + year1971);
		
	}
}
