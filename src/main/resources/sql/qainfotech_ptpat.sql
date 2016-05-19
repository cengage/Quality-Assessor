--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(40) NOT NULL,
  `role_description` varchar(40) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_name` (`role_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;


--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `role_name`, `role_description`) VALUES
(1, 'ROLE_ADMIN', ''),
(2, 'ROLE_USER', '');

--
-- Table structure for table `url_rule`
--

CREATE TABLE IF NOT EXISTS `url_rule` (
  `url_rule_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(40) NOT NULL,
  `method` varchar(40) NOT NULL,
  PRIMARY KEY (`url_rule_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `url_rule`
--

INSERT INTO `url_rule` (`url_rule_id`, `url`, `method`) VALUES
(1, '/login', 'GET'),
(2, '/home', 'GET');


--
-- Table structure for table `role_url_rule`
--

CREATE TABLE IF NOT EXISTS `role_url_rule` (
  `role_id` bigint(20) NOT NULL,
  `url_rule_id` bigint(20) NOT NULL,
  PRIMARY KEY (`role_id`,`url_rule_id`),
  KEY `FK89656D75DAA91374` (`role_id`),
  KEY `FK89656D75440A0FBF` (`url_rule_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Dumping data for table `role_url_rule`
--

INSERT INTO `role_url_rule` (`role_id`, `url_rule_id`) VALUES
(1, 2);

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(30) NOT NULL UNIQUE,
  `password` varchar(50) NOT NULL,
  `first_name` varchar(30) NOT NULL UNIQUE,
  `last_name` varchar(30) NOT NULL UNIQUE,
  `enabled` bit(1) NOT NULL DEFAULT b'1',
  `account_non_expired` bit(1) NOT NULL DEFAULT b'1',
  `account_non_locked` bit(1) NOT NULL DEFAULT b'1',
  `credentials_non_expired` bit(1) NOT NULL DEFAULT b'1',
  `creation_date` datetime NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `user_name`, `password`, `enabled`, `account_non_expired`, `account_non_locked`, `credentials_non_expired`, `creation_date`) VALUES
(1, 'sansar', 'ea9a7d3f4c7faf7f7d5297059b8ba3e0ae8d0145', b'1', b'1', b'1', b'1', '2013-12-11 00:00:00');

--
--Updating table 'users'
--

UPDATE `users` SET `first_name` = 'sansar',
`last_name` = 'mor',
`enabled` = b '1',
`account_non_expired` = b '1',
`account_non_locked` = b '1',
`credentials_non_expired` = b '1' WHERE `users`.`user_id` =1;

--
-- Table Structure for table 'users_role'
--

CREATE TABLE IF NOT EXISTS `users_role` (
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FK_users_role_users_id` (`user_id`),
  KEY `FK_users_role_role_id` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for 'users_role'
--

INSERT INTO `users_role` (`user_id`, `role_id`) VALUES
(1, 1);

--
-- Table structure for table `product`
--

CREATE TABLE IF NOT EXISTS `product` (
  `product_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(40) NOT NULL,
   PRIMARY KEY (`product_id`),
   UNIQUE KEY `product_name` (`product_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

ALTER TABLE `product` CHANGE `product_name` `product_code` VARCHAR( 40 ) CHARACTER SET latin1 COLLATE latin1_swedish_ci NOT NULL

--
-- Table structure for table 'category'
--


CREATE TABLE IF NOT EXISTS `category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(40) NOT NULL,
   PRIMARY KEY (`category_id`),
   UNIQUE KEY `category_name` (`category_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;


--
-- Table structure for table 'sub_category'
--

CREATE TABLE IF NOT EXISTS `sub_category` (
  `sub_category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `sub_category_name` varchar(40) NOT NULL,
   PRIMARY KEY (`sub_category_id`),
   UNIQUE KEY `sub_category_name` (`sub_category_name`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Table structure for table 'product_category'
--

CREATE TABLE IF NOT EXISTS `product_category` (
  `product_category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_id` bigint(20) NOT NULL,
  `category_id` bigint(20) NOT NULL,
  `category_raw_data` varchar(40),
  `category_target_data` varchar(40),
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime,
  PRIMARY KEY (`id`,`product_id`,`category_id`),
  KEY `FK_product_category_product_id` (`product_id`),
  KEY `FK_product_category_category_id` (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


--
-- Table structure for table 'sub_category_raw_data'
--

CREATE TABLE IF NOT EXISTS `sub_category_data` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `product_category_id` bigint(20) NOT NULL,
  `sub_category_id` bigint(20) NOT NULL,
  `sub_category_raw_data` varchar(40),
  `sub_category_target_data` varchar(40),
  `sub_category_calculated_data` varchar(40),
  `created_date` datetime NOT NULL,
  `last_modified_date` datetime,
  PRIMARY KEY (`id`,`product_category_id`,`sub_category_id`),
  KEY `FK_SCRD_product_category_id` (`product_category_id`),
  KEY `FK_SCRD_sub_category_id` (`sub_category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
 