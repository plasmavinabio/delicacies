-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jan 26, 2018 at 04:50 PM
-- Server version: 5.6.33-0ubuntu0.14.04.1
-- PHP Version: 5.6.30-7+deb.sury.org~trusty+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `java_test1`
--

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE IF NOT EXISTS `image` (
  `image_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8_unicode_ci NOT NULL,
  `created` int(11) NOT NULL,
  PRIMARY KEY (`image_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=5 ;

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
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `news`
--

INSERT INTO `news` (`news_id`, `title`, `description`, `image_name`, `body`, `enabled`, `created`, `updated`) VALUES
(1, 'Title updated', 'Description updated -- tô đậm', NULL, '<p>Body Update again <strong>T&ocirc; đậm l&ecirc;n ph&aacute;t coi n&agrave;o<br />\r\n<span class="marker">C&ograve;n đoạn n&agrave;y m&agrave;u đỏ m&agrave; kh&ocirc;ng được</span></strong></p>\r\n', 1, 2147483647, 1516900502),
(2, 'Title2', 'DESC2', NULL, 'Body2', 1, 2147483647, 2147483647),
(3, 'Title3', 'DESC2', NULL, 'Body2', 1, 2147483647, 2147483647),
(6, 'Qu''est-ce que le Lorem Ipsum?', 'Le Lorem Ipsum est simplement du faux texte employé dans la composition et la mise en page avant impression. Le Lorem Ipsum est le faux texte standard de l''imprimerie depuis les années 1500, quand un peintre anonyme assembla ensemble des morceaux de texte pour réaliser un livre spécimen de polices de texte. Il n''a pas fait que survivre cinq siècles, mais s''est aussi adapté à la bureautique informatique, sans que son contenu n''en soit modifié. Il a été popularisé dans les années 1960 grâce à la vente de feuilles Letraset contenant des passages du Lorem Ipsum, et, plus récemment, par son inclusion dans des applications de mise en page de texte, comme Aldus PageMaker.', NULL, '<h2>N&oacute; đến từ đ&acirc;u?</h2>\r\n\r\n<p>Tr&aacute;i với quan điểm chung của số đ&ocirc;ng, Lorem Ipsum kh&ocirc;ng phải chỉ l&agrave; một đoạn văn bản ngẫu nhi&ecirc;n. Người ta t&igrave;m thấy nguồn gốc của n&oacute; từ những t&aacute;c phẩm văn học la-tinh cổ điển xuất hiện từ năm 45 trước C&ocirc;ng Nguy&ecirc;n, nghĩa l&agrave; n&oacute; đ&atilde; c&oacute; khoảng hơn 2000 tuổi. Một gi&aacute;o sư của trường Hampden-Sydney College (bang Virginia - Mỹ) quan t&acirc;m tới một trong những từ la-tinh kh&oacute; hiểu nhất, &quot;consectetur&quot;, tr&iacute;ch từ một đoạn của Lorem Ipsum, v&agrave; đ&atilde; nghi&ecirc;n cứu tất cả c&aacute;c ứng dụng của từ n&agrave;y trong văn học cổ điển, để từ đ&oacute; t&igrave;m ra nguồn gốc kh&ocirc;ng thể chối c&atilde;i của Lorem Ipsum. Thật ra, n&oacute; được t&igrave;m thấy trong c&aacute;c đoạn 1.10.32 v&agrave; 1.10.33 của &quot;De Finibus Bonorum et Malorum&quot; (Đỉnh tối thượng của C&aacute;i Tốt v&agrave; C&aacute;i Xấu) viết bởi Cicero v&agrave;o năm 45 trước C&ocirc;ng Nguy&ecirc;n. Cuốn s&aacute;ch n&agrave;y l&agrave; một luận thuyết đạo l&iacute; rất phổ biến trong thời k&igrave; Phục Hưng. D&ograve;ng đầu ti&ecirc;n của Lorem Ipsum, &quot;Lorem ipsum dolor sit amet...&quot; được tr&iacute;ch từ một c&acirc;u trong đoạn thứ 1.10.32.</p>\r\n\r\n<p>Tr&iacute;ch đoạn chuẩn của Lorem Ipsum được sử dụng từ thế kỉ thứ 16 v&agrave; được t&aacute;i bản sau đ&oacute; cho những người quan t&acirc;m đến n&oacute;. Đoạn 1.10.32 v&agrave; 1.10.33 trong cuốn &quot;De Finibus Bonorum et Malorum&quot; của Cicero cũng được t&aacute;i bản lại theo đ&uacute;ng cấu tr&uacute;c gốc, k&egrave;m theo phi&ecirc;n bản tiếng Anh được dịch bởi H. Rackham v&agrave;o năm 1914.</p>\r\n', 1, 1516941820, 1516941820);

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

--
-- Dumping data for table `persistent_logins`
--

INSERT INTO `persistent_logins` (`username`, `series`, `token`, `last_used`) VALUES
('admin', 'heZKlzznsKw51uUZRy1LZQ==', 'jeNaD2kvywCr1Eny/kmacg==', '2018-01-26 09:35:31');

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
