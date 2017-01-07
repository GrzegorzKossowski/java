-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

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
VALUES ('Adam', 'Beka', '48 229-876-521', '48 792-456-654', 'adam.beka@tvp.com'),
('Barbara', 'Cep', '48 818-724-245', '48 512-654-123', 'barbara.cep@example.com'),
('Cecylia', 'Dudek', '48 645-555-555', '48 741-123-988', 'cecka@example.eu'),
('Edward', 'Fornal', '49 221-852-456', '49 156-225-654', 'fafik@autobahn.de'),
('Emma','Smith','39 22 968660927','49 22 923842054','Emma.Smith@example.com'),
('Olivia','Jones','40 22 386709545','50 22 778207805','Olivia.Jones@example.com'),
('Sophia','Taylor','41 22 678286511','51 22 508944842','Sophia.Taylor@example.com'),
('Ava','Williams','42 22 656340119','52 22 915173285','Ava.Williams@example.com'),
('Isabella','Brown','43 22 406844525','53 22 584608778','Isabella.Brown@example.com'),
('Mia','Davies','44 22 733014974','54 22 433042622','Mia.Davies@example.com'),
('Abigail','Evans','45 22 645886679','55 22 103830291','Abigail.Evans@example.com'),
('Emily','Wilson','46 22 748082494','56 22 644603283','Emily.Wilson@example.com'),
('Charlotte','Thomas','47 22 233971563','57 22 428355877','Charlotte.Thomas@example.com'),
('Harper','Roberts','48 22 797693656','58 22 572862633','Harper.Roberts@example.com'),
('Madison','Johnson','49 22 161911942','59 22 428355877','Madison.Johnson@example.com'),
('Amelia','Lewis','50 22 783259653','60 22 572862633','Amelia.Lewis@example.com'),
('Elizabeth','Walker','51 22 923842054','61 22 904896715','Elizabeth.Walker@example.com'),
('Sofia','Robinson','52 22 778207805','62 22 197336680','Sofia.Robinson@example.com'),
('Evelyn','Wood','53 22 508944842','63 22 968660927','Evelyn.Wood@example.com'),
('Avery','Thompson','54 22 915173285','64 22 386709545','Avery.Thompson@example.com'),
('Chloe','White','55 22 584608778','65 22 678286511','Chloe.White@example.com'),
('Ella','Watson','56 22 433042622','66 22 656340119','Ella.Watson@example.com'),
('Grace','Jackson','57 22 103830291','67 22 406844525','Grace.Jackson@example.com'),
('Victoria','Wright','58 22 644603283','68 22 733014974','Victoria.Wright@example.com'),
('Aubrey','Green','59 22 428355877','69 22 645886679','Aubrey.Green@example.com'),
('Scarlett','Harris','60 22 572862633','70 22 748082494','Scarlett.Harris@example.com'),
('Zoey','Cooper','61 22 904896715','71 22 233971563','Zoey.Cooper@example.com'),
('Addison','King','62 22 197336680','72 22 797693362','Addison.King@example.com'),
('Lily','Lee','63 22 968660927','73 22 161911942','Lily.Lee@example.com'),
('Lillian','Martin','64 22 386709545','74 22 783259653','Lillian.Martin@example.com'),
('Natalie','Clarke','65 22 678286511','75 22 923842054','Natalie.Clarke@example.com'),
('Hannah','James','66 22 656340119','76 22 778207805','Hannah.James@example.com'),
('Aria','Morgan','67 22 406844525','77 22 508944842','Aria.Morgan@example.com'),
('Layla','Hughes','68 22 733014974','53 22 508944842','Layla.Hughes@example.com'),
('Brooklyn','Edwards','69 22 645886679','54 22 915173285','Brooklyn.Edwards@example.com'),
('Alexa','Hill','70 22 748082494','55 22 584608778','Alexa.Hill@example.com'),
('Zoe','Moore','71 22 233971563','56 22 433042622','Zoe.Moore@example.com'),
('Penelope','Clark','72 22 797693362','57 22 103830291','Penelope.Clark@example.com'),
('Riley','Harrison','73 22 161911942','58 22 644603283','Riley.Harrison@example.com'),
('Leah','Scott','74 22 783259653','59 22 428355877','Leah.Scott@example.com'),
('Audrey','Young','75 22 923842054','60 22 572862633','Audrey.Young@example.com'),
('Savannah','Morris','76 22 778207805','61 22 904896715','Savannah.Morris@example.com'),
('Allison','Hall','77 22 508944842','62 22 197336680','Allison.Hall@example.com'),
('Samantha','Ward','78 22 915173285','63 22 968660927','Samantha.Ward@example.com');
;
