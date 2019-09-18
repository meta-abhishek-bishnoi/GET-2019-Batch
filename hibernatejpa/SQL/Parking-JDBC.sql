create database metaparking;

use metaparking;

create table employee (id int auto_increment primary key , employeeId varchar(20) unique key not null,
fullName varchar(60),gender varchar(10), emailId varchar(100) unique key,password varchar(32),
contactNo varchar(10),organisation varchar(20), profileImageUrl varchar(100),
hasVehicle boolean default false,hasPlan boolean default false); 

create table vehicle (id int auto_increment primary key,  employeeId varchar(20), vehicleName varchar(50),
vehicleType varchar(20), vehicleNumber varchar(20) unique key,identification varchar(200), amount double,
foreign key(employeeId) REFERENCES  employee(employeeId));

select * from employee;