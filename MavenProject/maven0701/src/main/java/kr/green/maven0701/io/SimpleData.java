package kr.green.maven0701.io;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
// Serializable :  직렬화/역직렬화 인터페이스
public class SimpleData implements Serializable {
	private String name;
	private int    age;
	private transient Date   birth; // transient 예약어는 저장하거나 읽기에서 빠져라!!!. 일반적으로 static 멤버에 붙여준다.
	
}
