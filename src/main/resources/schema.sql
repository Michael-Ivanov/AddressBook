DROP TABLE if EXISTS person CASCADE;

CREATE TABLE person(
    id serial PRIMARY KEY,
    firstname text,
    lastname text,
    birthday date,
    phone text
);

DROP TABLE if EXISTS address;

CREATE TABLE address(
    id serial PRIMARY KEY,
    country text,
    zipcode int,
    city text,
    street text,
    person_id int,
    FOREIGN KEY (person_id) REFERENCES person(id)
);
