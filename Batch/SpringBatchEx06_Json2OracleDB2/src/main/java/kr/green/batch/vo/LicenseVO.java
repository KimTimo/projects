package kr.green.batch.vo;
/*
CREATE TABLE license(
	idx NUMBER PRIMARY KEY,
	"TYPE" NUMBER,
	question varchar2(200) NOT NULL,
	ans1 varchar2(200),
	ans2 varchar2(200),
	ans3 varchar2(200),
	ans4 varchar2(200),
	ans5 varchar2(200),
	cor1 NUMBER DEFAULT 0,
	cor2 NUMBER DEFAULT 0,
	"DESC" varchar2(2000),	
	contents varchar2(200)		
);
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LicenseVO {
	private int idx;
	private int type;
	private String question;
	private String ans1;
	private String ans2;
	private String ans3;
	private String ans4;
	private String ans5;
	private int cor1;
	private int cor2;
	private String desc;
	private String contents;
	
}
