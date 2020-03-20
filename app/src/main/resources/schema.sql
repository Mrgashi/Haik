create schema Haik collate utf8mb4_0900_ai_ci;

create table User
(
    id int(10) auto_increment,
    firstname varchar(100) not null,
    lastname varchar(100) not null,
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
    id int(10) auto_increment unique,
    created varchar(100) not null,
    createdbyid int(10) not null,
    startdate varchar(20) not null,
    starttime varchar(8) not null,
    seatsavailable int(2) not null,
    startlocation varchar(45) not null,
    destination varchar(100) not null,
    comments varchar(255),

    primary key (id),
    constraint FK_ride_user FOREIGN KEY (createdById) REFERENCES user(id)
);




# CREATE TABLE `user_ride` (
#                              `user_ride_id` int(10) NOT NULL,
#                              `user_id` int(10) NOT NULL,
#                              `ride_id` int(10) DEFAULT NULL,
#                              PRIMARY KEY (`user_ride_id`),
#                              KEY `user_id_idx` (`user_id`),
#                              KEY `ride_id_idx` (`ride_id`),
#                              CONSTRAINT `ride_id` FOREIGN KEY (`ride_id`) REFERENCES `ride` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
#                              CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
# ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci