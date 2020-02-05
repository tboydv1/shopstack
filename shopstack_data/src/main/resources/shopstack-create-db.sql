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


-- -----------------------------------------------------
-- Table `mydb`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`category` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`category` (
  `category_id` INT(11) NOT NULL,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE INDEX `category_name_UNIQUE` (`category_name` ASC))
ENGINE = InnoDB;


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
-- Table `shopstack`.`ss_supplier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`ss_supplier` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`ss_supplier` (
  `supplier_id` INT(11) NOT NULL,
  `ss_display_name` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `company` VARCHAR(45) NULL DEFAULT NULL,
  `phone` INT(11) NOT NULL,
  `Title` VARCHAR(45) NULL,
  `middle_name` VARCHAR(45) NULL,
  `mobile` VARCHAR(45) NULL,
  `account_no` VARCHAR(45) NULL,
  PRIMARY KEY (`supplier_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`ss_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`ss_product` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`ss_product` (
  `product_code` INT(11) NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `purchase_date` DATE NOT NULL,
  `category_id` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
  `decription` VARCHAR(45) NULL DEFAULT NULL,
  `shop_shop_id` INT(11) NOT NULL,
  `ss_supplier_supplier_id` INT(11) NULL,
  PRIMARY KEY (`product_code`),
  INDEX `fk_product_category1_idx` (`category_id` ASC),
  INDEX `fk_ss_product_shop1_idx` (`shop_shop_id` ASC),
  INDEX `fk_ss_product_ss_supplier1_idx` (`ss_supplier_supplier_id` ASC),
  CONSTRAINT `fk_product_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `shopstack`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ss_product_shop1`
    FOREIGN KEY (`shop_shop_id`)
    REFERENCES `shopstack`.`shop` (`shop_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ss_product_ss_supplier1`
    FOREIGN KEY (`ss_supplier_supplier_id`)
    REFERENCES `shopstack`.`ss_supplier` (`supplier_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`line_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`line_item` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`line_item` (
  `ss_product_code` INT(11) NOT NULL,
  `description` VARCHAR(45) NULL DEFAULT NULL,
  `quantity` INT(11) NOT NULL,
  `price` DOUBLE NOT NULL,
  `amount` DOUBLE NOT NULL,
  PRIMARY KEY (`ss_product_code`),
  INDEX `fk_line_item_ss_product1_idx` (`ss_product_code` ASC),
  CONSTRAINT `fk_line_item_ss_product1`
    FOREIGN KEY (`ss_product_code`)
    REFERENCES `shopstack`.`ss_product` (`product_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `mydb`.`cash_invoice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`cash_invoice` ;

CREATE TABLE IF NOT EXISTS `mydb`.`cash_invoice` (
  `invoice_id` INT(11) NOT NULL,
  `line_item_ss_product_code` INT(11) NOT NULL,
  `invoice_date` DATE NOT NULL,
  `sub_total` DOUBLE NULL,
  `tax` DOUBLE NULL,
  `total` DOUBLE NULL,
  `description` VARCHAR(145) NULL,
  PRIMARY KEY (`invoice_id`),
  INDEX `fk_cash_invoice_line_item1_idx` (`line_item_ss_product_code` ASC),
  CONSTRAINT `fk_cash_invoice_line_item1`
    FOREIGN KEY (`line_item_ss_product_code`)
    REFERENCES `shopstack`.`line_item` (`ss_product_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `shopstack` ;

-- -----------------------------------------------------
-- Table `shopstack`.`ss_customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`ss_customer` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`ss_customer` (
  `customer_id` INT(11) NOT NULL,
  `ss_display_name` VARCHAR(45) NOT NULL,
  `ss_customer_title` VARCHAR(45) NULL,
  `ss_customer_email` VARCHAR(45) NOT NULL,
  `ss_customer_firstname` VARCHAR(45) NULL,
  `company` VARCHAR(45) NULL DEFAULT NULL,
  `ss_customer_phone` VARCHAR(45) NULL,
  `ss_customer_lastname` VARCHAR(45) NULL,
  `ss_customer_middlename` VARCHAR(45) NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`inventory`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`inventory` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`inventory` (
  `inventory_id` INT(11) NOT NULL AUTO_INCREMENT,
  `quantity_on_hand` INT(11) NOT NULL,
  `description` VARCHAR(145) NULL,
  `product_code` INT(11) NOT NULL,
  PRIMARY KEY (`inventory_id`, `product_code`),
  INDEX `fk_inventory_product1_idx` (`product_code` ASC),
  CONSTRAINT `fk_inventory_product1`
    FOREIGN KEY (`product_code`)
    REFERENCES `shopstack`.`ss_product` (`product_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`credit_invoice`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`credit_invoice` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`credit_invoice` (
  `invoice_id` INT(11) NOT NULL,
  `ss_customer_id` INT(11) NOT NULL,
  `balance_due` DOUBLE NOT NULL,
  `invoice_date` DATETIME NOT NULL,
  `invoice_due_date` VARCHAR(45) NOT NULL,
  `line_item_ss_product_code` INT(11) NOT NULL,
  `discount` DOUBLE NULL DEFAULT NULL,
  `tax` DOUBLE NULL DEFAULT NULL,
  `payments` DOUBLE NULL,
  `subtotal` VARCHAR(45) NULL,
  `total` DOUBLE NOT NULL,
  `invoice_notes` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`invoice_id`),
  INDEX `fk_invoice_ss_customer1_idx` (`ss_customer_id` ASC),
  INDEX `fk_invoice_line_item1_idx` (`line_item_ss_product_code` ASC),
  CONSTRAINT `fk_invoice_ss_customer1`
    FOREIGN KEY (`ss_customer_id`)
    REFERENCES `shopstack`.`ss_customer` (`customer_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_invoice_line_item1`
    FOREIGN KEY (`line_item_ss_product_code`)
    REFERENCES `shopstack`.`line_item` (`ss_product_code`)
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
  `status` VARCHAR(45) NULL DEFAULT NULL,
  `started_date` DATETIME NOT NULL,
  `date_completed` DATE NOT NULL,
  `shop_shop_id` INT(11) NOT NULL,
  `cash_invoice_id` INT(11) NOT NULL,
  `credit_invoice_id` INT(11) NOT NULL,
  PRIMARY KEY (`transaction_id`, `shop_shop_id`),
  INDEX `fk_transaction_shop1_idx` (`shop_shop_id` ASC),
  INDEX `fk_transaction_cash_invoice1_idx` (`cash_invoice_id` ASC),
  INDEX `fk_transaction_credit_invoice1_idx` (`credit_invoice_id` ASC),
  CONSTRAINT `fk_transaction_shop1`
    FOREIGN KEY (`shop_shop_id`)
    REFERENCES `shopstack`.`shop` (`shop_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_cash_invoice1`
    FOREIGN KEY (`cash_invoice_id`)
    REFERENCES `shopstack`.`cash_invoice` (`invoice_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_transaction_credit_invoice1`
    FOREIGN KEY (`credit_invoice_id`)
    REFERENCES `shopstack`.`credit_invoice` (`invoice_id`)
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
