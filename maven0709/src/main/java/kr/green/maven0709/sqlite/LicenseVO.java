package kr.green.maven0709.sqlite;

import lombok.Data;

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
