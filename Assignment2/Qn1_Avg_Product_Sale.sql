DELIMITER //
CREATE PROCEDURE avgProductSale(IN month int, IN year int)
BEGIN
SELECT p.product_name as NAME, avg(i.quantity) as AVERAGE_UNIT
from orders as o 
inner join items as i on i.order_id = o.order_id
inner join product as p on i.product_id = p.product_id
group by p.product_name;
END //
DELIMITER;
