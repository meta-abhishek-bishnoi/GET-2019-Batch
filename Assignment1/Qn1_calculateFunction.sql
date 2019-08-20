/**
* creating calculate function for a particular month and year
*/
delimiter $$ 
create function calculate(month int, year int) returns int
begin 
declare count int;
select count(order_id) into count from ordersorders 
where extract(month from ordertime) = month and extract(year from ordertime) = year;
return count;
end $$
delimiter;

