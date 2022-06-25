package kr.green.el;

import lombok.Data;

@Data
public class Person {
	private int idx;
	private String name;
	private int age;
	private double weight;
	private double height;
	
	public String getPerson() {
		return idx + ". " + name + "("
			+ age + "세, " + weight + "Kg, " + height + "Cm)";	
	}
}
