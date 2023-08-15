package kr.green.selenium;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MapVO {
	private String shape;
	private String coords;
	private String area;
	private String key;
	private String img;
}
