SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `cdstoretest` ;
CREATE SCHEMA IF NOT EXISTS `cdstoretest` DEFAULT CHARACTER SET utf8 ;
USE `cdstoretest` ;

-- -----------------------------------------------------
-- Table `cdstoretest`.`address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstoretest`.`address` ;

CREATE TABLE IF NOT EXISTS `cdstoretest`.`address` (
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
-- Table `cdstoretest`.`cd`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstoretest`.`cd` ;

CREATE TABLE IF NOT EXISTS `cdstoretest`.`cd` (
  `cdid` VARCHAR(20) NOT NULL,
  `title` VARCHAR(60) NOT NULL,
  `price` INT(10) UNSIGNED NOT NULL,
  `category` ENUM('COUNTRY','POP','ROCK') NOT NULL,
  PRIMARY KEY (`cdid`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `cdstoretest`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstoretest`.`user` ;

CREATE TABLE IF NOT EXISTS `cdstoretest`.`user` (
  `userid` BIGINT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `addressid` BIGINT NOT NULL,
  PRIMARY KEY (`userid`),
  CONSTRAINT `fk_user_address`
    FOREIGN KEY (`addressid`)
    REFERENCES `cdstoretest`.`address` (`addressid`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `fk_user_address_idx` ON `cdstoretest`.`user` (`addressid` ASC);


-- -----------------------------------------------------
-- Table `cdstoretest`.`po`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstoretest`.`po` ;

CREATE TABLE IF NOT EXISTS `cdstoretest`.`po` (
  `poid` BIGINT NOT NULL AUTO_INCREMENT,
  `status` ENUM('ORDERED','PROCESSED','DENIED') NOT NULL,
  `userid` BIGINT NOT NULL,
  PRIMARY KEY (`poid`),
  CONSTRAINT `fk_po_user`
    FOREIGN KEY (`userid`)
    REFERENCES `cdstoretest`.`user` (`userid`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4;

CREATE INDEX `fk_po_user_idx` ON `cdstoretest`.`po` (`userid` ASC);


-- -----------------------------------------------------
-- Table `cdstoretest`.`poitem`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstoretest`.`poitem` ;

CREATE TABLE IF NOT EXISTS `cdstoretest`.`poitem` (
  `poid` BIGINT NOT NULL,
  `cdid` VARCHAR(20) NOT NULL,
  `price` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`poid`, `cdid`),
  CONSTRAINT `fk_poitem_po`
    FOREIGN KEY (`poid`)
    REFERENCES `cdstoretest`.`po` (`poid`)
    ON DELETE CASCADE
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_poitem_cd`
    FOREIGN KEY (`cdid`)
    REFERENCES `cdstoretest`.`cd` (`cdid`)
    ON DELETE CASCADE)
ENGINE = InnoDB;

CREATE INDEX `id` ON `cdstoretest`.`poitem` (`poid` ASC);

CREATE INDEX `cdid` ON `cdstoretest`.`poitem` (`cdid` ASC);


-- -----------------------------------------------------
-- Table `cdstoretest`.`visitevent`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `cdstoretest`.`visitevent` ;

CREATE TABLE IF NOT EXISTS `cdstoretest`.`visitevent` (
  `visiteventid` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `day` VARCHAR(8) NOT NULL,
  `cdid` VARCHAR(20) NOT NULL,
  `eventtype` ENUM('VIEW','CART','PURCHASE') NOT NULL,
  PRIMARY KEY (`visiteventid`),
  CONSTRAINT `fk_visitevent_cd`
    FOREIGN KEY (`cdid`)
    REFERENCES `cdstoretest`.`cd` (`cdid`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `cdid` ON `cdstoretest`.`visitevent` (`cdid` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Table `cdstore`.`cd`
-- -----------------------------------------------------
INSERT INTO CD (cdid, title, price, category) VALUES ('cd001', 'Johnny Cash Greatest Hits', 1599, 'COUNTRY');
INSERT INTO CD (cdid, title, price, category) VALUES ('cd002','Willy Nelson Greatest', 1599, 'COUNTRY');
INSERT INTO CD (cdid, title, price, category) VALUES ('cd003','Patsy Cline Im So Lonely' ,1599,'COUNTRY');
INSERT INTO CD (cdid, title, price, category) VALUES ('cd004', 'Tragically Hip Fully Completely', 2000, 'ROCK');
INSERT INTO CD (cdid, title, price, category) VALUES ('cd005', 'Beatles White Album', 2000, 'ROCK');
INSERT INTO CD (cdid, title, price, category) VALUES ('cd006', 'Rolling Stones Forty Licks', 2000, 'ROCK');
INSERT INTO CD (cdid, title, price, category) VALUES ('cd007', 'Madonna Greatest Hits', 1799, 'POP');
INSERT INTO CD (cdid, title, price, category) VALUES ('cd008', 'Alannis Morissette Jagged Little Pill', 1799, 'POP');
INSERT INTO CD (cdid, title, price, category) VALUES ('cd009', 'Video Killed the Radio Star', 1799, 'POP');

--
-- Dumping data for table `address`
--

LOCK TABLES `address` WRITE;
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` VALUES (1,'123 King adward','ON','Canada','K1E 6T5','613-123-4567');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (9,'jon','jon','jon','6cb570acdab0e0bfc8e3dcb7bb4edf',1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `po`
--

LOCK TABLES `po` WRITE;
/*!40000 ALTER TABLE `po` DISABLE KEYS */;
INSERT INTO `po` VALUES (2,'ORDERED',9);
/*!40000 ALTER TABLE `po` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `poitem`
--

LOCK TABLES `poitem` WRITE;
/*!40000 ALTER TABLE `poitem` DISABLE KEYS */;
INSERT INTO `poitem` VALUES (2,'cd001',100),(2,'cd002',100),(2,'cd003',100);
/*!40000 ALTER TABLE `poitem` ENABLE KEYS */;
UNLOCK TABLES;