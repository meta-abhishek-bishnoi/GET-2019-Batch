create database cities;

use cities;

create table zipcodes (id int auto_increment primary key, zipcode int, city varchar(50), state varchar(50));

insert into zipcodes(zipcode, city, state) values(335051,'Raisinghnagar, Sri Ganganagar','Rajasthan'),
(110001,'New Dehli','Dehli'),(302022,'Sitapura, Jaipur','Rajasthan'),(302023,'Haldighati, Jaipur','Rajasthan'),
(127307,'Achina, Bhiwani','Haryana'),(152116,'Abhoar, Firozpur','Punjab');

select zipcode, city, state from zipcodes 
order by state, city;