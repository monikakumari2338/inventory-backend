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
-- Table structure for table `rtvinfo`
--

DROP TABLE IF EXISTS `rtvinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rtvinfo` (
  `rtvid` varchar(255) NOT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `default_reason_code` varchar(255) DEFAULT NULL,
  `dispatched_date` date DEFAULT NULL,
  `dispatched_user` varchar(255) DEFAULT NULL,
  `proof` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `store_id` int NOT NULL,
  `supplier_id` varchar(255) DEFAULT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `total_items` int NOT NULL,
  `total_sku` int NOT NULL,
  PRIMARY KEY (`rtvid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rtvinfo`
--

LOCK TABLES `rtvinfo` WRITE;
/*!40000 ALTER TABLE `rtvinfo` DISABLE KEYS */;
INSERT INTO `rtvinfo` VALUES ('RTV047677749924','Monika','2024-11-12','Wrong Item','2024-11-12',NULL,NULL,'Dispatched',3,'Sup101','ABC Industries',5,1),('RTV301979213270','Monika','2024-11-12','Wrong Item','2024-11-12',NULL,NULL,'Dispatched',3,'Sup101','ABC Industries',2,1),('RTV599746844722','Monika','2024-11-19','Wrong Item','2024-11-19',NULL,NULL,'Dispatched',3,'Sup101','ABC Industries',1,1),('RTV836475007868','Monika','2024-11-12','Box Damaged','2024-11-12',NULL,NULL,'Dispatched',3,'Sup101','ABC Industries',7,2),('RTV968302071528','Monika','2024-12-11','Damage','2024-12-11','string','string','Dispatched',3,'sup101','ABC Industries',1,1);
/*!40000 ALTER TABLE `rtvinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-17 12:57:46
