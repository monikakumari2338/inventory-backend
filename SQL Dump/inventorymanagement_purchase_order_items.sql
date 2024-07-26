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
-- Table structure for table `purchase_order_items`
--

DROP TABLE IF EXISTS `purchase_order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order_items` (
  `generated_id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `damage_image` mediumtext,
  `damage_qty` int NOT NULL,
  `expected_qty` int NOT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `is_completed` bit(1) NOT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `received_qty` int NOT NULL,
  `remaining_qty` int NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `tax_code` varchar(255) DEFAULT NULL,
  `tax_percentage` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `po_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`generated_id`),
  KEY `FKrflho7v2qimvvvm9xvuwuiwwl` (`po_number`),
  CONSTRAINT `FKrflho7v2qimvvvm9xvuwuiwwl` FOREIGN KEY (`po_number`) REFERENCES `purchase_order` (`po_number`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_items`
--

LOCK TABLES `purchase_order_items` WRITE;
/*!40000 ALTER TABLE `purchase_order_items` DISABLE KEYS */;
INSERT INTO `purchase_order_items` VALUES (1,'Sportswear','White','string',0,10,'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',5,5,'7','sku202','string','string','string','PO-Z4WTVFAMM5LB'),(2,'Sportswear','White',NULL,0,10,'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'6','sku203','string','string','string','PO-Z4WTVFAMM5LB'),(3,'string','string',NULL,0,0,'string',_binary '\0','string','string','string',0,0,'string','string','string','string','string','PO-573QCYZKZYTA'),(4,'string','string',NULL,0,0,'string',_binary '\0','string','string','string',0,0,'string','string','string','string','string','PO-1HPSI2AJ56ZH'),(5,'string','string',NULL,0,0,'string',_binary '\0','string','string','string',0,0,'string','string','string','string','string','PO-Y7H9878PC7MT'),(6,'string','string',NULL,0,0,'string',_binary '\0','string','string','string',0,0,'string','string','string','string','string','PO-GIDRXPEIILX6'),(7,'string','string',NULL,0,10,'string',_binary '\0','string','string','string',0,0,'string','string','string','string','string','PO-LFXLRB7KEGLH'),(8,'string','string',NULL,0,10,'string',_binary '\0','string','string','string',0,0,'string','string','string','string','string','PO-LFXLRB7KEGLH');
/*!40000 ALTER TABLE `purchase_order_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-26 11:30:46
