set foreign_key_checks = 0;

truncate table customer;
truncate table address;
truncate table customer_address_list;

insert into address(`id`,`address_line_one`,`city`,`state`,`zipcode`)
values(1,"7,sabo street","yaba","Lagos","1292"),
      (2,"2,lani street","Isi","Edo","1111"),
      (3,"7,Ikate Road","Lekki","Lagos","1561"),
      (4,"7,ring street","Ikorodu","Lagos","1292"),
      (5,"5,kile street","Reda","Delta","4563");

insert into customer(`id`,`email`,`first_name`,`last_name`,`password`,`phone_number`)
values(1,"jj@g.com","Justin","Lekan","12435","68724924729"),
      (2,"ly@gmail.com","Lois","Yomi","11100","46284792487"),
      (3,"laide@ymail.com","Tade","Timi","1561","7672472828"),
      (4,"fani@gmail.com","Yeni","Frederick","138294","37294748182"),
      (5,"grilly@gmail.com","Grundy","Frill","4563","164726266428");

set foreign_key_checks = 1;