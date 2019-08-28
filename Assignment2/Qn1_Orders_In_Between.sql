DELIMITER //
CREATE PROCEDURE ordersInBetween(IN fromDate date, IN tillDate date)
BEGIN
DECLARE startDate date;
if(fromDate>tillDate) then 
	select o.order_id as ID, o.ordertime as ORDER_TIME, p.product_name as NAME, i.quantity as QUNATITY, (p.price * QUANTITY) as ORDER_AMOUNT
	from orders as o
	inner join items as i on o.order_id = i.order_id
	inner join product as p on p.product_id = i.product_id
	where o.ordertime >= tillDate and o.ordertime <= startDate
	order by ID;
else
	select o.order_id as ID, o.ordertime as ORDER_TIME, p.product_name as NAME, i.quantity as QUNATITY, (p.price * QUANTITY) as ORDER_AMOUNT
	from orders as o
	inner join items as i on o.order_id = i.order_id
	inner join product as p on p.product_id = i.product_id
	where o.ordertime >= fromDate and o.ordertime <= tillDate
	order by ID;
end if;


END //
DELIMITER;
