-- MySQL dump 10.13  Distrib 8.0.26, for macos11 (x86_64)
--
-- Host: localhost    Database: air_travel
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `airlines`
--

DROP TABLE IF EXISTS `airlines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `airlines` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `time_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `airlines`
--

LOCK TABLES `airlines` WRITE;
/*!40000 ALTER TABLE `airlines` DISABLE KEYS */;
INSERT INTO `airlines` VALUES (1,'British Airways','2021-09-08 15:27:51'),(2,'Singapore Airlines','2021-09-08 15:27:51'),(3,'American Airlines','2021-09-08 15:27:51'),(4,'Cathay Pacific','2021-09-08 15:27:51'),(5,'Japan Airlines','2021-09-08 15:27:51'),(6,'Virgin','2021-09-08 15:27:51'),(7,'Emirates','2021-09-08 15:27:51');
/*!40000 ALTER TABLE `airlines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flights`
--

DROP TABLE IF EXISTS `flights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flights` (
  `id` int NOT NULL AUTO_INCREMENT,
  `plane_id` int NOT NULL,
  `airline_id` int NOT NULL,
  `flight_num` varchar(45) NOT NULL,
  `time_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_airline_id_idx` (`airline_id`),
  KEY `fk_plane_id_idx` (`plane_id`),
  CONSTRAINT `fk_airline_id` FOREIGN KEY (`airline_id`) REFERENCES `airlines` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_plane_id` FOREIGN KEY (`plane_id`) REFERENCES `planes` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flights`
--

LOCK TABLES `flights` WRITE;
/*!40000 ALTER TABLE `flights` DISABLE KEYS */;
INSERT INTO `flights` VALUES (1,1,1,'BA007','2021-09-08 16:36:20'),(2,2,1,'BA008','2021-09-08 16:36:20'),(3,3,2,'SG204','2021-09-08 16:36:20'),(4,4,2,'SG324','2021-09-08 16:36:20'),(5,1,2,'SG271','2021-09-08 16:36:20'),(6,2,3,'AA111','2021-09-08 16:36:20'),(7,3,3,'AA245','2021-09-08 16:36:20'),(8,4,4,'CP213','2021-09-08 16:36:20'),(9,1,4,'CP467','2021-09-08 16:36:20'),(10,2,4,'CP453','2021-09-08 16:36:20'),(11,3,5,'JL354','2021-09-08 16:36:20'),(12,4,6,'VA009','2021-09-08 16:36:20'),(13,1,6,'VA344','2021-09-08 16:36:20'),(14,2,7,'EM222','2021-09-08 16:36:20');
/*!40000 ALTER TABLE `flights` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locations`
--

DROP TABLE IF EXISTS `locations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `flight_id` int NOT NULL,
  `name` varchar(45) NOT NULL,
  `time_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_flight_id_idx` (`flight_id`),
  KEY `fk_loc_flight_id_idx` (`flight_id`),
  CONSTRAINT `fk_loc_flight_id` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locations`
--

LOCK TABLES `locations` WRITE;
/*!40000 ALTER TABLE `locations` DISABLE KEYS */;
INSERT INTO `locations` VALUES (1,1,'London','2021-09-08 15:43:05'),(2,2,'Tokyo','2021-09-08 15:43:05'),(3,3,'Singapore','2021-09-08 15:43:05'),(4,4,'London','2021-09-08 15:43:05'),(5,5,'Kuala Lumpar','2021-09-08 15:43:05'),(6,6,'New York','2021-09-08 15:43:05'),(7,7,'London','2021-09-08 15:43:05'),(8,8,'Hong Kong','2021-09-08 15:43:05'),(9,9,'Shanghai','2021-09-08 15:43:05'),(10,10,'London','2021-09-08 15:43:05'),(11,11,'Tokyo','2021-09-08 16:26:41'),(12,12,'Sydney','2021-09-08 16:26:41'),(13,13,'New York','2021-09-08 16:26:41'),(14,14,'Dubai','2021-09-08 16:26:41');
/*!40000 ALTER TABLE `locations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `passengers`
--

DROP TABLE IF EXISTS `passengers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `passengers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `passport_num` varchar(45) NOT NULL,
  `email_address` varchar(45) NOT NULL,
  `time_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `passengers`
--

LOCK TABLES `passengers` WRITE;
/*!40000 ALTER TABLE `passengers` DISABLE KEYS */;
INSERT INTO `passengers` VALUES (1,'Sadat','Malik','123456','sadat@malik.com','2021-09-08 16:28:55'),(2,'John','Smith','23456','js@smith.com','2021-09-08 16:28:55'),(3,'Katy','Baldwin','456789','katy@baldwin.net','2021-09-08 16:28:55'),(4,'Jackie','Alstead','3467892','jack@alt.net','2021-09-08 16:28:55'),(5,'Carol','Goodfrey','3546372','cg@goodyear.co.uk','2021-09-08 16:28:55');
/*!40000 ALTER TABLE `passengers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planes`
--

DROP TABLE IF EXISTS `planes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `make` varchar(45) NOT NULL,
  `model` varchar(45) NOT NULL,
  `capacity` int NOT NULL,
  `time_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planes`
--

LOCK TABLES `planes` WRITE;
/*!40000 ALTER TABLE `planes` DISABLE KEYS */;
INSERT INTO `planes` VALUES (1,'Boeing','777',600,'2021-09-08 16:32:34'),(2,'Boeing','747',400,'2021-09-08 16:30:59'),(3,'Airbus','740',600,'2021-09-08 16:30:59'),(4,'Lockhead','Tailstar',24,'2021-09-08 16:30:59');
/*!40000 ALTER TABLE `planes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tickets`
--

DROP TABLE IF EXISTS `tickets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tickets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `passenger_id` int NOT NULL,
  `flight_id` int NOT NULL,
  `time_created` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_passenger_id_idx` (`passenger_id`),
  KEY `fk_tx_flight_id_idx` (`flight_id`),
  CONSTRAINT `fk_passenger_id` FOREIGN KEY (`passenger_id`) REFERENCES `passengers` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_tx_flight_id` FOREIGN KEY (`flight_id`) REFERENCES `flights` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tickets`
--

LOCK TABLES `tickets` WRITE;
/*!40000 ALTER TABLE `tickets` DISABLE KEYS */;
INSERT INTO `tickets` VALUES (1,1,1,'2021-09-08 16:40:13'),(2,2,2,'2021-09-08 16:40:13'),(3,3,3,'2021-09-08 16:40:13'),(4,4,4,'2021-09-08 16:40:13'),(5,1,5,'2021-09-08 16:40:13'),(6,1,6,'2021-09-08 16:40:13'),(7,2,7,'2021-09-08 16:40:13'),(8,3,7,'2021-09-08 16:40:13'),(9,4,8,'2021-09-08 16:40:13'),(10,1,8,'2021-09-08 16:40:13'),(11,1,8,'2021-09-08 16:40:13'),(12,4,9,'2021-09-08 16:40:13'),(13,2,10,'2021-09-08 16:40:13'),(14,3,11,'2021-09-08 16:40:13'),(15,1,12,'2021-09-08 16:40:13'),(16,3,13,'2021-09-08 16:40:13'),(17,3,14,'2021-09-08 16:40:13');
/*!40000 ALTER TABLE `tickets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-08 16:41:44
