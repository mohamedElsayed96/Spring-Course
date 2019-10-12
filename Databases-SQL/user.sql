-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema user
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema user
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `user` DEFAULT CHARACTER SET utf8 ;
USE `user` ;

-- -----------------------------------------------------
-- Table `user`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `create_time` TIMESTAMP NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`.`view`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user`.`view` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`.`action`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user`.`action` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`.`authority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user`.`authority` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`.`user_view`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user`.`user_view` (
  `user_id` INT NOT NULL,
  `view_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `view_id`),
  INDEX `fk_user_has_view_view1_idx` (`view_id` ASC) VISIBLE,
  INDEX `fk_user_has_view_user_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_view_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `user`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_view_view1`
    FOREIGN KEY (`view_id`)
    REFERENCES `user`.`view` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`.`user_action`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user`.`user_action` (
  `action_id` INT NOT NULL,
  `user_id` INT NOT NULL,
  PRIMARY KEY (`action_id`, `user_id`),
  INDEX `fk_action_has_user_user1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_action_has_user_action1_idx` (`action_id` ASC) VISIBLE,
  CONSTRAINT `fk_action_has_user_action1`
    FOREIGN KEY (`action_id`)
    REFERENCES `user`.`action` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_action_has_user_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `user`.`user_authority`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `user`.`user_authority` (
  `user_id` INT NOT NULL,
  `authority_id` INT NOT NULL,
  PRIMARY KEY (`user_id`, `authority_id`),
  INDEX `fk_user_has_authority_authority1_idx` (`authority_id` ASC) VISIBLE,
  INDEX `fk_user_has_authority_user1_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_user_has_authority_user1`
    FOREIGN KEY (`user_id`)
    REFERENCES `user`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_has_authority_authority1`
    FOREIGN KEY (`authority_id`)
    REFERENCES `user`.`authority` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
