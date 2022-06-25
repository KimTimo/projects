package kr.green.mvc12.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeVO {
	private int id;
	private String name;
	private String role;
}
