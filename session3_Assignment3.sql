/**
* this query show users with their order counts in last 30 days
*/
select distinct u.first_name as FIRST_NAME, u.last_name as LAST_NAME, 
(select count(order_id)from orders where customer_id = u.user_id AND DATEDIFF(CURRENT_TIMESTAMP(), o.ordertime)<30) as LATEST_ORDER
from user as u
left join orders as o on o.customer_id = u.user_id
inner join role as r on u.user_id = r.user_id
order by LATEST_ORDER desc;
/**
* 10 shoppers with max revenue
*/
select u.first_name as FIRST_NAME, u.last_name as LAST_NAME, sum(p.price*i.quantity) as AMOUNT
from user as u
inner join orders as o on u.user_id = o.customer_id
inner join items as i on o.order_id = i.order_id
inner join product as p on p.product_id = i.product_id
inner join role as r on u.user_id = r.user_id
group by u.first_name, u.last_name
order by AMOUNT desc
limit 10;

/**
* top 20 products ordered most
*/
select p.product_name as NAME , sum(i.quantity) as Quantity
from orders as o
inner join items as i on i.order_id = o.order_id
inner join product as p on p.product_id = i.product_id
where datediff(curdate(),o.ordertime) <= 60
group by NAME
order by Quantity desc
limit 20;

/**
* mothwise sales revenue of last 3 months 
*/
select EXTRACT(MONTH FROM o.ordertime) as MONTH, sum(i.quantity*p.price) as TOTAL
from orders as o 
inner join items as i on i.order_id = o.order_id
inner join product as p on p.product_id = i.product_id
where datediff(curdate(),o.ordertime)/365 < 1
group by MONTH
limit 6;

/**
* inactivating product which are not sold from last 90 days
*/
update product as pr
left join items as i on i.product_id = pr.product_id 
left join orders as o on o.order_id = i.order_id 
set productstatus='inactive'
where datediff(curdate(),o.ordertime) > 90; 
/**
* show all products of category/categries
*/
select p.product_name as PRODUCT, c.category_name as CATEGORY
from category as c
inner join productrelation as pr on pr.category_id = c.category_id
inner join product as p on p.product_id = pr.product_id
where  category_name like '%men%';
/**
* top 10 cancelled items
*/
select p.product_name as NAME, count(i.status) as COUNT
from items as i 
inner join orders as o on i.order_id = o.order_id
inner join product as p on i.product_id = p.product_id
where i.status like 'cancelled'
group by NAME
limit 10;