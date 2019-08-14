/**
* adding users
*/
insert into user(username, password, role) values('meta-abhi','metacube','A');
insert into user(username, password, role) values('meta-yashi','metacube','S');
insert into user(username, password, role) values('meta-manoj','metacube','S');
insert into user(username, password, role) values('abhi29','metacube','S');
/**
* adding shoppers
*/
insert into shopper(user_id, fullname) values (2, 'Yatika Bansal');
insert into shopper(user_id, fullname) values (3, 'Manoj Sharma');
insert into shopper(user_id, fullname) values (4, 'Abhishek Bishnoi');
/**
* adding shopers delivery address
*/
insert into address(user_id, contact_person, address, contact_no, email) values (2,'Yatika','Jaipur',129865,'yb@xu.in');
insert into address(user_id, contact_person, address, contact_no, email) values (2,'Yatika','Jodhpur',543865,'yb@xu.in');
insert into address(user_id, contact_person, address, contact_no, email) values (3,'Manoj','Jaipur',186565,'ms@xyu.in');
insert into address(user_id, contact_person, address, contact_no, email) values (3,'Manoj','Kota',686565,'ms@xyu.in');
insert into address(user_id, contact_person, address, contact_no, email) values (4,'Abhishek','Jaipur',998270,'ab@xu.in');
insert into address(user_id, contact_person, address, contact_no, email) values (4,'Abhishek','Sri Ganganagar',6776565,'ab@xyu.in');
/**
* adding category
*/
insert into category(parent_key,category_name,description) values (0, 'electronics', 'contains electronics items');
insert into category(parent_key,category_name,description) values (0, 'kitchen', 'contains kitchen items');
insert into category(parent_key,category_name,description) values (0, 'child', 'contains childs items');
insert into category(parent_key,category_name,description) values (0, 'cloths', 'contains cloths');
insert into category(parent_key,category_name,description) values (1, 'mobile', 'mobile phones');
insert into category(parent_key,category_name,description) values (1, 'TV', 'Television');
insert into category(parent_key,category_name,description) values (1, 'other electronics', 'non categorized itms');
insert into category(parent_key,category_name,description) values (2, 'grossary', 'grossary items');
insert into category(parent_key,category_name,description) values (3, 'toys', 'toys');
insert into category(parent_key,category_name,description) values (3, 'stationary', 'stationary');
insert into category(parent_key,category_name,description) values (4, 'men', 'stationary');
insert into category(parent_key,category_name,description) values (4, 'women', 'stationary');
/**
*
*/
insert into product(product_name, price, stock, description) values ('oopo-9x',14999,10,'smart phone with 3 gb 64 gb'),
('iphone-8',54999,20,'i phone 8 gray'),('mi-9p',8999,40,'smart phone with 3 gb 32 gb'),
('nokia-3310',2499,10,'feature phone'),('samsung-2832',32469,15,'smart phone with 3 gb 32 gb'),
('iphone-xr',124999,12,'balck iphone XR'),('sony-HD-216',144500,20,'Smart Tv'),
('mi-Samrt-Tv',44999,40,'smart Tv'),('samsung-washing-145',7999,5,'Smart Washing Machine'),
('iphone-4',9999,0,'i phone 8 gray'),('Pigen-kitchen-set',5999,12,'kitchen set'),
('Pigen-automatic-gas',12999,10,'gas stove'),('Pigen-tifin-box',999,25,'tifin box'),
('my-ToySet-01',35499,5,'toy set'),('light-House',1499,10,'light hoouse'),
('trimax-pen-set-10',429,20,'pen set'),('non-toxic-color',1429,20,'color set'),
('sketch-book',129,50,'sketch book'),('water-color',429,20,'color set'),
('nike-men-001',34499,10,'sports shoes'),('zara-men-shirt-L',4429,20,'shirt'),
('zara-men-pent',9429,10,'pent'),('zara-men-kit',34549,10,'total kit'),
('zara-girl-kit',48429,10,'woment kit'),('zara-charming-kit',74429,10,'woment kit'),
('zara-purse',4429,15,'woment purse'),('Calvin-Klein-Jeans-women',14429,10,'woment jeans');
/**
* adding relation of products and categories
*/
insert into productrelation(product_id, category_id) values(1,5),
(2,5),(3,5),(4,5),(5,5),(6,5),(10,5),(7,6),(8,6),(9,7),(11,8),
(12,8),(13,8),(14,9),(15,9),(16,10),(17,10),(18,10),(19,10),(20,11),
(21,11),(22,11),(23,11),(24,12),(25,12),(26,12),(27,12);
/**
* adding images value
*/
insert into images(image_url,product_id) values ("1-front.jpg",1),
("1-back.jpg",1),("1-side.jpg",1),("2-front.jpg",2),("2-back.jpg",2),
("2-side.jpg",2),("3-front.jpg",3),("4-front.jpg",4),("4-back.jpg",4),
("4-side.jpg",4),("5-front.jpg",5),("5-back.jpg",5),("7-front.jpg",7),
("7-side.jpg",7),("8-front.jpg",8),("8-side.jpg",8),("14-front.jpg",14),
("15-front.jpg",15),("23-front.jpg",23),("23-back.jpg",23),("24-front.jpg",24),
("24-back.jpg",24),("25-front.jpg",25),("25-back.jpg",25),("26-front.jpg",26),
("26-back.jpg",26),("27-front.jpg",27),("27-back.jpg",27);
/**
* orders
*/
insert into orders(customer_id, ordertime) values (4,CURRENT_TIMESTAMP()),
(2,CURRENT_TIMESTAMP()),
(2,CURRENT_TIMESTAMP()),
(4,CURRENT_TIMESTAMP());
/**
* items placed
*/
insert into items(order_id, address_id,product_id,quantity,status) values(1,5,4,1,'pending'),(1,6,21,2,'pending'),
(2,1,6,2,'delivered'),(3,1,7,2,'shipped'),(3,1,25,3,'delivered'),(4,5,6,1,'pending');

