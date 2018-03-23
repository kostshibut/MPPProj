-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: training_center
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `SignIn_info_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_admin_SignIn_info1_idx` (`SignIn_info_id`),
  CONSTRAINT `fk_admin_SignIn_info1` FOREIGN KEY (`SignIn_info_id`) REFERENCES `signin_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,1);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme` varchar(45) NOT NULL,
  `duration` time(5) NOT NULL,
  `Subject_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Lesson_Subject1_idx` (`Subject_id`),
  CONSTRAINT `fk_Lesson_Subject1` FOREIGN KEY (`Subject_id`) REFERENCES `subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,'Past Simple','25:00:00.00000',1);
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `scholar`
--

DROP TABLE IF EXISTS `scholar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `scholar` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `SignIn_info_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_scholar_SignIn_info1_idx` (`SignIn_info_id`),
  CONSTRAINT `fk_scholar_SignIn_info1` FOREIGN KEY (`SignIn_info_id`) REFERENCES `signin_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `scholar`
--

LOCK TABLES `scholar` WRITE;
/*!40000 ALTER TABLE `scholar` DISABLE KEYS */;
INSERT INTO `scholar` VALUES (1,3);
/*!40000 ALTER TABLE `scholar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `signin_info`
--

DROP TABLE IF EXISTS `signin_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `signin_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `age` int(3) NOT NULL,
  `education` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `signin_info`
--

LOCK TABLES `signin_info` WRITE;
/*!40000 ALTER TABLE `signin_info` DISABLE KEYS */;
INSERT INTO `signin_info` VALUES (1,'admin','admin','Nick','TwentyEight','some@gmail.com',28,'High'),(2,'teacher','teacher','Nep','Enthes','other@gmail.com',88,'Middle'),(3,'scholar','scholar','Scho','Lar','scholar@gmail.com',17,'Small');
/*!40000 ALTER TABLE `signin_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `duration` time(5) NOT NULL,
  `Teacher_id` int(11) NOT NULL,
  `Scholar_list_ID` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Subject_Teacher1_idx` (`Teacher_id`),
  KEY `fk_Subject_Subject_scholar_list1_idx` (`Scholar_list_ID`),
  CONSTRAINT `fk_Subject_Subject_scholar_list1` FOREIGN KEY (`Scholar_list_ID`) REFERENCES `subject_scholar_list` (`ID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Subject_Teacher1` FOREIGN KEY (`Teacher_id`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'English','23:00:00.00000',1,1);
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_feedback`
--

DROP TABLE IF EXISTS `subject_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(5) NOT NULL,
  `description` varchar(255) NOT NULL,
  `Scholar_id` int(11) NOT NULL,
  `Subject_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Subject_feedback_Scholar1_idx` (`Scholar_id`),
  KEY `fk_Subject_feedback_Subject1_idx` (`Subject_id`),
  CONSTRAINT `fk_Subject_feedback_Scholar1` FOREIGN KEY (`Scholar_id`) REFERENCES `scholar` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Subject_feedback_Subject1` FOREIGN KEY (`Subject_id`) REFERENCES `subject` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_feedback`
--

LOCK TABLES `subject_feedback` WRITE;
/*!40000 ALTER TABLE `subject_feedback` DISABLE KEYS */;
INSERT INTO `subject_feedback` VALUES (1,5,'Everybody be cool, u... be cool',1,1);
/*!40000 ALTER TABLE `subject_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject_scholar_list`
--

DROP TABLE IF EXISTS `subject_scholar_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `subject_scholar_list` (
  `ID` int(11) NOT NULL,
  `Scholar_id` int(11) NOT NULL,
  `Registration` date NOT NULL,
  `Expiration` date NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_Subject_scholar_list_Scholar1_idx` (`Scholar_id`),
  CONSTRAINT `fk_Subject_scholar_list_Scholar1` FOREIGN KEY (`Scholar_id`) REFERENCES `scholar` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject_scholar_list`
--

LOCK TABLES `subject_scholar_list` WRITE;
/*!40000 ALTER TABLE `subject_scholar_list` DISABLE KEYS */;
INSERT INTO `subject_scholar_list` VALUES (1,1,'2022-03-20','2022-05-20');
/*!40000 ALTER TABLE `subject_scholar_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(5) NOT NULL,
  `theme` varchar(45) NOT NULL,
  `Lesson_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Task_Lesson1_idx` (`Lesson_id`),
  CONSTRAINT `fk_Task_Lesson1` FOREIGN KEY (`Lesson_id`) REFERENCES `lesson` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task`
--

LOCK TABLES `task` WRITE;
/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` VALUES (1,4,'1',1);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `SignIn_info_id` int(11) NOT NULL,
  `spetialization` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Teacher_SignIn_info1_idx` (`SignIn_info_id`),
  CONSTRAINT `fk_Teacher_SignIn_info1` FOREIGN KEY (`SignIn_info_id`) REFERENCES `signin_info` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,2,'English');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_feedback`
--

DROP TABLE IF EXISTS `teacher_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mark` int(5) NOT NULL,
  `description` varchar(255) NOT NULL,
  `Teacher_id` int(11) NOT NULL,
  `Scholar_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_Teacher_feedback_Teacher1_idx` (`Teacher_id`),
  KEY `fk_Teacher_feedback_Scholar1_idx` (`Scholar_id`),
  CONSTRAINT `fk_Teacher_feedback_Scholar1` FOREIGN KEY (`Scholar_id`) REFERENCES `scholar` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Teacher_feedback_Teacher1` FOREIGN KEY (`Teacher_id`) REFERENCES `teacher` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_feedback`
--

LOCK TABLES `teacher_feedback` WRITE;
/*!40000 ALTER TABLE `teacher_feedback` DISABLE KEYS */;
INSERT INTO `teacher_feedback` VALUES (1,2,'Ahuena',1,1);
/*!40000 ALTER TABLE `teacher_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'training_center'
--

--
-- Dumping routines for database 'training_center'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-03-23 10:31:48
