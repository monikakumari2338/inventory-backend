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
-- Table structure for table `save_stock_count_products`
--

DROP TABLE IF EXISTS `save_stock_count_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `save_stock_count_products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_qty` int NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `counted_qty` int NOT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `re_count_qty` int NOT NULL,
  `recount_variance_qty` int NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `store` varchar(255) DEFAULT NULL,
  `variance_qty` int NOT NULL,
  `stockcount_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3aebxawqimhlx9fpvi7o07inq` (`stockcount_id`),
  CONSTRAINT `FK3aebxawqimhlx9fpvi7o07inq` FOREIGN KEY (`stockcount_id`) REFERENCES `save_stock_count_info` (`count_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `save_stock_count_products`
--

LOCK TABLES `save_stock_count_products` WRITE;
/*!40000 ALTER TABLE `save_stock_count_products` DISABLE KEYS */;
INSERT INTO `save_stock_count_products` VALUES (5,15,'Sportswear','Barely Green',1,'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png','Nike Elevate','2425','7000',0,0,'6','sku200','Pacific Dwarka',14,39),(6,10,'Sportswear','Barely Green',1,'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png','Nike Elevate','2425','7000',0,0,'7','sku201','Pacific Dwarka',9,39),(7,0,'string','string',0,'string','string','string','string',0,0,'string','string','Vegas',0,100000),(8,5,'Handbags','string',4,'string','string','string','string',0,0,'string','string','Pacific Dwarka',1,1),(9,5,'Handbags','string',4,'string','string','string','string',0,0,'string','string','Pacific Dwarka',1,1),(10,5,'Sportswear','string',4,'string','string','string','string',0,0,'string','string','Pacific Dwarka',1,3),(11,5,'Sportswear','string',4,'string','string','string','string',0,0,'string','string','Pacific Dwarka',1,3),(12,5,'Womenwear','string',4,'string','string','string','string',0,0,'string','string','Pacific Dwarka',1,6),(13,5,'Womenwear','string',4,'string','string','string','string',0,0,'string','string','Pacific Dwarka',1,6);
/*!40000 ALTER TABLE `save_stock_count_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-08-05 12:14:32
