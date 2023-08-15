-- =======================================================================================================
DROP SEQUENCE category_idx_seq;
CREATE SEQUENCE category_idx_seq;
drop TABLE category;
CREATE TABLE category(
	idx NUMBER PRIMARY KEY,
	ref NUMBER,
	seq NUMBER DEFAULT 0, 
	lev NUMBER DEFAULT 0, 
	item varchar2(2000)
);
SELECT * FROM category;
INSERT INTO category VALUES (category_idx_seq.nextval, category_idx_seq.currval, 0, 0 ,'가전제품'); 
INSERT INTO category VALUES (category_idx_seq.nextval, category_idx_seq.currval, 0, 0 ,'의류'); 
SELECT * FROM category;
INSERT INTO category VALUES (category_idx_seq.nextval, 1, 1, 1 ,'냉장고'); 
INSERT INTO category VALUES (category_idx_seq.nextval, 1, 2, 1 ,'TV'); 
INSERT INTO category VALUES (category_idx_seq.nextval, 2, 1, 1 ,'셔츠'); 
INSERT INTO category VALUES (category_idx_seq.nextval, 2, 2, 1 ,'점퍼'); 
SELECT * FROM category;
SELECT idx, LPAD(' ', lev*5,' ')||item  FROM category ORDER BY ref DESC, seq ASC;

-- =======================================================================================================
-- 삭제를 하려면 어떻게 해야 할까요?
SELECT idx, LPAD(' ', lev*5,' ')||item  FROM category ORDER BY ref DESC, seq ASC;
-- 대항목의 경우는 아래의 모든 것을 구해서 삭제하면 된다.
SELECT idx, LPAD(' ', lev*5,' ')||item  FROM category WHERE REF = 38 ORDER BY ref DESC, seq ASC;
SELECT idx, LPAD(' ', lev*5,' ')||item  FROM category WHERE REF = 21 ORDER BY ref DESC, seq ASC;
SELECT idx, REF, seq, lev, LPAD(' ', lev*5,' ')||item  FROM category ORDER BY ref DESC, seq ASC;

-- 대항목 삭제
-- 대항목 삭제 쿼리 : ref가 같으면 모두 삭제
SELECT * FROM	category WHERE 	REF = 21 ;

SELECT idx, REF, seq, lev, LPAD(' ', lev*5,' ')||item  FROM category ORDER BY ref DESC, seq ASC;

-- 소항목 삭제
SELECT idx, REF, seq, lev, LPAD(' ', lev*5,' ')||item  FROM category ORDER BY ref DESC, seq ASC;

SELECT idx, REF, seq, lev, LPAD(' ', lev*5,' ')||item 
FROM category 
WHERE REF=2 AND seq>1
ORDER BY ref DESC, seq ASC;







