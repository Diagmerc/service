CREATE TABLE users
(
    id IDENTITY not null,
    username varchar(255) not null,
    password varchar  not null,
    email varchar     ,
    registered timestamp default now(),
    role varchar(255) not null,
    primary key (id)
);
CREATE TABLE cars
(
    id IDENTITY not null,
    vin varchar not null,
    motor varchar not null,
    user_id     INTEGER      NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE TABLE record
(
    id IDENTITY not null,
    text varchar not null,
    date timestamp default now() not null,
    type varchar not null,
    car_id  INTEGER NOT NULL ,
    FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE
);
