CREATE TABLE `orders` (
    `id` bigint NOT NULL AUTO_INCREMENT,
    `product_name` varchar(255) NOT NULL,
    `product_count` int NOT NULL,
    `price_per_product` int NOT NULL,
    PRIMARY KEY (`id`)
);