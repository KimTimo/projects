DROP SEQUENCE hanjatest_idx_seq;
CREATE SEQUENCE hanjatest_idx_seq;
/*
 * 	private String d;
	private String s;
	private String n;
	private String q;
	private String e1;
	private String e2;
	private String e3;
	private String e4;
	private String a;
 */
DROP TABLE hanjatest;
CREATE TABLE hanjatest(
	idx NUMBER PRIMARY KEY,
	d   varchar2(200) NOT NULL,
	s   varchar2(200) NOT NULL,
	n   varchar2(200) NOT NULL,
	q   varchar2(200) NOT NULL,
	e1   varchar2(200),
	e2   varchar2(200),
	e3   varchar2(200),
	e4   varchar2(200),
	a    varchar2(200) NOT NULL
);


-- ==========================================
-- insert into EXAM_RESULT(STUDENT_NAME, DOB, PERCENTAGE) values (?, ?, ?)
CREATE SEQUENCE EXAM_RESULT_idx_seq;

CREATE TABLE EXAM_RESULT(
	idx NUMBER PRIMARY KEY,
	STUDENT_NAME varchar2(100),
	DOB TIMESTAMP,
	PERCENTAGE NUMBER(10,2)
);

SELECT * FROM EXAM_RESULT;

-- 운전 면허 필기 문제 테이블
/*
idx: 985,
type: 5,
question: "다음 3방향 도로명 예고표지에 대한 설명으로 맞는 것은?",
ans1: "좌회전하면 300미터 전방에 시청이 나온다.",
ans2: "관평로'는 북에서 남으로 도로구간이 설정되어 있다.",
ans3: "우회전하면 300미터 전방에 평촌역이 나온다.",
ans4: "직진하면 300미터 전방에 '관평로'가 나온다.",
cor1: 4,
cor2: 0,
desc: "도로구간은 서→동, 남→북으로 설정되며, 도로의 시작지점에서 끝지점으로 갈수록 건물번호가 커진다.",
contents: "contents_985.jpg"
*/
DROP TABLE license;
CREATE TABLE license(
	idx NUMBER PRIMARY KEY,
	"TYPE" NUMBER,
	question varchar2(400) NOT NULL,
	ans1 varchar2(400),
	ans2 varchar2(400),
	ans3 varchar2(400),
	ans4 varchar2(400),
	ans5 varchar2(400),
	cor1 NUMBER DEFAULT 0,
	cor2 NUMBER DEFAULT 0,
	"DESC" varchar2(4000),	
	contents varchar2(400)		
);


SELECT count(*) FROM LICENSE;

DROP TABLE license2;
CREATE TABLE license2(
	idx NUMBER PRIMARY KEY,
	"TYPE" NUMBER,
	question varchar2(400) NOT NULL,
	ans1 varchar2(400),
	ans2 varchar2(400),
	ans3 varchar2(400),
	ans4 varchar2(400),
	ans5 varchar2(400),
	cor1 NUMBER DEFAULT 0,
	cor2 NUMBER DEFAULT 0,
	"DESC" varchar2(4000),	
	contents varchar2(400)		
);


SELECT count(*) FROM LICENSE2;

