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
-- Table structure for table `asn`
--

DROP TABLE IF EXISTS `asn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asn` (
  `asn_number` varchar(255) NOT NULL,
  `attached_image` varchar(255) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `supplier` varchar(255) DEFAULT NULL,
  `totalsku` int NOT NULL,
  `total_qty` int NOT NULL,
  `receiving_date` date DEFAULT NULL,
  PRIMARY KEY (`asn_number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asn`
--

LOCK TABLES `asn` WRITE;
/*!40000 ALTER TABLE `asn` DISABLE KEYS */;
INSERT INTO `asn` VALUES ('ASN014535273243',NULL,'2024-06-03','string','string',0,0,NULL),('ASN055795907332',NULL,'2024-06-03','string','string',0,0,NULL),('ASN206215015385',NULL,'2024-06-03','string','string',0,0,NULL),('ASN294636962206',NULL,'2024-06-03','string','string',0,0,NULL),('ASN334541789395',NULL,'2024-07-22','string','string',0,0,NULL),('ASN408369836177',NULL,'2024-07-24','string','Supplier1',1,0,NULL),('ASN535478046512',NULL,'2024-07-25','Saved','string',0,0,NULL),('ASN619102978113',NULL,'2024-07-24','Saved','Supplier1',1,5,NULL),('ASN641040062329',NULL,'2024-07-25','Saved','string',0,0,NULL),('ASN675064991298',NULL,'2024-07-22','string','string',0,0,NULL);
/*!40000 ALTER TABLE `asn` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-26 11:30:44
