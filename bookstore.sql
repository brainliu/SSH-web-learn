create database bookstore;
use bookstore;
create table category(
	id varchar(100) primary key,
	name varchar(100) not null unique,
	description varchar(255)
);
create table book(
	id varchar(100) primary key,
	name varchar(100) not null,
	author varchar(100),
	money float(8,2),
	description varchar(255),
	path varchar(100),
	oldImageName varchar(100),
	newImageName varchar(100),
	categoryId varchar(100),
	constraint categoryId_fk foreign key(categoryId) references category(id) 
);