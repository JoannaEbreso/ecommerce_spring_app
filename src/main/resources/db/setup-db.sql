drop database if exists ecommercedb;
create database ecommercedb;

drop user if exists 'ecomuser'@'localhost';
create user 'ecomuser'@'localhost' identified by 'ecom111';
grant all privileges on ecommercedb.* to 'ecomuser'@'localhost';
flush privileges;

