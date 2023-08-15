package kr.green.guestbook.vo;

import java.util.Date;

import lombok.Data;

@Data
public class GuestBookVO {
	private int 	idx;
	private String 	name;
	private String 	password;
	private String 	content;
	private Date   	regDate;
	private String 	ip;
	
	// 수정/저장/삭제를 구분하기 위한 변수 추가
	private String mode;
}
