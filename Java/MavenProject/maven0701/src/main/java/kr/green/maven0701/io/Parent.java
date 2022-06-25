package kr.green.maven0701.io;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // 부모 클래스는 직렬화/역직렬화를 하지 않았다.
@AllArgsConstructor
@NoArgsConstructor
public class Parent {
	private String name;
	private int age;
}
