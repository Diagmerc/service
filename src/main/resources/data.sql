INSERT INTO users (username, password, email, role)
VALUES ('User', '$2a$10$X0wSyjWLDIgn.mS1Cm5ZbeBLVuxQedcLFBitGKHyqU9q1GphmBmgq', 'dfsf@mail.ru', 'ROLE_USER'),
('Admin', '$2a$10$X0wSyjWLDIgn.mS1Cm5ZbeBLVuxQedcLFBitGKHyqU9q1GphmBmgq', 'dff@mail.ru', 'ROLE_ADMIN');

-- INSERT INTO user_roles (role, user_id)
-- VALUES ('ROLE_USER', 1),
--        ('ROLE_ADMIN', 2);

INSERT INTO cars (user_id, vin, motor)
VALUES (1,'WDC1641821A223521', 'BENZIN');

INSERT INTO record (car_id, text, date, type)
VALUES (1, 'change oil', '2020-01-30 10:00:00',  'PLANNED'),
       (1, 'diagnostic', '2020-01-30 11:00:00',  'PLANNED');
