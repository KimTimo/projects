-- 회원테이블을 만들고 샘플 데이터를 넣어보자
create table tmember(
	idx int primary key auto_increment,
	userid varchar(30) not null,
	password varchar(50) not null,
	nickname varchar(40) not null,
	point  int default(0)
);
insert into tmember (userid,password,nickname,point) value 
	('admin',password('1234'),'최고관리자',123),

insert into tmember (userid,password,nickname,point) value 
	('admin1',password('1234'),'최고관리자',123),
	('admin2',password('1234'),'관리자',34),
	('root',password('1234'),'망나니',21),
	('administrator',password('1234'),'나그네',1000),
	('root1',password('1234'),'지나는이',45),
	('root2',password('1234'),'나그네2',87),
	('root12',password('1234'),'김선달',129),
	('admin3',password('1234'),'최달봉',444);


select * from tmember;
select count(*) from tmember where userid='root';
select count(*) from tmember where userid='root7';
commit;