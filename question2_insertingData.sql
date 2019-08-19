/** creating users
*/
INSERT INTO `user` (`username`,`password`,`first_name`,`last_name`,`email`,`contact_no`) VALUES ('meta-abhi','metacube','Abhishek','Bishnoi','abhishek.bishnoi@metacube.com',8976568778),
('meta-manoj','metacube','manoj','sharma','manoj@metacube.com',47253765),
('meta-shreyash','metacube','shreyash','khandelwal','shresyash@metacube.com',31340543),
('meta-babbar','metacube','anmol','babbar','anmol.babbar@metacube.com',41462340),
('meta-pankaj','metacube','pankaj','kumar','pankaj.kumar@metacube.com',48730116),
('meta-yatika','metacube','yatika','bansal','yatika.bansal@metacube.com',51312773),
('meta-aman','metacube','aman','kumar','aman@metacube.com',16987243),
('ecb-monika','ecb','monika','suthar','monika.suthar@ecb.ac.in',55612233),
('ecb-ashwani','ecb','ashwani','dev','ashwani@ecb.ac.in',97088102),
('ecb-nitin','ecb','nitin','chahuhan','nitin@ecb.ac.in',45255458),
('ecb-mini','ecb','minakshi','malav','mini@ecb.ac.in',2601667),
('ecb-anshu','ecb','anhsuman','galav','anshu@ecb.ac.in',52655608),
('ecb-bhagraj','ecb','bhagraj','choudhary','bhag@ecb.ac.in',93665842),
('ecb-bhagu','ecb','bhagyashree','arya','bhagu@ecb.ac.in',83890911),
('ecb-nidhi','ecb','nidhi','jan','nidhi@ecb.ac.in',50765936),
('ecb-naag','ecb','ramnarayan','vishnoi','naag@ecb.ac.in',45967131),
('ecb-siya','ecb','siya','goyal','coder_siya@ecb.ac.in',28963916);
/** assigning roles
*/
INSERT INTO `role` (`user_id`,`role`) VALUES (1,'Admin'),
(1,'Shopper'),(2,'Shopper'),(3,'Admin'),(3,'Shopper'),
(4,'Shopper'),(5,'Shopper'),(6,'Shopper'),(7,'Admin'),
(8,'Shopper'),(8,'Admin'),(9,'Admin'),(10,'Shopper'),
(11,'Shopper'),(12,'Admin'),(12,'Shopper'),(13,'Shopper'),
(14,'Admin'),(14,'Shopper'),(15,'Shopper'),(16,'Shopper'),
(17,'Shopper');
/** adding address
*/
INSERT INTO `address` (`user_id`,`contact_person`,`address`,`contact_no`,`email`) 
VALUES (1,'Linus','Opwijk',670478,'eros.non@congueIn.com'),
(1,'Leo','Baton Rouge',632985,'Phasellus.dolor.elit@erosNamconsequat.net'),
(1,'Micah','Poitiers',306303,'Donec.sollicitudin@egetmetus.net'),
(2,'Brendan','Roccalumera',871084,'tellus@Namnullamagna.com'),
(3,'Trevor','Oldenburg',843291,'ut@at.org'),
(3,'Sebastian','Connah\'s Quay',43934,'Mauris.magna@nisisem.edu'),
(4,'Xenos','Bicinicco',853782,'id.ante@vitaesodales.co.uk'),
(5,'Tad','New Sarepta',363020,'Ut.sagittis.lobortis@malesuada.edu'),
(5,'Lamar','A Coruña',910476,'erat@idmollisnec.ca'),
(6,'Brennan','De Haan',804942,'neque@Nullatemporaugue.org'),
(8,'Norman','San Giovanni Lipioni',273359,'Vivamus@estarcuac.co.uk'),
(8,'Fletcher','Budaun',166976,'Duis.at@facilisismagnatellus.org'),
(8,'Damon','Mauá',93611,'ipsum.dolor.sit@Lorem.co.uk'),
(10,'Emerson','Omaha',386630,'ante.Vivamus.non@ullamcorpermagna.net'),
(11,'Xavier','South Portland',619604,'tincidunt.congue@elementum.net'),
(12,'Fritz','Sassocorvaro',675672,'malesuada.id@ipsumleo.ca'),
(13,'Kieran','Essene',937086,'arcu.ac@Integer.edu'),
(14,'Lawrence','Chaudfontaine',964195,'placerat.eget@vestibulum.co.uk'),
(15,'Lewis','San Sostene',433631,'feugiat.nec@Aenean.org'),
(16,'Maxwell','Newmarket',743144,'dignissim.pharetra.Nam@vel.net'),
(17,'Ryan','Detroit',132157,'euismod.mauris.eu@cursus.org');
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
insert into productrelation(product_id, category_id) values(1,5),(1,6),
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
(4,CURRENT_TIMESTAMP()),
(12,CURRENT_TIMESTAMP()),
(11,CURRENT_TIMESTAMP()),
(13,CURRENT_TIMESTAMP()),
(8,CURRENT_TIMESTAMP()),
(8,CURRENT_TIMESTAMP()),
(14,CURRENT_TIMESTAMP()),
(16,CURRENT_TIMESTAMP()),
(9,CURRENT_TIMESTAMP()),
(3,CURRENT_TIMESTAMP()),
(7,CURRENT_TIMESTAMP()),
(13,CURRENT_TIMESTAMP()),
(17,CURRENT_TIMESTAMP()),
(5,CURRENT_TIMESTAMP()),
(8,CURRENT_TIMESTAMP()),
(2,CURRENT_TIMESTAMP()),
(8,CURRENT_TIMESTAMP())
;