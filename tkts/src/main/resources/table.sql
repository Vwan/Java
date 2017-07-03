use rest;
create table book1(
    isbn varchar(50) primary key,
    name varchar(30) not null,
    author varchar(20) not null,
    price numeric(10,2)
);

create table book(
    isbn varchar(50) ,
    name varchar(30) not null ,
    author varchar(20) not null,
    price numeric(10,2)  ,
	primary key (isbn,name)
    );