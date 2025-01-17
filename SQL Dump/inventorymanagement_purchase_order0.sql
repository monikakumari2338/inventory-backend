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
INSERT INTO `purchase_order` VALUES ('PO-0FO92HI7TTL5','2024-11-12','2024-11-12',NULL,21000,'2024-11-12','2024-11-12','In Progress','Pacific Dwarka','Sup101','ABC Industries',38,3),('PO-4RUOQNLXZG06','2024-11-12','2024-11-12',NULL,6000,'2024-11-12','2024-11-12','Completed','Pacific Dwarka','Sup101','ABC Industries',48,3),('PO-6JF54QMJ4CKL','2024-11-12','2024-11-12',NULL,8000,'2024-11-12','2024-11-12','Pending','Pacific Dwarka','Sup101','ABC Industries',98,4),('PO-6O0GLJMYGHF0','2024-11-12','2024-11-12',NULL,16300,'2024-11-12','2024-11-12','Pending','Pacific Dwarka','Sup101','ABC Industries',128,3),('PO-70OZ0UXKCKUE','2024-11-12','2024-11-12',NULL,25600,'2024-11-12','2024-11-12','Pending','Pacific Dwarka','Sup101','ABC Industries',238,5),('PO-ALZB756NFVAT','2024-11-12','2024-11-12',NULL,21000,'2024-11-12','2024-11-12','Pending','Pacific Dwarka','Sup101','ABC Industries',38,3),('PO-DSDBIPU78B57CEN','2024-11-12','2024-11-12',NULL,0,'2024-11-12','2024-11-12','Completed','Pacific Dwarka','Sup101','ABC Industries',1,1),('PO-DSDD7V58RIMGAMH','2024-11-20','2024-11-20',NULL,0,'2024-11-20','2024-11-20','Completed','Pacific Dwarka','Sup101','ABC Industries',1,1),('PO-DSDHV2OJ129AOMY','2024-11-26','2024-11-26',NULL,0,'2024-11-26','2024-11-26','Completed','Pacific Dwarka','Sup101','ABC Industries',1,1),('PO-DSDJN1CNHTSARBY','2024-11-28','2024-11-28',NULL,0,'2024-11-28','2024-11-28','Completed','Pacific Dwarka','Sup101','ABC Industries',3,21),('PO-DSDSITNWBO2IU0W','2024-11-12','2024-11-12',NULL,0,'2024-11-12','2024-11-12','Completed','Pacific Dwarka','Sup101','ABC Industries',2,6),('PO-DSDTSHVBLPQ6YLF','2024-11-19','2024-11-19',NULL,0,'2024-11-19','2024-11-19','Completed','Pacific Dwarka','Sup101','ABC Industries',1,10),('PO-FL18RR91ZUYR','2024-11-12','2024-11-12',NULL,25600,'2024-11-12','2024-11-12','Pending','Pacific Dwarka','Sup101','ABC Industries',238,5),('PO-GQWABYGM9SRT','2024-11-12','2024-11-12',NULL,25600,'2024-11-12','2024-11-12','Pending','Pacific Dwarka','Sup101','ABC Industries',238,5),('PO-HDZTRNG3T6J9','2024-11-12','2024-11-12',NULL,11600,'2024-11-12','2024-11-12','Pending','Pacific Dwarka','Sup101','ABC Industries',115,3),('PO-KM5NL8ZUOG3P','2024-11-12','2024-11-12',NULL,11600,'2024-11-12','2024-11-12','Pending','Pacific Dwarka','Sup101','ABC Industries',178,3),('PO-TQCUPNKXQ118','2024-11-12','2024-11-12',NULL,6000,'2024-11-12','2024-11-12','In Progress','Pacific Dwarka','Sup101','ABC Industries',88,3),('PO-WMRMQPO4TOKG','2024-11-12','2024-11-12',NULL,23300,'2024-11-12','2024-11-12','Pending','Pacific Dwarka','Sup101','ABC Industries',138,4);
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

-- Dump completed on 2025-01-17 12:57:38
