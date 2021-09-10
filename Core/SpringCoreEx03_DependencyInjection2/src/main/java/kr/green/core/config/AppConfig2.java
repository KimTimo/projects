package kr.green.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import kr.green.core.vo.Address;
import kr.green.core.vo.Employee;
import kr.green.core.vo.Person;

@Configuration
public class AppConfig2 {

	@Bean("address1")
	public Address address1() {
		return new Address("성남", "미금로 3가", "대한민국");
	}
	
	@Bean("address2")
	public Address address2() {
		return new Address( "대한민국", "성남", "미금로 3가");
	}
	
	@Bean("address3")
	public Address address3() {
		return new Address("성남", "미금로 3가", "대한민국");
	}
	
	@Bean("person1")
	public Person person1() {
		return new Person("한사람", 35, address1());
	}
	
	@Bean("person2")
	public Person person2() {
		return new Person("한사람", 35, address1());
	}
	
	@Bean("person3")
	public Person person3() {
		Person person = new Person();
		person.setAge(44);
		person.setName("천송이");
		person.setAddress(address3());
		return person;
	}
	@Bean("person4")
	public Person person4() {
		Person person = new Person();
		person.setAddress(address3());
		person.setName("천송이");
		person.setAge(44);
		return person;
	}
	@Bean("person5")
	public Person person5() {
		Person person = new Person();
		person.setAddress(new Address("용인시", "고림로", "경기민국"));
		person.setName("천송이");
		person.setAge(44);
		return person;
	}
	
}
