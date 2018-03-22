-- MySQL Script generated by MySQL Workbench
-- Thu Mar 22 13:52:06 2018
-- Model: New Model    Version: 1.0
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
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`SignIn_info`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`SignIn_info` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `age` INT(3) NOT NULL,
  `education` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Admin` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `SignIn_info_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_admin_SignIn_info1_idx` (`SignIn_info_id` ASC),
  CONSTRAINT `fk_admin_SignIn_info1`
    FOREIGN KEY (`SignIn_info_id`)
    REFERENCES `mydb`.`SignIn_info` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Teacher` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `SignIn_info_id` INT NOT NULL,
  `spetialization` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Teacher_SignIn_info1_idx` (`SignIn_info_id` ASC),
  CONSTRAINT `fk_Teacher_SignIn_info1`
    FOREIGN KEY (`SignIn_info_id`)
    REFERENCES `mydb`.`SignIn_info` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Scholar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Scholar` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `SignIn_info_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_scholar_SignIn_info1_idx` (`SignIn_info_id` ASC),
  CONSTRAINT `fk_scholar_SignIn_info1`
    FOREIGN KEY (`SignIn_info_id`)
    REFERENCES `mydb`.`SignIn_info` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Subject_scholar_list`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Subject_scholar_list` (
  `ID` INT NOT NULL,
  `Scholar_id` INT NOT NULL,
  `Registration` DATE NOT NULL,
  `Expiration` DATE NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Subject_scholar_list_Scholar1_idx` (`Scholar_id` ASC),
  CONSTRAINT `fk_Subject_scholar_list_Scholar1`
    FOREIGN KEY (`Scholar_id`)
    REFERENCES `mydb`.`Scholar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Subject` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `duration` TIME(5) NOT NULL,
  `Teacher_id` INT NOT NULL,
  `Scholar_list_ID` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Subject_Teacher1_idx` (`Teacher_id` ASC),
  INDEX `fk_Subject_Subject_scholar_list1_idx` (`Scholar_list_ID` ASC),
  CONSTRAINT `fk_Subject_Teacher1`
    FOREIGN KEY (`Teacher_id`)
    REFERENCES `mydb`.`Teacher` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Subject_Subject_scholar_list1`
    FOREIGN KEY (`Scholar_list_ID`)
    REFERENCES `mydb`.`Subject_scholar_list` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Lesson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Lesson` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `theme` VARCHAR(45) NOT NULL,
  `duration` TIME(5) NOT NULL,
  `Subject_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Lesson_Subject1_idx` (`Subject_id` ASC),
  CONSTRAINT `fk_Lesson_Subject1`
    FOREIGN KEY (`Subject_id`)
    REFERENCES `mydb`.`Subject` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Teacher_feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Teacher_feedback` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mark` INT(5) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `Teacher_id` INT NOT NULL,
  `Scholar_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Teacher_feedback_Teacher1_idx` (`Teacher_id` ASC),
  INDEX `fk_Teacher_feedback_Scholar1_idx` (`Scholar_id` ASC),
  CONSTRAINT `fk_Teacher_feedback_Teacher1`
    FOREIGN KEY (`Teacher_id`)
    REFERENCES `mydb`.`Teacher` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Teacher_feedback_Scholar1`
    FOREIGN KEY (`Scholar_id`)
    REFERENCES `mydb`.`Scholar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Subject_feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Subject_feedback` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mark` INT(5) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `Scholar_id` INT NOT NULL,
  `Subject_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Subject_feedback_Scholar1_idx` (`Scholar_id` ASC),
  INDEX `fk_Subject_feedback_Subject1_idx` (`Subject_id` ASC),
  CONSTRAINT `fk_Subject_feedback_Scholar1`
    FOREIGN KEY (`Scholar_id`)
    REFERENCES `mydb`.`Scholar` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Subject_feedback_Subject1`
    FOREIGN KEY (`Subject_id`)
    REFERENCES `mydb`.`Subject` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Task` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `mark` INT(5) NOT NULL,
  `theme` VARCHAR(45) NOT NULL,
  `Lesson_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Task_Lesson1_idx` (`Lesson_id` ASC),
  CONSTRAINT `fk_Task_Lesson1`
    FOREIGN KEY (`Lesson_id`)
    REFERENCES `mydb`.`Lesson` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
