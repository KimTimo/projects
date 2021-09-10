create table memo( -- 테이블이름 memo
	idx int primary key auto_increment, -- 기본키
	name varchar(30) not null, -- 작성자
	password varchar(50) not null, -- 비밀번호
	content text not null, -- 내용
	regDate timestamp default now(), -- 작성일
	ip varchar(20) -- 사용자 아이피
);

show tables;


delete from memo;
commit;

insert into memo 
	(name,password,content,regdate,ip)
values
	('한사람','1234','와 일빠다~~~', now(), '192.168.5.123'),
	('두사람','1234','와 이빠다~~~', now(), '192.168.5.45'),
	('세사람','1234','와 삼빠다~~~', now(), '192.168.5.23'),
	('네사람','1234','와 4등이다!!!', now(), '192.168.5.78'),
	('오사람','1234','ㅠㅠ 5등이네.....', now(), '192.168.5.111');
commit;
select * from memo;
