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
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_adjustment_products`
--

LOCK TABLES `inventory_adjustment_products` WRITE;
/*!40000 ALTER TABLE `inventory_adjustment_products` DISABLE KEYS */;
INSERT INTO `inventory_adjustment_products` VALUES (7,4,'Sportswear','White','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424','file:///data/user/0/host.exp.exponent/cache/ExperienceData/%2540anonymous%252FinventoryManagement-cfe52548-81b1-465b-bb40-d8f70a6884a0/ImagePicker/b1f61c3a-4bdd-44fe-89cd-5df125d1be53.png','5','sku002','10000002','IA178927131997'),(8,4,'Sportswear','Red',NULL,'Nike 45','2424','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','6','sku001','10000001','IA178927131997'),(9,6,'Sportswear','Red',NULL,'Nike 45','2424','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','5','sku004','10000004','IA178927131997'),(10,7,'Womenwear','Black',NULL,'Dress ','4444','https://th.bing.com/th/id/OIP.tFh_59B4phzg3uzWQunZzAHaHa?pid=ImgDet&w=193&h=193&c=7&dpr=1.5','M','sku006','10000007','IA178927131997'),(11,8,'Womenwear','Red',NULL,'Dress ','4444','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','L','sku008','100087884','IA178927131997'),(12,34,'Sportswear','White',NULL,'Nike 45','2424','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','6','sku003','10000003','IA178927131997'),(14,2,'Sportswear','Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424','file:///data/user/0/host.exp.exponent/cache/ExperienceData/%2540anonymous%252FinventoryManagement-cfe52548-81b1-465b-bb40-d8f70a6884a0/ImagePicker/ec72af8f-56ae-484d-a94f-39c8c6e3d006.png','6','sku001','10000001','IA880968674945'),(16,4,'Sportswear','White','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424','file:///data/user/0/host.exp.exponent/cache/ExperienceData/%2540anonymous%252FinventoryManagement-cfe52548-81b1-465b-bb40-d8f70a6884a0/ImagePicker/ccefdebd-7e1a-4986-babf-8d4297fc1cf8.png','5','sku002','10000002','IA109776261408'),(17,0,'string','string','string','string','string','string','string','sku004','string','IA679170329077'),(18,1,'Sportswear','Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424',NULL,'5','sku004','10000004','IA482355537870'),(20,4,'Sportswear','White','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424',NULL,'5','sku002','10000002','IA393299062438'),(29,10,'Sportswear','Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424','file:///data/user/0/host.exp.exponent/cache/ExperienceData/%2540anonymous%252FinventoryManagement-cfe52548-81b1-465b-bb40-d8f70a6884a0/ImagePicker/9fa3553a-2d6c-4a5d-a5ff-4ea3fd519347.png','5','sku004','10000004','IA116553177918'),(38,10,'Sportswear','Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424',NULL,'6','sku001','10000001','IA834233807687'),(39,10,'Sportswear','Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424',NULL,'5','sku004','10000004','IA834233807687'),(40,10,'Womenwear','Black','https://m.media-amazon.com/images/I/61aRKDOQGEL._SY879_.jpg','Dress ','4444',NULL,'M','sku006','10000006','IA834233807687'),(41,1,'Womenwear','Pink','https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg','Dress ','4444',NULL,'L','sku008','10000008','IA834233807687'),(42,10,'Sportswear','Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424',NULL,'6','sku001','10000001','IA690896017781'),(43,10,'Sportswear','Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424',NULL,'5','sku004','10000004','IA690896017781'),(44,10,'Womenwear','Black','https://m.media-amazon.com/images/I/61aRKDOQGEL._SY879_.jpg','Dress ','4444',NULL,'M','sku006','10000006','IA690896017781'),(45,10,'Womenwear','Pink','https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg','Dress ','4444',NULL,'L','sku008','10000008','IA690896017781');
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

-- Dump completed on 2025-01-17 12:57:40
