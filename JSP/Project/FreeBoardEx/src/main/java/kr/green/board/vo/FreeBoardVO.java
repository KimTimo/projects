package kr.green.board.vo;

import java.util.Date;

import lombok.Data;
/*
CREATE TABLE freeboard
(
    `idx`       INT             NOT NULL    AUTO_INCREMENT COMMENT '키필드', 
    `name`      VARCHAR(45)     NOT NULL    COMMENT '이름', 
    `password`  VARCHAR(45)     NOT NULL    COMMENT '비밀번호', 
    `subject`   VARCHAR(200)    NOT NULL    COMMENT '제목', 
    `content`   TEXT            NOT NULL    COMMENT '내용', 
    `regDate`   TIMESTAMP       NOT NULL    default now() COMMENT '작성일', 
    `hit`       INT             NOT NULL    default 0     COMMENT '조회수', 
    `ip`        VARCHAR(20)     NOT NULL    COMMENT '아이피', 
     PRIMARY KEY (idx)
);
 */
@Data
public class FreeBoardVO {
	private int    idx;
	private String name;
	private String password;
	private String subject;
	private String content;
	private Date   regDate;
	private int    hit;
	private String ip;
}
