/**
* This query provides list of products which are occuring in more then one categories
*/
select distinct  p.product_id as ID, p.product_name, 
(select count(category_id)from productrelation where product_id = p.product_id) as COUNT
from product as p
inner join productrelation as pr on p.product_id = pr.product_id
inner join category as c on pr.category_id = c.category_id
where (select count(category_id) from productrelation where product_id = p.product_id) >1;

/**
* Counts of products as per category here i am using 0-5000, 50001 - 10000 and above then 10000
*/
select
case when price between 0 and 5000 then '0-5000'
when price between 5001 and 10000 then '5001-10000'
else '>10000'
end as RangeInRs,
count(product_id) as CountOfProducts
from product
group by RangeInRs;

/**
* no of products with respect to category
*/
select distinct  c.category_id as ID, c.category_name as CATEGORY, 
(select count(product_id)from productrelation where category_id = c.category_id) as PRODUCTS
from category as c
inner join productrelation as pr on c.category_id = pr.category_id
inner join product as p on pr.product_id = p.product_id
/**
*
*/
