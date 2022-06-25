package kr.green.core.vo;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Question {
	private int id;
	private String name;
	private Map<Answer, User> answer;
}
// 문제 : Question 객체를 스프링에 등록하여 사용하는 예제 만들기
//        xml로도 만들고 Annotation 으로도 만들어보기