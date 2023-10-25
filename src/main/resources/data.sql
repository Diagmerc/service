INSERT INTO users (username, password, phone, role)
VALUES
('User', '$2a$10$X0wSyjWLDIgn.mS1Cm5ZbeBLVuxQedcLFBitGKHyqU9q1GphmBmgq', '89269999999', 'ROLE_USER'),
('User2', '$2a$10$X0wSyjWLDIgn.mS1Cm5ZbeBLVuxQedcLFBitGKHyqU9q1GphmBmgq', '89261111111', 'ROLE_USER'),
('Admin', '$2a$10$X0wSyjWLDIgn.mS1Cm5ZbeBLVuxQedcLFBitGKHyqU9q1GphmBmgq', '89056666666', 'ROLE_ADMIN');

-- INSERT INTO user_roles (role, user_id)
-- VALUES ('ROLE_USER', 1),
--        ('ROLE_ADMIN', 2);

INSERT INTO cars (user_id, vin, motor)
VALUES (2,'WDC1641821A223521', 'BENZIN'),
       (2,'WDC1661821A223521', 'BENZIN'),
       (2,'WDC2221821A223521', 'BENZIN'),
       (1,'WDC2531821A223521', 'BENZIN'),
       (1,'WDD2051821A223521', 'BENZIN');

INSERT INTO record (car_id, text, recommend, mileage, date, type)
VALUES (1, 'change oil', 'change motor', '1000', '2020-01-30 10:00:00', 'PLANNED'),
       (1, 'diagnostic', 'break', '2000', '2020-01-30 11:00:00', 'PLANNED');
