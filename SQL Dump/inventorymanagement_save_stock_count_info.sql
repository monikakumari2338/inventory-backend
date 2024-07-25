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
-- Table structure for table `save_stock_count_info`
--

DROP TABLE IF EXISTS `save_stock_count_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `save_stock_count_info` (
  `count_id` int NOT NULL,
  `completed_at` varchar(255) DEFAULT NULL,
  `count_description` varchar(255) DEFAULT NULL,
  `counted_qty` int NOT NULL,
  `re_count` varchar(255) DEFAULT NULL,
  `re_count_qty` int NOT NULL,
  `recount_variance_qty` int NOT NULL,
  `started_at` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `total_book_qty` int NOT NULL,
  `variance_qty` int NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `store` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`count_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_stock_count_info`
--

LOCK TABLES `save_stock_count_info` WRITE;
/*!40000 ALTER TABLE `save_stock_count_info` DISABLE KEYS */;
INSERT INTO `save_stock_count_info` VALUES (1,'19-05-2024 12:25:20','string',8,'string',0,0,'17-05-2024 12:25:20','complete',10,2,'Handbags','Pacific Dwarka'),(3,'19-05-2024 12:25:20','string',8,'string',0,0,'17-05-2024 12:25:20','complete',10,2,'Sportswear','Pacific Dwarka'),(6,'20-05-2024 12:25:20','string',8,'string',0,0,'17-05-2024 12:25:20','complete',10,2,'Womenwear','Pacific Dwarka'),(39,'20-05-2024 12:25:20','test',2,'processing',0,0,'17-05-2024 12:25:20','processing',25,23,'Sportswear','Pacific Dwarka'),(100000,'19-06-2024 12:25:20','string',0,'string',0,0,'17-06-2024 12:25:20','string',0,0,'Sportswear',NULL);
/*!40000 ALTER TABLE `save_stock_count_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-25 15:43:21
