-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: atlantiscitybowlingalleydb
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `shoes_customers`
--

DROP TABLE IF EXISTS `shoes_customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shoes_customers` (
  `sc_shoes_customersID` int(11) NOT NULL AUTO_INCREMENT,
  `sc_customerID` int(11) NOT NULL,
  `sc_shoeID` int(11) NOT NULL,
  `sc_checkedOutDate` datetime NOT NULL,
  `sc_checkInDate` datetime NOT NULL,
  `customers_customers_customerID` int(11) NOT NULL,
  PRIMARY KEY (`sc_shoes_customersID`,`customers_customers_customerID`),
  KEY `fk_shoes_customers_customers1_idx` (`customers_customers_customerID`),
  CONSTRAINT `fk_shoes_customers_customers1` FOREIGN KEY (`customers_customers_customerID`) REFERENCES `customers` (`customers_customerid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shoes_customers`
--

LOCK TABLES `shoes_customers` WRITE;
/*!40000 ALTER TABLE `shoes_customers` DISABLE KEYS */;
INSERT INTO `shoes_customers` VALUES (1,1,1,'2010-10-11 10:15:00','0000-00-00 00:00:00',1),(2,3,5,'2009-06-18 15:20:10','2009-06-18 17:20:10',3),(3,5,3,'2009-07-11 16:10:10','2009-07-11 17:05:00',5);
/*!40000 ALTER TABLE `shoes_customers` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-01 15:41:36
