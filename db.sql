-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 26, 2018 at 12:56 AM
-- Server version: 5.6.33-0ubuntu0.14.04.1
-- PHP Version: 5.6.31-6+ubuntu14.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `java_test1`
--

-- --------------------------------------------------------

--
-- Table structure for table `language`
--

CREATE TABLE IF NOT EXISTS `language` (
  `id` int(3) unsigned NOT NULL AUTO_INCREMENT,
  `code` varchar(32) NOT NULL,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `language`
--

INSERT INTO `language` (`id`, `code`, `name`) VALUES
(1, 'vn', 'Việt Nam'),
(2, 'en', 'English'),
(3, 'fr', 'French'),
(5, 'ir', 'IRAQ'),
(6, 'ab', 'AB language');

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE IF NOT EXISTS `news` (
  `news_id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(256) NOT NULL,
  `description` longtext CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `image_name` int(11) DEFAULT NULL,
  `body` longtext NOT NULL,
  `enabled` tinyint(1) NOT NULL DEFAULT '0',
  `created` int(11) DEFAULT NULL,
  `updated` int(11) DEFAULT NULL,
  PRIMARY KEY (`news_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`news_id`, `title`, `description`, `image_name`, `body`, `enabled`, `created`, `updated`) VALUES
(1, 'Title updated', 'Description updated -- tô đậm', NULL, '<p>Body Update again <strong>T&ocirc; đậm l&ecirc;n ph&aacute;t coi n&agrave;o<br />\r\n<span class="marker">C&ograve;n đoạn n&agrave;y m&agrave;u đỏ m&agrave; kh&ocirc;ng được</span></strong></p>\r\n', 1, 2147483647, 1516900502),
(2, 'Title2', 'DESC2', NULL, 'Body2', 1, 2147483647, 2147483647),
(3, 'Title3', 'DESC2', NULL, 'Body2', 1, 2147483647, 2147483647);

-- --------------------------------------------------------

--
-- Table structure for table `persistent_logins`
--

CREATE TABLE IF NOT EXISTS `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role_id` bigint(20) NOT NULL,
  `code` varchar(30) NOT NULL,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `ROLE_UK` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `code`, `name`) VALUES
(1, 'ROLE_ADMIN', ''),
(2, 'ROLE_USER', '');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `user_id` bigint(20) NOT NULL,
  `user_name` varchar(36) NOT NULL,
  `encryted_password` varchar(128) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `email` varchar(265) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `USER_UK` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `encryted_password`, `enabled`, `email`) VALUES
(1, 'admin', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', b'1', 'admin@example.com'),
(2, 'user', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', b'1', 'user@example.com');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE IF NOT EXISTS `user_role` (
  `id` bigint(20) NOT NULL,
  `user_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `USER_ROLE_UK` (`user_id`,`role_id`),
  KEY `USER_ROLE_FK2` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`id`, `user_id`, `role_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 2);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `USER_ROLE_FK1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `USER_ROLE_FK2` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);
