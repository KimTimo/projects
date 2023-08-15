-- 시퀀스를 만든다.
CREATE SEQUENCE guest_idx_seq;
-- 테이블을 만든다.
CREATE TABLE guest (
	idx NUMBER PRIMARY KEY,
	name varchar2(50) NOT NULL,
	password varchar2(50) NOT NULL,
	content varchar2(2000) NOT NULL,
	regDate timestamp  DEFAULT SYSDATE,
	ip varchar2(50) NOT NULL
);
SELECT * FROM guest;
INSERT INTO guest VALUES (guest_idx_seq.nextval, '주인장','123456','방명록입니다. 잘쓰세요',SYSDATE,'192.168.5.123');
COMMIT;
SELECT * FROM guest;