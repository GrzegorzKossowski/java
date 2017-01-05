-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema phonebook
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `phonebook` ;

-- -----------------------------------------------------
-- Schema phonebook
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `phonebook` DEFAULT CHARACTER SET utf8 ;
USE `phonebook` ;

-- -----------------------------------------------------
-- Table `phonebook`.`person`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phonebook`.`person` ;

CREATE TABLE IF NOT EXISTS `phonebook`.`person` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `lastname` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `phone` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `mobile` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  `email` VARCHAR(45) CHARACTER SET 'utf8' NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


-- -----------------------------------------------------
-- Table `phonebook`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `phonebook`.`user` ;

CREATE TABLE IF NOT EXISTS `phonebook`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  `password` VARCHAR(45) CHARACTER SET 'utf8' NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_unicode_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


INSERT INTO `phonebook`.`user` (`login`, `password`) 
VALUES ('tom', 'tom001'), ('jerry', 'jerry001'), ('mickey', 'mouse123');

INSERT INTO `phonebook`.`person` (`firstname`, `lastname`, `phone`, `mobile`, `email`) 
VALUES ('Adam', 'Słodowy', '48 229-876-521', '48 792-456-654', 'adam.slodowy@tvp.com'),
('Barbara', 'Ćwikła', '48 818-724-245', '48 512-654-123', 'barbara.cwikla@example.com'),
('Cecylia', 'Dławik', '48 645-555-555', '48 741-123-988', 'cecka@example.eu'),
('Edward', 'Fąfara', '49 221-852-456', '49 156-225-654', 'fafik@autobahn.de');
