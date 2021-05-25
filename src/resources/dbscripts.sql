CREATE DATABASE `food_delivery`;
USE `food_delivery`;


drop table users;
drop table drivers;
drop table products;
drop table ingredients;


CREATE TABLE `users` (
                         `id` 			varchar(50) NOT NULL,
                         `username` 		varchar(30) NOT NULL,
                         `password` 		varchar(30) NOT NULL,
                         `name` 			varchar(30) NOT NULL,
                         `phoneNumber` 	varchar(15) DEFAULT NULL,
                         `email`			varchar(100) DEFAULT NULL,
                         `address`		varchar(80) DEFAULT NULL,
                         `currentorder` varchar(50) DEFAULT NULL,
                         PRIMARY KEY (`id`)
);



CREATE TABLE `drivers` (
                           `id` 			varchar(50) NOT NULL,
                           `username` 		varchar(30) NOT NULL,
                           `password` 		varchar(30) NOT NULL,
                           `name` 			varchar(30) NOT NULL,
                           `phoneNumber` 	varchar(15) DEFAULT NULL,
                           `email`			varchar(100) DEFAULT NULL,
                           `address`		varchar(80) DEFAULT NULL,
                           `currentorder` varchar(50) DEFAULT NULL,
                           `ratings`		varchar(100) DEFAULT NULL,
                           `currentdelivery` varchar(50) DEFAULT NULL,
                           PRIMARY KEY (`id`)
);

CREATE TABLE `ingredients` (
                               `id` 			varchar(50) NOT NULL,
                               `name` 			varchar(30) NOT NULL,
                               `calories` 		double(30, 2) DEFAULT NULL,
PRIMARY KEY (`id`)
);

CREATE TABLE `products` (
                            `id` 			varchar(50) NOT NULL,
                            `name` 			varchar(30) NOT NULL,
                            `price` 		double(30, 2) DEFAULT NULL,
`ingredients`	varchar(200) DEFAULT NULL,
PRIMARY KEY (`id`)
);


select * from users;
select * from drivers;
select * from products;
select * from ingredients;



