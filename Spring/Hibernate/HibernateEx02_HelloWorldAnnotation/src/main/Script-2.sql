CREATE SEQUENCE student_idx_seq;

CREATE TABLE student(
	idx NUMBER PRIMARY KEY,
	name varchar2(60) NOT NULL,
	SECTION varchar2(30) NOT NULL 
);

SELECT * FROM tab;

SELECT * FROM student;