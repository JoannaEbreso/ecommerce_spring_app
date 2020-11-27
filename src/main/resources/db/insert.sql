set foreign_key_checks = 0;

truncate table customer;
truncate table address;
truncate table product;
truncate table cart;
truncate table cart_item;
truncate table order_model;
truncate table customer_address_list;

insert into address(`id`,`address_line_one`,`city`,`country`,`state`,`zipcode`)
values(1,"7,sabo street","yaba","Togo","Lagos","1292"),
      (2,"2,lani street","Isi","Nigeria","Edo","1111"),
      (3,"7,Ikate Road","Lekki","Ghana","Lagos","1561"),
      (4,"7,ring street","Ikorodu","Nigeria","Lagos","1292"),
      (5,"5,kile street","Reda","Ghana","Delta","4563");

insert into customer(`id`,`email`,`first_name`,`last_name`,`password`,`phone_number`)
values(1,"jj@g.com","Justin","Lekan","12435","68724924729"),
      (2,"ly@gmail.com","Lois","Yomi","11100","46284792487"),
      (3,"laide@ymail.com","Tade","Timi","1561","7672472828"),
      (4,"fani@gmail.com","Yeni","Frederick","138294","37294748182"),
      (5,"grilly@gmail.com","Grundy","Frill","4563","164726266428");

insert into product(`id`,`name`,`price`,`product_description`)
values(1,"round neck blouse",250.00,"A perfect wear on a casual day"),
(2,"v neck blouse",250.00,"A little stye to a casusal wear"),
(3,"high waist trouser","1000.00","Perfect for a crop top"),
(4,"skinny jeans",500.00,"Great if your not up for tights"),
(5,"turtle neck blouse",400.00,"great for the cold days");

insert into cart(`id`,`total_price`)
values(1,50000.00),
(2,23000.00),
(3,15000.00),
(4,3500.00),
(5,44000.00);

insert into cart_item(`id`,`price`,`quantity`,`product_id`)
value (1,2500.00,4,1),
(2,5000.00,5,1);

insert into order_model(`id`,`delivery_date`,`order_date`,`status`,`customer_id`)
value(1,'2011-11-10','2011-10-30','DELIVERED',2),
(2,'2012-10-5','2012-10-1','DELIVERED',2),
(3,'2015-12-3','2015-11-5','PENDING',3);

set foreign_key_checks = 1;