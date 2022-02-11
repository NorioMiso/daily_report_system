-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: message_board
-- ------------------------------------------------------
-- Server version	8.0.26

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `id` int NOT NULL AUTO_INCREMENT,
  `content` varchar(255) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `title` varchar(255) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
INSERT INTO `messages` VALUES (3,'メッセージです','2021-12-29 22:27:13.727000','タイトルです','2021-12-29 22:27:13.727000'),(4,'耳が立っています','2021-12-29 22:27:36.011000','猫ちゃんは・・・','2021-12-29 22:27:36.011000'),(5,'ラーメンを食べました。二郎系のラーメンでした。','2021-12-29 22:28:21.326000','今日は・・・','2021-12-30 09:53:59.726000'),(7,'げんき？','2021-12-30 11:25:17.262000','やっほー','2021-12-30 11:25:17.262000'),(8,'げんき？','2021-12-30 11:25:33.462000','ぐっもー','2021-12-30 11:25:33.462000'),(9,'12月30日です','2021-12-30 11:25:51.356000','きょうは・・・','2021-12-30 11:29:33.273000'),(10,'猫ちゃんがいます','2021-12-30 11:26:03.744000','膝には・・・','2021-12-30 11:26:03.744000'),(11,'さむいね','2021-12-30 11:26:13.504000','やっほー','2021-12-30 11:26:13.504000'),(12,'しょうごとラインしました','2021-12-30 11:26:26.577000','昨日は・・・','2021-12-30 11:26:26.577000'),(13,'キャットタワーから外を見ています','2021-12-30 11:26:45.613000','のりおは・・・','2021-12-30 11:26:45.613000'),(14,'もう書くことがないね','2021-12-30 11:27:02.316000','うーん・・・','2021-12-30 11:27:02.316000'),(15,'勉強頑張ってます','2021-12-30 11:27:16.236000','テックアカデミー','2021-12-30 11:27:16.236000'),(16,'今日含めてあと２日だけ','2021-12-30 11:27:30.104000','今年も・・・','2021-12-30 11:27:30.104000'),(17,'夕方吉祥寺にいきます','2021-12-30 11:27:44.355000','今日は・・・','2021-12-30 11:27:44.355000'),(18,'髪を切ります','2021-12-30 11:27:55.101000','来年・・・','2021-12-30 11:27:55.101000'),(19,'どうしよう','2021-12-30 11:28:06.898000','結婚式の髪型','2021-12-30 11:28:06.898000'),(20,'ケガしています','2021-12-30 11:28:25.530000','みそちゃんの背中','2021-12-30 11:28:25.530000'),(21,'おいしい','2021-12-30 11:28:36.412000','コーヒー','2021-12-30 11:28:36.412000'),(22,'欲しかった豆を買えました','2021-12-30 11:29:02.634000','ポストコーヒー','2021-12-30 11:29:02.634000'),(23,'aa','2021-12-30 12:10:38.469000','aa','2021-12-30 12:10:55.430000');
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-11  9:28:47
