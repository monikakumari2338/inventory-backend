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
-- Table structure for table `draft_purchase_order_items`
--

DROP TABLE IF EXISTS `draft_purchase_order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `draft_purchase_order_items` (
  `generated_id` int NOT NULL AUTO_INCREMENT,
  `asn_number` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `damage_image` mediumtext,
  `damage_qty` int NOT NULL,
  `expected_qty` int NOT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `po_number` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `received_qty` int NOT NULL,
  `remaining_qty` int NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `tax_code` varchar(255) DEFAULT NULL,
  `tax_percentage` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`generated_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `draft_purchase_order_items`
--

LOCK TABLES `draft_purchase_order_items` WRITE;
/*!40000 ALTER TABLE `draft_purchase_order_items` DISABLE KEYS */;
/*!40000 ALTER TABLE `draft_purchase_order_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-17 12:57:37
