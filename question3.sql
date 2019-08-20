/**
* Showing last 50 orders
*/ 
select o.order_id as ORDER_ID, o.ordertime as ORDER_TIME, p.price * i.quantity as AMOUNT 
from orders as o inner join items as i on o.order_id = i.order_id
inner join product as p on p.product_id = i.product_id
group by order_id
order by ordertime desc
limit 50;
/**
* 10 most expensive orders
*/
select o.order_id as ORDER_ID, o.ordertime as ORDER_TIME, p.price * i.quantity as AMOUNT 
from orders as o inner join items as i on o.order_id = i.order_id
inner join product as p on p.product_id = i.product_id
group by order_id
order by AMOUNT desc
limit 10;
/**
* showing pending items ordered 10 days ago
*/
select o.order_id as Order_Id, p.product_name as NAME, o.ordertime AS TIME
from items as i inner join orders as o on i.order_id = o.order_id
inner join product as p on i.product_id = p.product_id
where i.status like 'pending' AND DATEDIFF(CURRENT_TIMESTAMP(), o.ordertime)>10;

/**
* showing name of users who doesn't orders more then 1 month
*/
select u.first_name as FIRST_NAME, u.last_name as LAST_NAME
from user as u inner join orders as o on u.user_id = o.customer_id
inner join role as r on u.user_id = r.user_id
where datediff(curdate(),o.ordertime)/30 >= 1 and r.role = 'Shopper';
/**
* list of users ordered in last 15 days
*/
select u.first_name as FIRST_NAME, u.last_name as LAST_NAME, o.order_id as ORDER_ID
from user as u inner join orders as o on u.user_id = o.customer_id
inner join role as r on u.user_id = r.user_id
where datediff(curdate(),o.ordertime) < 15  and r.role = 'Shopper';
/**
* products which are shipped for a particular order id
*/
select product_id from items where status like 'shipped' AND order_id = 3;

/**
* products orders in range
*/
select i.product_id as ID,o.ordertime as DATE_TIME 
from orders as o inner join items as i on o.order_id=i.order_id
inner join product p on p.product_id = i.product_id
where p.price between 1000 and 50000;