CREATE SCHEMA IF NOT EXISTS `jdbc_demos`;
USE `jdbc_demos` ;

-- -----------------------------------------------------
-- Table `jdbc_demos`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `jdbc_demos`.`product` (
  `id` INT PRIMARY KEY AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `price` DECIMAL(13,2) NOT NULL,
  `quantity` INT DEFAULT 1
  );


-- -----------------------------------------------------
-- Add sample data
-- -----------------------------------------------------
insert into product (name, price, quantity) values ('Television', 40000, 2);
insert into product (name, price, quantity) values ('Air Conditioner', 45000, 3);
