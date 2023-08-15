package kr.green.mvc19.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Pizza {
	private String	name;
	private String	flavor;
	private List<String> toppings = new ArrayList<>();
	
	public Pizza(String name){
		this.name = name;
		this.flavor = "spicy";
		this.toppings.add("치즈");
		this.toppings.add("베이컨");
	}
}
