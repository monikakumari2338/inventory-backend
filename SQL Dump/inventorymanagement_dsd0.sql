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
  `supplier_id` varchar(255) DEFAULT NULL,
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
INSERT INTO `dsd` VALUES ('DSD452989549916','','2024-11-12',0,'PO-DSDSITNWBO2IU0W','Completed','Pacific Dwarka','Sup101',NULL,6,'Monika'),('DSD468762149093','file:///data/user/0/host.exp.exponent/cache/ExperienceData/%2540anonymous%252FinventoryManagement-cfe52548-81b1-465b-bb40-d8f70a6884a0/ImagePicker/a7213ddc-4776-48ff-82cd-4c70c4648341.png','2024-11-28',0,'PO-DSDJN1CNHTSARBY','Completed','Pacific Dwarka','Sup101','ABC Industries',21,'Monika Kumari'),('DSD607933393601','','2024-11-19',0,'PO-DSDTSHVBLPQ6YLF','Completed','Pacific Dwarka','Sup101',NULL,10,'Monika'),('DSD719606461135','','2024-11-20',0,'PO-DSDD7V58RIMGAMH','Completed','Pacific Dwarka','Sup101','ABC Industries',1,'Monika'),('DSD783885781786',NULL,'2024-11-26',0,'PO-DSDHV2OJ129AOMY','Completed','Pacific Dwarka','Sup101','ABC Industries',1,'Monika Kumari'),('DSD828498752883','','2024-11-12',0,'PO-DSDBIPU78B57CEN','Completed','Pacific Dwarka','Sup101',NULL,1,'Monika');
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

-- Dump completed on 2025-01-17 12:57:41
