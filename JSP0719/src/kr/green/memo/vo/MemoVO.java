package kr.green.memo.vo;

import lombok.Data;

/*
 	{
		"name": "주인",
		"password": "123456",
		"content": "한줄메모장입니다. 잘쓰세요",
		"regDate": "2021-07-19 11:11:11",
		"ip": "192.168.0.17"
	}
 */
@Data
public class MemoVO {
	private String name;
	private String password;
	private String content;
	private String regDate;
	private String ip;
}
