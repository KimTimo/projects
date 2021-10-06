-- 방명록 테이블 만들기
create table guestbook( -- 테이블이름 guestbook
	idx int primary key auto_increment, -- 기본키
	name varchar(30) not null, -- 작성자
	password varchar(50) not null, -- 비밀번호
	content text not null, -- 내용
	regDate timestamp default now(), -- 작성일
	ip varchar(20) -- 사용자 아이피
);
-- mariadb에서 암호화 하는 방법
select password('1234'), length(password('12345678'));
select md5('1234'), length(md5('12345678'));
select sha('1234'), length(sha('12345678'));

show tables;

INSERT INTO guestbook (name,password,content,ip) VALUES ('한사람','1234','나는
내용이 맞아요 1','192.168.0.7');
INSERT INTO guestbook (name,password,content,ip) VALUES ('두사람','1234','나는
내용이 맞아요 2','192.168.0.7');
INSERT INTO guestbook (name,password,content,ip) VALUES ('세사람','1234','<b>
나는 내용이 맞아요 3</b>','192.168.0.7');
INSERT INTO guestbook (name,password,content,ip) VALUES ('네사람','1234','나는
내용이 맞아요 4','192.168.0.7');
INSERT INTO guestbook (name,password,content,ip) VALUES ('오사람','1234','나는
<h1>내용</h1>이 맞아요 5','192.168.0.7');

commit;

select * from guestbook;