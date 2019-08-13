/**
* creating database storefront
*/
create database storefront;
use storefront;

/**
* user table contaions password of all users and their authentication type
*/
create table user (
	user_id int NOT NULL AUTO_INCREMENT primary key, 
	username varchar(50) unique, 
	password varchar(50), 
	role char(1) CHECK( role in ('A','S'))
);


/**
* shopper is a classification of user class
* this class contains user_id as a foreign key of user table
*/
create table shopper(
	sn int not null auto_increment primary key, 
	user_id int, 
	fullname varchar(50), 
	foreign key(user_id) references user(user_id)
);

/**
* this address table stores delivery address wrt to each shopper 
* where it contains user_id as foreign key
*/
create table address(
	address_id int not null auto_increment primary key,
	user_id int,
	contact_person varchar(50),
	address varchar(200),
	contact_no BIGINT,
	email varchar(50),
	foreign key(user_id) references user(user_id)
);

/**
* this table contains category of product if it is top most category parent category id is 0
*/
create table category(
	category_id int not null auto_increment primary key,
	parent_key int default null,
	category_name varchar(50),
	description varchar(200)
);

/**
* This table contains product informations
*/
create table product(
	product_id int not null auto_increment primary key,
	product_name varchar(50),
	price double,
	stock int,
	description varchar(200)
);


/**
* this table is created to decide relation between 
*/

create table productrelation(
	sn int not null auto_increment primary key,
	product_id int,
	category_id int,
	foreign key(product_id) REFERENCES product(product_id),
	foreign key(category_id) REFERENCES category(category_id)
);

/**
* this table contains images url wrt to product id
*/

create table images(
	image_id int NOT NULL AUTO_INCREMENT primary key,
	image_url varchar(200) not null,
	product_id int,
	foreign key(product_id) REFERENCES product(product_id)
);

/**
* order table contains details of order
*/

create table orders(
	order_no int auto_increment not null primary key,
	customer_id int,
	address_id int,
	product_id int,
	ordertime datetime,
	quantity int,
	status varchar(50) check(status IN ('shipped','delivered','pending')),
	foreign key(customer_id) references user(user_id),
	foreign key(address_id) references address(address_id),
	foreign key(product_id) REFERENCES product(product_id)
);

/**
* here we are droping product table, here product's id is used as foreign key 
* sp either delete all foreign key references from all tables or just disable foreign key check
*/

SET FOREIGN_KEY_CHECKS=0; DROP TABLE product; SET FOREIGN_KEY_CHECKS=1;

/**
* creating again product table
*/

create table product(
	product_id int not null auto_increment primary key,
	product_name varchar(50),
	price double,
	stock int,
	description varchar(200)
);