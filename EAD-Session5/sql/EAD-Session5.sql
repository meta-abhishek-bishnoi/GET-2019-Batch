create database shopping;
use shopping;
create table product(product_code int auto_increment primary key, product_type varchar(50), product_name varchar(50), product_price double);
create table orders(order_id int auto_increment primary key, product_code int, quantity int, foreign key(product_code)
REFERENCES product(product_code)); 
