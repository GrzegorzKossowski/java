SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `registration` ;
CREATE SCHEMA IF NOT EXISTS `registration` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `registration` ;

-- -----------------------------------------------------
-- Table `registration`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `registration`.`DBUser` ;

CREATE TABLE IF NOT EXISTS `registration`.`DBUser` (
  `idUser` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `priviledge` INT NULL,
  `description` VARCHAR(400) NULL DEFAULT NULL,
  PRIMARY KEY (`idUser`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8;

/*
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`)  
VALUES ("admin", "0192023a7bbd73250516f069df18b500", 0);
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`)  
VALUES ("doctor", "b3666d14ca079417ba6c2a99f079b2ac", 1);
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`)  
VALUES ("user", "b5b73fae0d87d8b4e2573105f8fbe7bc", 2);
*/

INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`, `description`)
VALUES ("admin123", "admin123", 0, "Christian Michael Leonard Slater was born on August 18, 1969 in New");
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`, `description`)
VALUES ("doctor12", "doctor12", 1, "Ana de Armas was born in Cuba on April 30, 1988. At the age of 14");
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`, `description`)
VALUES ("user1234", "user1234", 2, "Saoirse Una Ronan was born in The Bronx, New York City, New York, Un");

INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`, `description`)
VALUES ("kicia", "narazie", 1, "José María Caro Rodríguez (ur. 23 czerwca 1866 w San Antonio de Petr");
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`, `description`)
VALUES ("massager", "bazie", 1, "Dydona i Eneasz (ang. Dido and Aeneas) – opera w trzech aktach do l");
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`, `description`)
VALUES ("pluszak", "taboret", 0, "Osadzanie topionego materiału (FDM, ang. fused deposition modelling)");
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`, `description`)
VALUES ("cinkciarz", "zgaslo", 2, "Port lotniczy Interlaken-Matten – szwajcarski port lotniczy położ");
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`, `description`)
VALUES ("loveDoll", "trzaslo", 2, "an Adach, ps. Czer (ur. 3 czerwca 1913 w Nowym Franciszkowie) – p");
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`, `description`)
VALUES ("professur", "maslo", 1, "Polskojęzyczne encyklopedie − encyklopedie wydane w języku polskim");
INSERT INTO `registration`.`DBUser` (`login`, `password`, `priviledge`, `description`)
VALUES ("kleszczu", "haslo", 2, "Harry Potter i Insygnia Śmierci: Część II (oryg. Harry Potter and t");


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
