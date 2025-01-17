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
-- Table structure for table `tsf_details`
--

DROP TABLE IF EXISTS `tsf_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tsf_details` (
  `generated_id` int NOT NULL AUTO_INCREMENT,
  `approved_qty` int NOT NULL,
  `damage_proof` varchar(255) DEFAULT NULL,
  `damage_qty` int NOT NULL,
  `received_qty` int NOT NULL,
  `requested_qty` int NOT NULL,
  `shipped_qty` int NOT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `tsf_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`generated_id`),
  KEY `FKl5ia3447d5xgo105sauo2ep5s` (`tsf_id`),
  CONSTRAINT `FKl5ia3447d5xgo105sauo2ep5s` FOREIGN KEY (`tsf_id`) REFERENCES `tsf_head` (`tsf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tsf_details`
--

LOCK TABLES `tsf_details` WRITE;
/*!40000 ALTER TABLE `tsf_details` DISABLE KEYS */;
INSERT INTO `tsf_details` VALUES (1,0,NULL,0,0,1,0,'sku002','10000002','TSF384742540640'),(2,0,'',0,0,4,2,'sku003','10000003','TSF336979613205'),(3,6,'',0,6,10,6,'sku003','10000003','TSF474655391446'),(4,10,NULL,0,0,10,0,'sku001','10000001','TSF462067815000'),(5,10,NULL,0,0,10,0,'sku002','10000002','TSF462067815000'),(6,1,NULL,0,0,1,0,'sku002','10000002','TSF462738805086'),(7,0,NULL,0,0,20,0,'sku002','10000002','TSF438773743413'),(8,0,NULL,0,0,20,0,'sku001','10000001','TSF438773743413'),(9,1,'',0,0,1,0,'sku001','10000001','TSF953417201548');
/*!40000 ALTER TABLE `tsf_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-17 12:57:48
