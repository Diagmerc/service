CREATE TABLE users
(
    id integer not null,
    name varchar(255) not null,
    password varchar  not null,
    email varchar     not null,
    registered timestamp default now() not null


);