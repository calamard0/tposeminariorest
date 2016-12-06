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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aspirante`
--

LOCK TABLES `aspirante` WRITE;
/*!40000 ALTER TABLE `aspirante` DISABLE KEYS */;
INSERT INTO `aspirante` VALUES (1,'Scarlett','BETES','2010-01-01','F','DNI','44000000','Argentina','Sistema Salud',NULL,0,1),(2,'Honey','LAMBERTO','2010-01-02','F','DNI','44000359','Argentina','Sistema Salud',NULL,0,3),(3,'Hea','GAUDIOSO','2010-01-03','F','DNI','44000718','Argentina','Sistema Salud',NULL,0,5),(4,'Waverly','GONZALEZ DE ZARATE','2010-01-04','M','DNI','44001436','Argentina','Sistema Salud',NULL,0,7),(5,'Teodolinda','CABANILLES','2010-01-05','F','DNI','44002154','Argentina','Sistema Salud',NULL,0,9),(6,'Ridgley','PERALS','2010-01-06','M','DNI','44002513','Argentina','Sistema Salud',NULL,0,11),(7,'Arcana','CARR','2010-01-07','F','DNI','44003231','Argentina','Sistema Salud',NULL,0,13),(8,'Aftonio','QUIROGA','2010-01-08','M','DNI','44003590','Argentina','Sistema Salud',NULL,0,15),(9,'Amadis','BEATO','2010-01-09','M','DNI','44004308','Argentina','Sistema Salud',NULL,0,17),(10,'Prosdocia','ARRABE','2010-01-10','F','DNI','44004667','Argentina','Sistema Salud',NULL,0,19),(11,'Bradney','PLANELLS','2010-01-11','M','DNI','44005026','Argentina','Sistema Salud',NULL,0,21),(12,'Goar','HURTADO','2010-01-12','M','DNI','44005744','Argentina','Sistema Salud',NULL,0,23),(13,'Georgette','CIOCA','2010-01-13','F','DNI','44006103','Argentina','Sistema Salud',NULL,0,25),(14,'Anera','COFAN','2010-01-14','F','DNI','44006462','Argentina','Sistema Salud',NULL,0,27),(15,'Abbas','SESMERO','2010-01-15','M','DNI','44006821','Argentina','Sistema Salud',NULL,0,29),(16,'Ranger','JORNET','2010-01-16','M','DNI','44007180','Argentina','Sistema Salud',NULL,0,31),(17,'Alesandra','MICULAICIUC','2010-01-17','F','DNI','44007539','Argentina','Sistema Salud',NULL,0,33),(18,'Marjeta','ORLOVA','2010-01-18','F','DNI','44007898','Argentina','Sistema Salud',NULL,0,35),(19,'Magnerico','SAWYER','2010-01-19','M','DNI','44008257','Argentina','Sistema Salud',NULL,0,37),(20,'Papilo','MINGUILLAN','2010-01-20','M','DNI','44008616','Argentina','Sistema Salud',NULL,0,39),(21,'Ariel','LLACH','2010-01-21','M','DNI','44008975','Argentina','Sistema Salud',NULL,0,41),(22,'Annabella','BENAQUE','2010-01-22','F','DNI','44009693','Argentina','Sistema Salud',NULL,0,43),(23,'Onora','BARREÑA','2010-01-23','F','DNI','44010411','Argentina','Sistema Salud',NULL,0,45),(24,'Reva','CESTERO','2010-01-24','F','DNI','44011129','Argentina','Sistema Salud',NULL,0,47),(25,'Yoninah','VEGANZONES','2010-01-25','F','DNI','44011488','Argentina','Sistema Salud',NULL,0,49);
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
INSERT INTO `curso` VALUES (65,'Primer Grado',1,1,1),(66,'Primer Grado',1,1,2),(67,'Primer Grado',1,1,3),(68,'Primer Grado',1,1,4),(69,'Primer Grado',1,1,5),(70,'Primer Grado',1,1,6),(71,'Primer Grado',1,1,7),(72,'Primer Grado',1,1,8),(73,'Primer Grado',1,1,9),(74,'Primer Grado',1,1,10),(75,'Primer Grado',1,1,11),(76,'Primer Grado',1,1,12),(77,'Primer Grado',1,1,13),(78,'Primer Grado',1,1,14),(79,'Primer Grado',1,1,15),(80,'Primer Grado',1,1,16),(81,'Primer Grado',1,1,17),(82,'Primer Grado',1,1,18),(83,'Primer Grado',1,1,19),(84,'Primer Grado',1,1,20),(85,'Primer Grado',1,1,21),(86,'Primer Grado',1,1,22),(87,'Primer Grado',1,1,23),(88,'Primer Grado',1,1,24),(89,'Primer Grado',1,1,25);
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_extra`
--

LOCK TABLES `datos_extra` WRITE;
/*!40000 ALTER TABLE `datos_extra` DISABLE KEYS */;
INSERT INTO `datos_extra` VALUES (1,'CA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Jardin 2','SANTO TOME 1111'),(2,'CA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Jardin 3','MANZANARES 1111'),(3,'DH',11,'Crisol','GAUDIOSO','2010-07-29','44001077','DNI',NULL,NULL,NULL,NULL),(4,'DH',17,'Ernie','GONZALEZ DE ZARATE','2010-07-29','44001795','DNI',NULL,NULL,NULL,NULL),(5,'CA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Jardin 4','AV.GRAL PAZ 1111'),(6,'DH',25,'Brendan','PERALS','2010-07-29','44002872','DNI',NULL,NULL,NULL,NULL),(7,'DP',25,NULL,NULL,NULL,NULL,NULL,'18835','Docente',NULL,NULL),(8,'DH',12,'Abdiel','QUIROGA','2010-07-29','44003949','DNI',NULL,NULL,NULL,NULL),(9,'CA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Jardin 5','AV. ELCANO 1111'),(10,'CA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Jardin 6','SAN PEDRO 1111'),(11,'DH',4,'Atila','PLANELLS','2010-07-29','44005385','DNI',NULL,NULL,NULL,NULL),(12,'DP',10,NULL,NULL,NULL,NULL,NULL,'21670','Docente',NULL,NULL),(13,'CA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Jardin 7','AV. SAN JUAN 1111'),(14,'DP',24,NULL,NULL,NULL,NULL,NULL,'22804','Docente',NULL,NULL),(15,'DP',6,NULL,NULL,NULL,NULL,NULL,'23371','Docente',NULL,NULL),(16,'DP',15,NULL,NULL,NULL,NULL,NULL,'23938','Persona',NULL,NULL),(17,'DP',15,NULL,NULL,NULL,NULL,NULL,'24505','Docente',NULL,NULL),(18,'DP',3,NULL,NULL,NULL,NULL,NULL,'25072','Docente',NULL,NULL),(19,'CA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Jardin 8','JOAQUIN V. GONZALEZ 1111'),(20,'DP',14,NULL,NULL,NULL,NULL,NULL,'26206','Persona',NULL,NULL),(21,'DH',12,'Polienetes','LLACH','2010-07-29','44009334','DNI',NULL,NULL,NULL,NULL),(22,'DH',3,'Olaf','BENAQUE','2010-07-29','44010052','DNI',NULL,NULL,NULL,NULL),(23,'DH',15,'Escubiculo','BARREÑA','2010-07-29','44010770','DNI',NULL,NULL,NULL,NULL),(24,'CA',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Jardin 9','LEOPARDI 1111'),(25,'DP',15,NULL,NULL,NULL,NULL,NULL,'29041','Persona',NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datos_laborales`
--

LOCK TABLES `datos_laborales` WRITE;
/*!40000 ALTER TABLE `datos_laborales` DISABLE KEYS */;
INSERT INTO `datos_laborales` VALUES (1,'Juez/a',1,'45456677','SinRef',2),(2,'Lector/a',1,'45456941','SinRef',4),(3,'Policía',1,'45457205','SinRef',6),(4,'Pintor/a',1,'45457469','SinRef',8),(5,'Carnicero/a',1,'45457733','SinRef',10),(6,'Bibliotecario/a',1,'45457997','SinRef',12),(7,'Gasfitero',1,'45458261','SinRef',14),(8,'Estilista',1,'45458525','SinRef',16),(9,'Contador/a',1,'45458789','SinRef',18),(10,'Autor/a',1,'45459053','SinRef',20),(11,'Corredor de propiedades',1,'45459317','SinRef',22),(12,'Florista',1,'45459581','SinRef',24),(13,'Gásfiter',1,'45459845','SinRef',26),(14,'Dentista',1,'45460109','SinRef',28),(15,'Científico/a',1,'45460373','SinRef',30),(16,'Fotógrafo/a',1,'45460637','SinRef',32),(17,'Contador/a',1,'45460901','SinRef',34),(18,'Secretario/a',1,'45461165','SinRef',36),(19,'Bombero/a',1,'45461429','SinRef',38),(20,'Mecánico/a',1,'45461693','SinRef',40),(21,'Abogado/a',1,'45461957','SinRef',42),(22,'Científico/a',1,'45462221','SinRef',44),(23,'Pintor/a',1,'45462485','SinRef',46),(24,'Secretario/a',1,'45462749','SinRef',48),(25,'Panadero/a',1,'45463013','SinRef',50);
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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domicilio`
--

LOCK TABLES `domicilio` WRITE;
/*!40000 ALTER TABLE `domicilio` DISABLE KEYS */;
INSERT INTO `domicilio` VALUES (1,'CABA','MCAL.ANTONIO JOSE DE SUCRE',2923,'',4,'A','2923','Depto'),(2,'CABA','AV.FRANKLIN D. ROOSEVELT',241,'',9,'B','241','Depto'),(3,'CABA','CAMPILLO',3155,'',4,'C','3155','Depto'),(4,'CABA','O\'HIGGINS',1018,'',1,'B','1018','Depto'),(5,'CABA','LAVALLE',129,'',2,'A','129','Depto'),(6,'CABA','PILAR',4236,'',3,'D','4236','Depto'),(7,'CABA','MEMBRILLAR',2343,'',9,'D','2343','Depto'),(8,'CABA','FRAY CAYETANO RODRIGUEZ',1653,'',3,'C','1653','Depto'),(9,'CABA','AV.ASAMBLEA',2646,'',0,'','2646','Casa'),(10,'CABA','EMILIO LAMARCA',3465,'',3,'B','3465','Depto'),(11,'CABA','NAZCA',3013,'',2,'C','3013','Depto'),(12,'CABA','AV.GRAL PAZ',4007,'',9,'D','4007','Depto'),(13,'CABA','DE LA PIEDAD',2919,'',3,'A','2919','Depto'),(14,'CABA','AV. PARQUE ROBERTO GOYENECHE',4152,'',8,'B','4152','Depto'),(15,'CABA','AV. DR.T. ACHAVAL RODRIGUEZ',2706,'',3,'B','2706','Depto'),(16,'CABA','BRASIL',1341,'',1,'C','1341','Depto'),(17,'CABA','TAPALQUE',1873,'',7,'C','1873','Depto'),(18,'CABA','PRIMERA JUNTA',2436,'',4,'C','2436','Depto'),(19,'CABA','AV.CONGRESO',4196,'',6,'C','4196','Depto'),(20,'CABA','PEDRO CALDERON DE LA BARCA',611,'',3,'A','611','Depto'),(21,'CABA','TACUARI',543,'',0,'','543','Casa'),(22,'CABA','AV. PARQUE ROBERTO GOYENECHE',3229,'',2,'D','3229','Depto'),(23,'CABA','TIMOTEO GORDILLO',1064,'',5,'B','1064','Depto'),(24,'CABA','MARIANO ACOSTA',3018,'',6,'A','3018','Depto'),(25,'CABA','AV.GRAL PAZ',1276,'',2,'D','1276','Depto'),(26,'CABA','NEUQUEN',2835,'',2,'C','2835','Depto'),(27,'CABA','SALCEDO',456,'',6,'A','456','Depto'),(28,'CABA','HEREDIA',2192,'',5,'C','2192','Depto'),(29,'CABA','AV.CNEL. ROCA',2129,'',3,'A','2129','Depto'),(30,'CABA','FERRE',2665,'',0,'','2665','Casa'),(31,'CABA','SANABRIA',1740,'',8,'A','1740','Depto'),(32,'CABA','AV. DEL CAMPO',1500,'',3,'B','1500','Depto'),(33,'CABA','GURRUCHAGA',3473,'',0,'','3473','Casa'),(34,'CABA','MEXICO',3606,'',0,'','3606','Casa'),(35,'CABA','GONCALVES DIAS',2357,'',8,'C','2357','Depto'),(36,'CABA','QUESADA',2799,'',5,'C','2799','Depto'),(37,'CABA','PUAN',1011,'',2,'A','1011','Depto'),(38,'CABA','PASAJE 24 BO. RIVADAVIA',920,'',8,'A','920','Depto'),(39,'CABA','JOSE E. RODO',1801,'',5,'D','1801','Depto'),(40,'CABA','AV. ELCANO',497,'',9,'B','497','Depto'),(41,'CABA','TTE.GENERAL JUAN DOMINGO PERON',1936,'',2,'A','1936','Depto'),(42,'CABA','AV. SANTA FE',2223,'',6,'A','2223','Depto'),(43,'CABA','JOSE MARMOL',2760,'',1,'B','2760','Depto'),(44,'CABA','GRAL.ENRIQUE MARTINEZ',4113,'',4,'B','4113','Depto'),(45,'CABA','FRAGA',824,'',9,'B','824','Depto'),(46,'CABA','SENDERO BOLIVIA',3225,'',4,'A','3225','Depto'),(47,'CABA','LA PAMPA',2228,'',1,'C','2228','Depto'),(48,'CABA','QUINTINO BOCAYUVA',4307,'',3,'B','4307','Depto'),(49,'CABA','CORONEL MARTINIANO CHILAVERT',3963,'',5,'C','3963','Depto'),(50,'CABA','PAYSANDU',1756,'',8,'D','1756','Depto');
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preinscripcion`
--

LOCK TABLES `preinscripcion` WRITE;
/*!40000 ALTER TABLE `preinscripcion` DISABLE KEYS */;
INSERT INTO `preinscripcion` VALUES (1,1,1,1,NULL,'INI',1),(2,2,2,2,NULL,'INI',1),(3,3,3,3,NULL,'INI',1),(4,4,4,4,NULL,'INI',1),(5,5,5,5,NULL,'INI',1),(6,6,6,6,NULL,'INI',1),(7,7,7,7,NULL,'INI',1),(8,8,8,8,NULL,'INI',1),(9,9,9,9,NULL,'INI',1),(10,10,10,10,NULL,'INI',1),(11,11,11,11,NULL,'INI',1),(12,12,12,12,NULL,'INI',1),(13,13,13,13,NULL,'INI',1),(14,14,14,14,NULL,'INI',1),(15,15,15,15,NULL,'INI',1),(16,16,16,16,NULL,'INI',1),(17,17,17,17,NULL,'INI',1),(18,18,18,18,NULL,'INI',1),(19,19,19,19,NULL,'INI',1),(20,20,20,20,NULL,'INI',1),(21,21,21,21,NULL,'INI',1),(22,22,22,22,NULL,'INI',1),(23,23,23,23,NULL,'INI',1),(24,24,24,24,NULL,'INI',1),(25,25,25,25,NULL,'INI',1);
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
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `responsable`
--

LOCK TABLES `responsable` WRITE;
/*!40000 ALTER TABLE `responsable` DISABLE KEYS */;
INSERT INTO `responsable` VALUES (1,'Sabrina','BETES','DNI','32000000','Argentina','BETES@mail.com','Madre','45456834','24954444',1,1),(2,'Poria','LAMBERTO','DNI','32000148','Argentina','LAMBERTO@mail.com','Madre','45457098','24954652',1,2),(3,'Oakes','GAUDIOSO','DNI','32000296','Argentina','GAUDIOSO@mail.com','Padre','45457362','24954860',1,3),(4,'Genna','GONZALEZ DE ZARATE','DNI','32000444','Argentina','GONZALEZ DE ZARATE@mail.com','Madre','45457626','24955068',1,4),(5,'Louise','CABANILLES','DNI','32000592','Argentina','CABANILLES@mail.com','Madre','45457890','24955276',1,5),(6,'Osvaldo','PERALS','DNI','32000740','Argentina','PERALS@mail.com','Padre','45458154','24955484',1,6),(7,'Amapola','CARR','DNI','32000888','Argentina','CARR@mail.com','Madre','45458418','24955692',1,7),(8,'Rosalia','QUIROGA','DNI','32001036','Argentina','QUIROGA@mail.com','Madre','45458682','24955900',1,8),(9,'Varuna','BEATO','DNI','32001184','Argentina','BEATO@mail.com','Padre','45458946','24956108',1,9),(10,'Tyee','ARRABE','DNI','32001332','Argentina','ARRABE@mail.com','Padre','45459210','24956316',1,10),(11,'Lael','PLANELLS','DNI','32001480','Argentina','PLANELLS@mail.com','Madre','45459474','24956524',1,11),(12,'Proserpina','HURTADO','DNI','32001628','Argentina','HURTADO@mail.com','Madre','45459738','24956732',1,12),(13,'Afton','CIOCA','DNI','32001776','Argentina','CIOCA@mail.com','Padre','45460002','24956940',1,13),(14,'Romana','COFAN','DNI','32001924','Argentina','COFAN@mail.com','Madre','45460266','24957148',1,14),(15,'Robustiano','SESMERO','DNI','32002072','Argentina','SESMERO@mail.com','Padre','45460530','24957356',1,15),(16,'Hospicio','JORNET','DNI','32002220','Argentina','JORNET@mail.com','Padre','45460794','24957564',1,16),(17,'Diamela','MICULAICIUC','DNI','32002368','Argentina','MICULAICIUC@mail.com','Madre','45461058','24957772',1,17),(18,'Chin','ORLOVA','DNI','32002516','Argentina','ORLOVA@mail.com','Padre','45461322','24957980',1,18),(19,'Rufil','SAWYER','DNI','32002664','Argentina','SAWYER@mail.com','Padre','45461586','24958188',1,19),(20,'Elvina','MINGUILLAN','DNI','32002812','Argentina','MINGUILLAN@mail.com','Madre','45461850','24958396',1,20),(21,'Franka','LLACH','DNI','32002960','Argentina','LLACH@mail.com','Madre','45462114','24958604',1,21),(22,'Clodulfo','BENAQUE','DNI','32003108','Argentina','BENAQUE@mail.com','Padre','45462378','24958812',1,22),(23,'Eucario','BARREÑA','DNI','32003256','Argentina','BARREÑA@mail.com','Padre','45462642','24959020',1,23),(24,'Maria Angel','CESTERO','DNI','32003404','Argentina','CESTERO@mail.com','Madre','45462906','24959228',1,24),(25,'Alena','VEGANZONES','DNI','32003552','Argentina','VEGANZONES@mail.com','Madre','45463170','24959436',1,25);
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
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacante`
--

LOCK TABLES `vacante` WRITE;
/*!40000 ALTER TABLE `vacante` DISABLE KEYS */;
INSERT INTO `vacante` VALUES (1,3,0,3,1,69),(2,4,0,4,1,66),(3,7,0,7,1,68),(4,6,0,6,1,89),(5,5,0,5,1,65),(6,1,0,1,1,77),(7,8,0,8,1,70),(8,2,0,2,1,72),(9,6,0,6,2,66),(10,8,0,8,2,77),(11,7,0,7,2,89),(12,2,0,2,2,70),(13,1,0,1,2,73),(14,5,0,5,2,82),(15,4,0,4,2,68),(16,3,0,3,2,72),(17,7,0,7,3,71),(18,4,0,4,3,80),(19,2,0,2,3,69),(20,8,0,8,3,75),(21,3,0,3,3,84),(22,1,0,1,3,89),(23,5,0,5,3,67),(24,6,0,6,3,74),(25,6,0,6,4,88),(26,5,0,5,4,70),(27,8,0,8,4,81),(28,4,0,4,4,86),(29,3,0,3,4,68),(30,7,0,7,4,65),(31,2,0,2,4,69),(32,1,0,1,4,89),(33,6,0,6,5,80),(34,2,0,2,5,77),(35,8,0,8,5,88),(36,4,0,4,5,78),(37,5,0,5,5,74),(38,1,0,1,5,71),(39,7,0,7,5,67),(40,3,0,3,5,69),(41,3,0,3,6,87),(42,8,0,8,6,89),(43,4,0,4,6,69),(44,7,0,7,6,68),(45,2,0,2,6,84),(46,1,0,1,6,81),(47,6,0,6,6,70),(48,5,0,5,6,85),(49,7,0,7,7,86),(50,8,0,8,7,89),(51,4,0,4,7,80),(52,3,0,3,7,78),(53,2,0,2,7,79),(54,1,0,1,7,71),(55,6,0,6,7,67),(56,5,0,5,7,72),(57,7,0,7,8,85),(58,8,0,8,8,76),(59,2,0,2,8,67),(60,1,0,1,8,79),(61,4,0,4,8,69),(62,3,0,3,8,68),(63,6,0,6,8,65),(64,5,0,5,8,73),(65,3,0,3,9,72),(66,2,0,2,9,80),(67,6,0,6,9,74),(68,1,0,1,9,89),(69,8,0,8,9,71),(70,7,0,7,9,68),(71,4,0,4,9,78),(72,5,0,5,9,76),(73,6,0,6,10,78),(74,2,0,2,10,67),(75,7,0,7,10,66),(76,8,0,8,10,76),(77,3,0,3,10,88),(78,1,0,1,10,69),(79,5,0,5,10,71),(80,4,0,4,10,87),(81,5,0,5,11,83),(82,6,0,6,11,72),(83,4,0,4,11,87),(84,8,0,8,11,68),(85,1,0,1,11,77),(86,7,0,7,11,86),(87,3,0,3,11,89),(88,2,0,2,11,66),(89,8,0,8,12,74),(90,6,0,6,12,81),(91,2,0,2,12,79),(92,3,0,3,12,80),(93,7,0,7,12,86),(94,4,0,4,12,76),(95,1,0,1,12,78),(96,5,0,5,12,72),(97,2,0,2,13,83),(98,3,0,3,13,67),(99,8,0,8,13,82),(100,5,0,5,13,70),(101,1,0,1,13,79),(102,7,0,7,13,84),(103,6,0,6,13,86),(104,4,0,4,13,71),(105,8,0,8,14,88),(106,3,0,3,14,66),(107,2,0,2,14,76),(108,5,0,5,14,72),(109,4,0,4,14,67),(110,6,0,6,14,87),(111,7,0,7,14,85),(112,1,0,1,14,75),(113,4,0,4,15,77),(114,3,0,3,15,84),(115,5,0,5,15,87),(116,7,0,7,15,71),(117,2,0,2,15,76),(118,1,0,1,15,78),(119,8,0,8,15,70),(120,6,0,6,15,65),(121,2,0,2,16,71),(122,1,0,1,16,72),(123,4,0,4,16,77),(124,8,0,8,16,79),(125,6,0,6,16,88),(126,5,0,5,16,87),(127,7,0,7,16,75),(128,3,0,3,16,76),(129,4,0,4,17,80),(130,1,0,1,17,82),(131,7,0,7,17,76),(132,5,0,5,17,67),(133,2,0,2,17,69),(134,3,0,3,17,86),(135,6,0,6,17,70),(136,8,0,8,17,79),(137,5,0,5,18,86),(138,8,0,8,18,67),(139,1,0,1,18,76),(140,2,0,2,18,87),(141,6,0,6,18,85),(142,3,0,3,18,78),(143,7,0,7,18,81),(144,4,0,4,18,74),(145,4,0,4,19,83),(146,5,0,5,19,77),(147,3,0,3,19,71),(148,2,0,2,19,85),(149,7,0,7,19,69),(150,8,0,8,19,78),(151,6,0,6,19,72),(152,1,0,1,19,88),(153,4,0,4,20,88),(154,6,0,6,20,72),(155,2,0,2,20,68),(156,8,0,8,20,78),(157,7,0,7,20,84),(158,3,0,3,20,73),(159,1,0,1,20,74),(160,5,0,5,20,85),(161,6,0,6,21,85),(162,1,0,1,21,74),(163,7,0,7,21,75),(164,5,0,5,21,65),(165,8,0,8,21,76),(166,3,0,3,21,68),(167,4,0,4,21,77),(168,2,0,2,21,72),(169,5,0,5,22,79),(170,1,0,1,22,65),(171,3,0,3,22,68),(172,4,0,4,22,88),(173,7,0,7,22,85),(174,6,0,6,22,84),(175,8,0,8,22,67),(176,2,0,2,22,86),(177,8,0,8,23,79),(178,2,0,2,23,75),(179,3,0,3,23,86),(180,5,0,5,23,67),(181,7,0,7,23,82),(182,4,0,4,23,89),(183,1,0,1,23,80),(184,6,0,6,23,77),(185,6,0,6,24,84),(186,7,0,7,24,68),(187,5,0,5,24,87),(188,1,0,1,24,83),(189,8,0,8,24,74),(190,3,0,3,24,78),(191,4,0,4,24,81),(192,2,0,2,24,65),(193,2,0,2,25,74),(194,5,0,5,25,85),(195,8,0,8,25,79),(196,1,0,1,25,84),(197,6,0,6,25,77),(198,3,0,3,25,78),(199,7,0,7,25,68),(200,4,0,4,25,67);
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

-- Dump completed on 2016-12-06 15:51:32
