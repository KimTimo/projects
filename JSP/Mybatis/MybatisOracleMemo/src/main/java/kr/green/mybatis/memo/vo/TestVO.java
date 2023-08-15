package kr.green.mybatis.memo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class TestVO {
	private Date today;
	private int  result;
	private String message;
}
