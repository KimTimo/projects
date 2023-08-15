create table people (
	id int primary key auto_increment,
	name varchar(40) not null,
	age integer default 0
);

insert into people (name, age) values
('Vlad Boyarskiy', 21),
('Oksi  Bahatskaya', 30),
('Vadim  Vadimich', 32);

select * from people;
commit;