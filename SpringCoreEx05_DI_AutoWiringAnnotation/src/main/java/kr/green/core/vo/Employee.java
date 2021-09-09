package kr.green.core.vo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Employee {

	//@Autowired
	private EmployeeAddress address;

	public Employee() {
		
	}

	//@Autowired
	public Employee(EmployeeAddress address) {
		super();
		this.address = address;
	}

	public EmployeeAddress getAddress() {
		return address;
	}
	@Autowired
	public void setAddress(EmployeeAddress address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [address=" + address + "]";
	}
	
	
}
