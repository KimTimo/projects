package kr.green.maven0705.stream;

import java.util.List;

public class Ex06_Stream {

	public static void main(String[] args) {
		Employee.persons().stream().filter(Employee::isFemale).forEach(System.out::println);

		List<Employee> list = Employee.persons();
		System.out.println("변경전 : " + list);

		list.stream().filter(Employee::isFemale).forEach(p -> p.setIncome(p.getIncome() * 1.1));

		System.out.println("변경후 : " + list);

		list.stream().filter(Employee::isFemale) // 여자만
				.filter(p -> p.getIncome() > 5000) // 수입이 5000이상
				.map(Employee::getName) // 변환
				.forEach(System.out::println);
		
		
		list.stream()
		.filter(p -> p.getIncome() > 5000 && p.isFemale()) // 수입이 5000이상
		.map(Employee::getName) // 변환
		.forEach(System.out::println);
	}

}
