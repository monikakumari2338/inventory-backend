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
-- Table structure for table `dsd`
--

DROP TABLE IF EXISTS `dsd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dsd` (
  `dsd_number` varchar(255) NOT NULL,
  `attached_image` varchar(255) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `invoice_number` int NOT NULL,
  `po_number` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `store_location` varchar(255) DEFAULT NULL,
  `supplier_name` varchar(255) DEFAULT NULL,
  `totalsku` int NOT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dsd_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dsd`
--

LOCK TABLES `dsd` WRITE;
/*!40000 ALTER TABLE `dsd` DISABLE KEYS */;
INSERT INTO `dsd` VALUES ('DSD069047460638','string','2024-07-22',0,'PO-DSDHZ21U0KUDYAY','string','Pacific Dwarka','Ram',0,'Amit'),('DSD340558043885','string','2024-07-22',0,'PO-DSDH0PSBGZHJVGQ','string','Pacific Dwarka','Ram',0,'Amit'),('DSD765936376133','string','2024-07-18',101010,'PO-DSD6H0PF3G4J5KX','Complete','Pacific Dwarka','Ram',10,'Jasmine1'),('DSD811880855826','string','2024-07-18',101010,'PO-DSD6RF1BZ2TBDRF','Complete','Pacific Dwarka','Ram',10,'Jasmine'),('DSD885259082112','string','2024-07-15',0,NULL,'string','Pacific Dwarka','string',0,'Jasmine1');
/*!40000 ALTER TABLE `dsd` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-24 14:33:44
