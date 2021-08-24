-- -----------------------------------------------------
-- hr 에서 작업하세요
  select 
    e.employee_id emp_id, e.first_name || ' ' || e.last_name emp_name, e.JOB_ID JOB_ID ,
    d.department_id dept_id, d.department_name dept_name, l.city dept_city
  from
    employees E, departments D, locations L
  where
    e.department_id = d.department_id
    and
    d.location_id = L.location_id;

DROP TABLE dept_location;
create table dept_location
as
  select 
    e.employee_id emp_id, e.first_name || ' ' || e.last_name emp_name, e.JOB_ID JOB_ID ,
    d.department_id dept_id, d.department_name dept_name, l.city dept_city
  from
    employees E, departments D, locations L
  where
    e.department_id = d.department_id
    and
    d.location_id = L.location_id;

select * from dept_location;
select count(*) from dept_location;
COMMIT;

SELECT DISTINCT dept_id FROM DEPT_LOCATION ORDER BY 1; 