create table memo( -- 테이블이름 memo
	idx int primary key auto_increment, -- 기본키
	name varchar(30) not null, -- 작성자
	password varchar(50) not null, -- 비밀번호
	content text not null, -- 내용
	regDate timestamp default now(), -- 작성일
	ip varchar(20) -- 사용자 아이피
);

show tables;

