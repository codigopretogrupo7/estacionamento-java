CREATE DATABASE  IF NOT EXISTS `temvaga` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `temvaga`;
-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: localhost    Database: temvaga
-- ------------------------------------------------------
-- Server version	8.0.25

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



DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cnh` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `sennha` varchar(255) DEFAULT NULL,
  `sobre_nome` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'368954521','user@user.com','Matheus Feitosa','<123456','Feitosa'),(2,'368954521','user@user.com','Matheus Feitosa','<123456','Feitosa'),(3,'368954521','user@user.com','Matheus Feitosa','<123456','Feitosa'),(4,'368954521','user@Marcos.com','Marcos','1244121','Feitosa'),(5,'368954521','user@Marcos.com','Marcos','1244121','Feitosa');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacionamento`
--

DROP TABLE IF EXISTS `estacionamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estacionamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cep` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `descricao` varchar(255) DEFAULT NULL,
  `dias_funcionamento` tinyblob,
  `email_estacionamento` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `foto` tinyblob,
  `frame` varchar(255) DEFAULT NULL,
  `hr_abertura` varchar(255) DEFAULT NULL,
  `hr_fechamento` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `lat` varchar(255) DEFAULT NULL,
  `lng` varchar(255) DEFAULT NULL,
  `logadouro` varchar(255) DEFAULT NULL,
  `nome_estacionamento` varchar(255) DEFAULT NULL,
  `num_vagas` int DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `senha_estacionamento` varchar(255) DEFAULT NULL,
  `vl_adicional` double DEFAULT NULL,
  `vl_diaria` double DEFAULT NULL,
  `vl_hora` double DEFAULT NULL,
  `usuario_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKkfx0if9505c8s4gyextkn5uig` (`usuario_id`),
  CONSTRAINT `FKkfx0if9505c8s4gyextkn5uig` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacionamento`
--

LOCK TABLES `estacionamento` WRITE;
/*!40000 ALTER TABLE `estacionamento` DISABLE KEYS */;
INSERT INTO `estacionamento` VALUES (1,'74.780.825','Centro','Estacionamento Rotativo',NULL,'nossoestacionamento@gmail.com','GO',NULL,'<{frame: }>,','05:00','23:00','Imagem','-16.586043139144625','-49.33854118694673','Rua L-785, N8','Nosso Estacionamento',200,'208','123456',4.5,45.5,13.8,1),(2,'74.780.825','Centro','Estacionamento Rotativo',NULL,'nossoestacionamento@gmail.com','GO',NULL,'<{frame: }>,','05:00','23:00','Imagem','-16.586043139144625','-49.33854118694673','Rua L-785, N8','Nosso Estacionamento',200,'208','123456',4.5,45.5,13.8,NULL),(3,'74.780.825','Centro','Estacionamento Rotativo',NULL,'nossoestacionamento@gmail.com','GO',NULL,'<{frame: }>,','05:00','23:00','Imagem','-16.586043139144625','-49.33854118694673','Rua L-785, N8','Nosso Estacionamento',200,'208','123456',4.5,45.5,13.8,3),(4,'74.780.825','Centro','Estacionamento Rotativo',NULL,'nossoestacionamento@gmail.com','GO',NULL,'<{frame: }>,','05:00','23:00','Imagem','-16.586043139144625','-49.33854118694673','Rua L-785, N8','Nosso Estacionamento',200,'208','123456',4.5,45.5,13.8,5);
/*!40000 ALTER TABLE `estacionamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `flyway_schema_history`
--

DROP TABLE IF EXISTS `flyway_schema_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `flyway_schema_history` (
  `installed_rank` int NOT NULL,
  `version` varchar(50) DEFAULT NULL,
  `description` varchar(200) NOT NULL,
  `type` varchar(20) NOT NULL,
  `script` varchar(1000) NOT NULL,
  `checksum` int DEFAULT NULL,
  `installed_by` varchar(100) NOT NULL,
  `installed_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `execution_time` int NOT NULL,
  `success` tinyint(1) NOT NULL,
  PRIMARY KEY (`installed_rank`),
  KEY `flyway_schema_history_s_idx` (`success`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `flyway_schema_history`
--

LOCK TABLES `flyway_schema_history` WRITE;
/*!40000 ALTER TABLE `flyway_schema_history` DISABLE KEYS */;
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gerenciamento`
--

DROP TABLE IF EXISTS `gerenciamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gerenciamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `vl_recebido` double NOT NULL,
  `hr_entrada` datetime(6) DEFAULT NULL,
  `hr_saida` datetime(6) DEFAULT NULL,
  `pk_id_estacionamento` int DEFAULT NULL,
  `pk_id_vaga` bigint DEFAULT NULL,
  `pk_id_veiculo` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKh02ng922f2v897l33ft9sdbq2` (`pk_id_estacionamento`),
  KEY `FK7gq27i8e3wkh46y4eecc5k6k6` (`pk_id_vaga`),
  KEY `FKgw8u6mjjik2er55y9n0bdsg1q` (`pk_id_veiculo`),
  CONSTRAINT `FK7gq27i8e3wkh46y4eecc5k6k6` FOREIGN KEY (`pk_id_vaga`) REFERENCES `vaga` (`id`),
  CONSTRAINT `FKgw8u6mjjik2er55y9n0bdsg1q` FOREIGN KEY (`pk_id_veiculo`) REFERENCES `veiculo` (`id`),
  CONSTRAINT `FKh02ng922f2v897l33ft9sdbq2` FOREIGN KEY (`pk_id_estacionamento`) REFERENCES `estacionamento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gerenciamento`
--

LOCK TABLES `gerenciamento` WRITE;
/*!40000 ALTER TABLE `gerenciamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `gerenciamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefone` (
  `id` int NOT NULL AUTO_INCREMENT,
  `telefone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefone`
--

LOCK TABLES `telefone` WRITE;
/*!40000 ALTER TABLE `telefone` DISABLE KEYS */;
INSERT INTO `telefone` VALUES (2,'3205825'),(3,'3205825'),(4,'3205825'),(5,'3205825');
/*!40000 ALTER TABLE `telefone` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--



--
-- Table structure for table `vaga`
--

DROP TABLE IF EXISTS `vaga`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vaga` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dt_entrada` varchar(255) DEFAULT NULL,
  `situacao` int DEFAULT NULL,
  `pk_id_estacionamento` int DEFAULT NULL,
  `pk_id_veiculo` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1oid9e3bbthqy0ju5sg6xjo9h` (`pk_id_estacionamento`),
  KEY `FKhwhhbxc8q77wielsk8xh74ktt` (`pk_id_veiculo`),
  CONSTRAINT `FK1oid9e3bbthqy0ju5sg6xjo9h` FOREIGN KEY (`pk_id_estacionamento`) REFERENCES `estacionamento` (`id`),
  CONSTRAINT `FKhwhhbxc8q77wielsk8xh74ktt` FOREIGN KEY (`pk_id_veiculo`) REFERENCES `veiculo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vaga`
--

LOCK TABLES `vaga` WRITE;
/*!40000 ALTER TABLE `vaga` DISABLE KEYS */;
/*!40000 ALTER TABLE `vaga` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veiculo`
--

DROP TABLE IF EXISTS `veiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veiculo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cor` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `fk_id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK7078u4j9i4i3gk011ntcrbxqm` (`fk_id_usuario`),
  CONSTRAINT `FK7078u4j9i4i3gk011ntcrbxqm` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veiculo`
--

LOCK TABLES `veiculo` WRITE;
/*!40000 ALTER TABLE `veiculo` DISABLE KEYS */;
/*!40000 ALTER TABLE `veiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-29 18:15:44
