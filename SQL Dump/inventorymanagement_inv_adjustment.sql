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
-- Table structure for table `inv_adjustment`
--

DROP TABLE IF EXISTS `inv_adjustment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inv_adjustment` (
  `adj_id` varchar(255) NOT NULL,
  `date` date DEFAULT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `store` varchar(255) DEFAULT NULL,
  `total_sku` int NOT NULL,
  `user` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adj_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inv_adjustment`
--

LOCK TABLES `inv_adjustment` WRITE;
/*!40000 ALTER TABLE `inv_adjustment` DISABLE KEYS */;
INSERT INTO `inv_adjustment` VALUES ('IA109776261408','2024-11-19','','Stock In','Completed','Pacific Dwarka',4,'Monika'),('IA116553177918','2024-11-28',NULL,'Damage','Completed','Pacific Dwarka',10,'Monika Kumari'),('IA178927131997','2024-11-12','','Theft','Completed','Pacific Dwarka',63,'Monika'),('IA393299062438','2024-11-26',NULL,'Damage','Completed','Pacific Dwarka',4,'Monika Kumari'),('IA482355537870','2024-11-20','','Theft','Completed','Pacific Dwarka',1,'Monika'),('IA679170329077','2024-11-20','string','string','Completed','Pacific Dwarka',0,'Swastik'),('IA690896017781','2024-12-11',NULL,'Damage','Completed','Pacific Dwarka',40,'Monika Kumari'),('IA834233807687','2024-12-11','file:///data/user/0/host.exp.exponent/cache/ExperienceData/%2540anonymous%252FinventoryManagement-cfe52548-81b1-465b-bb40-d8f70a6884a0/ImagePicker/1b0a774f-bbee-44b8-ae07-e2a1d152882d.png','Damage','Completed','Pacific Dwarka',31,'Monika Kumari'),('IA880968674945','2024-11-12','','Damage','Completed','Pacific Dwarka',2,'Monika');
/*!40000 ALTER TABLE `inv_adjustment` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-11 11:51:24
