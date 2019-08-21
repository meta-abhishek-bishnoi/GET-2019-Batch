/**
* creating index for product
*/
create index product_index on product(product_name);
SHOW INDEXES FROM product;
 
/**
* creting indexes 
*/
create index order_index_user on orders(customer_id);
create index order_index_time on orders(ordertime);
show indexes from orders;

/**
* creating indexes
*/
CREATE INDEX category_index ON category(parent_key);
CREATE INDEX category_index_name ON category(category_name);
SHOW INDEXES FROM category;