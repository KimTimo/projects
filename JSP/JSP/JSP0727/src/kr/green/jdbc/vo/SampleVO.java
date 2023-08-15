package kr.green.jdbc.vo;

import lombok.Data;
// VO(Value Object) : 값을 저장하기 위한 용도의 클래스
//                    테이블의 필드명과 1:1 로 매칭되게 만든다.
// Domain Class
// DTO(Data Transfer Object) : 데이터를 전달하기 위한 클래스

@Data
public class SampleVO {
	private int    idx;
	private String name;
	private int    age;
	private String gender;
}
