# CREATE TABLE IF NOT EXISTS `item_package` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `transport_unit_id` VARCHAR(255),
#     `delivery_address_id` INT,
#     `return_address_id` INT,
#     `weight` FLOAT NOT NULL,
#     `delivery_not_before` DATETIME,
#     `delivery_not_after` DATETIME,
#     `last_event_id` INT,
#      PRIMARY KEY (`id`)
# );
#
# CREATE TABLE IF NOT EXISTS `address` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `company` VARCHAR(255) NOT NULL,
#     `contact` VARCHAR(255),
#     `address_line_1` VARCHAR(255),
#     `address_line_2` VARCHAR(255),
#     `suburb` VARCHAR(255),
#     `city` VARCHAR(255) NOT NULL,
#     `country_code` VARCHAR(255) NOT NULL,
#     `postal_code` VARCHAR(255) NOT NULL,
#     `phone_number` VARCHAR(255),
#     `email` VARCHAR(255),
#     `geocode` VARCHAR(255),
#      PRIMARY KEY (`id`)
# );
#
# CREATE TABLE IF NOT EXISTS `event` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `item_package_id` INT,
#     `event_type` VARCHAR(255) NOT NULL,
#     `geolocation` VARCHAR(255),
#     `address_id` INT,
#     `timestamp` DATETIME NOT NULL,
#      PRIMARY KEY (`id`)
# );
#
# CREATE TABLE IF NOT EXISTS `order` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `seller` VARCHAR(255) NOT NULL,
#     `buyer` VARCHAR(255) NOT NULL,
#     `date` DATETIME NOT NULL,
#     `order_number` VARCHAR(255) NOT NULL,
#     `delivery_address_id` INT NOT NULL,
#     `do_not_deliver_before` DATETIME,
#     `do_not_deliver_after` DATETIME,
#     `item_package_id` INT,
#      PRIMARY KEY (`id`)
# );
#
# CREATE TABLE IF NOT EXISTS `order_item` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `order_id` INT,
#     `product_code` VARCHAR(255) NOT NULL,
#     `product_desc` VARCHAR(255) NOT NULL,
#     `quantity` INT NOT NULL,
#      PRIMARY KEY (`id`)
# );
#
# ALTER TABLE `item_package` ADD CONSTRAINT `item_package_fk0` FOREIGN KEY (`delivery_address_id`) REFERENCES `address`(`id`);
#
# ALTER TABLE `item_package` ADD CONSTRAINT `item_package_fk1` FOREIGN KEY (`return_address_id`) REFERENCES `address`(`id`);
#
# ALTER TABLE `item_package` ADD CONSTRAINT `item_package_fk2` FOREIGN KEY (`last_event_id`) REFERENCES `event`(`id`);
#
# ALTER TABLE `event` ADD CONSTRAINT `events_fk0` FOREIGN KEY (`item_package_id`) REFERENCES `item_package`(`id`);
#
# ALTER TABLE `event` ADD CONSTRAINT `events_fk2` FOREIGN KEY (`address_id`) REFERENCES `address`(`id`);
#
# ALTER TABLE `order` ADD CONSTRAINT `orders_fk0` FOREIGN KEY (`delivery_address_id`) REFERENCES `address`(`id`);
#
# ALTER TABLE `order` ADD CONSTRAINT `orders_fk1` FOREIGN KEY (`item_package_id`) REFERENCES `item_package`(`id`);
#
# ALTER TABLE `order_item` ADD CONSTRAINT `order_items_fk0` FOREIGN KEY (`order_id`) REFERENCES `order`(`id`);
