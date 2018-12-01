-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema atlantiscitybowlingalleydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema atlantiscitybowlingalleydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `atlantiscitybowlingalleydb` DEFAULT CHARACTER SET utf8 ;
USE `atlantiscitybowlingalleydb` ;

-- -----------------------------------------------------
-- Table `atlantiscitybowlingalleydb`.`customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atlantiscitybowlingalleydb`.`customers` (
  `customers_customerID` INT(11) NOT NULL AUTO_INCREMENT,
  `customers_lastName` VARCHAR(45) NOT NULL,
  `customer_firstName` VARCHAR(45) NOT NULL,
  `customers_phoneNumber` VARCHAR(45) NOT NULL,
  `customers_email` VARCHAR(60) NULL DEFAULT NULL,
  `customers_registrationDate` DATE NOT NULL,
  `customers_deactive` TINYINT(4) NULL DEFAULT NULL,
  `customers_deactiveDate` DATE NULL DEFAULT NULL,
  PRIMARY KEY (`customers_customerID`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `atlantiscitybowlingalleydb`.`shoes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atlantiscitybowlingalleydb`.`shoes` (
  `shoes_shoeID` INT(11) NOT NULL AUTO_INCREMENT,
  `shoes_gender` CHAR(1) NOT NULL,
  `shoes_shoeSize` DOUBLE NOT NULL,
  `shoes_shoeWidth` CHAR(1) NULL DEFAULT NULL,
  `shoes_ageGroup` CHAR(1) NOT NULL,
  `shoes_isCheckedOut` TINYINT(4) NOT NULL,
  `shoes_retireShoe` TINYINT(4) NOT NULL,
  PRIMARY KEY (`shoes_shoeID`),
  UNIQUE INDEX `dhoes_shoesID_UNIQUE` (`shoes_shoeID` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `atlantiscitybowlingalleydb`.`shoes_customers`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `atlantiscitybowlingalleydb`.`shoes_customers` (
  `sc_shoes_customersID` INT(11) NOT NULL AUTO_INCREMENT,
  `sc_customerID` INT(11) NOT NULL,
  `sc_shoeID` INT(11) NOT NULL,
  `sc_checkedOutDate` DATETIME NOT NULL,
  `sc_checkInDate` DATETIME NOT NULL,
  `customers_customers_customerID` INT(11) NOT NULL,
  `shoes_shoes_shoeID` INT(11) NOT NULL,
  PRIMARY KEY (`sc_shoes_customersID`, `customers_customers_customerID`, `shoes_shoes_shoeID`),
  INDEX `fk_shoes_customers_customers1_idx` (`customers_customers_customerID` ASC),
  INDEX `fk_shoes_customers_shoes1_idx` (`shoes_shoes_shoeID` ASC),
  CONSTRAINT `fk_shoes_customers_customers1`
    FOREIGN KEY (`customers_customers_customerID`)
    REFERENCES `atlantiscitybowlingalleydb`.`customers` (`customers_customerID`),
  CONSTRAINT `fk_shoes_customers_shoes1`
    FOREIGN KEY (`shoes_shoes_shoeID`)
    REFERENCES `atlantiscitybowlingalleydb`.`shoes` (`shoes_shoeID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
