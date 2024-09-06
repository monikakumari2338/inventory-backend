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
-- Table structure for table `purchase_order`
--

DROP TABLE IF EXISTS `purchase_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order` (
  `po_number` varchar(255) NOT NULL,
  `receive_after` date DEFAULT NULL,
  `receive_before` date DEFAULT NULL,
  `attached_image` varchar(255) DEFAULT NULL,
  `cost` int NOT NULL,
  `creation_date` date DEFAULT NULL,
  `expected_delivery_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `store_location` varchar(255) DEFAULT NULL,
  `supplier_id` varchar(255) DEFAULT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `total_items` int NOT NULL,
  `totalsku` int NOT NULL,
  PRIMARY KEY (`po_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order`
--

LOCK TABLES `purchase_order` WRITE;
/*!40000 ALTER TABLE `purchase_order` DISABLE KEYS */;
INSERT INTO `purchase_order` VALUES ('PO-08OYK7YHU9QH','2024-07-26','2024-07-26',NULL,1010100,'2024-07-26','2024-07-26','Complete','Pacific Dwarka','Sup101','ABC Industries',40,4),('PO-2F3PEE8GQM2L','2024-07-26','2024-07-26',NULL,1010100,'2024-07-26','2024-07-26','Pending','Pacific Dwarka','Sup101','ABC Industries',40,4),('PO-60J1Y30FDTO6','2024-07-26','2024-07-26',NULL,1010100,'2024-07-26','2024-07-26','In Progress','Pacific Dwarka','Sup101','ABC Industries',30,3),('PO-79TVEIB93E5H','2024-08-06','2024-08-06',NULL,4600,'2024-08-13','2024-08-06','In Progress','string','Sup101','string',30,2),('PO-8TAZL9QXWN3A','2024-07-30','2024-07-30',NULL,4600,'2024-07-30','2024-07-30','Pending','Pacific Dwarka','Sup101','string',0,2),('PO-BZ72BQ7HJ3FO','2024-08-06','2024-08-06',NULL,4600,'2024-08-12','2024-08-06','Pending','string','Sup101','string',30,2),('PO-CSHOR3D4NFI3','2024-08-05','2024-08-05',NULL,0,'2024-08-05','2024-08-05','Pending','string','string','string',0,1),('PO-EIB6AM6RI1S6','2024-07-26','2024-07-26',NULL,1010100,'2024-07-26','2024-07-26','Pending','Pacific Dwarka','Sup101','ABC Industries',40,4),('PO-I8EZ8LV4EII7','2024-07-26','2024-07-26',NULL,1010100,'2024-07-26','2024-07-26','Pending','Pacific Dwarka','Sup101','ABC Industries',40,4),('PO-JYFIYCN5FBUU','2024-08-06','2024-08-06',NULL,4600,'2024-08-09','2024-08-06','Pending','Pacific Dwarka','Sup101','string',40,2),('PO-MZBIYY6RE7SX','2024-07-26','2024-07-26',NULL,1010100,'2024-07-26','2024-07-26','Pending','Pacific Dwarka','Sup101','ABC Industries',40,4),('PO-NK9PM2XQBGYZ','2024-07-26','2024-07-26',NULL,1010100,'2024-07-26','2024-07-26','Pending','Pacific Dwarka','Sup101','ABC Industries',40,4),('PO-R0TLVSQIP1J7','2024-07-26','2024-07-26',NULL,1010100,'2024-07-26','2024-07-26','Pending','Pacific Dwarka','Sup101','ABC Industries',40,4),('PO-XRTTBNEVI546','2024-08-06','2024-08-06',NULL,4600,'2024-08-06','2024-08-06','Pending','Pacific Dwarka','Sup101','string',30,2),('PO-Y1U8EZSJX5I9','2024-07-26','2024-07-26',NULL,1010100,'2024-07-26','2024-07-26','Pending','Pacific Dwarka','Sup101','ABC Industries',40,4),('PO-YRH3BZJB3PZZ','2024-08-06','2024-08-06',NULL,4600,'2024-08-08','2024-08-06','Pending','Pacific Dwarka','Sup101','string',30,2);
/*!40000 ALTER TABLE `purchase_order` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-06 12:43:41
