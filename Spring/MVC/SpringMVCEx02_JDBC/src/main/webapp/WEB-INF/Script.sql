drop table Employee;
CREATE TABLE `Employee` (
  `id` int(11) primary key auto_increment,
  `name` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

show tables;

select * from Employee;

insert into  Employee (name, role) values 
   ('김상어','집주인'),
   ('안자몽','곤듀집주인'),
   ('안몽쉘','곤듀바보');

commit;

select * from Employee;