drop database parking;
create database parking;
use parking;

create table employee(sn int auto_increment primary key, employee_id varchar(20) unique key not null, employee_name varchar(50) not null,
employee_gender varchar(10) not null, employee_email varchar(100) unique key, employee_password varchar(40), 
employee_contact varchar(10), employee_oragnization varchar(20), isVehicle int default 0,  isPlan int default 0);


create table vehicle (sn int auto_increment primary key, employee_email varchar(100) unique key, 
vehicle_type varchar(20), vehicle_number varchar(20) unique key, description varchar(100),amount double,
foreign key (employee_email) REFERENCES employee(employee_email));

/*drop table vehicle;
drop database parking;
*/
create table plans (sn int auto_increment primary key, vehicle_type varchar(20), daily double, monthly double, yearly double);