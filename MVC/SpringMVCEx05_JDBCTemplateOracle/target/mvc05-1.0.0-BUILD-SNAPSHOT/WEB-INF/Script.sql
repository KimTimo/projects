CREATE SEQUENCE people_idx_seq;
create table people (
	id int primary key,
	name varchar(40) not null,
	age integer default 0
);

insert into people VALUES (people_idx_seq.nextval, 'Vlad Boyarskiy', 21);
insert into people VALUES (people_idx_seq.nextval, 'Oksi  Bahatskaya', 30);
insert into people VALUES (people_idx_seq.nextval, 'Vadim  Vadimich', 32);


select * from people;
commit;