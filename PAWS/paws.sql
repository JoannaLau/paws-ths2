CREATE DATABASE  IF NOT EXISTS `paws` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `paws`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: paws
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.21-MariaDB

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

--
-- Table structure for table `accreditor-award`
--

DROP TABLE IF EXISTS `accreditor-award`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accreditor-award` (
  `accreditorID` int(11) NOT NULL,
  `awardID` int(11) NOT NULL,
  `dateNotif` date DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accreditor-award`
--

LOCK TABLES `accreditor-award` WRITE;
/*!40000 ALTER TABLE `accreditor-award` DISABLE KEYS */;
/*!40000 ALTER TABLE `accreditor-award` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accreditor-degree`
--

DROP TABLE IF EXISTS `accreditor-degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accreditor-degree` (
  `accreditorID` int(11) NOT NULL,
  `degreeName` varchar(30) DEFAULT NULL,
  `institutionID` int(11) DEFAULT NULL,
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `levelID` int(1) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accreditor-degree`
--

LOCK TABLES `accreditor-degree` WRITE;
/*!40000 ALTER TABLE `accreditor-degree` DISABLE KEYS */;
INSERT INTO `accreditor-degree` VALUES (1,'1',3,1,4),(1,'2',1,2,4),(1,'4',3,3,4),(2,'1',4,4,4),(2,'5',2,5,4),(3,'1',5,6,4),(4,'6',4,7,4),(5,'7',3,8,4),(5,'8',10,9,4),(5,'5',9,10,4),(6,'1',8,11,4),(6,'2',7,12,4),(7,'3',6,13,4),(8,'1',1,14,4),(8,'1',5,15,4),(8,'2',4,16,4),(9,'4',3,17,4),(1,'7',2,18,4),(40,'Compsci',2,19,4),(41,'cs',11,20,4),(0,NULL,NULL,21,4);
/*!40000 ALTER TABLE `accreditor-degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `accreditors`
--

DROP TABLE IF EXISTS `accreditors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `accreditors` (
  `accreditorID` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(45) DEFAULT NULL,
  `firstname` varchar(45) DEFAULT NULL,
  `middlename` varchar(45) DEFAULT NULL,
  `honorifics` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `numSurveys` int(11) DEFAULT NULL,
  `dateTrained` varchar(19) DEFAULT NULL,
  `contact` varchar(11) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `venueTrained` varchar(45) DEFAULT NULL,
  `primaryAreaID` int(11) DEFAULT NULL,
  `secondaryAreaID` int(11) DEFAULT NULL,
  `tertiaryAreaID` varchar(45) DEFAULT NULL,
  `discipline` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`accreditorID`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `accreditors`
--

LOCK TABLES `accreditors` WRITE;
/*!40000 ALTER TABLE `accreditors` DISABLE KEYS */;
INSERT INTO `accreditors` VALUES (1,'CABARLES','JAIME',' C','Jr.','cabarlesj@gmail.com',21,'2013-01-01','921486','kalawan 23, cabo village','Muntinlupa','Philippines','Quezon',1,1,NULL,'Agriculture'),(2,'CALALANG','GUADALUPE',' ','ENGR','guadacalang@gmail.com',11,'2002-02-27','912342',NULL,NULL,NULL,NULL,2,2,NULL,'Agriculture'),(3,'CUBELO','JOSE EDWIN',NULL,'DR','cubeloedwin@gmail.com',10,'2003-11-02','12345687',NULL,'Dumagete City','Philippines','Quezon City',3,1,NULL,'Agriculture'),(4,'DUSARAN','REYNALDO',NULL,'DR','dusuranreynaldo@gmail.com',18,'2000-05-11','9123456',NULL,NULL,NULL,NULL,3,5,NULL,'Agriculture'),(6,'GONZALES','LORD BRYON',NULL,'MR','gonzaleslordb@gmail.com',10,'2002-11-11','2342356','Baguio','Baguio','Philippines','Baguio',4,1,NULL,'Agriculture'),(7,'JESENA','CESAR',NULL,'DR','jesenacesar@gmail.com',9,'2007-09-12','93242658',NULL,NULL,NULL,NULL,3,2,NULL,'Agriculture'),(8,'FAJARDO','ARNEL','L','MR','fajardoarnel@gmail.com',17,'2008-04-19','93264753','Manila','Manila','Philippines','Quezon',1,1,NULL,'Computer Science'),(9,'FLORES','NANCY','M','MS','floresnancy@gmail.com',24,'2006-08-18','2436534','Baguio','Baguio','Philippines',NULL,5,1,NULL,'Computer Science'),(10,'GABISON','GREGG VICTOR',' ','DR.','gabisongregg@gmail.com',13,'2007-02-02','9322526','Cebu','Cebu','Philippines',NULL,3,10,NULL,'Computer Science'),(11,'HARO','ELMER',' ','DR','haroelmer@gmail.com',11,'2009-09-11','2325336','Bacolod','Bacolod','Philippines','Quezon',4,8,NULL,'Computer Science'),(12,'ISIDRO','DANILO','SJ','FR.','isidrodanilo@gmail.com',20,'2008-03-01','2356278','Naga','Naga','Philippines','Quezon',7,6,NULL,'Computer Science'),(13,'MAMARIL','JENNIFER',' ','MR.','mamariljennifer@gmail.com',30,'2010-01-01','3263573','Davao','Davao','Philippines','Davao',6,3,NULL,'Computer Science'),(14,'MARCOS','NELSON',' ','DR.','marcosnelson@gmail.com',11,'2007-11-18','4345267','Manila','Manila','Philippines','Quezon',9,2,NULL,'Computer Science'),(15,'ONG','ETHEL CHUA JOY',' ','MS.','ongchua@dlsu.edu.ph',8,'2012-07-14','2367584','Manila','Manila','Philippines','Manila',8,5,NULL,'Computer Science'),(16,'ACANTO','CAESAR RICO',' ','MR.','acantocesar@gmail.com',7,'2014-01-18','4563895',NULL,NULL,'Philippines',NULL,6,1,NULL,'Engineering'),(37,'Ramos','Venue','L.C.','Mrs.','kaabayaw@gmail.com',0,'2010-10-02','9213432','23b sampaloc marikina','Manila','America','Quiapo',1,9,NULL,'Computer Education'),(41,'Gesmundo','Alex','','Mr.','alexg@gmail.com',0,'2013-03-07','','Quezon City','Manila','Philippines','Ateneo de Davao',1,8,NULL,''),(42,'Nelson','Marcos','','Dr.','nelsonMarcos@gmai.com',0,'2016-12-15','123421421','manila','manila','Philippines','Quezon',1,2,'3','Computer Science');
/*!40000 ALTER TABLE `accreditors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areas`
--

DROP TABLE IF EXISTS `areas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `areas` (
  `name` varchar(45) DEFAULT NULL,
  `areaID` int(11) NOT NULL,
  PRIMARY KEY (`areaID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas`
--

LOCK TABLES `areas` WRITE;
/*!40000 ALTER TABLE `areas` DISABLE KEYS */;
INSERT INTO `areas` VALUES ('Faculty',1),('Curriculum and Instructions',2),('Laboratories',3),('Libraries',4),('Community',5),('Physical Facilities',6),('Student Services',7),('Administration',8),('Research',9),('Clinical Training',10),('Other Resources',11),('Clinical Training/Service Facilities',12),('Students',13);
/*!40000 ALTER TABLE `areas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `awards`
--

DROP TABLE IF EXISTS `awards`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `awards` (
  `awardID` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`awardID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `awards`
--

LOCK TABLES `awards` WRITE;
/*!40000 ALTER TABLE `awards` DISABLE KEYS */;
/*!40000 ALTER TABLE `awards` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `decisions`
--

DROP TABLE IF EXISTS `decisions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `decisions` (
  `decisionID` int(11) NOT NULL AUTO_INCREMENT,
  `decisionBy` varchar(45) DEFAULT NULL,
  `decision` varchar(245) DEFAULT 'None',
  `validThru` varchar(45) DEFAULT 'NA',
  `remarks` varchar(245) DEFAULT 'NA',
  `forInterim` varchar(30) DEFAULT NULL,
  `forConsultation` varchar(30) DEFAULT NULL,
  `forProgressReport` varchar(30) DEFAULT NULL,
  `PSID` int(11) DEFAULT NULL,
  PRIMARY KEY (`decisionID`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `decisions`
--

LOCK TABLES `decisions` WRITE;
/*!40000 ALTER TABLE `decisions` DISABLE KEYS */;
INSERT INTO `decisions` VALUES (1,'Board','Consultancy Visit after one year for the following areas:','NA','Research, Curriculum and Instructions','','','',37),(2,'Commission','Consultancy Visit after one year for the following areas:','NA',' ','','','',37),(3,'Team','Consultancy Visit after one year for the following areas:','3 years','Curriculum and Instructions','','','',37),(4,'Board','Eligible for formal survey after six months to one year','NA','','','','',38),(5,'Commission','Consultancy Visit after one year for the following areas:','NA','  Faculty','','','',38),(6,'Team','Consultancy Visit after one year for the following areas:','NA','Faculty','','','',38),(7,'Board','Consultancy Visit after one year for the following areas:','NA','Faculty','','','',39),(8,'Commission','Consultancy Visit after one year for the following areas:','NA','Curriculum and Instructions','','','',39),(9,'Team','Consultancy Visit after one year for the following areas:','NA','Student Services','','','',39),(10,'Board','Initial accreditation for three (3) years','NA','','','','',40),(11,'Commission','Accreditation not granted','NA','Lacks details with materials','','','',40),(12,'Team','Accreditation not granted','NA','Lacks manuals','','','',40),(13,'Board','None','NA','NA',NULL,NULL,NULL,41),(14,'Commission','None','NA','NA',NULL,NULL,NULL,41),(15,'Team','None','NA','NA',NULL,NULL,NULL,41),(16,'Board','None','NA','NA',NULL,NULL,NULL,42),(17,'Commission','None','NA','NA',NULL,NULL,NULL,42),(18,'Team','None','NA','NA',NULL,NULL,NULL,42),(19,'Board','None','NA','NA',NULL,NULL,NULL,43),(20,'Commission','None','NA','NA',NULL,NULL,NULL,43),(21,'Team','None','NA','NA',NULL,NULL,NULL,43),(22,'Board',NULL,'NA','','','','',44),(23,'Commission','null','NA',' ','','','',44),(24,'Team','Eligible for formal survey after one year','NA','','','','',44),(25,'Board','Consultancy Visit after one year for the following areas:','NA','Laboratories','','','',45),(26,'Commission','Consultancy Visit after one year for the following areas:','NA',' Laboratories','','','',45),(27,'Team','Eligible for formal survey after six months to one year','NA','','','','',45),(28,'Board','Consultancy Visit after one year for the following areas:','NA','Faculty','','','',46),(29,'Commission','Eligible for formal survey after six months to one year','NA',' ','','','',46),(30,'Team','Eligible for formal survey after six months to one year','NA','','','','',46),(31,'Board','Eligible for formal survey after six months to one year','NA','','','','',47),(32,'Commission',NULL,'NA',' ','','','',47),(33,'Team',NULL,'NA','','','','',47);
/*!40000 ALTER TABLE `decisions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `educationlevel`
--

DROP TABLE IF EXISTS `educationlevel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `educationlevel` (
  `levelID` int(11) NOT NULL AUTO_INCREMENT,
  `levelName` varchar(100) NOT NULL,
  PRIMARY KEY (`levelID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `educationlevel`
--

LOCK TABLES `educationlevel` WRITE;
/*!40000 ALTER TABLE `educationlevel` DISABLE KEYS */;
INSERT INTO `educationlevel` VALUES (1,'Elementary Education'),(2,'Secondary Education'),(3,'Integrated Basic Education'),(4,'Tertiary Education'),(5,'Graduate Education'),(6,'Medical Education'),(7,'CECSTE');
/*!40000 ALTER TABLE `educationlevel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `institutions`
--

DROP TABLE IF EXISTS `institutions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `institutions` (
  `institutionID` int(11) NOT NULL AUTO_INCREMENT,
  `systemID` int(11) DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  `head` varchar(45) DEFAULT NULL,
  `hPosition` varchar(45) DEFAULT NULL,
  `hEmail` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `dateAdded` varchar(20) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `fax` varchar(30) DEFAULT NULL,
  `contactPerson` varchar(45) DEFAULT NULL,
  `contactPosition` varchar(45) DEFAULT NULL,
  `contactNumber` varchar(30) DEFAULT NULL,
  `website` varchar(250) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  `contactEmail` varchar(45) DEFAULT NULL,
  `acronym` varchar(45) DEFAULT NULL,
  `educLevelID` int(11) DEFAULT NULL,
  PRIMARY KEY (`institutionID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `institutions`
--

LOCK TABLES `institutions` WRITE;
/*!40000 ALTER TABLE `institutions` DISABLE KEYS */;
INSERT INTO `institutions` VALUES (1,3,'Ateneo De Cagayan','Roman Jose','President','rj@gmail.com','Cagayan DE ORO','Preliminary Visit','2017-03-17','Cagayan','2324253','Ms. Lele Tan','chairperson','(632) 524-4611 locals 802 ','ADCU.com','Philippines','leletan@yahoo.com','ADCU',4),(2,1,'De La Salle University','Br. Raymundo B. Suplido FSC','President','','2401 Taft Avenue 1004 Manila, Philippines','Active','2017-03-14','Manila','','De La Salle University','De La Salle University','(632) 524-4611 locals 802 ','www.dlsu.com','Philippines','De La Salle University','DLSU',4),(3,4,'Central Philippines University','Rey Abraham','President',NULL,NULL,'Active','2017-03-14','Manila',NULL,NULL,NULL,'(632) 524-4611 locals 802 ',NULL,'Philippines',NULL,'CPU',4),(4,5,'University of the Philippines Diliman','Hon. PATRICIA B. LICUANAN','Chairperson',NULL,NULL,'Active','2017-03-14','Quezon',NULL,NULL,NULL,'(632) 524-4611 locals 802 ',NULL,'Philippines',NULL,'UPD',4),(5,5,'University of the Philippines Los Banos','Hon. DANILO L. CONCEPCION','Vice Chairperson',NULL,NULL,'Active','2017-03-14','Laguna',NULL,NULL,NULL,'(632) 524-4611 locals 802 ',NULL,'Philippines',NULL,'UPLB',4),(6,6,'University of Santo Tomas','VERY REV. FR. BRUNO F. CADORE, O.P., MD','Chancellor',NULL,NULL,'Active','2017-03-14','Quezon',NULL,NULL,NULL,'(632) 524-4611 locals 802 ',NULL,'Philippines',NULL,'UST',4),(7,7,'Philippine Women\'s University','Dr. Jose Francisco B. Benitez','President',NULL,NULL,'Active','2017-03-14','Manila',NULL,NULL,NULL,'(632) 524-4611 locals 802 ',NULL,'Philippines',NULL,'PWU',4),(8,8,'St. Scholastica College','Sr. Mary Thomas Prado, OSB','President',NULL,NULL,'Active','2017-03-14','Manila',NULL,NULL,NULL,'(632) 524-4611 locals 802 ',NULL,'Philippines',NULL,'SSC',4),(9,19,'Holy Angel University','Luis Maria Calingo, MURP, MBA, PhD','President','luiscalingo@gmail.com','null','Preliminary Visit','2017-03-17','Makati','null','Sherylyn Magpison','Secretary of the President','(632) 524-4611 locals 802 ','null','Philippines','sMagpison@gmail.com','HAU',4),(10,21,'Negros Oriental University','Dr. Lito Manalsin PhD.','null','null','null','Preliminary Visit','2017-03-17','Negros','null','null','null','(632) 524-4611 locals 802 ','null','Philippines','null','NOU',4),(11,1,'De La Salle University Dasmarinas','Br. Raymundo B. Suplido FSC','President',NULL,NULL,'Active','2017-03-14','Cavite',NULL,NULL,NULL,'(632) 524-4611 locals 802 ',NULL,'Philippines',NULL,'DLSU-D',4),(12,1,'College of Saint Benilde','Br. Dennis M. Magbanua FSC','President',NULL,NULL,'Active','2017-03-14','Manila',NULL,NULL,NULL,'(632) 524-4611 locals 802 ',NULL,'Philippines',NULL,'DSL-CSB',4),(19,22,'ST. MARYS UNIVERSITY','','','','','Preliminary Visit','2017-03-17','','','','','','','','','SMU',4),(20,19,'Holy Angel\'s University','','','','','Preliminary Visit','2017-03-28','','','','','','','','','HAUS',4),(21,3,'Xavier University','Engr. Roman Doreteo (PhD.)','President','doreteoRoman@xavier.edu.ph','Quezon City','Preliminary Visit','2008-06-11',NULL,'293-2130','Lize Ang','Secretery of the registrar','(632) 234-5231','www.xavier..edu.ph','Philippines','--','Xavier',4),(22,6,'Letran University','','','','Manila City','Preliminary Visit','2010-05-17','Manila','','','','','','Philippines','','Letran',4),(23,23,'AMA Quezon City','','','','Quezon City','Preliminary Visit','2017-04-04','Quezon City','','','','','','Philippines','','AMA-QC',4),(24,1,'La Salle Greenhills',NULL,NULL,NULL,'Mandaluyong City','Active','2017-07-03','Mandaluyong City',NULL,NULL,NULL,NULL,NULL,'Philippines',NULL,'LSGH',3);
/*!40000 ALTER TABLE `institutions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notifications`
--

DROP TABLE IF EXISTS `notifications`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `notifications` (
  `notificationID` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(200) DEFAULT NULL,
  `dateCreated` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`notificationID`),
  UNIQUE KEY `content_UNIQUE` (`content`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notifications`
--

LOCK TABLES `notifications` WRITE;
/*!40000 ALTER TABLE `notifications` DISABLE KEYS */;
INSERT INTO `notifications` VALUES (1,'<b>MARCOS, Nelson (DR.)</b>: Completed 50th Survey','Nov 04 2014 11:45 PM','pending','Awards'),(2,'Pogi Si Benjo Award','Nov 12 1994 11:45 PM','done','Expirations');
/*!40000 ALTER TABLE `notifications` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program-area`
--

DROP TABLE IF EXISTS `program-area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `program-area` (
  `PSID` int(11) NOT NULL,
  `areaID` varchar(45) DEFAULT NULL,
  `accreditorID` varchar(45) DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `attendanceConfirmation` varchar(45) DEFAULT NULL,
  `counter` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`counter`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program-area`
--

LOCK TABLES `program-area` WRITE;
/*!40000 ALTER TABLE `program-area` DISABLE KEYS */;
INSERT INTO `program-area` VALUES (37,'1','2','Accreditor','Confirmed',48),(38,'1','15','Accreditor','Confirmed',49),(38,'2','2','Accreditor','Confirmed',50),(39,'3','10','Accreditor','Confirmed',51),(40,'1','3','Accreditor','Confirmed',52),(41,'1','1','Accreditor','Unconfirmed',53),(42,'1','1','Accreditor','Unconfirmed',54),(43,'1','1','Accreditor','Unconfirmed',55),(44,'1','1','Accreditor','Confirmed',56),(45,'1','8','Accreditor','Confirmed',57),(46,'1','1','Accreditor','Confirmed',58),(47,'1','7','Accreditor','Confirmed',59),(47,'2','9','Accreditor','Confirmed',60);
/*!40000 ALTER TABLE `program-area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `program-survey`
--

DROP TABLE IF EXISTS `program-survey`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `program-survey` (
  `PSID` int(11) NOT NULL AUTO_INCREMENT,
  `surveyID` varchar(45) DEFAULT NULL,
  `SPID` varchar(45) DEFAULT NULL,
  `surveyType` varchar(45) DEFAULT 'Preliminary',
  `reportPath` varchar(45) DEFAULT NULL,
  `currentDecisionBy` varchar(45) DEFAULT 'None',
  `validThru` date DEFAULT NULL,
  `boardApprovalDate` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`PSID`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `program-survey`
--

LOCK TABLES `program-survey` WRITE;
/*!40000 ALTER TABLE `program-survey` DISABLE KEYS */;
INSERT INTO `program-survey` VALUES (37,'36','27','Preliminary',NULL,'Board','2020-02-02','2017-02-02'),(38,'37','24','Preliminary',NULL,'Board','2020-02-02','2013-02-02'),(39,'37','24','Consultancy',NULL,'Board','2018-02-02','2016-02-02'),(40,'38','1','Formal',NULL,'Board','2020-04-05','2017-04-05'),(44,'42','28','Preliminary',NULL,'Board','2020-04-05','2020-04-05'),(45,'43','3','Preliminary',NULL,'Board',NULL,''),(46,'44','24','Preliminary',NULL,'Board','2020-04-01','2017-04-01'),(47,'45','4','Preliminary',NULL,'Board','2018-03-29','2017-03-29');
/*!40000 ALTER TABLE `program-survey` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `programs`
--

DROP TABLE IF EXISTS `programs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `programs` (
  `programID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`programID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `programs`
--

LOCK TABLES `programs` WRITE;
/*!40000 ALTER TABLE `programs` DISABLE KEYS */;
INSERT INTO `programs` VALUES (1,'Human Biology'),(2,'Agriculture'),(3,'Architechture and Fine Arts'),(4,'Computer Science'),(5,'Engineering'),(6,'HRM'),(7,'LAEDBUS'),(8,'Medicine'),(9,'Music'),(10,'Nursing'),(11,'Benjology'),(12,'Chemistry'),(13,'Entrepreneurship');
/*!40000 ALTER TABLE `programs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school-program`
--

DROP TABLE IF EXISTS `school-program`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school-program` (
  `SPID` int(11) NOT NULL AUTO_INCREMENT,
  `programID` int(11) DEFAULT NULL,
  `institutionID` int(11) DEFAULT NULL,
  `level` varchar(45) DEFAULT NULL,
  `dateAdded` varchar(20) DEFAULT NULL,
  `nextSurveySched` varchar(45) DEFAULT NULL,
  `pendingReports` varchar(45) DEFAULT NULL,
  `nextSurveyType` varchar(45) DEFAULT NULL,
  `degreeName` varchar(45) DEFAULT NULL,
  `levelID` int(1) NOT NULL,
  PRIMARY KEY (`SPID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school-program`
--

LOCK TABLES `school-program` WRITE;
/*!40000 ALTER TABLE `school-program` DISABLE KEYS */;
INSERT INTO `school-program` VALUES (1,1,1,'4','2006-03-14','2017-02-11','NA','Resurvey','BS - Agricuture',4),(2,2,1,'3','2007-11-14','2017-02-11','NA','Resurvey','BS - Human Biology',4),(3,3,2,'2','2013-09-14','2017-02-11','NA','Consultancy','BA-Fine Arts',4),(4,4,2,'3','2012-05-16','2017-02-11','NA','Resurvey','BS-Computer Science',4),(5,5,3,'3','2007-03-24','2017-02-11','NA','Preliminary','BS-Mechanical Engineering',4),(6,6,3,'3','2005-02-24','2017-02-11','NA','Resurvey','BS-Hotel Management',4),(7,7,4,'3','2017-10-12','2017-02-11','NA','Preliminary','BA-Communication Arts',4),(8,8,4,'4','2017-03-14','2017-02-11','NA','Resurvey','General Medicine',4),(9,9,5,'1','2017-03-14','2017-02-11','NA','Formal','BA-Music Production',4),(10,10,6,'2','2017-03-14','2017-02-11','NA','Resurvey','Nursing',4),(16,1,6,'NA','2017-03-14',NULL,NULL,NULL,'BS-Biology',4),(17,4,6,'NA','2017-03-14',NULL,NULL,NULL,'BS-Computer Science',4),(18,2,16,'NA','2017-03-14',NULL,NULL,NULL,'BS-Farming ',4),(19,8,6,'NA','2017-03-14',NULL,NULL,NULL,'Internal Medicine',4),(20,5,11,'NA','2017-03-17',NULL,NULL,NULL,'BS-Chemical Engineering',4),(21,9,11,'NA','2017-03-17',NULL,NULL,NULL,'BA-Music',4),(23,2,10,'NA','2017-03-17',NULL,NULL,NULL,'BS-Agriculture',4),(24,3,7,'NA','2017-03-17',NULL,NULL,NULL,'BS-Architechture',4),(25,2,8,'NA','2017-03-17',NULL,NULL,NULL,'BS-Environment Science',4),(26,2,5,'NA','2017-03-17',NULL,NULL,NULL,'BS-Forestry',4),(27,6,2,'NA','2017-03-17',NULL,NULL,NULL,'BA-Hotel Management',4),(28,2,19,'NA','2017-03-17',NULL,NULL,NULL,'BS-Agriculture',4),(29,7,20,'NA','2017-03-28',NULL,NULL,NULL,'Liberal Arts',4),(30,12,22,'NA','2017-04-02',NULL,NULL,NULL,'BS-Chemistry',4),(31,1,23,'NA','2017-04-03',NULL,NULL,NULL,'BS - Biology',4);
/*!40000 ALTER TABLE `school-program` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `school-systems`
--

DROP TABLE IF EXISTS `school-systems`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `school-systems` (
  `systemID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `dateJoined` date DEFAULT NULL,
  PRIMARY KEY (`systemID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school-systems`
--

LOCK TABLES `school-systems` WRITE;
/*!40000 ALTER TABLE `school-systems` DISABLE KEYS */;
INSERT INTO `school-systems` VALUES (1,'De La Salle','1995-11-04'),(3,'Ateneo','1997-02-18'),(4,'Central Philippines University','2002-09-12'),(5,'University of the Philippines',NULL),(6,'University of Santo Tomas','2016-01-01'),(7,'Philippines Women\'s University','2006-02-05'),(8,'St. Scholastica University','2017-01-01'),(19,'Holy Angel University','1999-02-11'),(21,'University of Negros Oriental','2016-01-01'),(22,'RVM','1989-03-17'),(23,'AMA',NULL),(24,'Test','1938-08-22');
/*!40000 ALTER TABLE `school-systems` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `surveys`
--

DROP TABLE IF EXISTS `surveys`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `surveys` (
  `surveyID` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `dateApproved` date DEFAULT NULL,
  `dateRequested` date DEFAULT NULL,
  `institutionID` int(11) DEFAULT NULL,
  `paascu1Name` varchar(45) DEFAULT NULL,
  `paascu1Contact` varchar(45) DEFAULT NULL,
  `paascu1Position` varchar(45) DEFAULT NULL,
  `paascu2Name` varchar(45) DEFAULT NULL,
  `paascu2Contact` varchar(45) DEFAULT NULL,
  `paascu2Position` varchar(45) DEFAULT NULL,
  `chairpersonID` int(11) DEFAULT NULL,
  `levelID` int(1) NOT NULL,
  PRIMARY KEY (`surveyID`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `surveys`
--

LOCK TABLES `surveys` WRITE;
/*!40000 ALTER TABLE `surveys` DISABLE KEYS */;
INSERT INTO `surveys` VALUES (36,'2017-03-23','2017-03-23',NULL,NULL,2,'','','','','','',NULL,4),(37,'2017-03-17','2017-03-17',NULL,NULL,7,'','','','','','',NULL,4),(38,'2017-03-21','2017-03-21',NULL,NULL,1,'','','','','','',NULL,4),(42,'2017-03-29','2017-03-29',NULL,NULL,19,'','','','','','',NULL,4),(43,'2017-05-03','2017-05-03',NULL,NULL,2,'','','','','','',NULL,4),(44,'2017-03-30','2017-03-30',NULL,NULL,7,'','','','','','',1,4),(45,'2017-03-31','2017-03-31',NULL,NULL,2,'Alma','','Staff','','','',8,4);
/*!40000 ALTER TABLE `surveys` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work` (
  `workID` int(11) NOT NULL AUTO_INCREMENT,
  `institutionID` int(11) NOT NULL,
  `accreditorID` int(11) DEFAULT NULL,
  `dateEntered` date DEFAULT NULL,
  `dateFinished` date DEFAULT NULL,
  `position` varchar(45) DEFAULT NULL,
  `levelID` int(1) DEFAULT NULL,
  PRIMARY KEY (`workID`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
INSERT INTO `work` VALUES (1,1,1,'2000-01-01',NULL,'Dean',4),(2,2,1,'2000-01-01',NULL,'Professor',4),(3,3,2,'2000-01-01',NULL,'Professor',4),(4,1,2,'2000-01-01',NULL,'Professor',4),(5,4,3,'2000-01-01',NULL,'Professor',4),(6,5,4,'2000-01-01',NULL,'Professor',4),(7,5,5,'2000-01-01',NULL,'Professor',4),(8,6,6,'2000-01-01',NULL,'Professor',4),(9,6,7,'2000-01-01',NULL,'Professor',4),(10,7,8,'2000-01-01',NULL,'Professor',4),(11,5,8,'2000-01-01',NULL,'Professor',4),(12,8,9,'2000-01-01',NULL,'Professor',4),(13,35,10,'2000-01-01',NULL,'Professor',4),(14,5,11,'2000-01-01',NULL,'Professor',4),(15,6,12,'2000-01-01',NULL,'Professor',4),(16,1,13,'2000-01-01',NULL,'Professor',4),(17,7,14,'2000-01-01',NULL,'Professor',4),(18,8,15,'2000-01-01',NULL,'Professor',4),(19,5,16,'2000-01-01',NULL,'Professor',4),(20,1,17,'2000-01-01',NULL,'Professor',4),(21,35,18,'2000-01-01',NULL,'Professor',4),(22,6,19,'2000-01-01',NULL,'Professor',4),(23,7,20,'2000-01-01',NULL,'Professor',4),(24,1,36,'2017-03-07',NULL,'Chairman',4),(25,3,36,'2017-03-01','2017-03-02','Chairperson',4),(26,1,37,'2010-02-02',NULL,'Din',4),(27,1,38,'2017-03-07',NULL,'bb',4),(28,5,39,'2017-03-08',NULL,'Dean',4),(30,40,40,'2017-03-01',NULL,'papogi',4),(31,19,41,'2000-03-07',NULL,'It Specialist',4);
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-06  3:39:11
