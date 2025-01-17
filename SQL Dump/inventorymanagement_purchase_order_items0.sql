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
  `image` varchar(255) DEFAULT NULL,
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
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `purchase_order_items`
--

LOCK TABLES `purchase_order_items` WRITE;
/*!40000 ALTER TABLE `purchase_order_items` DISABLE KEYS */;
INSERT INTO `purchase_order_items` VALUES (1,'Sportswear','Red',NULL,0,50,'','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,50,'6','sku001','string','string','string','PO-HDZTRNG3T6J9'),(2,'Sportswear','White',NULL,0,50,'','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,50,'5','sku002','string','string','string','PO-HDZTRNG3T6J9'),(3,'Sportswear','Barely Green',NULL,0,15,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,15,'6','sku200','string','string','string','PO-HDZTRNG3T6J9'),(4,'Sportswear','Red',NULL,0,100,'','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,100,'6','sku001','string','string','string','PO-KM5NL8ZUOG3P'),(5,'Sportswear','White',NULL,0,60,'','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,60,'5','sku002','string','string','string','PO-KM5NL8ZUOG3P'),(6,'Sportswear','Barely Green',NULL,0,18,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,18,'6','sku200','string','string','string','PO-KM5NL8ZUOG3P'),(10,'Sportswear','Red',NULL,0,100,'','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,100,'6','sku001','string','string','string','PO-6O0GLJMYGHF0'),(11,'Sportswear','White',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku202','string','string','string','PO-6O0GLJMYGHF0'),(12,'Sportswear','Barely Green',NULL,0,18,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,18,'6','sku200','string','string','string','PO-6O0GLJMYGHF0'),(13,'Sportswear','Barely Green','string',0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '','Nike Elevate','2425','7000',10,0,'7','sku201','string','string','string','PO-0FO92HI7TTL5'),(14,'Sportswear','White',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku202','string','string','string','PO-0FO92HI7TTL5'),(15,'Sportswear','Barely Green',NULL,0,18,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,18,'6','sku200','string','string','string','PO-0FO92HI7TTL5'),(16,'Sportswear','Barely Green',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku201','string','string','string','PO-ALZB756NFVAT'),(17,'Sportswear','White',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku202','string','string','string','PO-ALZB756NFVAT'),(18,'Sportswear','Barely Green',NULL,0,18,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,18,'6','sku200','string','string','string','PO-ALZB756NFVAT'),(19,'Sportswear','Barely Green',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku201','string','string','string','PO-WMRMQPO4TOKG'),(20,'Sportswear','White',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku202','string','string','string','PO-WMRMQPO4TOKG'),(21,'Sportswear','Barely Green',NULL,0,18,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,18,'6','sku200','string','string','string','PO-WMRMQPO4TOKG'),(22,'Sportswear','Red',NULL,0,100,'','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,100,'6','sku001','string','string','string','PO-WMRMQPO4TOKG'),(23,'Sportswear','Barely Green',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku201','string','string','string','PO-FL18RR91ZUYR'),(24,'Sportswear','White',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku202','string','string','string','PO-FL18RR91ZUYR'),(25,'Sportswear','Barely Green',NULL,0,18,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,18,'6','sku200','string','string','string','PO-FL18RR91ZUYR'),(26,'Sportswear','Red',NULL,0,100,'','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,100,'6','sku001','string','string','string','PO-FL18RR91ZUYR'),(27,'Sportswear','White',NULL,0,100,'','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,100,'6','sku002','string','string','string','PO-FL18RR91ZUYR'),(28,'Sportswear','Barely Green',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku201','string','string','string','PO-70OZ0UXKCKUE'),(29,'Sportswear','White',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku202','string','string','string','PO-70OZ0UXKCKUE'),(30,'Sportswear','Barely Green',NULL,0,18,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,18,'6','sku200','string','string','string','PO-70OZ0UXKCKUE'),(31,'Sportswear','Red',NULL,0,100,'','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,100,'6','sku001','string','string','string','PO-70OZ0UXKCKUE'),(32,'Sportswear','White',NULL,0,100,'','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,100,'6','sku002','string','string','string','PO-70OZ0UXKCKUE'),(33,'Sportswear','Barely Green',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku201','string','string','string','PO-GQWABYGM9SRT'),(34,'Sportswear','White',NULL,0,10,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,10,'7','sku202','string','string','string','PO-GQWABYGM9SRT'),(35,'Sportswear','Barely Green',NULL,0,18,'','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png',_binary '\0','Nike Elevate','2425','7000',0,18,'6','sku200','string','string','string','PO-GQWABYGM9SRT'),(36,'Sportswear','Red',NULL,0,100,'','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',_binary '\0','Nike 45','2424','2300',0,100,'6','sku001','string','string','string','PO-GQWABYGM9SRT'),(37,'Sportswear','White',NULL,0,100,'','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424','2300',0,100,'6','sku002','string','string','string','PO-GQWABYGM9SRT'),(38,'Womenwear','Red',NULL,0,50,'','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',10,40,'M','sku751','string','string','string','PO-TQCUPNKXQ118'),(39,'Womenwear','Red',NULL,0,30,'','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,30,'S','sku752','string','string','string','PO-TQCUPNKXQ118'),(40,'Womenwear','Black',NULL,0,8,'','https://th.bing.com/th/id/OIP.tFh_59B4phzg3uzWQunZzAHaHa?pid=ImgDet&w=193&h=193&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,8,'M','sku006','string','string','string','PO-TQCUPNKXQ118'),(41,'Womenwear','Red',NULL,0,50,'','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,50,'M','sku751','string','string','string','PO-6JF54QMJ4CKL'),(42,'Womenwear','Red',NULL,0,30,'','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,30,'S','sku752','string','string','string','PO-6JF54QMJ4CKL'),(43,'Womenwear','Black',NULL,0,8,'','https://th.bing.com/th/id/OIP.tFh_59B4phzg3uzWQunZzAHaHa?pid=ImgDet&w=193&h=193&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,8,'M','sku006','string','string','string','PO-6JF54QMJ4CKL'),(44,'Womenwear','Red',NULL,0,10,'','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444','2000',0,10,'L','sku008','string','string','string','PO-6JF54QMJ4CKL'),(45,'Womenwear','Red','string',2,30,'','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '','Dress','4444','2000',43,0,'S','sku752','string','string','string','PO-4RUOQNLXZG06'),(46,'Womenwear','Black','string',0,8,'','https://th.bing.com/th/id/OIP.tFh_59B4phzg3uzWQunZzAHaHa?pid=ImgDet&w=193&h=193&c=7&dpr=1.5',_binary '','Dress','4444','2000',10,0,'M','sku006','string','string','string','PO-4RUOQNLXZG06'),(47,'Womenwear','Red','string',0,10,'','https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '','Dress','4444','2000',10,0,'L','sku008','string','string','string','PO-4RUOQNLXZG06'),(48,'Sportswear','White',NULL,0,4,NULL,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424',NULL,5,0,'5','sku002',NULL,NULL,'string','PO-DSDSITNWBO2IU0W'),(49,'Womenwear','Black',NULL,0,1,NULL,'https://th.bing.com/th/id/OIP.tFh_59B4phzg3uzWQunZzAHaHa?pid=ImgDet&w=193&h=193&c=7&dpr=1.5',_binary '\0','Dress','4444',NULL,1,0,'M','sku006',NULL,NULL,'1000007','PO-DSDSITNWBO2IU0W'),(50,'Sportswear','White',NULL,0,1,NULL,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424',NULL,1,0,'5','sku002',NULL,NULL,'string','PO-DSDBIPU78B57CEN'),(51,'Womenwear','Red',NULL,0,10,NULL,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5',_binary '\0','Dress','4444',NULL,10,0,'L','sku008',NULL,NULL,'1000007','PO-DSDTSHVBLPQ6YLF'),(52,'Sportswear','White',NULL,0,0,NULL,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424',NULL,1,0,'5','sku002',NULL,NULL,'string','PO-DSDD7V58RIMGAMH'),(53,'Sportswear','White',NULL,0,0,NULL,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',_binary '\0','Nike 45','2424',NULL,1,0,'5','sku002',NULL,NULL,'string','PO-DSDHV2OJ129AOMY'),(54,'Womenwear','Pink',NULL,0,0,NULL,'https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg',_binary '\0','Dress','4444',NULL,10,0,'M','sku751',NULL,NULL,'string','PO-DSDJN1CNHTSARBY'),(55,'Womenwear','Pink',NULL,0,0,NULL,'https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg',_binary '\0','Dress','4444',NULL,10,0,'S','sku752',NULL,NULL,'string','PO-DSDJN1CNHTSARBY'),(56,'Womenwear','Black',NULL,0,0,NULL,'https://m.media-amazon.com/images/I/61aRKDOQGEL._SY879_.jpg',_binary '\0','Dress','4444',NULL,1,0,'M','sku006',NULL,NULL,'1000007','PO-DSDJN1CNHTSARBY');
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

-- Dump completed on 2025-01-17 12:57:36