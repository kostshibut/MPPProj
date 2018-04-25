-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema CT_center
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema CT_center
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `CT_center` DEFAULT CHARACTER SET utf8 ;
USE `CT_center` ;

-- -----------------------------------------------------
-- Table `CT_center`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CT_center`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `firstName` VARCHAR(45) NOT NULL,
  `lastName` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `age` INT(3) NOT NULL,
  `education` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CT_center`.`admin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CT_center`.`admin` (
  `admin_id` INT NOT NULL AUTO_INCREMENT,
  `user_user_id` INT NOT NULL,
  PRIMARY KEY (`admin_id`),
  INDEX `fk_Admin_user1_idx` (`user_user_id` ASC),
  CONSTRAINT `fk_Admin_user1`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `CT_center`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CT_center`.`teacher`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CT_center`.`teacher` (
  `teacher_id` INT NOT NULL AUTO_INCREMENT,
  `spetialization` VARCHAR(45) NULL,
  `user_user_id` INT NOT NULL,
  PRIMARY KEY (`teacher_id`),
  INDEX `fk_teacher_user1_idx` (`user_user_id` ASC),
  CONSTRAINT `fk_teacher_user1`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `CT_center`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CT_center`.`subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CT_center`.`subject` (
  `subject_id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `duration` INT NULL,
  `teacher_teacher_id` INT NOT NULL,
  PRIMARY KEY (`subject_id`),
  INDEX `fk_subject_teacher1_idx` (`teacher_teacher_id` ASC),
  CONSTRAINT `fk_subject_teacher1`
    FOREIGN KEY (`teacher_teacher_id`)
    REFERENCES `CT_center`.`teacher` (`teacher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CT_center`.`scholar`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CT_center`.`scholar` (
  `scholar_id` INT NOT NULL AUTO_INCREMENT,
  `user_user_id` INT NOT NULL,
  PRIMARY KEY (`scholar_id`),
  INDEX `fk_Scholar_user1_idx` (`user_user_id` ASC),
  CONSTRAINT `fk_Scholar_user1`
    FOREIGN KEY (`user_user_id`)
    REFERENCES `CT_center`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CT_center`.`lesson`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CT_center`.`lesson` (
  `lesson_id` INT NOT NULL AUTO_INCREMENT,
  `theme` VARCHAR(45) NOT NULL,
  `duration` TIME(5) NOT NULL,
  `subject_subject_id` INT NOT NULL,
  PRIMARY KEY (`lesson_id`),
  INDEX `fk_lesson_subject1_idx` (`subject_subject_id` ASC),
  CONSTRAINT `fk_lesson_subject1`
    FOREIGN KEY (`subject_subject_id`)
    REFERENCES `CT_center`.`subject` (`subject_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CT_center`.`teacher_feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CT_center`.`teacher_feedback` (
  `teacher_feedback_id` INT NOT NULL AUTO_INCREMENT,
  `mark` INT(5) NULL,
  `description` VARCHAR(255) NULL,
  `scholar_scholar_id` INT NOT NULL,
  `teacher_teacher_id` INT NOT NULL,
  PRIMARY KEY (`teacher_feedback_id`),
  INDEX `fk_teacher_feedback_scholar1_idx` (`scholar_scholar_id` ASC),
  INDEX `fk_teacher_feedback_teacher1_idx` (`teacher_teacher_id` ASC),
  CONSTRAINT `fk_teacher_feedback_scholar1`
    FOREIGN KEY (`scholar_scholar_id`)
    REFERENCES `CT_center`.`scholar` (`scholar_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_teacher_feedback_teacher1`
    FOREIGN KEY (`teacher_teacher_id`)
    REFERENCES `CT_center`.`teacher` (`teacher_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CT_center`.`subject_feedback`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CT_center`.`subject_feedback` (
  `subject_feedback_id` INT NOT NULL AUTO_INCREMENT,
  `mark` INT(5) NULL,
  `description` VARCHAR(255) NULL,
  `subject_subject_id` INT NOT NULL,
  `scholar_scholar_id` INT NOT NULL,
  PRIMARY KEY (`subject_feedback_id`),
  INDEX `fk_subject_feedback_subject1_idx` (`subject_subject_id` ASC),
  INDEX `fk_subject_feedback_scholar1_idx` (`scholar_scholar_id` ASC),
  CONSTRAINT `fk_subject_feedback_subject1`
    FOREIGN KEY (`subject_subject_id`)
    REFERENCES `CT_center`.`subject` (`subject_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_subject_feedback_scholar1`
    FOREIGN KEY (`scholar_scholar_id`)
    REFERENCES `CT_center`.`scholar` (`scholar_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CT_center`.`task`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CT_center`.`task` (
  `task_id` INT NOT NULL AUTO_INCREMENT,
  `theme` VARCHAR(500) NULL,
  `lesson_lesson_id` INT NOT NULL,
  PRIMARY KEY (`task_id`),
  INDEX `fk_task_lesson1_idx` (`lesson_lesson_id` ASC),
  CONSTRAINT `fk_task_lesson1`
    FOREIGN KEY (`lesson_lesson_id`)
    REFERENCES `CT_center`.`lesson` (`lesson_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `CT_center`.`list_scholar_subject`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `CT_center`.`list_scholar_subject` (
  `list_scholar_subject_id` INT NOT NULL AUTO_INCREMENT,
  `scholar_scholar_id` INT NOT NULL,
  `subject_subject_id` INT NOT NULL,
  INDEX `fk_scholar_has_subject_subject1_idx` (`subject_subject_id` ASC),
  INDEX `fk_scholar_has_subject_scholar1_idx` (`scholar_scholar_id` ASC),
  PRIMARY KEY (`list_scholar_subject_id`),
  CONSTRAINT `fk_scholar_has_subject_scholar1`
    FOREIGN KEY (`scholar_scholar_id`)
    REFERENCES `CT_center`.`scholar` (`scholar_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_scholar_has_subject_subject1`
    FOREIGN KEY (`subject_subject_id`)
    REFERENCES `CT_center`.`subject` (`subject_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
