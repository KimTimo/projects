package kr.green.memo.vo;

import java.util.Date;

import lombok.Data;

/*
 * 테이블의 필드명과 동일한 이름으로 속성(멥버변수)을 선언해준다.
create table memo( -- 테이블이름 memo
idx int primary key auto_increment, -- 기본키
name varchar(30) not null, -- 작성자
password varchar(50) not null, -- 비밀번호
content text not null, -- 내용
regDate timestamp default now(), -- 작성일
ip varchar(20) -- 사용자 아이피
);
*/
@Data
public class MemoVO {
	private int 	idx;
	private String 	name;
	private String 	password;
	private String 	content;
	private Date 	regDate;
	private String 	ip;
	
	// 수정/저장/삭제를 구분하기 위한 변수 추가
	private String mode;
}
