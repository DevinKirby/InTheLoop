-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`Parks`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Parks` (
  `ParksID` INT NOT NULL COMMENT '',
  `Address` VARCHAR(45) NULL COMMENT '',
  `Rating` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`ParksID`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Stops`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Stops` (
  `StopID` INT NOT NULL COMMENT '',
  `Address` VARCHAR(45) NULL COMMENT '',
  `Rating` VARCHAR(45) NULL COMMENT '',
  `ParksID` INT NULL COMMENT '',
  PRIMARY KEY (`StopID`)  COMMENT '',
  INDEX `ParksID_FK_idx` (`ParksID` ASC)  COMMENT '',
  CONSTRAINT `ParksID_FK`
    FOREIGN KEY (`ParksID`)
    REFERENCES `mydb`.`Parks` (`ParksID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Locations`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Locations` (
  `LocationsID` INT NOT NULL COMMENT '',
  `Address` VARCHAR(45) NULL COMMENT '',
  `Latitude` VARCHAR(45) NULL COMMENT '',
  `Name` VARCHAR(45) NULL COMMENT '',
  `Longitude` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`LocationsID`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `UserId` INT NOT NULL COMMENT '',
  `Name` VARCHAR(45) NULL COMMENT '',
  `Location` VARCHAR(45) NULL COMMENT '',
  `Address` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`UserId`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`UserLinkTable`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`UserLinkTable` (
  `Link` INT NOT NULL COMMENT '',
  PRIMARY KEY (`Link`)  COMMENT '')
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`User` (
  `UserId` INT NOT NULL COMMENT '',
  `Name` VARCHAR(45) NULL COMMENT '',
  `Location` VARCHAR(45) NULL COMMENT '',
  `Address` VARCHAR(45) NULL COMMENT '',
  PRIMARY KEY (`UserId`)  COMMENT '')
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
