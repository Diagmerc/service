CREATE DATABASE  IF NOT EXISTS `service`;

CREATE TABLE IF NOT EXISTS `users` (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `username` varchar(45) NOT NULL,
                         `password` varchar(255) NOT NULL,
                         `phone` varchar(45) DEFAULT NULL,
                         `registered` date DEFAULT NULL,
                         `role` varchar(45) NOT NULL,
                         PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `cars` (
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `vin` varchar(45) NOT NULL,
                        `motor` varchar(45) NOT NULL,
                        `user_id` bigint NOT NULL,
                        PRIMARY KEY (`id`),
                        KEY `user_id_idx` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE IF NOT EXISTS `record` (
                          `id` bigint NOT NULL AUTO_INCREMENT,
                          `text` varchar(45) NOT NULL,
                          `recommend` varchar(45) NOT NULL,
                          `mileage` varchar(45) NOT NULL,
                          `date` datetime NOT NULL,
                          `type` varchar(45) NOT NULL,
                          `car_id` bigint NOT NULL,
                          PRIMARY KEY (`id`),
                          KEY `car_id_idx` (`car_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


