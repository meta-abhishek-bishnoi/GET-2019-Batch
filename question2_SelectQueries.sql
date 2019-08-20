/**
*
* Selecting Data Using inner join and displaying 
*/
select p.product_id as ID,
p.product_name as NAME,
c.category_name as CATEGORY,
p.price as PRICE
from product as p inner join productrelation as pr on p.product_id = pr.product_id
inner join category as c on pr.category_id = c.category_id
where p.stock > 0
order by p.product_id desc;

/**
* This Provides Data from Images Where Images are null
*/
select p.product_name as NAME
from product as p left outer join images as i on p.product_id = i.product_id
where image_id is null;

/**
* Selecting data for parent category where root category is set as Top Category
*/
select c.category_id,c.category_name,ifnull(d.category_name,'Top Category') as parent
from category c left outer join category d on c.parent_key = d.category_id
order by d.category_name,c.category_name;

/**
* Display parent key of all  leaf categories
*/
select c.category_id,c.category_name,d.category_name as parent
from category c right outer join category d on c.parent_key = d.category_id
where c.category_name is not null;
/**
* display data fro a category
*/
select p.product_name,p.price
from product as p inner join productrelation as pr on p.product_id = pr.product_id
inner join category as c on pr.category_id = c.category_id
where c.category_name = 'women';

/**
* show products which have stock less then 50
*/
select product_name
from product
where stock < 50;