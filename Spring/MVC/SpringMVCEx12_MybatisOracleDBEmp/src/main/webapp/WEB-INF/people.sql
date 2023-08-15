CREATE SEQUENCE people_id_seq;
create table people (
	id number primary key,
	name varchar2(40) not null,
	age number default 0
);

insert into people (id, name, age) VALUES (people_id_seq.nextval,'Vlad Boyarskiy', 21);
insert into people (id, name, age) VALUES (people_id_seq.nextval,'Oksi  Bahatskaya', 21);
insert into people (id, name, age) VALUES (people_id_seq.nextval,'Vadim  Vadimich', 21);


select * from people;
commit;