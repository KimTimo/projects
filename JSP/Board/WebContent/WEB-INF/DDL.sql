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

ALTER TABLE comment COMMENT '댓글테이블';

show tables;
