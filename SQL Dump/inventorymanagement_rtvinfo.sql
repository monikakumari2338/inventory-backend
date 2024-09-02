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
INSERT INTO `rtvinfo` VALUES ('RTV064461845821','jasmine','2024-08-01','Box Damage','2024-08-01','Swastik','abc','Dispatched',3,'Sup101','ABC Industries',22,2),('RTV141829208794','Monika','2024-08-20','Item Damaged','2024-08-20',NULL,NULL,'Dispatched',3,'Sup101','ABC Industries',4,2),('RTV153745758592','Ramana','2024-08-06','Box Damaged','2024-08-06','Swastik','string','Dispatched',3,'Sup101','ABC Industries',10,1),('RTV389571094826','Monika','2024-08-13','Quality Issue','2024-08-13',NULL,NULL,'Dispatched',3,'Sup101','ABC Industries',1,1),('RTV461806453813','Monika','2024-08-13','Wrong Item','2024-08-13',NULL,NULL,'Dispatched',3,'Sup101','ABC Industries',1,1),('RTV498798500696','Monika','2024-08-01','Box Damage','2024-08-01','Swastik','abc','Dispatched',3,'Sup101','ABC Industries',20,2),('RTV537033673992','Monika','2024-08-18','Item Damaged','2024-08-18',NULL,NULL,'Dispatched',3,'Sup101','ABC Industries',2,2),('RTV564279920235','Monika','2024-08-18','Box Damaged','2024-08-18',NULL,NULL,'Dispatched',3,'Sup101','ABC Industries',7,2),('RTV661508958674','Monika','2024-08-07',NULL,'2024-08-12',NULL,NULL,'Dispatched',3,'Sup101','ABC Industries',1,1),('RTV966365464403','Monika','2024-08-20',NULL,NULL,NULL,NULL,'In Progress',3,NULL,NULL,0,0),('RTV998548683830','Amit','2024-08-05','Damage','2024-08-05','Swastik','abc','Dispatched',3,'Sup101','ABC Industries',4,2);
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

-- Dump completed on 2024-09-02 12:15:06
