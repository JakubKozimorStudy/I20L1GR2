-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: restauracja
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `dish`
--

DROP TABLE IF EXISTS `dish`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dish` (
  `dish_id` int NOT NULL AUTO_INCREMENT,
  `dish_name` varchar(255) CHARACTER SET utf16 COLLATE utf16_polish_ci NOT NULL,
  `descripion` varchar(255) CHARACTER SET utf16 COLLATE utf16_polish_ci NOT NULL,
  `dish_price` int NOT NULL,
  `category` varchar(255) COLLATE utf16_polish_ci DEFAULT NULL,
  PRIMARY KEY (`dish_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf16 COLLATE=utf16_polish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dish`
--

LOCK TABLES `dish` WRITE;
/*!40000 ALTER TABLE `dish` DISABLE KEYS */;
INSERT INTO `dish` VALUES (1,'Margherita','Sos pomidorowy łagodny, Ser mozzarella, Oregano',24,'Pizza'),(2,'Funghi','Sos pomidorowy łagodny, Ser mozzarella, Pieczarki, Oregano',25,'Pizza'),(3,'Wegetariana','Sos pomidorowy łagodny, Ser mozzarella, Pieczarki, Oregano, Papryka, Kukurydza',28,'Pizza'),(4,'Capricciosa','Sos pomidorowy łagodny, Ser mozzarella, Pieczarki, Oregano, Papryka, Szynka',27,'Pizza'),(5,'Calzone capri','sos pomidorowy, ser, szynka, pieczarki, cebula, tymianek',21,'Calzone'),(6,'Makaron spaghetti bolognese','Makaron spaghetti z tradycyjnym sosem bolońskim, wołowiną, soczystymi pomidorami, czosnkiem, warzywami, parmezanem.',19,'Makarony'),(7,'Makaron penne z kurczakiem cukinią i brokułami','Makaron penne w lekkim sosie śmietanowym z kawałkami kurczaka, cebuli, cukinii oraz brokuł, doprawiony estragonem i parmezanem.',21,'Makarony'),(8,'Burger classic','200g mięsa wołowego, sałata, rucola, pomidor, ogórek kiszony, czerwona cebula, sos BBQ, majonez',17,'Burgery'),(9,'Lasagna szpinakowa','Płaty włoskiego makaronu przekładane szpinakiem i sosem beszamelowym, zapiekane z mozarellą',17,'Lasagne');
/*!40000 ALTER TABLE `dish` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-05 22:46:04
