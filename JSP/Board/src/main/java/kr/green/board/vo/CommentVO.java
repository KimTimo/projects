package kr.green.board.vo;

import java.util.Date;

import lombok.Data;

/*
CREATE TABLE comment
(
    `idx`       INT            NOT NULL    AUTO_INCREMENT COMMENT '키필드', 
    `ref`       INT            NULL        COMMENT '원본글번호', 
    `name`      VARCHAR(45)    NULL        COMMENT '이름', 
    `password`  VARCHAR(45)    NULL        COMMENT '비번', 
    `content`   TEXT           NULL        COMMENT '내용', 
    `regDate`   TIMESTAMP      default now()    COMMENT '작성일', 
    `ip`        VARCHAR(20)    NULL        COMMENT '아이피', 
     PRIMARY KEY (idx)
);
 */
@Data
public class CommentVO {
	private int    idx;
	private int    ref;
	private String name;
	private String password;
	private String content;
	private Date   regDate;
	private String ip;
}
