CREATE SEQUENCE Employee_id_seq;
CREATE TABLE Employee (
  id NUMBER (11) primary key,
  name varchar2(20) NOT NULL,
  role varchar2(20) NOT NULL
);

SELECT * FROM tab;

select * from Employee;

insert into  Employee (id, name, role) values (Employee_id_seq.nextval,'한사람','프로그래머');
insert into  Employee (id, name, role) values (Employee_id_seq.nextval,'두사람','웹프로그래머');
insert into  Employee (id, name, role) values (Employee_id_seq.nextval,'세사람','자바팀장');

commit;

select * from Employee;

