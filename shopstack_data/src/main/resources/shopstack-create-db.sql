-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- Schema shopstack
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `shopstack` ;

-- -----------------------------------------------------
-- Schema shopstack
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopstack` DEFAULT CHARACTER SET latin1 ;
USE `shopstack` ;

-- -----------------------------------------------------
-- Table `shopstack`.`ss_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`ss_users` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`ss_users` (
  `ss_user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ss_first_name` VARCHAR(45) NOT NULL,
  `ss_last_name` VARCHAR(45) NOT NULL,
  `ss_address` VARCHAR(45) NULL DEFAULT NULL,
  `ss_email` VARCHAR(45) NOT NULL,
  `ss_contact_number` VARCHAR(45) NOT NULL,
  `ss_date_joined` DATE NOT NULL,
  `ss_password` VARCHAR(45) NULL,
  `ss_enabled` TINYINT(1) NULL,
  PRIMARY KEY (`ss_user_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`verification_token`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`verification_token` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`verification_token` (
  `id` INT NOT NULL,
  `token` VARCHAR(45) NOT NULL,
  `expiry_date` DATE NULL,
  `ss_user_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`, `ss_user_id`),
  INDEX `fk_verification_token_ss_users_idx` (`ss_user_id` ASC),
  CONSTRAINT `fk_verification_token_ss_users`
    FOREIGN KEY (`ss_user_id`)
    REFERENCES `shopstack`.`ss_users` (`ss_user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `shopstack` ;

-- -----------------------------------------------------
-- Table `shopstack`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`customer` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`customer` (
  `customer_id` INT(11) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `organization_name` VARCHAR(45) NULL DEFAULT NULL,
  `contact_number` INT(11) NOT NULL,
  PRIMARY KEY (`customer_id`))
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
  `supplier_id` INT(11) NOT NULL,
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
-- Table `shopstack`.`shop`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`shop` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`shop` (
  `shop_id` INT(11) NOT NULL AUTO_INCREMENT,
  `shop_name` VARCHAR(45) NOT NULL,
  `shop_logo` VARCHAR(45) NULL DEFAULT NULL,
  `shop_address` VARCHAR(45) NULL DEFAULT NULL,
  `shop_website` VARCHAR(45) NULL DEFAULT NULL,
  `date_created` DATETIME NOT NULL,
  `shop_category` VARCHAR(45) NOT NULL,
  `shop_location` VARCHAR(45) NULL,
  `shop_email` VARCHAR(45) NULL,
  PRIMARY KEY (`shop_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`transaction` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`transaction` (
  `transaction_id` INT(11) NOT NULL AUTO_INCREMENT,
  `shop_shop_id` INT(11) NOT NULL,
  `transaction_item_id` INT(11) NOT NULL,
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `total` DOUBLE NULL DEFAULT NULL,
  `transaction_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`transaction_id`),
  INDEX `fk_transaction_item_id_idx` (`transaction_item_id` ASC),
  INDEX `fk_transaction_shop1_idx` (`shop_shop_id` ASC),
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
  `invoice_id` INT(11) NOT NULL,
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
-- Table `shopstack`.`role`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`role` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`role` (
  `role_id` INT(11) NOT NULL,
  `role` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`shop_users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`shop_users` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`shop_users` (
  `shop_id` INT(11) NOT NULL,
  `ss_users_user_id` INT(11) NOT NULL,
  `role_role_id` INT(11) NOT NULL,
  PRIMARY KEY (`shop_id`, `ss_users_user_id`),
  INDEX `fk_shop_has_ss_users_ss_users1_idx` (`ss_users_user_id` ASC),
  INDEX `fk_shop_has_ss_users_shop1_idx` (`shop_id` ASC),
  INDEX `fk_shop_users_role1_idx` (`role_role_id` ASC),
  CONSTRAINT `fk_shop_has_ss_users_shop1`
    FOREIGN KEY (`shop_id`)
    REFERENCES `shopstack`.`shop` (`shop_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shop_has_ss_users_ss_users1`
    FOREIGN KEY (`ss_users_user_id`)
    REFERENCES `shopstack`.`ss_users` (`ss_user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_shop_users_role1`
    FOREIGN KEY (`role_role_id`)
    REFERENCES `shopstack`.`role` (`role_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
