# CREATE TABLE IF NOT EXISTS packages (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `transport_unit_id` VARCHAR(255),
#     `delivery_address` INT NOT NULL,
#     `return_address` INT NOT NULL,
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
# CREATE TABLE IF NOT EXISTS `events` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `package_id` INT NOT NULL,
#     `event_type_id` INT NOT NULL,
#     `geolocation` VARCHAR(255),
#     `address_id` INT,
#     `timestamp` DATETIME NOT NULL,
#      PRIMARY KEY (`id`)
# );
#
# CREATE TABLE IF NOT EXISTS `event_type` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `name` VARCHAR(255) NOT NULL,
#      PRIMARY KEY (`id`)
# );
#
# CREATE TABLE IF NOT EXISTS `orders` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `seller` VARCHAR(255) NOT NULL,
#     `buyer` VARCHAR(255) NOT NULL,
#     `date` DATETIME NOT NULL,
#     `order_number` VARCHAR(255) NOT NULL,
#     `delivery_address_id` INT NOT NULL,
#     `do_not_deliver_before` DATETIME,
#     `do_not_deliver_after` DATETIME,
#      PRIMARY KEY (`id`)
# );
#
# CREATE TABLE IF NOT EXISTS `order_items` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `order_id` INT NOT NULL,
#     `product_code` VARCHAR(255) NOT NULL,
#     `product_desc` VARCHAR(255) NOT NULL,
#     `quantity` INT NOT NULL,
#      PRIMARY KEY (`id`,`order_id`)
# );
#
# CREATE TABLE IF NOT EXISTS `order_x_package` (
#     `id` INT NOT NULL AUTO_INCREMENT,
#     `order_item_id` INT NOT NULL,
#     `order_id` INT NOT NULL,
#     `package_id` INT NOT NULL,
#      PRIMARY KEY (`id`,`order_item_id`)
# );
#
# ALTER TABLE `packages` ADD CONSTRAINT `packages_fk0` FOREIGN KEY (`delivery_address`) REFERENCES `address`(`id`);
#
# ALTER TABLE `packages` ADD CONSTRAINT `packages_fk1` FOREIGN KEY (`return_address`) REFERENCES `address`(`id`);
#
# ALTER TABLE `packages` ADD CONSTRAINT `packages_fk2` FOREIGN KEY (`last_event_id`) REFERENCES `events`(`id`);
#
# ALTER TABLE `events` ADD CONSTRAINT `events_fk0` FOREIGN KEY (`package_id`) REFERENCES `packages`(`id`);
#
# ALTER TABLE `events` ADD CONSTRAINT `events_fk1` FOREIGN KEY (`event_type_id`) REFERENCES `event_type`(`id`);
#
# ALTER TABLE `events` ADD CONSTRAINT `events_fk2` FOREIGN KEY (`address_id`) REFERENCES `address`(`id`);
#
# ALTER TABLE `orders` ADD CONSTRAINT `orders_fk0` FOREIGN KEY (`delivery_address_id`) REFERENCES `address`(`id`);
#
# ALTER TABLE `order_items` ADD CONSTRAINT `order_items_fk0` FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`);
#
# ALTER TABLE `order_x_package` ADD CONSTRAINT `order_x_package_fk0` FOREIGN KEY (`order_item_id`) REFERENCES `order_items`(`id`);
#
# ALTER TABLE `order_x_package` ADD CONSTRAINT `order_x_package_fk1` FOREIGN KEY (`order_id`) REFERENCES `orders`(`id`);
#
# ALTER TABLE `order_x_package` ADD CONSTRAINT `order_x_package_fk2` FOREIGN KEY (`package_id`) REFERENCES `packages`(`id`);
#
#
#
#




