package kr.green.category.vo;

import lombok.Data;

/*
CREATE TABLE category(
	idx NUMBER PRIMARY KEY,
	ref NUMBER,
	seq NUMBER DEFAULT 0, 
	lev NUMBER DEFAULT 0, 
	item varchar2(2000)
);
 */
@Data
public class CategoryVO {
	private int idx;
	private int ref;
	private int seq;
	private int lev;
	private String item;
}
