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
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `store` varchar(255) DEFAULT NULL,
  `stockcount_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ymybuhjrbm1l91f5er5wmsv0` (`stockcount_id`),
  CONSTRAINT `FK4ymybuhjrbm1l91f5er5wmsv0` FOREIGN KEY (`stockcount_id`) REFERENCES `stock_count_creation` (`count_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock_count_creation_products`
--

LOCK TABLES `stock_count_creation_products` WRITE;
/*!40000 ALTER TABLE `stock_count_creation_products` DISABLE KEYS */;
INSERT INTO `stock_count_creation_products` VALUES (1,0,'Handbags','string','string','string','string','string','string','string','string',1),(2,0,'Handbags','string','string','string','string','string','string','string','string',1),(3,0,'Handbags','string','string','string','string','string','string','string','string',2),(4,0,'Handbags','string','string','string','string','string','string','string','string',2),(5,0,'Sportswear','string','string','string','string','string','string','string','string',3),(6,0,'Sportswear','string','string','string','string','string','string','string','string',3),(7,0,'Sportswear','string','string','string','string','string','string','string','string',4),(8,0,'Sportswear','string','string','string','string','string','string','string','string',4),(9,0,'Footwear','string','string','string','string','string','string','string','string',5),(10,0,'Footwear','string','string','string','string','string','string','string','string',5),(11,0,'Womenwear','string','string','string','string','string','string','string','string',6),(12,0,'Womenwear','string','string','string','string','string','string','string','string',6),(13,0,'Womenwear','string','string','string','string','string','string','string','string',7),(14,0,'Womenwear','string','string','string','string','string','string','string','string',7);
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

-- Dump completed on 2024-07-29 21:31:45
