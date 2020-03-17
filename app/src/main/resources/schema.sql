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
    id int(10) auto_increment,
    created varchar(100) not null,
    startdate datetime not null,
    seatsavailable int(2) not null,
    startlocation varchar(45) not null,
    destination varchar(100) not null,
    comment varchar(255) null,
    constraint user_id_ride_UNIQUE
        unique (id)
);

alter table ride
    add primary key (id);

