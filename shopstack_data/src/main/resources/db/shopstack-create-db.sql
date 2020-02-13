-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';


-- -----------------------------------------------------
-- Schema shopstack
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `shopstack` DEFAULT CHARACTER SET latin1 ;
USE `shopstack` ;

-----------------------------------------------------
-- Table `shopstack`.`business_category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`business_category` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`business_category` (
  `biz_category_id` INT(11) NOT NULL AUTO_INCREMENT,
  `biz_category_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`biz_category_id`),
  UNIQUE INDEX `biz_category_name_UNIQUE` (`biz_category_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`business_services`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`business_services` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`business_services` (
  `biz_service_id` INT(11) NOT NULL AUTO_INCREMENT,
  `biz_service_name` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`biz_service_id`),
  UNIQUE INDEX `biz_service_name_UNIQUE` (`biz_service_name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`ss_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`ss_user` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`ss_user` (
  `ss_user_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ss_title` VARCHAR(45) NULL DEFAULT NULL,
  `ss_first_name` VARCHAR(45) NOT NULL,
  `ss_last_name` VARCHAR(45) NOT NULL,
  `ss_address` VARCHAR(45) NULL DEFAULT NULL,
  `ss_email` VARCHAR(45) NOT NULL,
  `ss_phone_number` VARCHAR(45) NOT NULL,
  `ss_date_joined` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ss_password` VARCHAR(45) NOT NULL,
  `ss_enabled` TINYINT(1) NOT NULL,
  `ss_status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ss_user_id`, `ss_email`),
  INDEX `index2` (`ss_email` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`ss_business`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`ss_business` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`ss_business` (
  `biz_id` INT(11) NOT NULL AUTO_INCREMENT,
  `biz_logo` VARCHAR(45) NULL DEFAULT NULL,
  `biz_name` VARCHAR(45) NOT NULL,
  `biz_email` VARCHAR(45) NOT NULL,
  `biz_website` VARCHAR(45) NULL DEFAULT NULL,
  `biz_phone` VARCHAR(45) NULL DEFAULT NULL,
  `date_created` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `biz_category_id` INT(11) NOT NULL,
  `biz_service_id` INT(11) NOT NULL,
  `biz_creator` INT(11) NOT NULL,
  PRIMARY KEY (`biz_id`),
  INDEX `fk_biz_category1_idx` (`biz_category_id` ASC),
  INDEX `fk_biz_services1_idx` (`biz_service_id` ASC),
  INDEX `fk_ss_business_ss_user1_idx` (`biz_creator` ASC),
  CONSTRAINT `fk_biz_category1`
    FOREIGN KEY (`biz_category_id`)
    REFERENCES `shopstack`.`business_category` (`biz_category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_biz_service1`
    FOREIGN KEY (`biz_service_id`)
    REFERENCES `shopstack`.`business_services` (`biz_service_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ss_business_ss_user1`
    FOREIGN KEY (`biz_creator`)
    REFERENCES `shopstack`.`ss_user` (`ss_user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`ss_business_accounts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`ss_business_accounts` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`ss_business_accounts` (
  `account_number` INT(11) NOT NULL,
  `bank_name` VARCHAR(45) NOT NULL,
  `account_name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`account_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`ss_business_outlet`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`ss_business_outlet` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`ss_business_outlet` (
  `ss_business_outlet_id` INT(11) NOT NULL AUTO_INCREMENT,
  `ss_outlet_display_name` VARCHAR(50) NOT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `location` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL DEFAULT NULL,
  `date_added` DATE NULL DEFAULT NULL,
  `ss_business_biz_id` INT(11) NOT NULL,
  `ss_business_account_number` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`ss_business_outlet_id`),
  INDEX `fk_ss_business_outlet_ss_business1_idx` (`ss_business_biz_id` ASC),
  INDEX `fk_ss_business_outlet_ss_business_accounts1_idx` (`ss_business_account_number` ASC),
  CONSTRAINT `fk_ss_business_outlet_ss_business1`
    FOREIGN KEY (`ss_business_biz_id`)
    REFERENCES `shopstack`.`ss_business` (`biz_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ss_business_outlet_ss_business_accounts1`
    FOREIGN KEY (`ss_business_account_number`)
    REFERENCES `shopstack`.`ss_business_accounts` (`account_number`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`business_outlet_has_employee`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`business_outlet_has_employee` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`business_outlet_has_employee` (
  `ss_business_outlet_id` INT(11) NOT NULL,
  `ss_user_id` INT(11) NOT NULL,
  PRIMARY KEY (`ss_business_outlet_id`, `ss_user_id`),
  INDEX `fk_ss_business_outlet_has_ss_user_ss_user1_idx` (`ss_user_id` ASC),
  INDEX `fk_ss_business_outlet_has_ss_user_ss_business_outlet1_idx` (`ss_business_outlet_id` ASC),
  CONSTRAINT `fk_ss_business_outlet_has_ss_user_ss_business_outlet1`
    FOREIGN KEY (`ss_business_outlet_id`)
    REFERENCES `shopstack`.`ss_business_outlet` (`ss_business_outlet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ss_business_outlet_has_ss_user_ss_user1`
    FOREIGN KEY (`ss_user_id`)
    REFERENCES `shopstack`.`ss_user` (`ss_user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`category` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`category` (
  `category_id` INT(11) NOT NULL,
  `category_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE INDEX `category_name_UNIQUE` (`category_name` ASC))
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
  PRIMARY KEY (`product_code`),
  INDEX `fk_product_category1_idx` (`category_id` ASC),
  CONSTRAINT `fk_product_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `shopstack`.`category` (`category_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`business_outlet_has_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`business_outlet_has_product` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`business_outlet_has_product` (
  `business_outlet_id` INT(11) NOT NULL,
  `product_code` INT(11) NOT NULL,
  PRIMARY KEY (`business_outlet_id`, `product_code`),
  INDEX `fk_ss_business_outlet_has_ss_product_ss_product1_idx` (`product_code` ASC),
  INDEX `fk_ss_business_outlet_has_ss_product_ss_business_outlet1_idx` (`business_outlet_id` ASC),
  CONSTRAINT `fk_ss_business_outlet_has_ss_product_ss_business_outlet1`
    FOREIGN KEY (`business_outlet_id`)
    REFERENCES `shopstack`.`ss_business_outlet` (`ss_business_outlet_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ss_business_outlet_has_ss_product_ss_product1`
    FOREIGN KEY (`product_code`)
    REFERENCES `shopstack`.`ss_product` (`product_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `shopstack`.`customer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `shopstack`.`customer` ;

CREATE TABLE IF NOT EXISTS `shopstack`.`customer` (
  `customer_id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NULL DEFAULT NULL,
  `firstname` VARCHAR(45) NULL DEFAULT NULL,
  `lastname` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NULL DEFAULT NULL,
  `ss_business_outlet_ss_business_outlet_id` INT(11) NOT NULL,
  PRIMARY KEY (`customer_id`),
  INDEX `fk_customer_ss_business_outlet1_idx` (`ss_business_outlet_ss_business_outlet_id` ASC),
  CONSTRAINT `fk_customer_ss_business_outlet1`
    FOREIGN KEY (`ss_business_outlet_ss_business_outlet_id`)
    REFERENCES `shopstack`.`ss_business_outlet` (`ss_business_outlet_id`)
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
  `business_outlet_id` INT(11) NOT NULL,
  PRIMARY KEY (`transaction_id`),
  INDEX `fk_transaction_ss_business_outlet1_idx` (`business_outlet_id` ASC),
  CONSTRAINT `fk_transaction_ss_business_outlet1`
    FOREIGN KEY (`business_outlet_id`)
    REFERENCES `shopstack`.`ss_business_outlet` (`ss_business_outlet_id`)
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
  `transaction_id` INT(11) NOT NULL,
  PRIMARY KEY (`ss_product_code`),
  INDEX `fk_line_item_ss_product1_idx` (`ss_product_code` ASC),
  INDEX `fk_line_item_transaction1_idx` (`transaction_id` ASC),
  CONSTRAINT `fk_line_item_ss_product1`
    FOREIGN KEY (`ss_product_code`)
    REFERENCES `shopstack`.`ss_product` (`product_code`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_line_item_transaction1`
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
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `role` VARCHAR(50) NOT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`role_id`),
  INDEX `fk_role_user_email_idx` (`user_email` ASC),
  CONSTRAINT `fk_role_user_email`
    FOREIGN KEY (`user_email`)
    REFERENCES `shopstack`.`ss_user` (`ss_email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
