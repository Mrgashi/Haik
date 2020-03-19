create schema Haik collate utf8mb4_0900_ai_ci;

create table User
(
    id int(10) auto_increment,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
    starttime time not null,
    email varchar(100) not null,
    password varchar(100) not null,
    phone_number varchar(100) not null,
    constraint id_UNIQUE
        unique (id)
);

alter table User
    add primary key (id);


create table ride
(
    id int(10) auto_increment,
    created varchar(100) not null,
    startdate date not null,
#     date date not null , /*Endret til date istedenfor datetime for å få kontakt med view - Karoline */
    seatsavailable int(2) not null,
    startlocation varchar(45) not null,
    destination varchar(100) not null,
    comment varchar(255) null,
    constraint user_id_ride_UNIQUE
        unique (id)
);

alter table ride
    add primary key (id);


CREATE TABLE `user_ride` (
                             `user_ride_id` int(10) NOT NULL,
                             `user_id` int(10) NOT NULL,
                             `ride_id` int(10) DEFAULT NULL,
                             PRIMARY KEY (`user_ride_id`),
                             KEY `user_id_idx` (`user_id`),
                             KEY `ride_id_idx` (`ride_id`),
                             CONSTRAINT `ride_id` FOREIGN KEY (`ride_id`) REFERENCES `ride` (`ride_id`) ON DELETE CASCADE ON UPDATE CASCADE,
                             CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci