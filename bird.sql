/*
SQLyog Professional v10.42 
MySQL - 5.5.5-10.1.31-MariaDB : Database - bird
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bird` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bird`;

/*Table structure for table `tont_aves` */

CREATE TABLE `tont_aves` (
  `cdave` varchar(5) NOT NULL,
  `dsnombre_comun` varchar(100) DEFAULT NULL,
  `dsnombre_cientifico` varchar(200) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cdave`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tont_aves` */

insert  into `tont_aves`(`cdave`,`dsnombre_comun`,`dsnombre_cientifico`,`image`) values ('001','Halcón peregrino','Falco peregrinus','http://www.animalesextremos.com/Imagenes/halcon-peregrino-el-ave-mas-rapida-del-mundo.jpg'),('002','Martín pescador','Alcedo Atthis','https://cdn.pixabay.com/photo/2017/02/07/16/47/kingfisher-2046453_960_720.jpg'),('003','Condor','Vultur gryphus','https://uploads.knightlab.com/storymapjs/451c4c653171435c81f354f00df7b916/los-condores-en-el-pais/_images/condooor.jpg'),('004','Fregata','Fregatidae','https://www.nationalgeographic.com.es/medio/2018/02/27/fragata-en-vuelo__1280x720.JPG');

/*Table structure for table `tont_aves_pais` */

CREATE TABLE `tont_aves_pais` (
  `cdpais` varchar(3) DEFAULT NULL,
  `cdave` varchar(5) DEFAULT NULL,
  KEY `cdpais` (`cdpais`),
  KEY `cdave` (`cdave`),
  CONSTRAINT `tont_aves_pais_ibfk_1` FOREIGN KEY (`cdpais`) REFERENCES `tont_paises` (`cdpais`),
  CONSTRAINT `tont_aves_pais_ibfk_2` FOREIGN KEY (`cdave`) REFERENCES `tont_aves` (`cdave`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tont_aves_pais` */

insert  into `tont_aves_pais`(`cdpais`,`cdave`) values ('001','001'),('002','001'),('003','002'),('001','003'),('002','003'),('001','004'),('002','004');

/*Table structure for table `tont_paises` */

CREATE TABLE `tont_paises` (
  `cdpais` varchar(3) NOT NULL,
  `dsnombre` varchar(45) DEFAULT NULL,
  `cdzona` varchar(3) DEFAULT NULL,
  `zone_cdzona` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cdpais`),
  KEY `cdzona` (`cdzona`),
  KEY `FKlmt8n0u8kkme3sw9nipqh67qa` (`zone_cdzona`),
  CONSTRAINT `FKlmt8n0u8kkme3sw9nipqh67qa` FOREIGN KEY (`zone_cdzona`) REFERENCES `tont_zonas` (`cdzona`),
  CONSTRAINT `tont_paises_ibfk_1` FOREIGN KEY (`cdzona`) REFERENCES `tont_zonas` (`cdzona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tont_paises` */

insert  into `tont_paises`(`cdpais`,`dsnombre`,`cdzona`,`zone_cdzona`) values ('001','Colombia','001',NULL),('002','Ecuador','001',NULL),('003','Chile','002',NULL),('004',NULL,NULL,NULL),('005',NULL,NULL,NULL),('006',NULL,NULL,NULL),('007','brasil',NULL,NULL);

/*Table structure for table `tont_zonas` */

CREATE TABLE `tont_zonas` (
  `cdzona` varchar(3) NOT NULL,
  `dsnombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cdzona`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tont_zonas` */

insert  into `tont_zonas`(`cdzona`,`dsnombre`) values ('001','Tropical'),('002','Templada');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
