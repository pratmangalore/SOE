-- MySQL dump 10.13  Distrib 5.5.50, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Institute
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
-- Table structure for table `Admin`
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Admin` (
  `user` varchar(30) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
INSERT INTO `Admin` VALUES ('Dean','mangax');
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Class`
--

DROP TABLE IF EXISTS `Class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Class` (
  `user` varchar(30) DEFAULT NULL,
  `class` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Class`
--

LOCK TABLES `Class` WRITE;
/*!40000 ALTER TABLE `Class` DISABLE KEYS */;
INSERT INTO `Class` VALUES ('iit2014001','SECTION A'),('iit2014112','SECTION C'),('iit2014111','SECTION C'),('iit2014110','SECTION B'),('iit2014109','SECTION B'),('iit2014113','SECTION A'),('Sandeep','SECTION A'),('iit2014073','SECTION A'),('iit2014108','SECTION C');
/*!40000 ALTER TABLE `Class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Course` (
  `user` varchar(30) DEFAULT NULL,
  `course` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES ('iit2014001','SOE'),('iit2014001','AI'),('iit2014001','GVC'),('iit2014112','SOE'),('iit2014112','AI'),('iit2014112','CNE'),('iit2014111','AI'),('iit2014111','POE'),('iit2014111','GVC'),('iit2014110','CNE'),('iit2014110','POE'),('iit2014109','GVC'),('iit2014109','CNE'),('iit2014113','SOE'),('iit2014113','CNE'),('iit2014073','  SOE  '),('iit2014073','AI'),('iit2014073','CNE'),('iit2014108','SOE'),('iit2014108','AI'),('iit2014108','CNE'),('iit2014108','GVC'),('iit2014108','POE');
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Profdata`
--

DROP TABLE IF EXISTS `Profdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Profdata` (
  `user` varchar(30) DEFAULT NULL,
  `course` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Profdata`
--

LOCK TABLES `Profdata` WRITE;
/*!40000 ALTER TABLE `Profdata` DISABLE KEYS */;
INSERT INTO `Profdata` VALUES ('Prof1','POE'),('Prof1','CNE'),('Prof2','AI'),('Prof2','GVC'),('Prof3','CNE'),('Prof3','AI'),('Prof4','SOE'),('Prof4','POE'),('Prof5','POE'),('Prof5','GVC'),('Prof6','SOE'),('Prof6','AI'),('Prof2','CNE'),('Dean','SOE'),('Dean','AI'),('Dean','CNE'),('Dean','GVC'),('Dean','POE');
/*!40000 ALTER TABLE `Profdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Professor`
--

DROP TABLE IF EXISTS `Professor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Professor` (
  `user` varchar(30) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Professor`
--

LOCK TABLES `Professor` WRITE;
/*!40000 ALTER TABLE `Professor` DISABLE KEYS */;
INSERT INTO `Professor` VALUES ('Prof1','squirt'),('Prof2','mangax'),('Prof3','stylex'),('Prof4','Prof4'),('Prof5','Prof5'),('Prof6','Prof6');
/*!40000 ALTER TABLE `Professor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Studata`
--

DROP TABLE IF EXISTS `Studata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Studata` (
  `user` varchar(30) DEFAULT NULL,
  `course` varchar(30) DEFAULT NULL,
  `attendance` int(11) DEFAULT NULL,
  `marks` int(11) DEFAULT NULL,
  `class` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Studata`
--

LOCK TABLES `Studata` WRITE;
/*!40000 ALTER TABLE `Studata` DISABLE KEYS */;
INSERT INTO `Studata` VALUES ('iit2014001','SOE',4,6,'SECTION A'),('iit2014001','AI',4,6,'SECTION A'),('iit2014001','GVC',4,6,'SECTION A'),('iit2014112','SOE',5,10,'SECTION C'),('iit2014112','AI',5,9,'SECTION C'),('iit2014112','CNE',7,10,'SECTION C'),('iit2014111','AI',6,10,'SECTION C'),('iit2014111','POE',6,10,'SECTION C'),('iit2014111','GVC',6,10,'SECTION C'),('iit2014110','CNE',6,2,'SECTION B'),('iit2014110','POE',6,2,'SECTION B'),('iit2014109','GVC',1,0,'SECTION B'),('iit2014109','CNE',5,10,'SECTION B'),('iit2014113','SOE',1,4,'SECTION A'),('iit2014113','CNE',1,4,'SECTION A'),('iit2014073','  SOE  ',0,0,'SECTION A'),('iit2014073','AI',0,0,'SECTION A'),('iit2014073','CNE',0,0,'SECTION A'),('iit2014108','SOE',0,0,'SECTION C'),('iit2014108','AI',0,0,'SECTION C'),('iit2014108','CNE',0,0,'SECTION C'),('iit2014108','GVC',0,0,'SECTION C'),('iit2014108','POE',0,0,'SECTION C');
/*!40000 ALTER TABLE `Studata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `user` varchar(30) DEFAULT NULL,
  `pass` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES ('iit2014001','squirt'),('iit2014112','mangax'),('iit2014111','stylex'),('iit2014110','Prof4'),('iit2014109','Prof5'),('iit2014113','Prof6'),('Sandeep','mangax'),('iit2014073','Sande1'),('iit2014108','aadity');
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

-- Dump completed on 2016-09-06 14:20:45
