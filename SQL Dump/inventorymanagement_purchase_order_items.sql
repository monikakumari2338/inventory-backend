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
-- Table structure for table `purchase_order_items`
--

DROP TABLE IF EXISTS `purchase_order_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `purchase_order_items` (
  `generated_id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `damage_image` mediumtext,
  `damage_qty` int NOT NULL,
  `expected_qty` int NOT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `is_completed` bit(1) NOT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `received_qty` int NOT NULL,
  `remaining_qty` int NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `tax_code` varchar(255) DEFAULT NULL,
  `tax_percentage` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `po_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`generated_id`),
  KEY `FKrflho7v2qimvvvm9xvuwuiwwl` (`po_number`),
  CONSTRAINT `FKrflho7v2qimvvvm9xvuwuiwwl` FOREIGN KEY (`po_number`) REFERENCES `purchase_order` (`po_number`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_items`
--

LOCK TABLES `purchase_order_items` WRITE;
/*!40000 ALTER TABLE `purchase_order_items` DISABLE KEYS */;
INSERT INTO `purchase_order_items` VALUES (1,'Sportswear','Red',NULL,0,10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','PO-60J1Y30FDTO6'),(2,'Sportswear','White',NULL,0,10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','PO-60J1Y30FDTO6'),(3,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'M','sku751','string','string','string','PO-60J1Y30FDTO6'),(4,'Sportswear','Red',NULL,0,10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','PO-R0TLVSQIP1J7'),(5,'Sportswear','White',NULL,0,10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','PO-R0TLVSQIP1J7'),(6,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'M','sku751','string','string','string','PO-R0TLVSQIP1J7'),(7,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'S','sku752','string','string','string','PO-R0TLVSQIP1J7'),(8,'Sportswear','Red',NULL,0,10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','PO-08OYK7YHU9QH'),(9,'Sportswear','White',NULL,0,10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','PO-08OYK7YHU9QH'),(10,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'M','sku751','string','string','string','PO-08OYK7YHU9QH'),(11,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'S','sku752','string','string','string','PO-08OYK7YHU9QH'),(12,'Sportswear','Red',NULL,0,10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','PO-2F3PEE8GQM2L'),(13,'Sportswear','White',NULL,0,10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','PO-2F3PEE8GQM2L'),(14,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'M','sku751','string','string','string','PO-2F3PEE8GQM2L'),(15,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'S','sku752','string','string','string','PO-2F3PEE8GQM2L'),(16,'Sportswear','Red',NULL,0,10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','PO-NK9PM2XQBGYZ'),(17,'Sportswear','White',NULL,0,10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','PO-NK9PM2XQBGYZ'),(18,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'M','sku751','string','string','string','PO-NK9PM2XQBGYZ'),(19,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'S','sku752','string','string','string','PO-NK9PM2XQBGYZ'),(20,'Sportswear','Red',NULL,0,10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','PO-EIB6AM6RI1S6'),(21,'Sportswear','White',NULL,0,10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','PO-EIB6AM6RI1S6'),(22,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'M','sku751','string','string','string','PO-EIB6AM6RI1S6'),(23,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'S','sku752','string','string','string','PO-EIB6AM6RI1S6'),(24,'Sportswear','Red',NULL,0,10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','PO-MZBIYY6RE7SX'),(25,'Sportswear','White',NULL,0,10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','PO-MZBIYY6RE7SX'),(26,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'M','sku751','string','string','string','PO-MZBIYY6RE7SX'),(27,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'S','sku752','string','string','string','PO-MZBIYY6RE7SX'),(28,'Sportswear','Red',NULL,0,10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','PO-Y1U8EZSJX5I9'),(29,'Sportswear','White',NULL,0,10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','PO-Y1U8EZSJX5I9'),(30,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'M','sku751','string','string','string','PO-Y1U8EZSJX5I9'),(31,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'S','sku752','string','string','string','PO-Y1U8EZSJX5I9'),(32,'Sportswear','Red',NULL,0,10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','PO-I8EZ8LV4EII7'),(33,'Sportswear','White',NULL,0,10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','PO-I8EZ8LV4EII7'),(34,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'M','sku751','string','string','string','PO-I8EZ8LV4EII7'),(35,'Sportswear','Red',NULL,0,10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'S','sku752','string','string','string','PO-I8EZ8LV4EII7');
/*!40000 ALTER TABLE `purchase_order_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-26 15:31:08
