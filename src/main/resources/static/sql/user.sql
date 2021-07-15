CREATE DATABASE  IF NOT EXISTS `prototype_directory`;
USE `prototype_directory`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
                        `id`  bigint(4) unsigned zerofill NOT NULL AUTO_INCREMENT,
                        `org_code` int(4) NOT NULL,
                        `formal_name` varchar(45) DEFAULT NULL,
                        `username` varchar(45) DEFAULT NULL,
                        `password` varchar(100) DEFAULT NULL,
                        `enabled` boolean DEFAULT false,
                        `authority` varchar(45) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT = 1000;

--
-- Data for table `user`
-- 預設密碼是123456
--


INSERT INTO `user` VALUES
('1001',1,'李玉','abc123','$2a$10$V3ofie/tuk83liTfQ02DOuEfg8bW8UesYNUYnw4yID1dFeIPsyK32',1,'ROLE_EMPLOYEE'),
('1002',2,'王小名','abc456','$2a$10$V3ofie/tuk83liTfQ02DOuEfg8bW8UesYNUYnw4yID1dFeIPsyK32',1,'ROLE_MANAGER'),
('1003',3,'林大同','abc789','$2a$10$V3ofie/tuk83liTfQ02DOuEfg8bW8UesYNUYnw4yID1dFeIPsyK32',1,'ROLE_ADMIN'),
('1004',1,'丁哥','test123','$2a$10$V3ofie/tuk83liTfQ02DOuEfg8bW8UesYNUYnw4yID1dFeIPsyK32',1,'ROLE_EMPLOYEE'),
('1005',2,'姚左群','test456','$2a$10$V3ofie/tuk83liTfQ02DOuEfg8bW8UesYNUYnw4yID1dFeIPsyK32',0,'ROLE_EMPLOYEE'),
('1006',3,'陳文政','test789','$2a$10$V3ofie/tuk83liTfQ02DOuEfg8bW8UesYNUYnw4yID1dFeIPsyK32',0,'ROLE_EMPLOYEE');

