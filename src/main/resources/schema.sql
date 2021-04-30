drop table if exists person cascade;

create table person(
    id serial primary key,
    firstname text,
    lastname text,
    birthday date,
    phone text
);

drop table if exists address;

create table address(
    id serial primary key,
    country text,
    zipcode int,
    city text,
    street text,
    person_id int,
    foreign key (person_id) references person(id)
);
