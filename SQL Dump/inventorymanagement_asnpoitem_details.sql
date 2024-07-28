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
-- Table structure for table `asnpoitem_details`
--

DROP TABLE IF EXISTS `asnpoitem_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `asnpoitem_details` (
  `generated_id` int NOT NULL AUTO_INCREMENT,
  `received_date` date DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `expected_delivery_date` date DEFAULT NULL,
  `expected_qty` int NOT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `remaining_qty` int NOT NULL,
  `shipped_qty` int NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `tax_code` varchar(255) DEFAULT NULL,
  `tax_percentage` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `asn_number` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`generated_id`),
  KEY `FKct52habcbsbj4ikf9xmsdwbfy` (`asn_number`),
  CONSTRAINT `FKct52habcbsbj4ikf9xmsdwbfy` FOREIGN KEY (`asn_number`) REFERENCES `asn` (`asn_number`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asnpoitem_details`
--

LOCK TABLES `asnpoitem_details` WRITE;
/*!40000 ALTER TABLE `asnpoitem_details` DISABLE KEYS */;
INSERT INTO `asnpoitem_details` VALUES (1,'2024-07-26','Sportswear','Red','2024-07-26',10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','ASN139150535975',NULL),(2,'2024-07-26','Sportswear','White','2024-07-26',10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','ASN261316939272',NULL),(3,'2024-07-26','Sportswear','Red','2024-07-26',10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','Dress','4444','2000',5,5,'S','sku752','string','string','string','ASN552853609198',NULL),(4,'2024-07-26','Sportswear','Red','2024-07-26',10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','Dress','4444','2000',5,5,'S','sku752','string','string','string','ASN146522263014',NULL),(5,'2024-07-26','Sportswear','Red','2024-07-26',10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','Dress','4444','2000',5,5,'M','sku751','string','string','string','ASN146522263014',NULL),(6,'2024-07-26','Sportswear','Red','2024-07-26',10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','Dress','4444','2000',0,10,'S','sku752','string','string','string','ASN628077724803',NULL),(7,'2024-07-26','Sportswear','Red','2024-07-26',10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','Dress','4444','2000',0,10,'M','sku751','string','string','string','ASN628077724803',NULL),(8,'2024-07-26','Sportswear','Red','2024-07-26',10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','ASN883852697136',NULL),(9,'2024-07-26','Sportswear','White','2024-07-26',10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','ASN883852697136',NULL),(10,'2024-07-26','Sportswear','Red','2024-07-26',10,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','Nike 45','2424','2300',0,10,'6','sku001','string','string','string','ASN829802200631',NULL),(11,'2024-07-26','Sportswear','White','2024-07-26',10,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424','2300',0,10,'5','sku002','string','string','string','ASN829802200631',NULL),(12,'2024-07-26','Sportswear','Red','2024-07-26',10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','Dress','4444','2000',0,10,'S','sku752','string','string','string','ASN383637543354',NULL),(13,'2024-07-26','Sportswear','Red','2024-07-26',10,'https://th.bing.com/th/id/OIP.-TSZOrEJ5F9mv5L0xv83OgAAAA?pid=ImgDet&w=193&h=231&c=7&dpr=1.5','Dress','4444','2000',0,10,'M','sku751','string','string','string','ASN758823604732',NULL);
/*!40000 ALTER TABLE `asnpoitem_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-28 19:55:59
