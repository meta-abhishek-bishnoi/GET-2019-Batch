/**
* creating index for product
*/
create index product_index on product(product_id);
SHOW INDEXES FROM product;
 
/**
* creting index cluster for order 
*/
create index order_index on orders(customer_id);
show indexes from orders;

/**
* creating cluster on parent key
*/
CREATE INDEX parent_index ON category(parent_key);

SHOW INDEXES FROM category;

