INSERT INTO users (name, password, email)
VALUES ('Vasiliy', '123', 'dfsf@mail.ru');

INSERT INTO cars (user_id, vin, motor)
VALUES (1,'WDC1641821A223521', 'BENZIN');

INSERT INTO service_record (car_id, record, service_date, service_type)
VALUES (1, 'change oil', '2020-01-30 10:00:00',  'PLANNED')
