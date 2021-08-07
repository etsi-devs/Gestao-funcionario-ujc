-- MySQL dump 10.13  Distrib 8.0.19, for Linux (x86_64)
--
-- Host: localhost    Database: gest_func
-- ------------------------------------------------------
-- Server version	8.0.19-0ubuntu5

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('admin','ROLE_ADMIN'),('funcionario','ROLE_USER'),('gestor','ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autorizacao`
--

DROP TABLE IF EXISTS `autorizacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autorizacao` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `funcionario_id_fk` bigint NOT NULL,
  `req_ferias_id_fk` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKfas0om2628iqm4mife94a4kll` (`funcionario_id_fk`),
  KEY `FK9nw05yk921al3bn953g3ch15m` (`req_ferias_id_fk`),
  CONSTRAINT `FK9nw05yk921al3bn953g3ch15m` FOREIGN KEY (`req_ferias_id_fk`) REFERENCES `req_ferias` (`id`),
  CONSTRAINT `FKfas0om2628iqm4mife94a4kll` FOREIGN KEY (`funcionario_id_fk`) REFERENCES `funcionarios` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autorizacao`
--

LOCK TABLES `autorizacao` WRITE;
/*!40000 ALTER TABLE `autorizacao` DISABLE KEYS */;
/*!40000 ALTER TABLE `autorizacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargos`
--

DROP TABLE IF EXISTS `cargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `departamento_id_fk` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gseglqgqp16hn9j3pqn06m8oy` (`nome`),
  KEY `FKry6xe8501fb5k82oudo6ep07t` (`departamento_id_fk`),
  CONSTRAINT `FKry6xe8501fb5k82oudo6ep07t` FOREIGN KEY (`departamento_id_fk`) REFERENCES `departamentos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargos`
--

LOCK TABLES `cargos` WRITE;
/*!40000 ALTER TABLE `cargos` DISABLE KEYS */;
INSERT INTO `cargos` VALUES (1,'Desenvolvedor Senior',3),(2,'Gestor Chefe',2),(3,'Developer Junior',3);
/*!40000 ALTER TABLE `cargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamentos`
--

DROP TABLE IF EXISTS `departamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamentos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `faculdade_id_fk` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_gmqvdqbwy3c9wja72wnfd01kc` (`nome`),
  KEY `FK3bf8q1vf5k421y3nqv3hp70cr` (`faculdade_id_fk`),
  CONSTRAINT `FK3bf8q1vf5k421y3nqv3hp70cr` FOREIGN KEY (`faculdade_id_fk`) REFERENCES `faculdade` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamentos`
--

LOCK TABLES `departamentos` WRITE;
/*!40000 ALTER TABLE `departamentos` DISABLE KEYS */;
INSERT INTO `departamentos` VALUES (1,'Acao Social',1),(2,'Recursos Humanos',2),(3,'Desenvolvimento',1);
/*!40000 ALTER TABLE `departamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enderecos`
--

DROP TABLE IF EXISTS `enderecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `enderecos` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `bairro` varchar(255) NOT NULL,
  `cidade` varchar(255) NOT NULL,
  `distrito` varchar(255) NOT NULL,
  `numero_de_casa` int NOT NULL,
  `rua` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecos`
--

LOCK TABLES `enderecos` WRITE;
/*!40000 ALTER TABLE `enderecos` DISABLE KEYS */;
INSERT INTO `enderecos` VALUES (1,'West Cape 2','Soweto','Mpumalanga',145,'Wall Street'),(2,'West Cape 2','Maputo','Kamavota',225,'Wall Street'),(3,'Patrice','werty','Mpumalanga',225,'P'),(4,'Magoanine','Maputo','Kamavota',225,'Caia');
/*!40000 ALTER TABLE `enderecos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculdade`
--

DROP TABLE IF EXISTS `faculdade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `faculdade` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `descricao` varchar(60) NOT NULL,
  `localizacao` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_fslbsh3inm3nwnel8d2ru33jc` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculdade`
--

LOCK TABLES `faculdade` WRITE;
/*!40000 ALTER TABLE `faculdade` DISABLE KEYS */;
INSERT INTO `faculdade` VALUES (1,'Faculdade de Ciencia e Tecnologia','Maputo, zimpeto','FCT'),(2,'Instituto Superior de Administracao Publica','Maputo, zimpeto','ISAP'),(3,'Escola Superior de Relacoes Internacionais','Maputo, zimpeto','ESRID');
/*!40000 ALTER TABLE `faculdade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `funcionarios`
--

DROP TABLE IF EXISTS `funcionarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `funcionarios` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_entrada` date NOT NULL,
  `data_saida` date DEFAULT NULL,
  `data_nascimento` date NOT NULL,
  `nome` varchar(255) NOT NULL,
  `cargo_id_fk` bigint DEFAULT NULL,
  `departamento_id_fk` bigint DEFAULT NULL,
  `endereco_id_fk` bigint NOT NULL,
  `nivel_academico_id_fk` bigint NOT NULL,
  `tipo_id_fk` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKo4oltd663g3w8cd4iiw5ggina` (`cargo_id_fk`),
  KEY `FKilihyln75u0ghc74xrvbicwyc` (`departamento_id_fk`),
  KEY `FK3qpeu6e4lxnghbisl8hwqm0oe` (`endereco_id_fk`),
  KEY `FKbytsvpdp62odae8dd1k0aiwd` (`nivel_academico_id_fk`),
  KEY `FKeym61lpl9ig10vmx0ll7l0ie7` (`tipo_id_fk`),
  CONSTRAINT `FK3qpeu6e4lxnghbisl8hwqm0oe` FOREIGN KEY (`endereco_id_fk`) REFERENCES `enderecos` (`id`),
  CONSTRAINT `FKbytsvpdp62odae8dd1k0aiwd` FOREIGN KEY (`nivel_academico_id_fk`) REFERENCES `nivel_academico` (`id`),
  CONSTRAINT `FKeym61lpl9ig10vmx0ll7l0ie7` FOREIGN KEY (`tipo_id_fk`) REFERENCES `tipo` (`id`),
  CONSTRAINT `FKilihyln75u0ghc74xrvbicwyc` FOREIGN KEY (`departamento_id_fk`) REFERENCES `departamentos` (`id`),
  CONSTRAINT `FKo4oltd663g3w8cd4iiw5ggina` FOREIGN KEY (`cargo_id_fk`) REFERENCES `cargos` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionarios`
--

LOCK TABLES `funcionarios` WRITE;
/*!40000 ALTER TABLE `funcionarios` DISABLE KEYS */;
INSERT INTO `funcionarios` VALUES (1,'2021-08-14',NULL,'2021-08-01','Helder Josue ',1,3,1,1,1),(2,'2021-08-01',NULL,'2021-08-11','Denilson Mac',2,2,2,1,2),(3,'2021-08-20',NULL,'2021-08-13','Aike Ruco',2,1,3,2,2),(4,'2021-08-18',NULL,'2021-08-11','Bomber Buddah Spain',2,3,4,3,2);
/*!40000 ALTER TABLE `funcionarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nivel_academico`
--

DROP TABLE IF EXISTS `nivel_academico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nivel_academico` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_snxsecd57gw6g1kiiapb0f0sa` (`nome`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nivel_academico`
--

LOCK TABLES `nivel_academico` WRITE;
/*!40000 ALTER TABLE `nivel_academico` DISABLE KEYS */;
INSERT INTO `nivel_academico` VALUES (3,'Doutoramento'),(1,'Licenciatura'),(2,'Mestrado');
/*!40000 ALTER TABLE `nivel_academico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pre_req`
--

DROP TABLE IF EXISTS `pre_req`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pre_req` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_fim` date NOT NULL,
  `data_inicio` date NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `funcionario_id_fk` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKprkix6c7pfbnw6e3ac1yywm0s` (`funcionario_id_fk`),
  CONSTRAINT `FKprkix6c7pfbnw6e3ac1yywm0s` FOREIGN KEY (`funcionario_id_fk`) REFERENCES `funcionarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pre_req`
--

LOCK TABLES `pre_req` WRITE;
/*!40000 ALTER TABLE `pre_req` DISABLE KEYS */;
INSERT INTO `pre_req` VALUES (1,'2020-12-20','2020-12-31','Pendente',1),(2,'2020-12-20','2020-12-31','Pendente',2),(3,'2020-12-20','2020-12-31','Pendente',3),(4,'2020-12-20','2020-12-31','Pendente',4);
/*!40000 ALTER TABLE `pre_req` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `req_ferias`
--

DROP TABLE IF EXISTS `req_ferias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `req_ferias` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `data_fim` date NOT NULL,
  `data_inicio` date NOT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `funcionario_id_fk` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3pbwvx7qsevablogh5p444dqm` (`funcionario_id_fk`),
  CONSTRAINT `FK3pbwvx7qsevablogh5p444dqm` FOREIGN KEY (`funcionario_id_fk`) REFERENCES `funcionarios` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `req_ferias`
--

LOCK TABLES `req_ferias` WRITE;
/*!40000 ALTER TABLE `req_ferias` DISABLE KEYS */;
INSERT INTO `req_ferias` VALUES (4,'2020-12-20','2020-12-31','Aprovado',2),(5,'2020-12-20','2020-12-31','Aprovado',1);
/*!40000 ALTER TABLE `req_ferias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefone`
--

DROP TABLE IF EXISTS `telefone`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefone` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `numero` int NOT NULL,
  `funcionario_id_fk` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_bpqxm7divmbgtv17ykdtte47o` (`numero`),
  KEY `FKm23iv9w035f6gynobh9frof3a` (`funcionario_id_fk`),
  CONSTRAINT `FKm23iv9w035f6gynobh9frof3a` FOREIGN KEY (`funcionario_id_fk`) REFERENCES `funcionarios` (`id`)
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
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `designacao` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'Docente'),(2,'CTA');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin','admin',1),('funcionario','funcionario',1),('gestor','gestor',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-07 22:14:02
