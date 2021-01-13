CREATE DATABASE  IF NOT EXISTS `user_directory`;
USE `user_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;


INSERT INTO `users` VALUES 
	(1,'Gyotaek','Lee','gyotaek.lee@hitaek.com'),
	(2,'Legend','Jon','legend@hitaek.com'),
	(3,'Rick','Ebrihelm','rick@hitaek.com'),
	(4,'Oliver','Balbosa','oliver@hitaek.com'),
	(5,'Ted','Mosby','ted@hitaek.com');

