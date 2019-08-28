/**
*/
delimiter //
create function monthHaveMaxOrder(year int) returns int
begin 
declare resultmonth int;
select extract(month from ordertime) into resultmonth from orders where extract(year from ordertime) = year
order by resultmonth
limit 1;
return resultmonth;
end //
delimiter;