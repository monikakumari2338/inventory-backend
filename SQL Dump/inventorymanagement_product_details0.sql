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
-- Table structure for table `product_details`
--

DROP TABLE IF EXISTS `product_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product_details` (
  `id` int NOT NULL AUTO_INCREMENT,
  `color` varchar(255) DEFAULT NULL,
  `image_data` varchar(255) DEFAULT NULL,
  `price` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `item_number` varchar(255) DEFAULT NULL,
  `store_id` int DEFAULT NULL,
  `upc` varchar(255) NOT NULL,
  `sku` varchar(255) DEFAULT NULL,
  `non_sellable_stock` int NOT NULL,
  `sellable_stock` int NOT NULL,
  `total_stock` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKia4qvliqh4ot1434tmwf6da3e` (`item_number`),
  KEY `FKpgol3h1vhok40n4mmpm6vbs3l` (`store_id`),
  CONSTRAINT `FKia4qvliqh4ot1434tmwf6da3e` FOREIGN KEY (`item_number`) REFERENCES `products_db` (`item_number`),
  CONSTRAINT `FKpgol3h1vhok40n4mmpm6vbs3l` FOREIGN KEY (`store_id`) REFERENCES `stores` (`store_id`)
) ENGINE=InnoDB AUTO_INCREMENT=123 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_details`
--

LOCK TABLES `product_details` WRITE;
/*!40000 ALTER TABLE `product_details` DISABLE KEYS */;
INSERT INTO `product_details` VALUES (41,'Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','2400','6','2424',3,'10000001','sku001',48,172,220),(42,'White','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','2500','5','2424',3,'10000002','sku002',16,136,136),(43,'White','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','2300','6','2424',2,'10000003','sku003',0,200,200),(44,'Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','2300','5','2424',3,'10000004','sku004',119,260,379),(45,'Black','https://m.media-amazon.com/images/I/61aRKDOQGEL._SY879_.jpg','7687','S','4444',2,'10000753','sku753',0,200,200),(46,'Black','https://m.media-amazon.com/images/I/61aRKDOQGEL._SY879_.jpg','8987','M','4444',2,'10000006','sku006',0,400,400),(47,'Black','https://m.media-amazon.com/images/I/61aRKDOQGEL._SY879_.jpg','2000','M','4444',3,'10000006','sku006',57,44,101),(48,'Pink','https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg','8087','L','4444',2,'10000008','sku008',0,400,400),(49,'Pink','https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg','9087','S','4444',2,'10000005','sku005',2,200,202),(50,'Black','https://m.media-amazon.com/images/I/61aRKDOQGEL._SY879_.jpg','9087','L','4444',4,'10000010','sku010',0,2,0),(75,'Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','20000','5','2424',2,'10000004','sku004',4,400,404),(76,'Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','20000','5','2424',4,'10000004','sku004',0,2,0),(77,'Blue','https://th.bing.com/th/id/OIP.OsVQO54jbToDjw1GvIsVvwHaFj?pid=ImgDet&w=178&h=133&c=7&dpr=1.5','5000','5','2424',2,'10000902','sku902',0,400,400),(87,'White','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','5000','5','2424',2,'10000002','sku002',1,190,191),(88,'Black','https://m.media-amazon.com/images/I/61aRKDOQGEL._SY879_.jpg','2000','L','4444',2,'10000010','sku010',0,200,200),(89,'Pink','https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg','2000','M','4444',2,'10000007','sku007',0,200,200),(90,'Pink','https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg','2000','L','4444',3,'10000008','sku008',21,24,45),(91,'Pink','https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg','2000','M','4444',3,'10000007','sku007',30,73,73),(92,'Pink','https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg','2000','S','4444',3,'10000005','sku005',30,88,88),(93,'Black','https://m.media-amazon.com/images/I/61aRKDOQGEL._SY879_.jpg','2000','L','4444',3,'10000010','sku010',0,2,2),(94,'Black','https://m.media-amazon.com/images/I/61aRKDOQGEL._SY879_.jpg','2000','S','4444',3,'10000753','sku753',0,2,2),(95,'Red','https://cdn-images.farfetch-contents.com/14/95/28/28/14952828_24667227_1000.jpg','2000','6','2424',2,'10000001','sku001',0,200,200),(97,'Blue','https://th.bing.com/th/id/OIP.OsVQO54jbToDjw1GvIsVvwHaFj?pid=ImgDet&w=178&h=133&c=7&dpr=1.5','2000','6','2424',3,'10000654','sku654',2,61,63),(98,'Blue','https://th.bing.com/th/id/OIP.OsVQO54jbToDjw1GvIsVvwHaFj?pid=ImgDet&w=178&h=133&c=7&dpr=1.5','2000','6','2424',2,'10000654','sku654',0,400,400),(99,'Blue','https://th.bing.com/th/id/OIP.OsVQO54jbToDjw1GvIsVvwHaFj?pid=ImgDet&w=178&h=133&c=7&dpr=1.5','2000','5','2424',3,'10000902','sku902',0,2,2),(101,'Barely Green','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png','7000','6','2425',3,'10000200','sku200',10,19,29),(102,'Barely Green','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/853de239-b6eb-48a1-baa2-02ea6c2d28c6/elevate-3-basketball-shoes-QT43Gj.png','7000','7','2425',3,'10000201','sku201',10,20,30),(103,'White','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png','7000','7','2425',3,'10000202','sku202',0,10,10),(104,'White','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/a38d9904-4eb2-4244-b242-4cae54f0136d/elevate-3-basketball-shoes-QT43Gj.png','7000','6','2425',3,'10000203','sku203',0,0,0),(105,'Light Violet','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/6d297943-4dad-4cf7-a1c5-0a4786591ae1/air-max-dn-shoes-drXjb8.png','13000','6','2426',3,'10000204','sku204',0,0,0),(106,'Light Violet','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/6d297943-4dad-4cf7-a1c5-0a4786591ae1/air-max-dn-shoes-drXjb8.png','13000','7','2426',3,'10000205','sku205',0,0,0),(107,'Half Blue','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/20ff441a-e1d5-475f-9b31-d52d7f01c217/air-max-dn-shoes-drXjb8.png','13000','7','2426',3,'10000206','sku206',0,0,0),(108,'Half Blue','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/20ff441a-e1d5-475f-9b31-d52d7f01c217/air-max-dn-shoes-drXjb8.png','13000','6','2426',3,'10000207','sku207',0,0,0),(109,'White','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/8a9c6c3e-4bc5-4909-9709-3911bc78a347/jumpman-mvp-shoes-JV1HCs.png','13000','6','2427',3,'10000208','sku208',3,17,20),(110,'White','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/8a9c6c3e-4bc5-4909-9709-3911bc78a347/jumpman-mvp-shoes-JV1HCs.png','13000','7','2427',3,'10000209','sku209',4,9,13),(111,'Black','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/117890a6-97f0-457b-9550-80baf31ea1ea/jumpman-mvp-shoes-JV1HCs.png','13000','7','2427',3,'10000210','sku210',17,21,38),(112,'Black','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/117890a6-97f0-457b-9550-80baf31ea1ea/jumpman-mvp-shoes-JV1HCs.png','13000','6','2427',3,'10000212','sku211',19,15,34),(113,'Navy','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/b9542e6b-db03-4ef3-8df5-7eb07de98020/interact-run-road-running-shoes-qVxgms.png','6700','6','2428',3,'10000012','sku212',0,0,0),(114,'Navy','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco,u_126ab356-44d8-4a06-89b4-fcdcc8df0245,c_scale,fl_relative,w_1.0,h_1.0,fl_layer_apply/117890a6-97f0-457b-9550-80baf31ea1ea/jumpman-mvp-shoes-JV1HCs.png','6700','7','2428',3,'10000213','sku213',0,0,0),(115,'Sail','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/65d684cb-c14a-43d4-80c2-c1c43b7892e6/interact-run-roada-running-shoes-qVxgms.png','7095','7','2428',3,'10000214','sku214',0,0,0),(116,'Sail','https://static.nike.com/a/images/t_PDP_1728_v1/f_auto,q_auto:eco/65d684cb-c14a-43d4-80c2-c1c43b7892e6/interact-run-road-running-shoes-qVxgms.png','7095','6','2428',3,'10000215','sku215',0,0,0),(119,'White','https://www.nike.ae/dw/image/v2/BDVB_PRD/on/demandware.static/-/Sites-akeneo-master-catalog/default/dw8ce2b3f8/nk/e6d/a/4/1/f/a/e6da41fa_1be4_4ce5_b89c_22be4f1f02d4.png?sw=540&sh=540&sm=fit&q=80','2300','6','2424',3,'10000003','sku003',34,900,934),(120,'Pink','https://m.media-amazon.com/images/I/61kWqKNP2CL._SY879_.jpg','9087','S','4444',4,'10000005','sku005',1,9,10);
/*!40000 ALTER TABLE `product_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-01-17 12:57:42
