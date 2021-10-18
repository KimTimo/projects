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
    birth       date         	 NULL, 
    phone       VARCHAR2(20)     NULL, 
    zipcode     VARCHAR2(10)     NULL, 
    addr1       VARCHAR2(100)    NULL, 
    addr2       VARCHAR2(100)    NULL, 
    enabled     NUMBER(1)        DEFAULT 0, 
    regdate     TIMESTAMP        DEFAULT SYSDATE	
);

SELECT * FROM SMEMBER;

CREATE SEQUENCE smember_roles_idx_seq;

CREATE TABLE smember_roles(
	idx 		NUMBER	PRIMARY KEY,
	username	varchar2(50)  NOT NULL,
	role	varchar2(50)  NOT NULL
);


SELECT * FROM smember_roles;

CREATE TABLE t(birth       date);

SELECT * FROM t;

INSERT INTO t VALUES ('2021-10-11');



