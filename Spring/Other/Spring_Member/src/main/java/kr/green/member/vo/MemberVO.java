package kr.green.member.vo;

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
	private int 	idx;
	private String 	userid;
	private String 	password;
	private String 	uuid;
	private String 	username;
	private String 	email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date 	birth;
	private String 	phone;
	private String 	zipcode;
	private String 	addr1;
	private String 	addr2;
	private int 	enabled;
	private Date 	regdate;
}
