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
-- Table structure for table `stock_count_creation_products`
--

DROP TABLE IF EXISTS `stock_count_creation_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock_count_creation_products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_qty` int NOT NULL,
  `counted_qty` int NOT NULL,
  `re_count_qty` int NOT NULL,
  `recount_variance_qty` int NOT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `variance_qty` int NOT NULL,
  `stockcount_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ymybuhjrbm1l91f5er5wmsv0` (`stockcount_id`),
  CONSTRAINT `FK4ymybuhjrbm1l91f5er5wmsv0` FOREIGN KEY (`stockcount_id`) REFERENCES `stock_count_creation` (`count_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_count_creation_products`
--

LOCK TABLES `stock_count_creation_products` WRITE;
/*!40000 ALTER TABLE `stock_count_creation_products` DISABLE KEYS */;
INSERT INTO `stock_count_creation_products` VALUES (1,176,0,0,0,'sku001','10000001',0,'SC353464120469'),(2,128,0,0,0,'sku002','10000002',0,'SC353464120469'),(3,267,0,0,0,'sku004','10000004',0,'SC353464120469'),(5,176,0,0,0,'sku001','10000001',0,'SC819596697149'),(6,20,0,0,0,'sku003','10000003',0,'SC819596697149'),(7,267,0,0,0,'sku004','10000004',0,'SC819596697149'),(12,176,0,0,0,'sku001','10000001',0,'SC322400151254'),(13,20,0,0,0,'sku003','10000003',0,'SC322400151254'),(14,2,0,0,0,'sku754','100087883',0,'SC322400151254'),(15,61,0,0,0,'sku654','100087884',0,'SC322400151254'),(24,9,0,0,0,'sku006','100087884',0,'SC977793532681'),(25,12,0,0,0,'sku008','10000003',0,'SC977793532681'),(26,53,0,0,0,'sku751','100087883',0,'SC977793532681'),(27,35,0,0,0,'sku752','100087884',0,'SC977793532681'),(28,9,0,7,-2,'sku006','100087884',0,'SC997497783549'),(29,9,0,9,0,'sku005','10000003',0,'SC997497783549'),(30,53,0,53,0,'sku751','100087883',0,'SC997497783549');
/*!40000 ALTER TABLE `stock_count_creation_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-19 11:53:40
