-- MySQL dump 10.13  Distrib 5.7.16, for Win64 (x86_64)
--
-- Host: localhost    Database: inscripciones
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

CREATE DATABASE IF NOT EXISTS inscripciones;
use inscripciones;

--
-- Table structure for table `aspirante`
--

DROP TABLE IF EXISTS `aspirante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `aspirante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `sexo` varchar(8) DEFAULT NULL,
  `tipo_documento` varchar(6) DEFAULT NULL,
  `numero_documento` varchar(20) DEFAULT NULL,
  `pais_nacimiento` varchar(100) DEFAULT NULL,
  `sistema_salud` varchar(100) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `certificado_disca` int(11) DEFAULT NULL,
  `domicilio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_aspirante_domicilio` (`domicilio_id`),
  CONSTRAINT `fk_aspirante_domicilio` FOREIGN KEY (`domicilio_id`) REFERENCES `domicilio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aspirante`
--

LOCK TABLES `aspirante` WRITE;
/*!40000 ALTER TABLE `aspirante` DISABLE KEYS */;
/*!40000 ALTER TABLE `aspirante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `colegio`
--

DROP TABLE IF EXISTS `colegio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `colegio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(200) NOT NULL,
  `direccion` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=446 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `colegio`
--

LOCK TABLES `colegio` WRITE;
/*!40000 ALTER TABLE `colegio` DISABLE KEYS */;
INSERT INTO `colegio` VALUES (1,'Esc. Primaria Nº 24 DE 14 Francisco Beiro','BOLIVIA 2569'),(2,'Esc. Primaria Nº 02 DE 14 Gral. Mariano Acha','ROSETI 1450'),(3,'Esc. Primaria Nº 21 DE 14 Alte. Segundo R. Storni','MARTINEZ ROSAS 1364'),(4,'Esc. Primaria Nº 01 DE 14 Rubén Darío','OTERO 271'),(5,'Esc. Primaria Nº 14 DE 14 Dr. Luis Agote - Intensificada en Artes','JORGE NEWBERY 3664'),(6,'Esc. Primaria Nº 08 DE 14 Carmen Catren de Mendez Casariego','JORGE NEWBERY 4436'),(7,'Esc. Primaria Nº 23 DE 14 Alfredo Rodolfo Bufano','GRAL. MANUEL A. RODRIGUEZ 2332'),(8,'Esc. Primaria Nº 13 DE 14 Provincia del Neuquen','ALTE. F. J. SEGUI 2580'),(9,'Esc. Primaria Nº 01 DE 10 Casto Munita','CUBA 2039'),(10,'Esc. Primaria Nº 25 DE 14 Carmen Sonda de Pandolfini','AVDA. SAN MARTIN 5021'),(11,'Esc. Primaria Nº 22 DE 14 Agronomia - Intensificada en Educación Física','AVDA. DE LOS CONSTITUYENTES 3100'),(12,'Esc. Primaria Nº 15 DE 14 Provincia de Mendoza','JUAN AGUSTIN GARCIA 1511'),(13,'Esc. Primaria Nº 21 DE 10 Cnel. Cornelio Saavedra - Plurilingüe','PINTO 3910'),(14,'Esc. Primaria Nº 07 DE 10 Manuel J. García','AVDA. CABILDO 3615'),(15,'Esc. Primaria Nº 20 DE 10 Vicealmirante Vicente E. Montes','AVDA. CONGRESO 1553'),(16,'Esc. Primaria Nº 22 DE 10 Remedios de Escalada de San Martin','FRANKLIN D. ROOSEVELT 1510'),(17,'Esc. Primaria Nº 08 DE 10 Alte. Ramon Gonzalez Fernandez - Intensificada en Educación Física','MENDOZA 1000'),(18,'Esc. Primaria Nº 06 DE 10 Manuel Dorrego','BESARES 2990'),(19,'Esc. Primaria Nº 13 DE 10 Ricardo Monner Sans','AVDA. RUIZ HUIDOBRO 2643'),(20,'Esc. Primaria Nº 17 DE 10 Dr. Juan Balestra','ARCOS 2440'),(21,'Esc. Primaria Nº 15 DE 10 Provincia de Santa Fe','PICO 2689'),(22,'Esc. Primaria Nº 05 DE 10 Juan Bautista Alberdi','MOLDES 2043'),(23,'Esc. Primaria Nº 09 DE 10 Evaristo Julio Badia','O HIGGINS 3050'),(24,'Esc. Primaria Nº 26 DE 14 Delfina de Vedia de Mitre - Plurilingüe','CARACAS 2372'),(25,'Esc. Primaria Nº 10 DE 10 Joaquin Maria Cullen','11 DE SEPTIEMBRE DE 1888 3451');
/*!40000 ALTER TABLE `colegio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `curso` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(50) NOT NULL,
  `grado` int(11) NOT NULL,
  `vacantes_disponibles` int(11) DEFAULT NULL,
  `colegio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_curso_colegio` (`colegio_id`),
  CONSTRAINT `fk_curso_colegio` FOREIGN KEY (`colegio_id`) REFERENCES `colegio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=90 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
INSERT INTO `curso` VALUES (65,'Primer Grado',1,10,1),(66,'Primer Grado',1,10,2),(67,'Primer Grado',1,10,3),(68,'Primer Grado',1,10,4),(69,'Primer Grado',1,10,5),(70,'Primer Grado',1,10,6),(71,'Primer Grado',1,10,7),(72,'Primer Grado',1,10,8),(73,'Primer Grado',1,10,9),(74,'Primer Grado',1,10,10),(75,'Primer Grado',1,10,11),(76,'Primer Grado',1,10,12),(77,'Primer Grado',1,10,13),(78,'Primer Grado',1,10,14),(79,'Primer Grado',1,10,15),(80,'Primer Grado',1,10,16),(81,'Primer Grado',1,10,17),(82,'Primer Grado',1,10,18),(83,'Primer Grado',1,10,19),(84,'Primer Grado',1,10,20),(85,'Primer Grado',1,10,21),(86,'Primer Grado',1,10,22),(87,'Primer Grado',1,10,23),(88,'Primer Grado',1,10,24),(89,'Primer Grado',1,10,25);
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_extra`
--

DROP TABLE IF EXISTS `datos_extra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datos_extra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(2) NOT NULL,
  `colegio_id` int(11) DEFAULT NULL,
  `nombre` varchar(100) DEFAULT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `numero_documento` varchar(20) DEFAULT NULL,
  `tipo_documento` varchar(20) DEFAULT NULL,
  `ficha_municipal` varchar(100) DEFAULT NULL,
  `tipo_responsable` varchar(100) DEFAULT NULL,
  `nombre_jardin` varchar(100) DEFAULT NULL,
  `direccion_jardin` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_datosExtra_colegio` (`colegio_id`),
  CONSTRAINT `fk_datosExtra_colegio` FOREIGN KEY (`colegio_id`) REFERENCES `colegio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_extra`
--

LOCK TABLES `datos_extra` WRITE;
/*!40000 ALTER TABLE `datos_extra` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_extra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datos_laborales`
--

DROP TABLE IF EXISTS `datos_laborales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `datos_laborales` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `profesion` varchar(50) DEFAULT NULL,
  `sosten_familiar` int(11) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `datos_referencia` varchar(100) DEFAULT NULL,
  `domicilio_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_datos_laborales_domicilio` (`domicilio_id`),
  CONSTRAINT `fk_datos_laborales_domicilio` FOREIGN KEY (`domicilio_id`) REFERENCES `domicilio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_laborales`
--

LOCK TABLES `datos_laborales` WRITE;
/*!40000 ALTER TABLE `datos_laborales` DISABLE KEYS */;
/*!40000 ALTER TABLE `datos_laborales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domicilio`
--

DROP TABLE IF EXISTS `domicilio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domicilio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `provincia` varchar(100) NOT NULL,
  `calle` varchar(100) DEFAULT NULL,
  `numero` int(11) DEFAULT NULL,
  `villa` varchar(100) DEFAULT NULL,
  `piso` int(11) DEFAULT NULL,
  `departamento` varchar(2) DEFAULT NULL,
  `codigo_postal` varchar(20) DEFAULT NULL,
  `tipo` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
/*!40000 ALTER TABLE `domicilio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preinscripcion`
--

DROP TABLE IF EXISTS `preinscripcion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preinscripcion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aspirante_id` int(11) NOT NULL,
  `responsable_id` int(11) NOT NULL,
  `datos_extra_id` int(11) DEFAULT NULL,
  `curso_id` int(11) DEFAULT NULL,
  `estado` varchar(30) DEFAULT NULL,
  `validada` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_preinscripcion_aspirante` (`aspirante_id`),
  KEY `fk_preinscripcion_responsable` (`responsable_id`),
  KEY `fk_preinscripcion_datosExtra` (`datos_extra_id`),
  KEY `fk_preinscripcion_cursos` (`curso_id`),
  CONSTRAINT `fk_preinscripcion_aspirante` FOREIGN KEY (`aspirante_id`) REFERENCES `aspirante` (`id`),
  CONSTRAINT `fk_preinscripcion_cursos` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`),
  CONSTRAINT `fk_preinscripcion_datosExtra` FOREIGN KEY (`datos_extra_id`) REFERENCES `datos_extra` (`id`),
  CONSTRAINT `fk_preinscripcion_responsable` FOREIGN KEY (`responsable_id`) REFERENCES `responsable` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preinscripcion`
--

LOCK TABLES `preinscripcion` WRITE;
/*!40000 ALTER TABLE `preinscripcion` DISABLE KEYS */;
/*!40000 ALTER TABLE `preinscripcion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `problema_salud`
--

DROP TABLE IF EXISTS `problema_salud`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `problema_salud` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aspirante_id` int(11) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_problemasalud_aspirante` (`aspirante_id`),
  CONSTRAINT `fk_problemasalud_aspirante` FOREIGN KEY (`aspirante_id`) REFERENCES `aspirante` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `problema_salud`
--

LOCK TABLES `problema_salud` WRITE;
/*!40000 ALTER TABLE `problema_salud` DISABLE KEYS */;
/*!40000 ALTER TABLE `problema_salud` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `responsable`
--

DROP TABLE IF EXISTS `responsable`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `responsable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) DEFAULT NULL,
  `tipo_documento` varchar(6) DEFAULT NULL,
  `numero_documento` varchar(20) DEFAULT NULL,
  `pais_nacimiento` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `vinculo_aspirante` varchar(100) DEFAULT NULL,
  `telefono_particular` varchar(20) DEFAULT NULL,
  `telefono_alternativo` varchar(20) DEFAULT NULL,
  `trabaja` int(11) NOT NULL,
  `datos_laborales_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_responsable_datosLaborales` (`datos_laborales_id`),
  CONSTRAINT `fk_responsable_datosLaborales` FOREIGN KEY (`datos_laborales_id`) REFERENCES `datos_laborales` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsable`
--

LOCK TABLES `responsable` WRITE;
/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
/*!40000 ALTER TABLE `responsable` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_usuario` varchar(100) NOT NULL,
  `password` varchar(100) DEFAULT NULL,
  `rol` varchar(20) DEFAULT NULL,
  `colegio_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_usuario_colegio` (`colegio_id`),
  CONSTRAINT `fk_usuario_colegio` FOREIGN KEY (`colegio_id`) REFERENCES `colegio` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vacante`
--

DROP TABLE IF EXISTS `vacante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vacante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `peso` double DEFAULT NULL,
  `esta_aprobada` int(11) NOT NULL,
  `prioridad` int(11) NOT NULL,
  `preinscripcion_id` int(11) NOT NULL,
  `curso_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vacante_curso` (`curso_id`),
  KEY `fk_vacante_preinscripcion` (`preinscripcion_id`),
  CONSTRAINT `fk_vacante_curso` FOREIGN KEY (`curso_id`) REFERENCES `curso` (`id`),
  CONSTRAINT `fk_vacante_preinscripcion` FOREIGN KEY (`preinscripcion_id`) REFERENCES `preinscripcion` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacante`
--

LOCK TABLES `vacante` WRITE;
/*!40000 ALTER TABLE `vacante` DISABLE KEYS */;
/*!40000 ALTER TABLE `vacante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-06 12:03:48
