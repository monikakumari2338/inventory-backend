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
-- Table structure for table `adhoc_stock_count`
--

DROP TABLE IF EXISTS `adhoc_stock_count`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adhoc_stock_count` (
  `adhoc_id` int NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `counted_qty` int NOT NULL,
  `creation_date` date DEFAULT NULL,
  `re_count_qty` int NOT NULL,
  `re_count_status` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `recount_variance_qty` int NOT NULL,
  `store` varchar(255) DEFAULT NULL,
  `total_book_qty` int NOT NULL,
  `variance_qty` int NOT NULL,
  PRIMARY KEY (`adhoc_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adhoc_stock_count`
--

LOCK TABLES `adhoc_stock_count` WRITE;
/*!40000 ALTER TABLE `adhoc_stock_count` DISABLE KEYS */;
INSERT INTO `adhoc_stock_count` VALUES (5000,'Sportswear',15,'2024-06-19',0,'string','Audit',0,'Pacific Dwarka',20,5),(5001,'Womenwear',28,'2024-06-19',0,'string','Audit',0,'Pacific Dwarka',30,5),(5002,'Footwear',20,'2024-06-19',0,'string','Audit',0,'Pacific Dwarka',25,5),(5003,'Handbags',20,'2024-06-19',0,'string','Audit',0,'Pacific Dwarka',25,10);
/*!40000 ALTER TABLE `adhoc_stock_count` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-28 19:56:02
