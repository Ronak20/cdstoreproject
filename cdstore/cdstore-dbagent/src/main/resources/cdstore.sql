SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `cdstore` ;
CREATE SCHEMA IF NOT EXISTS `cdstore` DEFAULT CHARACTER SET utf8 ;
USE `cdstore` ;

-- -----------------------------------------------------
-- Table `cdstore`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`address` ;

CREATE TABLE IF NOT EXISTS `cdstore`.`address` (
  `addressid` BIGINT NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(100) NOT NULL,
  `province` VARCHAR(20) NOT NULL,
  `country` VARCHAR(20) NOT NULL,
  `zip` VARCHAR(20) NOT NULL,
  `phone` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`addressid`))
ENGINE = InnoDB
AUTO_INCREMENT = 4;


-- -----------------------------------------------------
-- Table `cdstore`.`cd`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`cd` ;

CREATE TABLE IF NOT EXISTS `cdstore`.`cd` (
  `cdid` VARCHAR(20) NOT NULL,
  `title` VARCHAR(60) NOT NULL,
  `price` INT(10) UNSIGNED NOT NULL,
  `category` ENUM('COUNTRY','POP','ROCK') NOT NULL,
  PRIMARY KEY (`cdid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cdstore`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`user` ;

CREATE TABLE IF NOT EXISTS `cdstore`.`user` (
  `userid` BIGINT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `addressid` BIGINT NOT NULL,
  PRIMARY KEY (`userid`),
  CONSTRAINT `fk_user_address`
    FOREIGN KEY (`addressid`)
    REFERENCES `cdstore`.`address` (`addressid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_user_address_idx` ON `cdstore`.`user` (`addressid` ASC);


-- -----------------------------------------------------
-- Table `cdstore`.`po`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`po` ;

CREATE TABLE IF NOT EXISTS `cdstore`.`po` (
  `poid` BIGINT NOT NULL AUTO_INCREMENT,
  `status` ENUM('ORDERED','PROCESSED','DENIED') NOT NULL,
  `userid` BIGINT NOT NULL,
  PRIMARY KEY (`poid`),
  CONSTRAINT `fk_po_user`
    FOREIGN KEY (`userid`)
    REFERENCES `cdstore`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4;

CREATE INDEX `fk_po_user_idx` ON `cdstore`.`po` (`userid` ASC);


-- -----------------------------------------------------
-- Table `cdstore`.`poitem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`poitem` ;

CREATE TABLE IF NOT EXISTS `cdstore`.`poitem` (
  `poid` BIGINT NOT NULL,
  `cdid` VARCHAR(20) NOT NULL,
  `price` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`poid`, `cdid`),
  CONSTRAINT `fk_poitem_po`
    FOREIGN KEY (`poid`)
    REFERENCES `cdstore`.`po` (`poid`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_poitem_cd`
    FOREIGN KEY (`cdid`)
    REFERENCES `cdstore`.`cd` (`cdid`)
    ON DELETE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `id` ON `cdstore`.`poitem` (`poid` ASC);

CREATE INDEX `cdid` ON `cdstore`.`poitem` (`cdid` ASC);


-- -----------------------------------------------------
-- Table `cdstore`.`visitevent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstore`.`visitevent` ;

CREATE TABLE IF NOT EXISTS `cdstore`.`visitevent` (
  `visiteventid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `day` VARCHAR(8) NOT NULL,
  `cdid` VARCHAR(20) NOT NULL,
  `eventtype` ENUM('VIEW','CART','PURCHASE') NOT NULL,
  PRIMARY KEY (`visiteventid`),
  CONSTRAINT `fk_visitevent_cd`
    FOREIGN KEY (`cdid`)
    REFERENCES `cdstore`.`cd` (`cdid`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `cdid` ON `cdstore`.`visitevent` (`cdid` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
