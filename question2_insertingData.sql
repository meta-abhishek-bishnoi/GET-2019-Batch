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
insert into product(product_name, price, stock, description) values ('oopo-9x',14999,10,'smart phone with 3 gb 64 gb');
insert into product(product_name, price, stock, description) values ('iphone-8',54999,20,'i phone 8 gray');
insert into product(product_name, price, stock, description) values ('mi-9p',8999,40,'smart phone with 3 gb 32 gb');
insert into product(product_name, price, stock, description) values ('nokia-3310',2499,10,'feature phone');
insert into product(product_name, price, stock, description) values ('samsung-2832',32469,15,'smart phone with 3 gb 32 gb');
insert into product(product_name, price, stock, description) values ('iphone-xr',124999,12,'balck iphone XR');
insert into product(product_name, price, stock, description) values ('sony-HD-216',144500,20,'Smart Tv');
insert into product(product_name, price, stock, description) values ('mi-Samrt-Tv',44999,40,'smart Tv');
insert into product(product_name, price, stock, description) values ('samsung-washing-145',7999,5,'Smart Washing Machine');
insert into product(product_name, price, stock, description) values ('iphone-4',9999,0,'i phone 8 gray');
insert into product(product_name, price, stock, description) values ('Pigen-kitchen-set',5999,12,'kitchen set');
insert into product(product_name, price, stock, description) values ('Pigen-automatic-gas',12999,10,'gas stove');
insert into product(product_name, price, stock, description) values ('Pigen-tifin-box',999,25,'tifin box');
insert into product(product_name, price, stock, description) values ('my-ToySet-01',35499,5,'toy set');
insert into product(product_name, price, stock, description) values ('light-House',1499,10,'light hoouse');
insert into product(product_name, price, stock, description) values ('trimax-pen-set-10',429,20,'pen set');
insert into product(product_name, price, stock, description) values ('non-toxic-color',1429,20,'color set');
insert into product(product_name, price, stock, description) values ('sketch-book',129,50,'sketch book');
insert into product(product_name, price, stock, description) values ('water-color',429,20,'color set');
insert into product(product_name, price, stock, description) values ('nike-men-001',34499,10,'sports shoes');
insert into product(product_name, price, stock, description) values ('zara-men-shirt-L',4429,20,'shirt');
insert into product(product_name, price, stock, description) values ('zara-men-pent',9429,10,'pent');
insert into product(product_name, price, stock, description) values ('zara-men-kit',34549,10,'total kit');
insert into product(product_name, price, stock, description) values ('zara-girl-kit',48429,10,'woment kit');
insert into product(product_name, price, stock, description) values ('zara-charming-kit',74429,10,'woment kit');
insert into product(product_name, price, stock, description) values ('zara-purse',4429,15,'woment purse');
insert into product(product_name, price, stock, description) values ('Calvin-Klein-Jeans-women',14429,10,'woment jeans');
/**
* adding relation of products and categories
*/
insert into productrelation(product_id, category_id) values(1,5);
insert into productrelation(product_id, category_id) values(2,5);
insert into productrelation(product_id, category_id) values(3,5);
insert into productrelation(product_id, category_id) values(4,5);
insert into productrelation(product_id, category_id) values(5,5);
insert into productrelation(product_id, category_id) values(6,5);
insert into productrelation(product_id, category_id) values(10,5);
insert into productrelation(product_id, category_id) values(7,6);
insert into productrelation(product_id, category_id) values(8,6);
insert into productrelation(product_id, category_id) values(9,7);
insert into productrelation(product_id, category_id) values(11,8);
insert into productrelation(product_id, category_id) values(12,8);
insert into productrelation(product_id, category_id) values(13,8);
insert into productrelation(product_id, category_id) values(14,9);
insert into productrelation(product_id, category_id) values(15,9);
insert into productrelation(product_id, category_id) values(16,10);
insert into productrelation(product_id, category_id) values(17,10);
insert into productrelation(product_id, category_id) values(18,10);
insert into productrelation(product_id, category_id) values(19,10);
insert into productrelation(product_id, category_id) values(20,11);
insert into productrelation(product_id, category_id) values(21,11);
insert into productrelation(product_id, category_id) values(22,11);
insert into productrelation(product_id, category_id) values(23,11);
insert into productrelation(product_id, category_id) values(24,12);
insert into productrelation(product_id, category_id) values(25,12);
insert into productrelation(product_id, category_id) values(26,12);
insert into productrelation(product_id, category_id) values(27,12);
/**
* adding images value
*/
insert into images(image_url,product_id) values ("1-front.jpg",1);
insert into images(image_url,product_id) values ("1-back.jpg",1);
insert into images(image_url,product_id) values ("1-side.jpg",1);
insert into images(image_url,product_id) values ("2-front.jpg",2);
insert into images(image_url,product_id) values ("2-back.jpg",2);
insert into images(image_url,product_id) values ("2-side.jpg",2);
insert into images(image_url,product_id) values ("3-front.jpg",3);
insert into images(image_url,product_id) values ("4-front.jpg",4);
insert into images(image_url,product_id) values ("4-back.jpg",4);
insert into images(image_url,product_id) values ("4-side.jpg",4);
insert into images(image_url,product_id) values ("5-front.jpg",5);
insert into images(image_url,product_id) values ("5-back.jpg",5);
insert into images(image_url,product_id) values ("7-front.jpg",7);
insert into images(image_url,product_id) values ("7-side.jpg",7);
insert into images(image_url,product_id) values ("8-front.jpg",8);
insert into images(image_url,product_id) values ("8-side.jpg",8);
insert into images(image_url,product_id) values ("14-front.jpg",14);
insert into images(image_url,product_id) values ("15-front.jpg",15);
insert into images(image_url,product_id) values ("23-front.jpg",23);
insert into images(image_url,product_id) values ("23-back.jpg",23);
insert into images(image_url,product_id) values ("24-front.jpg",24);
insert into images(image_url,product_id) values ("24-back.jpg",24);
insert into images(image_url,product_id) values ("25-front.jpg",25);
insert into images(image_url,product_id) values ("25-back.jpg",25);
insert into images(image_url,product_id) values ("26-front.jpg",26);
insert into images(image_url,product_id) values ("26-back.jpg",26);
insert into images(image_url,product_id) values ("27-front.jpg",27);
insert into images(image_url,product_id) values ("27-back.jpg",27);
/**
* adding products 
*/
insert into orders(customer_id, address_id, product_id, ordertime,quantity, status) values (4,5,4, CURRENT_TIMESTAMP(),1,'pending');
insert into orders(customer_id, address_id, product_id, ordertime,quantity, status) values (4,6,21, CURRENT_TIMESTAMP(),2,'pending');
insert into orders(customer_id, address_id, product_id, ordertime,quantity, status) values (2,1,6, CURRENT_TIMESTAMP(),2,'delivered');
insert into orders(customer_id, address_id, product_id, ordertime,quantity, status) values (2,1,7, CURRENT_TIMESTAMP(),2,'shipped');
insert into orders(customer_id, address_id, product_id, ordertime,quantity, status) values (2,1,25, CURRENT_TIMESTAMP(),3,'delivered');
insert into orders(customer_id, address_id, product_id, ordertime,quantity, status) values (4,5,6, CURRENT_TIMESTAMP(),1,'pending');