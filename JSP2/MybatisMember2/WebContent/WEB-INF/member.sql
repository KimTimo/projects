DROP TABLE MEMBER;
CREATE TABLE member(
    idx          INT              NOT NULL, 
    userid       VARCHAR2(20)     NOT NULL, 
    password     VARCHAR2(20)     NOT NULL, 
    username     VARCHAR2(50)     NOT NULL, 
    email        VARCHAR2(50)     NOT NULL, 
    phone        VARCHAR2(20)     NOT NULL, 
    postcode     VARCHAR2(10)     NOT NULL, 
    roadAddr     VARCHAR2(150)    NOT NULL, 
    jibunAddr    VARCHAR2(150)    NOT NULL, 
    detailAddr   VARCHAR2(150)    NOT NULL, 
    auth    	 VARCHAR2(150)    NOT NULL, 
    use          NUMBER           NOT NULL, 
    PRIMARY KEY (idx)
);
drop SEQUENCE member_idx_SEQ;
CREATE SEQUENCE member_idx_SEQ;
-- 가입을 허락하지 않을 아이디들을 미리 저장해 주자!!!!
SELECT * FROM MEMBER;
INSERT INTO MEMBER VALUES 
(member_idx_SEQ.nextval,'admin','admin','최고관리자','master@xxxx.com', '010-1111-2222','10011',' ',' ',' ',' ',1);
INSERT INTO MEMBER VALUES 
(member_idx_SEQ.nextval,'root','root','최고관리자','master@xxxx.com', '010-1111-2222','10011',' ',' ',' ',' ',1);
INSERT INTO MEMBER VALUES 
(member_idx_SEQ.nextval,'administrator','administrator','최고관리자','master@xxxx.com', '010-1111-2222','10011',' ',' ',' ',' ',1);
INSERT INTO MEMBER VALUES 
(member_idx_SEQ.nextval,'master','master','최고관리자','master@xxxx.com', '010-1111-2222','10011',' ',' ',' ',' ',1);
INSERT INTO MEMBER VALUES 
(member_idx_SEQ.nextval,'webmaster','webmaster','최고관리자','master@xxxx.com', '010-1111-2222','10011',' ',' ',' ',' ',1);

SELECT * FROM MEMBER;

UPDATE MEMBER SET email = 'itsungnam202106@gmail.com';
UPDATE MEMBER SET email = 'top2blue@naver.com' WHERE idx=5;

SELECT * FROM MEMBER;