-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema flowidea_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema flowidea_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `flowidea_db` DEFAULT CHARACTER SET utf8 ;
USE `flowidea_db` ;

-- -----------------------------------------------------
-- Table `flowidea_db`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowidea_db`.`users` (
  `id_user` INT NOT NULL AUTO_INCREMENT,
  `fullname` VARCHAR(45) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_user`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flowidea_db`.`idea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowidea_db`.`idea` (
  `id_idea` INT NOT NULL AUTO_INCREMENT,
  `content` VARCHAR(255) NOT NULL,
  `in_time` TIMESTAMP NOT NULL,
  `likes` INT NOT NULL,
  `id_has_user` INT NOT NULL,
  PRIMARY KEY (`id_idea`, `id_has_user`),
  INDEX `fk_idea_users_idx` (`id_has_user` ASC),
  CONSTRAINT `fk_idea_users`
    FOREIGN KEY (`id_has_user`)
    REFERENCES `flowidea_db`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `flowidea_db`.`users_like_idea`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flowidea_db`.`users_like_idea` (
  `id_lkd_user` INT NOT NULL,
  `id_lkd_idea` INT NOT NULL,
  `lkd_date` TIMESTAMP NULL,
  PRIMARY KEY (`id_lkd_user`, `id_lkd_idea`),
  INDEX `fk_users_has_idea_idea1_idx` (`id_lkd_idea` ASC),
  INDEX `fk_users_has_idea_users1_idx` (`id_lkd_user` ASC),
  CONSTRAINT `fk_users_has_idea_users1`
    FOREIGN KEY (`id_lkd_user`)
    REFERENCES `flowidea_db`.`users` (`id_user`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_users_has_idea_idea1`
    FOREIGN KEY (`id_lkd_idea`)
    REFERENCES `flowidea_db`.`idea` (`id_idea`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
