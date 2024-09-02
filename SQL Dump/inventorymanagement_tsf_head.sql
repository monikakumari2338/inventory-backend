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
-- Table structure for table `tsf_head`
--

DROP TABLE IF EXISTS `tsf_head`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tsf_head` (
  `tsf_id` varchar(255) NOT NULL,
  `approved_date` date DEFAULT NULL,
  `attached_proof` varchar(255) DEFAULT NULL,
  `closed_date` date DEFAULT NULL,
  `created_by` varchar(255) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `delivery_date` date DEFAULT NULL,
  `not_after` date DEFAULT NULL,
  `not_before` date DEFAULT NULL,
  `reason_code` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `store_from` varchar(255) DEFAULT NULL,
  `store_to` varchar(255) DEFAULT NULL,
  `total_req_qty` int NOT NULL,
  PRIMARY KEY (`tsf_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tsf_head`
--

LOCK TABLES `tsf_head` WRITE;
/*!40000 ALTER TABLE `tsf_head` DISABLE KEYS */;
INSERT INTO `tsf_head` VALUES ('TSF107097757850',NULL,'string',NULL,'Swastik','2024-08-20',NULL,'2024-08-20','2024-08-20','Promotional Event','New Request','Pacific Dwarka','Ambience Mall',20),('TSF604167014290','2024-08-20','string',NULL,'jasmine','2024-08-20',NULL,'2024-08-20','2024-08-20','Emergency Request','Partially Accepted','Pacific Dwarka','Ambience mall',10),('TSF933116427059','2024-08-09','string',NULL,'Amit','2024-08-09','2024-08-09','2024-08-09','2024-08-09','Emergency Request','Delivered','Pacific Dwarka','Ambience Mall',10),('TSF979657408946',NULL,NULL,NULL,'Monika','2024-08-20',NULL,NULL,NULL,NULL,'In Progress','Ambience Mall','Pacific Dwarka',0);
/*!40000 ALTER TABLE `tsf_head` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-02 12:14:57
