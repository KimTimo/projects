package kr.green.ibatis.vo;

import java.util.Date;

import lombok.Data;

@Data
public class TestVO {
	private Date now;
	private int result;
	private String message;
}
