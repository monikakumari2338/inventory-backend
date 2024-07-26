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
  `category` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `damage_proof` varchar(255) DEFAULT NULL,
  `damage_qty` int NOT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `item_name` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `received_qty` int NOT NULL,
  `requested_qty` int NOT NULL,
  `shipped_qty` int NOT NULL,
  `size` varchar(255) DEFAULT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `tax_code` varchar(255) DEFAULT NULL,
  `tax_percentage` varchar(255) DEFAULT NULL,
  `upc` varchar(255) DEFAULT NULL,
  `tsf_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`generated_id`),
  KEY `FKl5ia3447d5xgo105sauo2ep5s` (`tsf_id`),
  CONSTRAINT `FKl5ia3447d5xgo105sauo2ep5s` FOREIGN KEY (`tsf_id`) REFERENCES `tsf_head` (`tsf_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tsf_details`
--

LOCK TABLES `tsf_details` WRITE;
/*!40000 ALTER TABLE `tsf_details` DISABLE KEYS */;
INSERT INTO `tsf_details` VALUES (1,5,'Sportswear','White','string',0,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424','2300',5,5,5,'6','sku003','string','string','10000003','TSF639617485201'),(2,5,'Womenwear','Black','abc.png',1,'https://th.bing.com/th/id/OIP.tFh_59B4phzg3uzWQunZzAHaHa?pid=ImgDet&w=193&h=193&c=7&dpr=1.5','Dress','4444','7686',4,5,5,'S','sku005','string','string','10000005','TSF639617485201'),(3,2,'Sportswear','White','string',0,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424','2300',2,2,2,'6','sku003','string','string','10000003','TSF420403229332'),(4,2,'Womenwear','Black','abc.png',1,'https://th.bing.com/th/id/OIP.tFh_59B4phzg3uzWQunZzAHaHa?pid=ImgDet&w=193&h=193&c=7&dpr=1.5','Dress','4444','7686',1,2,2,'S','sku005','string','string','10000005','TSF420403229332'),(5,2,'Sportswear','White',NULL,0,'https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','Nike 45','2424','2300',0,2,2,'5','sku002','string','string','100087883','TSF223428449508'),(6,2,'Womenwear','Black',NULL,0,'https://th.bing.com/th/id/OIP.tFh_59B4phzg3uzWQunZzAHaHa?pid=ImgDet&w=193&h=193&c=7&dpr=1.5','Dress','4444','8686',0,2,8,'M','sku006','string','string','10000006','TSF223428449508'),(8,0,'Sports','red',NULL,0,'abc','Nike 45','2424','20000',0,3,0,'5','sku004','003','2','1010100','TSF154304938762'),(9,0,'string','string',NULL,0,'string','string','string','string',0,0,0,'string','string','string','string','string','TSF329573523909'),(10,0,'string','string',NULL,0,'string','string','string','string',0,0,0,'string','string','string','string','string','TSF090182327709'),(11,0,'string','string',NULL,0,'string','string','string','string',0,0,0,'string','string','string','string','string','TSF744217411742'),(12,0,'string','string',NULL,0,'string','string','string','string',0,0,0,'string','string','string','string','string','TSF002548223170'),(13,0,'string','string',NULL,0,'string','string','string','string',0,0,0,'string','string','string','string','string','TSF081808395856'),(14,0,'string','string',NULL,0,'string','string','string','string',0,0,0,'string','string','string','string','string','TSF764378565072'),(15,0,'string','string',NULL,0,'string','string','string','string',0,0,0,'string','string','string','string','string','TSF251166674550'),(16,0,'string','string',NULL,0,'string','string','string','string',0,0,0,'string','string','string','string','string','TSF404694166765'),(17,0,'string','string',NULL,0,'string','string','string','string',0,0,0,'string','string','string','string','string','TSF396790535283'),(18,0,'string','string',NULL,0,'string','string','string','string',0,0,0,'string','string','string','string','string','TSF311849490561');
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

-- Dump completed on 2024-07-26 11:39:27
