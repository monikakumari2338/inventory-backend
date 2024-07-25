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
  PRIMARY KEY (`generated_id`),
  KEY `FKct52habcbsbj4ikf9xmsdwbfy` (`asn_number`),
  CONSTRAINT `FKct52habcbsbj4ikf9xmsdwbfy` FOREIGN KEY (`asn_number`) REFERENCES `asn` (`asn_number`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asnpoitem_details`
--

LOCK TABLES `asnpoitem_details` WRITE;
/*!40000 ALTER TABLE `asnpoitem_details` DISABLE KEYS */;
INSERT INTO `asnpoitem_details` VALUES (1,'2024-06-03','string','string','2024-06-03',0,'string','string','string','string',0,0,'string','sku004','string','string','string','ASN055795907332'),(2,'2024-07-22','string','string','2024-07-22',5,'string','string','string','string',5,0,'string','sku751','string','string','string','ASN675064991298'),(3,'2024-07-22','string','string','2024-07-22',5,'string','string','string','string',5,0,'string','sku751','string','string','string','ASN334541789395'),(8,'2024-07-24','Sportswear','White','2024-07-24',10,'https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png','Nike Elevate','2425','7000',4,6,'7','sku202','string','string','string','ASN619102978113'),(9,'2024-07-25','string','string','2024-07-24',0,'string','string','string','string',0,0,'string','string','string','string','string','ASN408369836177'),(11,'2024-07-25','string','string','2024-07-24',0,'string','string','string','string',0,0,'string','string','string','string','string','ASN641040062329');
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

-- Dump completed on 2024-07-25 15:43:14
