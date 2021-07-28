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
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nome_usuario` varchar(255) DEFAULT NULL,
  `sobrenome_usuario` varchar(255) DEFAULT NULL,
  `cnh` varchar(255) DEFAULT NULL,
  `email_usuario` varchar(255) DEFAULT NULL,
  `senha_usuario` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Matheus','Feitosa','368954521','user@user.com','<123456');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estacionamento`
--

DROP TABLE IF EXISTS `estacionamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estacionamento` (
  `id_estacionamento` int NOT NULL AUTO_INCREMENT,
  `nome_estacionamento` varchar(255) DEFAULT NULL,
  `descricao` text DEFAULT NULL,
  `foto` tinyblob,
  `cep` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `bairro` varchar(255) DEFAULT NULL,
  `logradouro` varchar(200) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL,
  `latitude` varchar(255) DEFAULT NULL,
  `longitude` varchar(255) DEFAULT NULL,

  `numero_vagas` int DEFAULT NULL,
  `dias_funcionamento` varchar(300) DEFAULT NULL,
  `valor_hora` double DEFAULT NULL,
  `valor_adicional` double DEFAULT NULL,
  `valor_diaria` double DEFAULT NULL,
  `hr_abertura` varchar(255) DEFAULT NULL,
  `hr_fechamento` varchar(255) DEFAULT NULL,
  `frame` varchar(255) DEFAULT NULL,

  `email_estacionamento` varchar(255) DEFAULT NULL,
  `senha_estacionamento` varchar(255) DEFAULT NULL,

  `fk_id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_estacionamento`),
  KEY `FKm5jd72csn4ogrqe6r2j513uok` (`fk_id_usuario`),
  CONSTRAINT `FKm5jd72csn4ogrqe6r2j513uok` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuario` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estacionamento`
--

LOCK TABLES `estacionamento` WRITE;
/*!40000 ALTER TABLE `estacionamento` DISABLE KEYS */;
INSERT INTO `estacionamento` VALUES (1,'74.780.825','Centro','Estacionamento Rotativo',NULL,'nossoestacionamento@gmail.com','GO',NULL,'<{frame: }>,','05:00','23:00','Imagem','-16.586043139144625','-49.33854118694673','Rua L-785, N8','Nosso Estacionamento',200,'208','123456',4.5,45.5,13.8,1);
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
INSERT INTO `flyway_schema_history` VALUES (1,'1','createTable','SQL','V1__createTable.sql',1175740064,'root','2021-07-22 21:13:12',898,1),(2,'1.0.1','inserts','SQL','V1.0.1__inserts.sql',2038927706,'root','2021-07-22 21:22:20',100,0);
/*!40000 ALTER TABLE `flyway_schema_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gerenciamento`
--

DROP TABLE IF EXISTS `gerenciamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gerenciamento` (
  `id_gerenciamento` int NOT NULL,
  `data_hora` varchar(100) NOT NULL,
  `valor_recebido` double NOT NULL,
  `hora_entrada` datetime(6) DEFAULT NULL,
  `hora_saida` datetime(6) DEFAULT NULL,
  `pk_id_estacionamento` int DEFAULT NULL,
  `pk_id_vaga` bigint DEFAULT NULL,
  `pk_id_veiculo` int DEFAULT NULL,
  PRIMARY KEY (`id_gerenciamento`),
  KEY `FKh02ng922f2v897l33ft9sdbq2` (`pk_id_estacionamento`),
  KEY `FK7gq27i8e3wkh46y4eecc5k6k6` (`pk_id_vaga`),
  KEY `FKgw8u6mjjik2er55y9n0bdsg1q` (`pk_id_veiculo`),
  CONSTRAINT `FK7gq27i8e3wkh46y4eecc5k6k6` FOREIGN KEY (`pk_id_vaga`) REFERENCES `vaga` (`id_vaga`),
  CONSTRAINT `FKgw8u6mjjik2er55y9n0bdsg1q` FOREIGN KEY (`pk_id_veiculo`) REFERENCES `veiculo` (`id_veiculo`),
  CONSTRAINT `FKh02ng922f2v897l33ft9sdbq2` FOREIGN KEY (`pk_id_estacionamento`) REFERENCES `estacionamento` (`id_estacionamento`)
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
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefone` (
  `id_telefone` int NOT NULL,
  `telefone` varchar(255) DEFAULT NULL,
  `fk_id_usuario` int,
  `fk_id_estacionamento` int,
  PRIMARY KEY (`id_telefone`),
  FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuario` (`id_usuario`),
  FOREIGN KEY (`fk_id_estacionamento`) REFERENCES `estacionamento` (`id_estacionamento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefone`
--

LOCK TABLES `telefone` WRITE;
/*!40000 ALTER TABLE `telefone` DISABLE KEYS */;
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
  CONSTRAINT `FK1oid9e3bbthqy0ju5sg6xjo9h` FOREIGN KEY (`pk_id_estacionamento`) REFERENCES `estacionamento` (`id_estacionamento`),
  CONSTRAINT `FKhwhhbxc8q77wielsk8xh74ktt` FOREIGN KEY (`pk_id_veiculo`) REFERENCES `veiculo` (`id_veiculo`)
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
  `id_veiculo` int NOT NULL AUTO_INCREMENT,
  `cor` varchar(255) DEFAULT NULL,
  `modelo` varchar(255) DEFAULT NULL,
  `placa` varchar(255) DEFAULT NULL,
  `fk_id_usuario` int DEFAULT NULL,
  PRIMARY KEY (`id_veiculo`),
  KEY `FK7078u4j9i4i3gk011ntcrbxqm` (`fk_id_usuario`),
  CONSTRAINT `FK7078u4j9i4i3gk011ntcrbxqm` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuario` (`id_usuario`)
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

-- Dump completed on 2021-07-22 18:42:22
