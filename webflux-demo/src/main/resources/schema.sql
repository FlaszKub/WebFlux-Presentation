BEGIN;
drop table if exists users;
drop table if exists addresses;
drop sequence if exists address_generator;
drop sequence if exists user_generator;

create sequence address_generator start 1 increment 1;
create sequence user_generator start 1 increment 1;

create table addresses (
    id int8 not null DEFAULT nextval('address_generator'),
    uuid uuid,
    city varchar(30),
    number varchar(10),
    state varchar(30),
    street varchar(40),
    zipcode varchar(6),
    primary key (id)
);

create table users (
    id int8 not null DEFAULT nextval('user_generator'),
    date_of_brith date,
    first_name varchar(40),
    last_name varchar(40),
    pesel varchar(11),
    address_id int8,
    primary key (id),
    foreign key (address_id) references addresses
);

END;