CREATE DATABASE  IF NOT EXISTS `ct_center` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ct_center`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: ct_center
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`admin_id`),
  KEY `fk_Admin_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_Admin_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,27);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `lesson_id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(45) NOT NULL,
  `duration` varchar(45) NOT NULL,
  `subject_subject_id` int(11) NOT NULL,
  PRIMARY KEY (`lesson_id`),
  KEY `fk_lesson_subject1_idx` (`subject_subject_id`),
  CONSTRAINT `fk_lesson_subject1` FOREIGN KEY (`subject_subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_scholar_subject`
--

DROP TABLE IF EXISTS `list_scholar_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `list_scholar_subject` (
  `list_scholar_subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `scholar_scholar_id` int(11) NOT NULL,
  `subject_subject_id` int(11) NOT NULL,
  PRIMARY KEY (`list_scholar_subject_id`),
  KEY `fk_scholar_has_subject_subject1_idx` (`subject_subject_id`),
  KEY `fk_scholar_has_subject_scholar1_idx` (`scholar_scholar_id`),
  CONSTRAINT `fk_scholar_has_subject_scholar1` FOREIGN KEY (`scholar_scholar_id`) REFERENCES `scholar` (`scholar_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_scholar_has_subject_subject1` FOREIGN KEY (`subject_subject_id`) REFERENCES `subject` (`subject_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_scholar_subject`
--

LOCK TABLES `list_scholar_subject` WRITE;
/*!40000 ALTER TABLE `list_scholar_subject` DISABLE KEYS */;
/*!40000 ALTER TABLE `list_scholar_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scholar`
--

DROP TABLE IF EXISTS `scholar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scholar` (
  `scholar_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_user_id` int(11) NOT NULL,
  PRIMARY KEY (`scholar_id`),
  KEY `fk_Scholar_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_Scholar_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scholar`
--

LOCK TABLES `scholar` WRITE;
/*!40000 ALTER TABLE `scholar` DISABLE KEYS */;
/*!40000 ALTER TABLE `scholar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `subject_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `duration` int(11) NOT NULL,
  `teacher_teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`subject_id`),
  KEY `fk_subject_teacher1_idx` (`teacher_teacher_id`),
  CONSTRAINT `fk_subject_teacher1` FOREIGN KEY (`teacher_teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (15,'Sex education',7,6),(16,'English',72,6);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_feedback`
--

DROP TABLE IF EXISTS `subject_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_feedback` (
  `subject_feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(5) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `subject_subject_id` int(11) DEFAULT NULL,
  `scholar_scholar_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`subject_feedback_id`),
  KEY `fk_subject_feedback_subject1_idx` (`subject_subject_id`),
  KEY `fk_subject_feedback_scholar1_idx` (`scholar_scholar_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_feedback`
--

LOCK TABLES `subject_feedback` WRITE;
/*!40000 ALTER TABLE `subject_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `subject_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `task_id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(500) DEFAULT NULL,
  `content` varchar(200) DEFAULT NULL,
  `lesson_lesson_id` int(11) NOT NULL,
  PRIMARY KEY (`task_id`),
  KEY `fk_task_lesson1_idx` (`lesson_lesson_id`),
  CONSTRAINT `fk_task_lesson1` FOREIGN KEY (`lesson_lesson_id`) REFERENCES `lesson` (`lesson_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teacher_id` int(11) NOT NULL AUTO_INCREMENT,
  `spetialization` varchar(45) DEFAULT NULL,
  `user_user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`),
  KEY `fk_teacher_user1_idx` (`user_user_id`),
  CONSTRAINT `fk_teacher_user1` FOREIGN KEY (`user_user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (6,'English',30),(20,'Java',46),(22,'DickSucking',48);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_feedback`
--

DROP TABLE IF EXISTS `teacher_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_feedback` (
  `teacher_feedback_id` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(5) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `scholar_scholar_id` int(11) NOT NULL,
  `teacher_teacher_id` int(11) NOT NULL,
  PRIMARY KEY (`teacher_feedback_id`),
  KEY `fk_teacher_feedback_scholar1_idx` (`scholar_scholar_id`),
  KEY `fk_teacher_feedback_teacher1_idx` (`teacher_teacher_id`),
  CONSTRAINT `fk_teacher_feedback_scholar1` FOREIGN KEY (`scholar_scholar_id`) REFERENCES `scholar` (`scholar_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_teacher_feedback_teacher1` FOREIGN KEY (`teacher_teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_feedback`
--

LOCK TABLES `teacher_feedback` WRITE;
/*!40000 ALTER TABLE `teacher_feedback` DISABLE KEYS */;
/*!40000 ALTER TABLE `teacher_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(100) NOT NULL,
  `firstName` varchar(45) NOT NULL,
  `lastName` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `age` int(3) NOT NULL,
  `education` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (27,'dimcoyk','d670d20234faf5480aa11529b1d732','Dimirar','Berbatov','ydimco@gmail.com',18,'High'),(30,'Rina','1095d338b4ed44b2bf94cb1857a0c3','Ekaterina','Smith','rinaEmail',18,'High'),(46,'Vadim','a152525fdba417fb886f80ad53b3895a','Vadim','Martinyk','someMail',21,'High'),(47,'sepon','4077b5f4d89d47afde1c1bbe669bae','Set','Ronin','someMail',20,'Begin'),(48,'Kost','cbf0b7732e17637db53263f21faf339','Konstanin','Shobut','someMail',21,'High');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ct_center'
--

--
-- Dumping routines for database 'ct_center'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-25  1:43:45
