package kr.green.maven0705.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
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
public class Ex12_Stream {
	public static void main(String[] args) {
		DoubleSummaryStatistics stats = new DoubleSummaryStatistics();
		stats.accept(100.0);
		stats.accept(200.0);
		stats.accept(225.0);
		stats.accept(312.0);
		stats.accept(543.0);
		stats.accept(765.0);
		stats.accept(229.0);
		
		System.out.println(stats);
		System.out.println(stats.getCount());
		System.out.println(stats.getSum());
		System.out.println(stats.getAverage());
		System.out.println(stats.getMax());
		System.out.println(stats.getMin());
		
		DoubleSummaryStatistics incomStat = Employee.persons().stream().map(Employee::getIncome)
				.collect(DoubleSummaryStatistics::new, DoubleSummaryStatistics::accept, DoubleSummaryStatistics::combine);
		System.out.println(incomStat);
		
		incomStat = Employee.persons().stream().collect(Collectors.summarizingDouble(Employee::getIncome));
		System.out.println(incomStat);
	}
}
