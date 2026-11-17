-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.16 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5154
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for des_security
CREATE DATABASE IF NOT EXISTS `des_security` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `des_security`;

-- Dumping structure for table des_security.des_file
CREATE TABLE IF NOT EXISTS `des_file` (
  `file_id` int(11) NOT NULL AUTO_INCREMENT,
  `file_code` int(11) NOT NULL DEFAULT '0',
  `cadenas_id` int(11) NOT NULL,
  `file_name` varchar(50) NOT NULL,
  `file_chars` varchar(10) NOT NULL,
  `file_prefix` varchar(10) DEFAULT NULL,
  `file_dir` varchar(250) DEFAULT NULL,
  `file_sufix` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table des_security.des_file: ~5 rows (approximately)
/*!40000 ALTER TABLE `des_file` DISABLE KEYS */;
INSERT INTO `des_file` (`file_id`, `file_code`, `cadenas_id`, `file_name`, `file_chars`, `file_prefix`, `file_dir`, `file_sufix`) VALUES
	(1, 1, 4, 'Ventas Diario', 'VEDF', NULL, NULL, NULL),
	(2, 2, 4, 'Inventario Diario', 'INDF', NULL, NULL, NULL),
	(3, 3, 4, 'Recibos', 'RECI', NULL, NULL, NULL),
	(4, 4, 4, 'Devoluciones', 'DEVO', NULL, NULL, NULL),
	(5, 5, 4, 'Ventas Mensual', 'VEMF', NULL, NULL, NULL);
/*!40000 ALTER TABLE `des_file` ENABLE KEYS */;

-- Dumping structure for table des_security.des_param
CREATE TABLE IF NOT EXISTS `des_param` (
  `param_id` int(11) NOT NULL AUTO_INCREMENT,
  `url_id` int(11) NOT NULL DEFAULT '0',
  `param_name` varchar(60) NOT NULL,
  `param_value` varchar(60) DEFAULT NULL,
  `param_type` varchar(60) NOT NULL,
  `param_ref` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`param_id`),
  KEY `FK_url_param` (`url_id`),
  CONSTRAINT `FK_url_param` FOREIGN KEY (`url_id`) REFERENCES `des_url` (`url_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table des_security.des_param: ~5 rows (approximately)
/*!40000 ALTER TABLE `des_param` DISABLE KEYS */;
INSERT INTO `des_param` (`param_id`, `url_id`, `param_name`, `param_value`, `param_type`, `param_ref`) VALUES
	(1, 1, 'proveedor', '(NULL)', 'VARIABLE', 'USER'),
	(2, 1, 'password', '(NULL)', 'VARIABLE', 'PASS'),
	(3, 1, 'enviar1', 'enviar1', 'CONSTANTE', ''),
	(4, 1, 'enviar1.x', '29', 'CONSTANTE', ''),
	(5, 1, 'enviar1.y', '6', 'CONSTANTE', '');
/*!40000 ALTER TABLE `des_param` ENABLE KEYS */;

-- Dumping structure for table des_security.des_property
CREATE TABLE IF NOT EXISTS `des_property` (
  `url_id` int(20) NOT NULL,
  `proper_name` varchar(250) NOT NULL,
  `proper_value` varchar(250) DEFAULT NULL,
  `proper_type` varchar(20) NOT NULL DEFAULT 'CONSTANTE',
  PRIMARY KEY (`url_id`,`proper_name`),
  KEY `FK_url_property` (`url_id`),
  CONSTRAINT `FK_property_url` FOREIGN KEY (`url_id`) REFERENCES `des_url` (`url_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table des_security.des_property: ~18 rows (approximately)
/*!40000 ALTER TABLE `des_property` DISABLE KEYS */;
INSERT INTO `des_property` (`url_id`, `proper_name`, `proper_value`, `proper_type`) VALUES
	(1, 'Accept', 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8', 'CONSTANTE'),
	(1, 'Accept-Encoding', 'gzip, deflate', 'CONSTANTE'),
	(1, 'Accept-Language', 'es-419,es;q=0.8', 'CONSTANTE'),
	(1, 'Connection', 'keep-alive', 'CONSTANTE'),
	(1, 'Cookie', NULL, 'VARIABLE'),
	(1, 'Host', 'www.proveccm.com', 'CONSTANTE'),
	(1, 'Referer', NULL, 'VARIABLE'),
	(1, 'Upgrade-Insecure-Request', '1', 'CONSTANTE'),
	(1, 'User-Agent', 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 UBrowser/6.0.1308.1016 Safari/537.36', 'CONSTANTE'),
	(2, 'Accept', 'text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8', 'CONSTANTE'),
	(2, 'Accept-Encoding', 'gzip, deflate', 'CONSTANTE'),
	(2, 'Accept-Language', 'es-419,es;q=0.8', 'CONSTANTE'),
	(2, 'Connection', 'keep-alive', 'CONSTANTE'),
	(2, 'Cookie', NULL, 'VARIABLE'),
	(2, 'Host', 'www.proveccm.com', 'CONSTANTE'),
	(2, 'Referer', 'http://www.proveccm.com/jspProvecomer/provecomerNp/Menu.jsp?megrId=14&megrIdAnt=0', 'VARIABLE'),
	(2, 'Upgrade-Insecure-Request', '1', 'CONSTANTE'),
	(2, 'User-Agent', 'Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.102 UBrowser/6.0.1308.1016 Safari/537.36', 'CONSTANTE');
/*!40000 ALTER TABLE `des_property` ENABLE KEYS */;

-- Dumping structure for table des_security.des_response
CREATE TABLE IF NOT EXISTS `des_response` (
  `response_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `response_value` varchar(250) NOT NULL DEFAULT '0',
  `response_code` varchar(4) NOT NULL DEFAULT '0',
  PRIMARY KEY (`response_id`),
  UNIQUE KEY `response_code` (`response_code`),
  UNIQUE KEY `response_value` (`response_value`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=latin1;

-- Dumping data for table des_security.des_response: ~11 rows (approximately)
/*!40000 ALTER TABLE `des_response` DISABLE KEYS */;
INSERT INTO `des_response` (`response_id`, `response_value`, `response_code`) VALUES
	(1, 'Success', 'E000'),
	(2, 'User exists for this chain', 'E001'),
	(9, 'User doesn\'t match with selected chain', 'E002'),
	(10, 'Invalid user or pass', 'E003'),
	(11, 'Invalid email format', 'E004'),
	(12, 'Date of birth is higher from current date', 'E005'),
	(13, 'User doesn\'t exist', 'E006'),
	(14, 'Y or N are only allowed options for active fiel', 'E008'),
	(15, 'No active login for chain', 'E009'),
	(16, 'No login to use for', 'E010'),
	(17, 'No matches found', 'E011');
/*!40000 ALTER TABLE `des_response` ENABLE KEYS */;

-- Dumping structure for table des_security.des_url
CREATE TABLE IF NOT EXISTS `des_url` (
  `url_id` int(11) NOT NULL AUTO_INCREMENT,
  `url_str` varchar(512) NOT NULL DEFAULT '0',
  `url_type` varchar(60) NOT NULL DEFAULT 'SCRAPPING',
  `url_referer` varchar(512) DEFAULT NULL,
  `chain_id` int(11) NOT NULL,
  `url_href` varchar(60) DEFAULT NULL,
  `url_next` int(11) NOT NULL,
  `url_parseuri` varchar(512) DEFAULT NULL,
  `url_seq` int(11) NOT NULL,
  PRIMARY KEY (`url_id`,`chain_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table des_security.des_url: ~4 rows (approximately)
/*!40000 ALTER TABLE `des_url` DISABLE KEYS */;
INSERT INTO `des_url` (`url_id`, `url_str`, `url_type`, `url_referer`, `chain_id`, `url_href`, `url_next`, `url_parseuri`, `url_seq`) VALUES
	(1, 'http://www.proveccm.com/webPrvd/LoginProvecomerNpSrv', 'LOGIN', '(NULL)', 4, '(NULL)', 1, NULL, 0),
	(2, 'http://www.proveccm.com/webPrvd/VerificaOpcMenuSrv?menuId=157', 'SCRAPPING', '', 4, '?repoStore', 2, 'http://www.proveccm.com/webPrvd/VerificaOpcMenuSrv', 1),
	(3, '(NULL)', 'SCRAPPING', 'http://www.proveccm.com/webPrvd/VerificaOpcMenuSrv?menuId=157', 4, '/vtainv', 3, 'http://www.proveccm.com', 2),
	(4, '(NULL)', 'DOWNLOAD', '(NULL)', 4, '', -1, '', 3);
/*!40000 ALTER TABLE `des_url` ENABLE KEYS */;

-- Dumping structure for table des_security.des_user
CREATE TABLE IF NOT EXISTS `des_user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(60) NOT NULL,
  `user_pass` varchar(512) NOT NULL,
  `is_active` varchar(1) DEFAULT 'Y',
  `client_name` varchar(60) NOT NULL,
  `chain_name` varchar(60) DEFAULT NULL,
  `created_by` varchar(60) DEFAULT NULL,
  `updated_by` varchar(60) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `last_login` datetime DEFAULT NULL,
  `pwd_expiration` datetime DEFAULT NULL,
  `date_of_birth` datetime DEFAULT NULL,
  `pwd_lastset` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `provider` varchar(255) DEFAULT NULL,
  `clientid` int(11) NOT NULL,
  `chainid` int(11) DEFAULT '0',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=80 DEFAULT CHARSET=latin1;



-- Dumping structure for table des_security.dimcadenas
CREATE TABLE IF NOT EXISTS `dimcadenas` (
  `cadenas_id` int(11) NOT NULL,
  `dimcadenas_nombre` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dimcadenas_nombre_corto` varchar(20) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dimcadenas_logo` varchar(200) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dimcadenas_tipo` varchar(100) COLLATE utf8_spanish_ci DEFAULT NULL,
  `dimcadenas_upc` smallint(1) DEFAULT '0',
  `dimcadenas_sku` smallint(1) DEFAULT '0',
  `dimcadenas_ventas` smallint(1) DEFAULT '0',
  `dimcadenas_existencias` smallint(1) DEFAULT '0',
  `dimcadenas_pedidos` smallint(1) DEFAULT '0',
  `dimcadenas_recibos` smallint(1) DEFAULT '0',
  `dimcadenas_devoluciones` smallint(1) DEFAULT '0',
  `dimcadenas_forecast` smallint(1) DEFAULT '0',
  `dimcadenas_asociacion` smallint(1) DEFAULT '0',
  `dimcadenas_ajuste` int(11) DEFAULT NULL,
  `dimcadenas_ajuste_dia` bigint(20) DEFAULT NULL,
  `dimcadenas_id` int(11) NOT NULL,
  PRIMARY KEY (`cadenas_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;



-- Dumping structure for table des_security.dimclientecadeba_bk
CREATE TABLE IF NOT EXISTS `dimclientecadeba_bk` (
  `cadena_id` bigint(20) NOT NULL,
  `bases_id` bigint(20) NOT NULL,
  `bases_nombre` varchar(255) DEFAULT NULL,
  `cadena_nombre` varchar(255) DEFAULT NULL,
  `clientes_id` int(11) NOT NULL,
  `clientes_nombre` varchar(255) DEFAULT NULL,
  `dwh` varchar(255) DEFAULT NULL,
  `fecha_fin` datetime DEFAULT '1970-01-01 00:00:00',
  `fecha_inicio` datetime DEFAULT '1970-01-01 00:00:00',
  `meswm_fin` int(11) NOT NULL,
  `meswm_inicio` int(11) NOT NULL,
  `mes_fin` int(11) NOT NULL,
  `mes_inicio` int(11) NOT NULL,
  `pass_activo` int(11) NOT NULL,
  `proceso_activo` int(11) NOT NULL,
  `proceso_activo_interno` int(11) NOT NULL,
  `semanawm_cerrada` int(11) NOT NULL,
  `semanawm_fin` int(11) NOT NULL,
  `semanawm_inicio` int(11) NOT NULL,
  `semana_cerrada` int(11) NOT NULL,
  `semana_fin` int(11) NOT NULL,
  `semana_inicio` int(11) NOT NULL,
  `tipo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping structure for table des_security.dimclientecadena
CREATE TABLE IF NOT EXISTS `dimclientecadena` (
  `cadena_id` bigint(20) NOT NULL,
  `bases_id` bigint(20) NOT NULL,
  `bases_nombre` varchar(255) DEFAULT NULL,
  `cadena_nombre` varchar(255) DEFAULT NULL,
  `clientes_id` int(11) NOT NULL,
  `clientes_nombre` varchar(255) DEFAULT NULL,
  `dwh` varchar(255) DEFAULT NULL,
  `fecha_fin` datetime DEFAULT '1970-01-01 00:00:00',
  `fecha_inicio` datetime DEFAULT '1970-01-01 00:00:00',
  `meswm_fin` int(11) NOT NULL,
  `meswm_inicio` int(11) NOT NULL,
  `mes_fin` int(11) NOT NULL,
  `mes_inicio` int(11) NOT NULL,
  `pass_activo` int(11) NOT NULL,
  `proceso_activo` int(11) NOT NULL,
  `proceso_activo_interno` int(11) NOT NULL,
  `semanawm_cerrada` int(11) NOT NULL,
  `semanawm_fin` int(11) NOT NULL,
  `semanawm_inicio` int(11) NOT NULL,
  `semana_cerrada` int(11) NOT NULL,
  `semana_fin` int(11) NOT NULL,
  `semana_inicio` int(11) NOT NULL,
  `tipo_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


-- Dumping structure for table des_security.url_param
CREATE TABLE IF NOT EXISTS `url_param` (
  `param_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `chain_name` varchar(60) NOT NULL,
  `param_name` varchar(40) DEFAULT NULL,
  `param_type` varchar(20) DEFAULT NULL,
  `url_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`param_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table des_security.url_param: ~0 rows (approximately)
/*!40000 ALTER TABLE `url_param` DISABLE KEYS */;
/*!40000 ALTER TABLE `url_param` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
