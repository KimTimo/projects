--
CREATE SEQUENCE event_idx_seq;
CREATE TABLE event(
	idx NUMBER PRIMARY KEY,
	title varchar2(100),
	description varchar2(100),
	startDate varchar2(100),
	endDate varchar2(100),
	type varchar2(100),
	username varchar2(100),
	backgroundColor varchar2(100),
	textColor varchar2(100),
	allDays CHAR(1) CONSTRAINT booleantest_verified_CK CHECK(allDay IN ('0', '1'))
);

-- 데이터 삽입
INSERT INTO event VALUES 
(event_idx_seq.nextval, '거래처 미팅','추가설명','2021-09-07T09:30','2021-09-07T15:00','카테고리1','다현','#D25565','#ffffff', 0);
INSERT INTO event VALUES 
(event_idx_seq.nextval, '치과예약','추가설명','2021-09-01T12:30','2021-09-01T15:20','카테고리1','나현','#9775fa','#ffffff', 0);
INSERT INTO event VALUES 
(event_idx_seq.nextval, '철수 생일','추가설명','2021-09-12','2021-09-12','카테고리2','다현','#ffa94d','#ffffff', 1);
INSERT INTO event VALUES 
(event_idx_seq.nextval, '멜론 만기','추가설명','2021-09-06','2021-09-06','카테고리2','지효','#74c0fc','#ffffff', 1);
INSERT INTO event VALUES 
(event_idx_seq.nextval, '청약 입금','추가설명','2021-09-08','2021-09-08','카테고리3','지효','#f06595','#ffffff', 1);
INSERT INTO event VALUES 
(event_idx_seq.nextval, '카드값 납부','추가설명','2021-09-14','2021-09-14','카테고리2','사나','#D25565','#ffffff', 1);
INSERT INTO event VALUES 
(event_idx_seq.nextval, '휴가','추가설명','2021-09-18','2021-09-20','카테고리4','사나','#a9e34b','#ffffff', 1);
INSERT INTO event VALUES 
(event_idx_seq.nextval, '세차예약','추가설명','2021-09-24T09:30','2021-09-24T12:00','카테고리3','정연','#4d638c','#ffffff', 0);
INSERT INTO event VALUES 
(event_idx_seq.nextval, '출장','추가설명','2021-09-28','2021-09-30','카테고리3','정연','#D25565','#ffffff', 0);
INSERT INTO event VALUES 
(event_idx_seq.nextval, '접수기간','추가설명','2021-09-15','2021-09-21','카테고리2','다현','#9775fa','#ffffff', 1);
INSERT INTO event VALUES 
(event_idx_seq.nextval, '내일정','추가설명','2021-09-01','2021-09-10','카테고리3','다현','#9775fa','#ffffff', 1);

SELECT * FROM event;
COMMIT;

SELECT 
	idx, title, DESCRIPTION , STARTDATE , ENDDATE , "TYPE" , USERNAME , BACKGROUNDCOLOR , TEXTCOLOR , ALLDAY 
FROM 
	event;
	
SELECT 
	idx AS "_id", title, DESCRIPTION , 
	STARTDATE "start" , ENDDATE "end" , "TYPE" , 
	USERNAME , BACKGROUNDCOLOR , TEXTCOLOR , DECODE(ALLDAYs,'0','false','1','true') AS "ALLDAY"
FROM 
	event;
COMMIT;	