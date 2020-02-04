
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema shopstack
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `shopstack` ;

-- -----------------------------------------------------
-- Schema shopstack
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopstack` DEFAULT CHARACTER SET latin1 ;
USE `shopstack` ;

-- -----------------------------------------------------
-- Table `shopstack`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`customer` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`customer` (
  `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `organization_name` VARCHAR(45) NULL DEFAULT NULL,
  `contact_number` INT(11) NOT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`user` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`user` (
  `user_id` INT(45) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  `enabled` TINYINT(1) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`shop_owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`shop_owner` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`shop_owner` (
  `shop_owner_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  `contact_number` VARCHAR(45) NOT NULL,
  `user_id` INT(45) NOT NULL,
  PRIMARY KEY (`shop_owner_id`, `user_id`),
  INDEX `fk_shop_owner_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_shop_owner_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `shopstack`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`shop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`shop` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`shop` (
  `shop_id` INT(11) NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(100) NOT NULL,
  `shop_name` VARCHAR(45) NOT NULL,
  `logo` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `shop_email` VARCHAR(45) NULL DEFAULT NULL,
  `website` VARCHAR(45) NULL DEFAULT NULL,
  `shop_owner_id` INT(11) NOT NULL,
  `date_created` DATETIME NOT NULL,
  PRIMARY KEY (`shop_id`, `shop_owner_id`),
  INDEX `fk_shop_shop_owner1_idx` (`shop_owner_id` ASC),
  CONSTRAINT `fk_shop_shop_owner1`
    FOREIGN KEY (`shop_owner_id`)
    REFERENCES `shopstack`.`shop_owner` (`shop_owner_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`employee` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`employee` (
  `employee_id` INT(11) NOT NULL AUTO_INCREMENT,
  `shop_id` INT(11) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NULL DEFAULT NULL,
  `contact_number` INT(11) NOT NULL,
  `date_added` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`employee_id`),
  INDEX `fk_employee_shop1_idx` (`shop_id` ASC),
  CONSTRAINT `fk_employee_shop1`
    FOREIGN KEY (`shop_id`)
    REFERENCES `shopstack`.`shop` (`shop_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`product` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`product` (
  `product_code` INT(11) NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `purchase_date` DATE NOT NULL,
  `expiry_date` DATE NULL DEFAULT NULL,
  `category` VARCHAR(45) NOT NULL,
  `rate` DOUBLE NOT NULL,
  `decription` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`product_code`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`inventory` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`inventory` (
  `inventory_id` INT(11) NOT NULL AUTO_INCREMENT,
  `product_code` INT(11) NOT NULL,
  `opening_stock` INT(11) NULL DEFAULT NULL,
  `closing_stock` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`inventory_id`),
  INDEX `fk_inventory_product1_idx` (`product_code` ASC),
  CONSTRAINT `fk_inventory_product1`
    FOREIGN KEY (`product_code`)
    REFERENCES `shopstack`.`product` (`product_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`supplier` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`supplier` (
  `supplier_id` INT(11) NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `organization_name` VARCHAR(45) NULL DEFAULT NULL,
  `contact_number` INT(11) NOT NULL,
  PRIMARY KEY (`supplier_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`transaction_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`transaction_item` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`transaction_item` (
  `product_code` INT(11) NOT NULL,
  `transaction_id` INT(11) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `type` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`product_code`, `transaction_id`),
  INDEX `fk_transaction_item_transaction1_idx` (`transaction_id` ASC),
  CONSTRAINT `fk_transaction_item_product1`
    FOREIGN KEY (`product_code`)
    REFERENCES `shopstack`.`product` (`product_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_item_transaction1`
    FOREIGN KEY (`transaction_id`)
    REFERENCES `shopstack`.`transaction` (`transaction_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`transaction` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`transaction` (
  `transaction_id` INT(11) NOT NULL AUTO_INCREMENT,
  `employee_id` INT(11) NOT NULL,
  `shop_shop_id` INT(11) NOT NULL,
  `transaction_item_id` INT(11) NOT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  `transaction_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  INDEX `fk_transaction_employee1_idx` (`employee_id` ASC),
  INDEX `fk_transaction_item_id_idx` (`transaction_item_id` ASC),
  INDEX `fk_transaction_shop1_idx` (`shop_shop_id` ASC),
  CONSTRAINT `fk_transaction_employee1`
    FOREIGN KEY (`employee_id`)
    REFERENCES `shopstack`.`employee` (`employee_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_item_id`
    FOREIGN KEY (`transaction_item_id`)
    REFERENCES `shopstack`.`transaction_item` (`product_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_shop1`
    FOREIGN KEY (`shop_shop_id`)
    REFERENCES `shopstack`.`shop` (`shop_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`invoice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`invoice` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`invoice` (
  `invoice_id` INT(11) NOT NULL AUTO_INCREMENT,
  `transaction_id` INT(11) NOT NULL,
  `customer_id` INT(11) NULL DEFAULT NULL,
  `supplier_id` INT(11) NULL DEFAULT NULL,
  `discount` DOUBLE NULL DEFAULT NULL,
  `tax` DOUBLE NULL DEFAULT NULL,
  `payments` DOUBLE NOT NULL,
  `balance` DOUBLE NOT NULL,
  `total` DOUBLE NOT NULL,
  `notes` VARCHAR(100) NULL DEFAULT NULL,
  `created_on` DATETIME NOT NULL,
  PRIMARY KEY (`invoice_id`),
  INDEX `fk_invoice_customer1_idx` (`customer_id` ASC),
  INDEX `fk_transaction_item_1_idx` (`transaction_id` ASC),
  INDEX `fk_invoice_vendor1_idx` (`supplier_id` ASC),
  CONSTRAINT `fk_invoice_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `shopstack`.`customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice_vendor1`
    FOREIGN KEY (`supplier_id`)
    REFERENCES `shopstack`.`supplier` (`supplier_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_item_1`
    FOREIGN KEY (`transaction_id`)
    REFERENCES `shopstack`.`transaction` (`transaction_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`verification_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`verification_token` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`verification_token` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `token` VARCHAR(45) NULL DEFAULT NULL,
  `expiry_date` DATE NULL DEFAULT NULL,
  `user_id` INT(45) NOT NULL,
  PRIMARY KEY (`id`, `user_id`),
  INDEX `fk_verification_token_user1_idx` (`user_id` ASC),
  CONSTRAINT `fk_verification_token_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `shopstack`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
