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
INSERT INTO `tsf_head` VALUES ('TSF002548223170',NULL,'string',NULL,'2024-06-18',NULL,'2024-06-18','2024-06-18','string','New Request','Vegas Mall','Pacific Dwarka',0),('TSF081808395856',NULL,'string',NULL,'2024-06-19',NULL,'2024-06-19','2024-06-19','string','New Request','Pacific Dwarka','Vegas Mall',0),('TSF090182327709','2024-06-18','string',NULL,'2024-06-18',NULL,'2024-06-18','2024-06-18','string','Shipped','Pacific Dwarka','Vegas mall',0),('TSF154304938762','2024-06-18','string',NULL,'2024-06-13',NULL,'2024-06-13','2024-06-13','Abc','Accepted','Pacific Dwarka','Ambiance Mall',4),('TSF223428449508',NULL,'string',NULL,'2024-01-07',NULL,'2024-06-10','2024-06-08','string','New Request','Ambience Mall','Vegas Dwarka',4),('TSF251166674550',NULL,'string',NULL,'2024-06-19',NULL,'2024-06-19','2024-06-19','string','Delivered','Vegas Mall','Pacific Dwarka',0),('TSF311849490561',NULL,'string',NULL,'2024-06-19',NULL,'2024-06-19','2024-06-19','string','New Request','Vegas Mall','Pacific Dwarka',0),('TSF329573523909',NULL,'string',NULL,'2024-06-18',NULL,'2024-06-18','2024-06-18','string','New Request','Pacific Dwarka','Vegas mall',0),('TSF396790535283',NULL,'string',NULL,'2024-06-19',NULL,'2024-06-19','2024-06-19','string','New Request','Vegas Mall','Pacific Dwarka',0),('TSF404694166765',NULL,'string',NULL,'2024-06-19',NULL,'2024-06-19','2024-06-19','string','Shipped','Vegas Mall','Pacific Dwarka',0),('TSF420403229332','2024-06-13','string',NULL,'2024-06-07','2024-06-13','2024-06-10','2024-06-08','string','Delivered','Pacific Dwarka','Ambience Mall',4),('TSF639617485201','2024-06-13','null',NULL,'2024-06-07','2024-06-13','2024-06-10','2024-06-08','string','Delivered','Ambience Mall','Pacific Dwarka',10),('TSF744217411742',NULL,'string',NULL,'2024-06-18',NULL,'2024-06-18','2024-06-18','string','Accepted','Vegas Mall','Pacific Dwarka',0),('TSF764378565072',NULL,'string',NULL,'2024-06-19',NULL,'2024-06-19','2024-06-19','string','New Request','Pacific Dwarka','Vegas Mall',0);
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

-- Dump completed on 2024-07-31 16:08:47
