CREATE DATABASE IF NOT EXISTS `retoJavaMaria` ;
USE `retoJavaMaria`;



CREATE TABLE IF NOT EXISTS `calculos` (
  `id`  INT(9) NOT NULL AUTO_INCREMENT, 
  `alto` int(11) DEFAULT NULL,
  `ancho` int(11) DEFAULT NULL,
  `operacion` smallint DEFAULT NULL,
  `result` longtext DEFAULT NULL,
  `data` longtext DEFAULT NULL,
  PRIMARY KEY (`id`)
) 


