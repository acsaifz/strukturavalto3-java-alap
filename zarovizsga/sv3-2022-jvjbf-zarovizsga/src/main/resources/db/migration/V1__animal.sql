CREATE TABLE `animals` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `animal_type` varchar(255) NOT NULL,
    `count_of_animal` int NOT NULL,
    `date_of_observation` date NOT NULL,
    PRIMARY KEY (`id`)
);