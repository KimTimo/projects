package kr.green.mvc05.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeopleVO {
	private int 	id;
	private String 	name;
	private int 	age;
}
