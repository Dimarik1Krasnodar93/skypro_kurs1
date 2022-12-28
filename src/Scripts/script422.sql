create table CARS(
                     id serial primary key,
                     name text
);
create table persons (
                         id serial primary key,
                         name text,
                         age int,
                         car_id int references cars(id)
);
SELECT
    student.id id,
    student.name name,
    faculty.name facultyname
from student
         LEFT JOIN faculty on student.faculty_id = faculty.id;

