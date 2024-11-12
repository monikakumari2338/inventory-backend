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
-- Table structure for table `inventory_adjustment_products`
--

DROP TABLE IF EXISTS `inventory_adjustment_products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory_adjustment_products` (
  `id` int NOT NULL AUTO_INCREMENT,
  `adj_qty` int NOT NULL,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `image_data` mediumtext,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `proof` mediumtext,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `adj_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK15gkjev64k2ldbhr9d6lloi8o` (`adj_id`),
  CONSTRAINT `FK15gkjev64k2ldbhr9d6lloi8o` FOREIGN KEY (`adj_id`) REFERENCES `inv_adjustment` (`adj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_adjustment_products`
--

LOCK TABLES `inventory_adjustment_products` WRITE;
/*!40000 ALTER TABLE `inventory_adjustment_products` DISABLE KEYS */;
INSERT INTO `inventory_adjustment_products` VALUES (7,4,'Sportswear','White','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424','file:///data/user/0/host.exp.exponent/cache/ExperienceData/%2540anonymous%252FinventoryManagement-cfe52548-81b1-465b-bb40-d8f70a6884a0/ImagePicker/b1f61c3a-4bdd-44fe-89cd-5df125d1be53.png','5','sku002','10000002','IA178927131997'),(8,4,'Sportswear','Red',NULL,'Nike 45','2424','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','6','sku001','10000001','IA178927131997'),(9,6,'Sportswear','Red',NULL,'Nike 45','2424','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','5','sku004','10000004','IA178927131997'),(10,7,'Womenwear','Black',NULL,'Dress ','4444','https://th.bing.com/th/id/OIP.tFh_59B4phzg3uzWQunZzAHaHa?pid=ImgDet&w=193&h=193&c=7&dpr=1.5','M','sku006','10000007','IA178927131997'),(11,8,'Womenwear','Red',NULL,'Dress ','4444','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','L','sku008','100087884','IA178927131997'),(12,34,'Sportswear','White',NULL,'Nike 45','2424','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','6','sku003','10000003','IA178927131997');
/*!40000 ALTER TABLE `inventory_adjustment_products` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-12 16:36:47
