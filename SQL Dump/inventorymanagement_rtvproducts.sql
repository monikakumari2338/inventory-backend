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
-- Table structure for table `rtvproducts`
--

DROP TABLE IF EXISTS `rtvproducts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rtvproducts` (
  `generated_id` int NOT NULL AUTO_INCREMENT,
  `attached_image` varchar(255) DEFAULT NULL,
  `return_qty` int NOT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `rtvid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`generated_id`),
  KEY `FK8d90qoimcniv9bjw3e2jirlbi` (`rtvid`),
  CONSTRAINT `FK8d90qoimcniv9bjw3e2jirlbi` FOREIGN KEY (`rtvid`) REFERENCES `rtvinfo` (`rtvid`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rtvproducts`
--

LOCK TABLES `rtvproducts` WRITE;
/*!40000 ALTER TABLE `rtvproducts` DISABLE KEYS */;
INSERT INTO `rtvproducts` VALUES (1,'img1',10,'sku200','upc1','RTV498798500696'),(2,'img1',10,'sku201','upc1','RTV498798500696'),(3,'img1',10,'sku004','upc1','RTV064461845821'),(4,'img1',12,'sku006','upc1','RTV064461845821'),(5,'img1',10,'sku004','upc1','RTV064461845821'),(6,'img1',12,'sku006','upc1','RTV064461845821'),(13,'string',2,'sku001','string','RTV998548683830'),(14,'string',2,'sku002','string','RTV998548683830'),(15,'string',10,'sku001','string','RTV153745758592'),(16,NULL,1,'sku001','string','RTV661508958674'),(17,NULL,1,'sku001','string','RTV461806453813'),(19,NULL,1,'sku002','string','RTV389571094826'),(23,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',3,'sku001','10000001','RTV564279920235'),(24,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',4,'sku002','10000002','RTV564279920235'),(31,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',1,'sku001','10000001','RTV537033673992'),(32,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80',1,'sku002','10000002','RTV537033673992'),(35,'https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg',3,'sku001','10000001','RTV141829208794'),(36,'file:///data/user/0/host.exp.exponent/cache/ExperienceData/%2540anonymous%252FinventoryManagement-cfe52548-81b1-465b-bb40-d8f70a6884a0/ImagePicker/ad6456af-c201-4117-be89-ca8422ad02a6.png',1,'sku002','string','RTV141829208794');
/*!40000 ALTER TABLE `rtvproducts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-06 12:43:40
