package kr.green.board.vo;

import java.util.Date;
import java.util.List;

import lombok.Data;
/*
CREATE TABLE board
(
    `idx`       INT              NOT NULL    AUTO_INCREMENT COMMENT '키필드', 
    `name`      VARCHAR(45)      NULL        COMMENT '이름', 
    `password`  VARCHAR(45)      NULL        COMMENT '비번', 
    `subject`   VARCHAR(1000)    NULL        COMMENT '제목', 
    `content`   TEXT             NULL        COMMENT '내용', 
    `regDate`   TIMESTAMP        default now()     COMMENT '작성일', 
    `ip`        VARCHAR(20)      NULL        COMMENT '아이피', 
    `hit`       INT              default 0        COMMENT '조회수', 
     PRIMARY KEY (idx)
);

ALTER TABLE board COMMENT '게시판테이블';
 */
@Data
public class BoardVO {
	private int    idx;
	private String name;
	private String password;
	private String subject;
	private String content;
	private Date   regDate;
	private int    hit;
	private String ip;
	
	// 두개를 추가한다.
	private int    commentCount; // 댓글의 개수를 저장할 변수 -- 복록보기
	private List<CommentVO> list; // 댓글들을 저장할 리스트 변수 -- 내용보기
}
