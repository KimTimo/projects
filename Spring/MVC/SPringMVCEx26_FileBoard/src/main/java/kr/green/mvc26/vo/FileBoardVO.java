package kr.green.mvc26.vo;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

/*
DROP SEQUENCE fileBoard_idx_seq;
CREATE SEQUENCE fileBoard_idx_seq;
DROP TABLE fileBoard;
CREATE TABLE fileBoard(
	idx NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL,
	password varchar2(50) NOT NULL,
	subject varchar2(500) NOT NULL,
	content varchar2(4000) NOT NULL,
	regDate timestamp  DEFAULT SYSDATE,
	ip varchar2(50) NOT NULL
);
 */
@XmlRootElement
@Data
public class FileBoardVO {
	private int 	idx;
	private String 	name;
	private String 	password;
	private String 	subject;
	private String 	content;
	private Date 	regDate;
	private String 	ip;
	// 첨부파일의 정보를 저장할 필드 추가
	private List<FileBoardFileVO> fileList;
	
}
