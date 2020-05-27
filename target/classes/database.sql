-- Table: students
create table students
(
    rollno int          not null auto_increment primary key,
    name   varchar(255) not null,
    marks  int          not null
);

-- Table: laptops
create table laptops
(
    lid   int          not null auto_increment primary key,
    lname varchar(255) not null
);

--
create table student_laptop
(
    id             int not null auto_increment primary key,
    student_rollno int not null,
    laptop_id      int not null,

    foreign key (student_rollno) references students (rollno),
    foreign key (laptop_id) references laptops (lid)
)

-- insert into
insert into students values(101,'Taleh',100);
insert into students values(102,'Ilkin',50);

insert into laptops values(1,'HP');
insert into laptops values(2,'DELL');

insert into student_laptop values(1,101,1);
insert into student_laptop values(2,101,2);
insert into student_laptop values(3,102,1);

select * from laptops;
