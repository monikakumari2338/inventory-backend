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
-- Table structure for table `dsd_items`
--

DROP TABLE IF EXISTS `dsd_items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dsd_items` (
  `generated_id` int NOT NULL AUTO_INCREMENT,
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `expected_qty` int NOT NULL,
  `image` varchar(255) DEFAULT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `received_qty` int NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `dsd_number` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`generated_id`),
  KEY `FKobs4muyots340ax36409tikqy` (`dsd_number`),
  CONSTRAINT `FKobs4muyots340ax36409tikqy` FOREIGN KEY (`dsd_number`) REFERENCES `dsd` (`dsd_number`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dsd_items`
--

LOCK TABLES `dsd_items` WRITE;
/*!40000 ALTER TABLE `dsd_items` DISABLE KEYS */;
INSERT INTO `dsd_items` VALUES (3,'Sportswear','White',0,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','5','Nike 45','2424',5,NULL,'sku002','string','DSD452989549916'),(4,'Womenwear','Black',0,'https://th.bing.com/th/id/OIP.tFh_59B4phzg3uzWQunZzAHaHa?pid=ImgDet&w=193&h=193&c=7&dpr=1.5','M','Dress','4444',1,NULL,'sku006','1000007','DSD452989549916');
/*!40000 ALTER TABLE `dsd_items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-12 16:36:56
