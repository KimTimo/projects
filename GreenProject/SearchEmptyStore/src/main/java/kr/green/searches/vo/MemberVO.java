package kr.green.searches.vo;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/*
CREATE TABLE smember(
	idx 		NUMBER	PRIMARY KEY,
	userid  	varchar2(50)  NOT NULL,
	password  	varchar2(200) NOT NULL,
	uuid  		varchar2(200) NULL,
	username	varchar2(50)  NOT NULL,
    email       VARCHAR2(100)    NULL, 
    birth       date         	 NULL, 
    phone       VARCHAR2(20)     NULL, 
    zipcode     VARCHAR2(10)     NULL, 
    addr1       VARCHAR2(100)    NULL, 
    addr2       VARCHAR2(100)    NULL, 
    enabled     NUMBER(1)        DEFAULT 0, 
    regdate     TIMESTAMP        DEFAULT SYSDATE	
);
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class MemberVO {
	private int 	idx;  // 글번호
	private String 	userid;  // 아이디
	private String 	password; // 비밀번호
	private String 	uuid; // 방문자 식별자 고유번호
	private String 	username; // 이름
	private String 	email; // 이메일
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date 	birth; // 생년월일
	private String 	phone; // 핸드폰번호 
	private String 	zipcode; // 우편번호
	private String 	addr1; // 도로명 주소
	private String 	addr2; // 지번주소(상세주소)
	private int 	enabled; // 활성화여부
	private Date 	regdate; // 가입일
}
