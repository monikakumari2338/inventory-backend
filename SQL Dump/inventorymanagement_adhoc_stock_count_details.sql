-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: inventorymanagement
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `adhoc_stock_count_details`
--

DROP TABLE IF EXISTS `adhoc_stock_count_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adhoc_stock_count_details` (
  `generated_id` int NOT NULL AUTO_INCREMENT,
  `book_qty` int NOT NULL,
  `color` varchar(255) DEFAULT NULL,
  `firstcounted_qty` int NOT NULL,
  `firstvariance_qty` int NOT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `re_count_qty` int NOT NULL,
  `re_count_status` varchar(255) DEFAULT NULL,
  `recount_variance_qty` int NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `adhoc_id` int DEFAULT NULL,
  PRIMARY KEY (`generated_id`),
  KEY `FKhrltekw76h2vop28lb53y2avd` (`adhoc_id`),
  CONSTRAINT `FKhrltekw76h2vop28lb53y2avd` FOREIGN KEY (`adhoc_id`) REFERENCES `adhoc_stock_count` (`adhoc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adhoc_stock_count_details`
--

LOCK TABLES `adhoc_stock_count_details` WRITE;
/*!40000 ALTER TABLE `adhoc_stock_count_details` DISABLE KEYS */;
INSERT INTO `adhoc_stock_count_details` VALUES (1,10,'string',8,2,'string','string','string','string',0,'string',0,'string','string',5000),(2,10,'string',7,3,'string','string','string','string',0,'string',0,'string','string',5000),(3,10,'string',18,2,'string','string','string','string',0,'string',0,'string','string',5001),(4,10,'string',10,0,'string','string','string','string',0,'string',0,'string','string',5001),(5,10,'string',13,2,'string','string','string','string',0,'string',0,'string','string',5002),(6,10,'string',7,3,'string','string','string','string',0,'string',0,'string','string',5002),(7,10,'string',9,6,'string','string','string','string',0,'string',0,'string','string',5003),(8,10,'string',6,4,'string','string','string','string',0,'string',0,'string','string',5003);
/*!40000 ALTER TABLE `adhoc_stock_count_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-11 11:51:21
