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
-- Table structure for table `stock_count_creation`
--

DROP TABLE IF EXISTS `stock_count_creation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_count_creation` (
  `count_id` varchar(255) NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `creation_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `reason` varchar(255) DEFAULT NULL,
  `recount_status` varchar(255) DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `store` varchar(255) DEFAULT NULL,
  `total_book_qty` int NOT NULL,
  `total_counted_qty` int NOT NULL,
  `total_recount_qty` int NOT NULL,
  `total_recount_variance_qty` int NOT NULL,
  `total_variance_qty` int NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `sub_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`count_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_count_creation`
--

LOCK TABLES `stock_count_creation` WRITE;
/*!40000 ALTER TABLE `stock_count_creation` DISABLE KEYS */;
INSERT INTO `stock_count_creation` VALUES ('ADHOC0100569','Sportswear','2024-11-27','2024-11-27','Audit','Completed','2024-11-27','Completed','Pacific Dwarka',1036,200,240,-796,836,'SC','AD'),('ADHOC0148423','Sportswear','2024-11-20','2024-11-11','Audit','Pending','2024-11-11','Completed','Pacific Dwarka',135,2,0,0,133,'SC','AD'),('ADHOC1647793','Sportswear','2024-11-27','2024-11-27',NULL,'Pending','2024-11-27','New','Pacific Dwarka',0,0,0,0,0,'SC','AD'),('ADHOC1852307','Sportswear','2024-11-19','2024-11-19','Audit','Pending','2024-11-19','Completed','Pacific Dwarka',261,10,0,0,251,'SC','AD'),('ADHOC3482003','Sportswear','2024-11-27','2024-11-27','Audit','Completed','2024-11-27','Completed','Pacific Dwarka',308,200,240,-68,108,'SC','AD'),('ADHOC4847258','Sportswear','2024-11-20','2024-11-11',NULL,'Pending','2024-11-11','Completed','Pacific Dwarka',135,2,0,0,133,'SC','AD'),('ADHOC7634149','Sportswear','2024-11-27','2024-11-27','Damage','Completed','2024-11-27','Completed','Pacific Dwarka',308,200,280,-28,108,'SC','AD'),('ADHOC8282917','Sportswear','2024-11-27','2024-11-27','Damage','Completed','2024-11-27','Completed','Pacific Dwarka',308,94,100,-208,214,'SC','AD'),('ADHOC8695322','Sportswear','2024-11-27','2024-11-27','Audit','Completed','2024-11-27','Completed','Pacific Dwarka',308,200,280,44,108,'SC','AD'),('SC322400151254','Sportswear','2024-11-12','2024-11-11','Routine','Pending','2024-11-11','Pending','Pacific Dwarka',259,0,0,0,0,'SC','SC'),('SC353464120469','Sportswear','2024-11-12','2024-11-11','Audit','Pending','2024-11-11','Pending','Pacific Dwarka',571,0,0,0,0,'SC','SC'),('SC819596697149','Sportswear','2024-11-12','2024-11-11','Routine','Pending','2024-11-11','Pending','Pacific Dwarka',463,0,0,0,0,'SC','SC'),('SC977793532681','Womenwear','2024-11-12','2024-11-11','Damage','Pending','2024-11-11','Pending','Pacific Dwarka',109,0,0,0,0,'SC','SC'),('SC997497783549','Womenwear','2024-11-12','2024-11-11','Routine','Pending','2024-11-11','pending','Pacific Dwarka',71,0,0,0,0,'SC','SC');
/*!40000 ALTER TABLE `stock_count_creation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-17 12:57:40
