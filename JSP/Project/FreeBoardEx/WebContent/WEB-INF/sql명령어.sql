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

ALTER TABLE freeboard COMMENT '자유게시판';

show tables;

-- sample데이터를 넣어보자
insert into freeboard (name, password, subject, content, ip) values 
	('한사람','1234','나는 제목 1','나는 내용 1','192.168.0.12'),
	('한사람','1234','나는 제목 2','나는 내용 2','192.168.0.12'),
	('한사람','1234','나는 제목 3','나는 내용 3','192.168.0.12'),
	('한사람','1234','나는 제목 4','나는 내용 4','192.168.0.12'),
	('한사람','1234','나는 제목 5','나는 내용 5','192.168.0.12'),
	('한사람','1234','나는 제목 6','나는 내용 6','192.168.0.12'),
	('한사람','1234','나는 제목 7','나는 내용 7','192.168.0.12');
commit;