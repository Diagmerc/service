INSERT INTO users (username, password, email)
VALUES ('Vasiliy', '$2a$10$X0wSyjWLDIgn.mS1Cm5ZbeBLVuxQedcLFBitGKHyqU9q1GphmBmgq', 'dfsf@mail.ru'),
('VasiliyAdmin', '$2a$10$X0wSyjWLDIgn.mS1Cm5ZbeBLVuxQedcLFBitGKHyqU9q1GphmBmgq', 'dff@mail.ru');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 1),
       ('ADMIN', 2);

INSERT INTO cars (user_id, vin, motor)
VALUES (1,'WDC1641821A223521', 'BENZIN');

INSERT INTO service_record (car_id, record, service_date, service_type)
VALUES (1, 'change oil', '2020-01-30 10:00:00',  'PLANNED')
