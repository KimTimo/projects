package kr.green.member.vo;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/*
CREATE TABLE member(
    idx          INT              NOT NULL, 
    userid       VARCHAR2(20)     NOT NULL, 
    password     VARCHAR2(20)     NOT NULL, 
    username     VARCHAR2(50)     NOT NULL, 
    email        VARCHAR2(50)     NOT NULL, 
    phone        VARCHAR2(20)     NOT NULL, 
    postcode     VARCHAR2(10)     NOT NULL, 
    roadAddr     VARCHAR2(150)    NOT NULL, 
    jibunAddr    VARCHAR2(150)    NOT NULL, 
    detailAddr    VARCHAR2(150)    NOT NULL, 
    auth    	 VARCHAR2(150)    NOT NULL,     
    use          NUMBER           NOT NULL, 
    PRIMARY KEY (idx)
);
 */
@XmlRootElement
@Data
public class MemberVO {
	private int idx;
	private String userid;
	private String password;
	private String newPassword; // 비번 수정시에만 사용
	private String username;
	private String email;
	private String phone;
	private String postCode;
	private String roadAddr;
	private String jibunAddr;
	private String detailAddr;
	private String auth;
	private int use; // 0 : 가입미인증, 1: 인증, 2:휴면계정, 3:탈퇴 ..... 여러분이 맘대로 결정한다.
	
}
