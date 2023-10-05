-- We add this line because every time we build our app the same table tried to create and give exception.
drop table IF exists EMPLOYEES;

create table EMPLOYEES(

                          id bigint not null,
                          name varchar(255),
                          primary key (id)

);