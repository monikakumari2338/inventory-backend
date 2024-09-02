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
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_count_creation_products`
--

LOCK TABLES `stock_count_creation_products` WRITE;
/*!40000 ALTER TABLE `stock_count_creation_products` DISABLE KEYS */;
INSERT INTO `stock_count_creation_products` VALUES (6,10,6,7,3,'sku003','abc61251',4,'ADHOC008644536215'),(7,9,6,7,2,'sku005','abc61251',3,'ADHOC008644536215'),(9,10,5,6,4,'sku003','abc61251',5,'SC514625503830'),(10,9,5,6,3,'sku005','abc61251',4,'SC514625503830'),(19,10,6,6,4,'sku003','abc61251',4,'SC333770347901'),(20,9,8,6,3,'sku005','abc61251',1,'SC333770347901'),(21,10,7,6,4,'sku003','abc61251',0,'ADHOC130941231023'),(22,9,7,6,3,'sku005','abc61251',0,'ADHOC130941231023'),(23,10,7,0,0,'sku003','abc61251',0,'ADHOC718532864491'),(24,9,7,0,0,'sku005','abc61251',0,'ADHOC718532864491'),(25,10,6,0,0,'sku003','abc61251',4,'ADHOC718532864491'),(26,9,6,0,0,'sku005','abc61251',3,'ADHOC718532864491'),(29,10,6,8,2,'sku003','abc61251',4,'ADHOC383339747600'),(30,9,6,8,1,'sku005','abc61251',3,'ADHOC383339747600'),(31,10,8,6,4,'sku003','abc123',2,'SC183975763519'),(32,10,12,8,2,'sku003','abc',-2,'ADHOC110498847463');
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

-- Dump completed on 2024-09-02 12:14:54
