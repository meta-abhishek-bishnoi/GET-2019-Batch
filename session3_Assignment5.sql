/**
* creating view
*/
create view view_orders as 
select o.order_id as ID, p.product_name as TITLE, p.price as PRICE, u.first_name as SHOPPER, u.email as EMAIL,
o.ordertime as TIME, i.status as ORDER_STATUS 
from items as i
inner join orders as o on o.order_id = i.order_id
inner join product as p on p.product_id = i.product_id
inner join user as u on o.customer_id = u.user_id
order by ID;
/**
* getting shipped products
*/

select TITLE from view_orders where ORDER_STATUS like 'shipped';
/**
* topmost selling products
*/

select TITLE, count(TITLE) as COUNT from view_orders 
group by TITLE
order by COUNT desc
limit 5;
