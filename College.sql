-- MySQL dump 10.13  Distrib 5.5.50, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: College
-- ------------------------------------------------------
-- Server version	5.5.50-0ubuntu0.14.04.1

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
-- Table structure for table `Class`
--

DROP TABLE IF EXISTS `Class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Class` (
  `class` varchar(10) DEFAULT NULL,
  `id` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Class`
--

LOCK TABLES `Class` WRITE;
/*!40000 ALTER TABLE `Class` DISABLE KEYS */;
INSERT INTO `Class` VALUES ('SECTION A','iit2018001'),('SECTION A','iit2018002'),('SECTION A','iit2018003'),('SECTION B','iit2018004'),('SECTION B','iit2018005'),('SECTION B','iit2018006'),('SECTION C','iit2018007'),('SECTION C','iit2018008'),('SECTION C','iit2018009');
/*!40000 ALTER TABLE `Class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Course` (
  `course` varchar(10) DEFAULT NULL,
  `id` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES ('SOE','iit2018001'),('SOE','iit2018002'),('SOE','iit2018003'),('SOE','iit2018004'),('SOE','iit2018005'),('SOE','iit2018006'),('SOE','iit2018007'),('SOE','iit2018008'),('SOE','iit2018009'),('CNN','iit2018001'),('CNN','iit2018002'),('CNN','iit2018004'),('CNN','iit2018008'),('POE','iit2018005'),('POE','iit2018008'),('POE','iit2018009'),('GVC','iit2018001'),('GVC','iit2018002'),('GVC','iit2018003'),('GVC','iit2018004'),('GVC','iit2018005'),('GVC','iit2018006'),('GVC','iit2018009'),('AI','iit2018002'),('AI','iit2018004'),('AI','iit2018006'),('AI','iit2018008');
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Fields`
--

DROP TABLE IF EXISTS `Fields`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Fields` (
  `id` int(11) DEFAULT NULL,
  `course` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Fields`
--

LOCK TABLES `Fields` WRITE;
/*!40000 ALTER TABLE `Fields` DISABLE KEYS */;
INSERT INTO `Fields` VALUES (1,'SOE'),(1,'AI'),(1,'GVC'),(2,'SOE'),(2,'AI'),(2,'CNN'),(2,'GVC'),(3,'AI'),(3,'POE'),(4,'POE'),(5,'GVC'),(6,'AI'),(6,'SOE');
/*!40000 ALTER TABLE `Fields` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Instructor`
--

DROP TABLE IF EXISTS `Instructor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Instructor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(30) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Instructor`
--

LOCK TABLES `Instructor` WRITE;
/*!40000 ALTER TABLE `Instructor` DISABLE KEYS */;
INSERT INTO `Instructor` VALUES (1,'Lorem','ipsumi'),(2,'pratik','mangax'),(3,'iit2014112','hihihi'),(4,'harsh','jayesh'),(5,'abhilol','shivam'),(6,'swapn','neeln6');
/*!40000 ALTER TABLE `Instructor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `id` varchar(12) DEFAULT NULL,
  `course` varchar(10) DEFAULT NULL,
  `attendance` int(11) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES ('iit2018001','SOE',0,0),('iit2018001','CNN',0,0),('iit2018001','GVC',0,0),('iit2018002','SOE',0,0),('iit2018002','CNN',0,0),('iit2018002','AI',2,15),('iit2018002','GVC',0,0),('iit2018003','SOE',5,2),('iit2018003','GVC',0,0),('iit2018004','GVC',4,15),('iit2018004','SOE',4,0),('iit2018004','CNN',7,16),('iit2018004','AI',2,5),('iit2018005','POE',2,15),('iit2018005','GVC',3,16),('iit2018005','SOE',9,4),('iit2018006','GVC',5,13),('iit2018006','SOE',2,7),('iit2018006','AI',2,9),('iit2018007','SOE',1,0),('iit2018008','AI',3,15),('iit2018008','SOE',0,0),('iit2018008','POE',0,0),('iit2018008','CNN',0,0),('iit2018009','SOE',5,7),('iit2018009','POE',0,0),('iit2018009','GVC',0,0);
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-09 18:15:31
