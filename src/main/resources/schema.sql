CREATE TABLE users
(
    id IDENTITY not null,
    username varchar(255) not null,
    password varchar  not null,
    email varchar     ,
    registered timestamp default now() not null,
    primary key (id)
);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR(255) NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE cars
(
    user_id integer not null,
    id IDENTITY not null,
    vin varchar not null,
    motor varchar not null,
    primary key (id),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);
CREATE TABLE service_record
(
    car_id integer not null,
    id IDENTITY not null,
    record varchar not null,
    service_date timestamp default now() not null,
    service_type varchar not null,
    FOREIGN KEY (car_id) REFERENCES cars(id) ON DELETE CASCADE
)
