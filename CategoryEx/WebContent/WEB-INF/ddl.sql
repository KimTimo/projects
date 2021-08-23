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
