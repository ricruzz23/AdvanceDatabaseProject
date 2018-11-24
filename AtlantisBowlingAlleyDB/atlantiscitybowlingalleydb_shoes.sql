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
-- Table structure for table `shoes`
--

DROP TABLE IF EXISTS `shoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `shoes` (
  `shoes_shoeID` int(11) NOT NULL AUTO_INCREMENT,
  `shoes_gender` char(1) NOT NULL,
  `shoes_shoeSize` double NOT NULL,
  `shoes_shoeWidth` char(1) DEFAULT NULL,
  `shoes_ageGroup` char(1) NOT NULL,
  `shoes_isCheckedOut` tinyint(4) NOT NULL,
  `shoes_retireShoe` tinyint(4) NOT NULL,
  `shoes_customers_sc_shoes_customersID` int(11) NOT NULL,
  PRIMARY KEY (`shoes_shoeID`,`shoes_customers_sc_shoes_customersID`),
  UNIQUE KEY `dhoes_shoesID_UNIQUE` (`shoes_shoeID`),
  KEY `fk_shoes_shoes_customers_idx` (`shoes_customers_sc_shoes_customersID`),
  CONSTRAINT `fk_shoes_shoes_customers` FOREIGN KEY (`shoes_customers_sc_shoes_customersID`) REFERENCES `shoes_customers` (`sc_shoes_customersid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-11-24 12:09:37
