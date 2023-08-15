-- 시큐리트 적용할 멤버 테이블
CREATE SEQUENCE smember_idx_seq;
DROP TABLE smember;
CREATE TABLE smember(
	idx 		NUMBER	PRIMARY KEY,
	userid  	varchar2(50)  NOT NULL,
	password  	varchar2(200) NOT NULL,
	uuid  		varchar2(200) NULL,
	username	varchar2(50)  NOT NULL,
    email       VARCHAR2(100)    NULL, 
    birth       DATE         	 NULL, 
    phone       VARCHAR2(20)     NULL, 
    zipcode     VARCHAR2(10)     NULL, 
    addr1       VARCHAR2(100)    NULL, 
    addr2       VARCHAR2(100)    NULL, 
    enabled     NUMBER(1)        DEFAULT 0, 
    regdate     TIMESTAMP        DEFAULT SYSDATE	
);

SELECT * FROM SMEMBER;

CREATE SEQUENCE smember_roles_idx_seq;
DROP TABLE smember_roles;
CREATE TABLE smember_roles(
	idx 		NUMBER	PRIMARY KEY,
	username	varchar2(50)  NOT NULL,
	role	varchar2(50)  NOT NULL
);


SELECT * FROM smember_roles;

CREATE TABLE t(birth       date);

SELECT * FROM t;

INSERT INTO t VALUES ('2021-11-08');


CREATE SEQUENCE fileBoard_idx_seq;
CREATE TABLE fileBoard(
	idx NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL,
	password varchar2(50) NOT NULL,
	subject varchar2(500) NOT NULL,
	content varchar2(4000) NOT NULL,
	regDate timestamp  DEFAULT SYSDATE,
	ip varchar2(50) NOT NULL
);

SELECT * FROM FILEBOARD;


-- 해당글의 첨부파일 정보를 저장할 테이블
CREATE SEQUENCE fileBoardFile_idx_seq;
CREATE TABLE fileBoardFile(
	idx NUMBER PRIMARY KEY,			 -- 키필드
	REF NUMBER DEFAULT 0,            -- 몇번글의 첨파일이냐를 저장할 원본글 번호
	saveName varchar2(500) NOT NULL, -- 저장파일명
	oriName  varchar2(500) NOT NULL  -- 원본파일명
);

SELECT * FROM fileBoard;
SELECT * FROM fileBoardFile;
