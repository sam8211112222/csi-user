CREATE DATABASE  IF NOT EXISTS `prototype_directory`;
USE `prototype_directory`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `org_code` int(4) NOT NULL,
  `formal_name` varchar(45) DEFAULT NULL,
  `nick_name` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `role` int(2) NOT NULL,
   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

--
-- Data for table `user`
--

INSERT INTO `user` VALUES 
	(1,1,'李玉','twadmin','123456',0),
	(2,2,'王小名','account','123456',1),
	(3,3,'林大同','Administrator','1234',0)

