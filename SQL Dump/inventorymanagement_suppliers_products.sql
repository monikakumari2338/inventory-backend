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
-- Table structure for table `suppliers_products`
--

DROP TABLE IF EXISTS `suppliers_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suppliers_products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `store` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `supplier_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdpy1wg96qkljeo1xh1cox05r9` (`supplier_id`),
  CONSTRAINT `FKdpy1wg96qkljeo1xh1cox05r9` FOREIGN KEY (`supplier_id`) REFERENCES `suppliers` (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suppliers_products`
--

LOCK TABLES `suppliers_products` WRITE;
/*!40000 ALTER TABLE `suppliers_products` DISABLE KEYS */;
INSERT INTO `suppliers_products` VALUES (1,'Sportswear','Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424','2300','6','sku001','Pacific Dwarka','string','Sup101'),(2,'Sportswear','White','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424','2300','5','sku002','Pacific Dwarka','string','Sup101'),(3,'Sportswear','Red','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','Dress','4444','2000','M','sku751','Pacific Dwarka','string','Sup101'),(4,'Sportswear','Red','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','Dress','4444','2000','S','sku752','Pacific Dwarka','string','Sup101'),(5,'Sportswear','Barely Green','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png','Nike Elevate','2425','7000','6','sku200','Pacific Dwarka','string','Sup101'),(6,'Sportswear','Barely Green','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png','Nike Elevate','2425','7000','7','sku201','Pacific Dwarka','string','Sup101'),(7,'Sportswear','White','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png','Nike Elevate','2425','7000','7','sku202','Pacific Dwarka','string','Sup101');
/*!40000 ALTER TABLE `suppliers_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-24 14:33:46
