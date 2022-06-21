-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 21, 2022 at 04:55 AM
-- Server version: 10.4.19-MariaDB
-- PHP Version: 7.3.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bookrent`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` varchar(100) NOT NULL,
  `address` text DEFAULT NULL,
  `village` varchar(40) DEFAULT '',
  `sub_district` varchar(40) DEFAULT '',
  `city` varchar(40) DEFAULT '',
  `zip_code` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `address`, `village`, `sub_district`, `city`, `zip_code`) VALUES
('20220618000011655536811868H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655536862810H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655536862904C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655536899107H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655536899155C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655536964729H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655536964759C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655537041306H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655537041410C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655537176079H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655537176126C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655537218193H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655537218268C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655537278256H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655537278335C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655537319342H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655537319430C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655537359238H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655537359294C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655537373908H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655537374004C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655537401903H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655537401928C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655537435678H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655537435686C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655566461709H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655566461893C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655566791094H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655566791287C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655566840922H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655566840994C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655567011587H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655567011735C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655567206620H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655567206784C', NULL, NULL, NULL, NULL, NULL),
('20220618000011655567436677H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220618000011655567436843C', NULL, NULL, NULL, NULL, NULL),
('20220619000001655622611704H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220619000001655622611737C', NULL, NULL, NULL, NULL, NULL),
('20220619000011655602939379H', 'Jl. Mampang Prapatan XIV No.30', 'Tegal Parang', 'Mampang Prapatan', 'Padang', 25173),
('20220619000011655602939473C', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE `book` (
  `code` varchar(100) NOT NULL,
  `title` varchar(225) DEFAULT NULL,
  `writer` int(11) DEFAULT NULL,
  `publisher` int(11) DEFAULT NULL,
  `publish_city` varchar(100) DEFAULT NULL,
  `pages_number` int(11) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `book_type` int(11) DEFAULT NULL,
  `publish_year` int(11) DEFAULT NULL,
  `publish_month` int(11) DEFAULT NULL,
  `bookshelf` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`code`, `title`, `writer`, `publisher`, `publish_city`, `pages_number`, `stock`, `book_type`, `publish_year`, `publish_month`, `bookshelf`) VALUES
('Y00KKH', 'SENI MELUPAKAN', NULL, NULL, 'PADANG', 0, 3, NULL, 0, 0, NULL),
('Y00KPH', 'SENI BELADIRI', NULL, NULL, 'PADANG', 0, 6, NULL, 0, 0, NULL),
('Y00KSH', 'SENI UNTUK MENGINGAT', NULL, NULL, NULL, 0, 0, NULL, 0, 0, NULL),
('Y00KYH', 'SENI TIDUR', NULL, NULL, 'PADANG', 0, 0, NULL, 0, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `bookshelf`
--

CREATE TABLE `bookshelf` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `line` int(11) DEFAULT NULL,
  `column` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bookshelf`
--

INSERT INTO `bookshelf` (`id`, `name`, `line`, `column`) VALUES
(7, 'MATAHRI', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `book_category`
--

CREATE TABLE `book_category` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `book_category`
--

INSERT INTO `book_category` (`id`, `name`) VALUES
(1, 'KOMIK'),
(2, 'NOVEL'),
(4, 'SEJARAH'),
(5, 'TEKNOLOGI'),
(6, 'ILMU PENGETAHUAN ALAM');

-- --------------------------------------------------------

--
-- Table structure for table `borrowing_books`
--

CREATE TABLE `borrowing_books` (
  `booking_code` varchar(100) NOT NULL,
  `booking_date` timestamp NULL DEFAULT current_timestamp(),
  `return_date` datetime DEFAULT NULL,
  `date_created` timestamp NULL DEFAULT current_timestamp(),
  `update_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `member_number` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `borrowing_books`
--

INSERT INTO `borrowing_books` (`booking_code`, `booking_date`, `return_date`, `date_created`, `update_date`, `member_number`) VALUES
('1655630841493', NULL, '2022-06-26 16:27:21', '2022-06-19 09:27:21', '2022-06-19 09:27:21', '2022061900000'),
('1655631606116', NULL, '2022-06-26 16:40:06', '2022-06-19 09:40:06', '2022-06-19 09:40:06', '2022061900000'),
('1655631638681', NULL, '2022-06-26 16:40:38', '2022-06-19 09:40:38', '2022-06-19 09:40:38', '2022061900000'),
('1655631905363', NULL, '2022-06-26 16:45:05', '2022-06-19 09:45:05', '2022-06-19 09:45:05', '2022061900000'),
('1655632072511', NULL, '2022-06-26 16:47:52', '2022-06-19 09:47:52', '2022-06-19 09:47:52', '2022061900000'),
('1655632218117', NULL, '2022-06-26 16:50:18', '2022-06-19 09:50:18', '2022-06-19 09:50:18', '2022061900000'),
('1655632258559', NULL, '2022-06-26 16:50:58', '2022-06-19 09:50:58', '2022-06-19 09:50:58', '2022061900000'),
('1655632302969', NULL, '2022-06-26 16:51:42', '2022-06-19 09:51:42', '2022-06-19 09:51:42', '2022061900000'),
('1655632397295', NULL, '2022-06-26 16:53:17', '2022-06-19 09:53:17', '2022-06-19 09:53:17', '2022061900000'),
('1655632858205', NULL, '2022-06-26 17:00:58', '2022-06-19 10:00:58', '2022-06-19 10:00:58', '2022061900000'),
('1655633114790', '2022-06-19 10:05:14', '2022-06-10 00:00:00', '2022-06-19 10:05:14', '2022-06-19 11:56:54', '2022061900000'),
('1655635046849', '2022-06-19 10:37:26', '2022-06-26 00:00:00', '2022-06-19 10:37:26', '2022-06-19 10:37:26', '2022061900000'),
('1655637070586', '2022-06-19 11:11:10', '2022-06-26 00:00:00', '2022-06-19 11:11:10', '2022-06-19 11:11:10', '2022061900000'),
('1655637078838', '2022-06-19 11:11:18', '2022-06-26 00:00:00', '2022-06-19 11:11:18', '2022-06-19 11:11:18', '2022061900000'),
('1655637123306', '2022-06-19 11:12:03', '2022-06-26 00:00:00', '2022-06-19 11:12:03', '2022-06-19 11:12:03', '2022061900000'),
('1655641076986', '2022-06-19 12:17:57', '2022-06-26 00:00:00', '2022-06-19 12:17:57', '2022-06-19 12:17:57', '2022061900000'),
('1655641520775', '2022-06-19 12:25:20', '2022-06-26 00:00:00', '2022-06-19 12:25:20', '2022-06-19 12:25:20', '2022061900000'),
('1655691748574', '2022-06-20 02:22:28', '2022-06-27 00:00:00', '2022-06-20 02:22:28', '2022-06-20 02:22:28', '2022061900000'),
('1655691799079', '2022-06-20 02:23:19', '2022-06-27 00:00:00', '2022-06-20 02:23:19', '2022-06-20 02:23:19', '2022061900000'),
('1655691995194', '2022-06-20 02:26:35', '2022-06-27 00:00:00', '2022-06-20 02:26:35', '2022-06-20 02:26:35', '2022061900000'),
('1655692041042', '2022-06-20 02:27:21', '2022-06-27 00:00:00', '2022-06-20 02:27:21', '2022-06-20 02:27:21', '2022061900000'),
('1655695060873', '2022-06-20 03:17:40', '2022-06-27 00:00:00', '2022-06-20 03:17:40', '2022-06-20 03:17:40', '2022061900000');

-- --------------------------------------------------------

--
-- Table structure for table `borrowing_books_return_books`
--

CREATE TABLE `borrowing_books_return_books` (
  `booking_books_booking_code` varchar(255) NOT NULL,
  `return_books_book_code` varchar(255) NOT NULL,
  `return_books_booking_code` varchar(255) NOT NULL,
  `borrowing_books_booking_code` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `borrowing_books_return_books`
--

INSERT INTO `borrowing_books_return_books` (`booking_books_booking_code`, `return_books_book_code`, `return_books_booking_code`, `borrowing_books_booking_code`) VALUES
('1655630841493', 'Y00KKH', '1655630841493', ''),
('1655632302969', 'Y00KKH', '1655632302969', ''),
('1655632397295', 'Y00KKH', '1655632397295', ''),
('1655632858205', 'Y00KKH', '1655632858205', ''),
('1655633114790', 'Y00KKH', '1655633114790', ''),
('1655635046849', 'Y00KKH', '1655635046849', ''),
('1655637123306', 'Y00KKH', '1655637123306', ''),
('1655641076986', 'Y00KKH', '1655641076986', ''),
('1655641520775', 'Y00KKH', '1655641520775', ''),
('1655691748574', 'Y00KKH', '1655691748574', ''),
('1655691799079', 'Y00KKH', '1655691799079', ''),
('1655691995194', 'Y00KKH', '1655691995194', ''),
('1655692041042', 'Y00KKH', '1655692041042', ''),
('1655695060873', 'Y00KKH', '1655695060873', ''),
('1655630841493', 'Y00KPH', '1655630841493', ''),
('1655631606116', 'Y00KPH', '1655631606116', ''),
('1655631638681', 'Y00KPH', '1655631638681', ''),
('1655631905363', 'Y00KPH', '1655631905363', ''),
('1655632072511', 'Y00KPH', '1655632072511', ''),
('1655632218117', 'Y00KPH', '1655632218117', ''),
('1655632258559', 'Y00KPH', '1655632258559', ''),
('1655632302969', 'Y00KPH', '1655632302969', ''),
('1655632397295', 'Y00KPH', '1655632397295', ''),
('1655632858205', 'Y00KPH', '1655632858205', ''),
('1655633114790', 'Y00KPH', '1655633114790', ''),
('1655635046849', 'Y00KPH', '1655635046849', ''),
('1655637070586', 'Y00KPH', '1655637070586', ''),
('1655637078838', 'Y00KPH', '1655637078838', ''),
('1655637123306', 'Y00KPH', '1655637123306', ''),
('1655641076986', 'Y00KPH', '1655641076986', ''),
('1655641520775', 'Y00KPH', '1655641520775', ''),
('1655691748574', 'Y00KPH', '1655691748574', ''),
('1655691799079', 'Y00KPH', '1655691799079', ''),
('1655691995194', 'Y00KPH', '1655691995194', ''),
('1655692041042', 'Y00KPH', '1655692041042', ''),
('1655695060873', 'Y00KPH', '1655695060873', '');

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(8);

-- --------------------------------------------------------

--
-- Table structure for table `identity_type`
--

CREATE TABLE `identity_type` (
  `id` int(11) NOT NULL,
  `name` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `identity_type`
--

INSERT INTO `identity_type` (`id`, `name`) VALUES
(1, 'KTP'),
(2, 'KITAS'),
(3, 'SIM'),
(4, 'Kartu Pelajar');

-- --------------------------------------------------------

--
-- Table structure for table `job_category`
--

CREATE TABLE `job_category` (
  `job_code` varchar(10) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `job_desc`
--

CREATE TABLE `job_desc` (
  `id` varchar(100) NOT NULL,
  `institute_name` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `institute_phone` varchar(100) DEFAULT NULL,
  `job` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `job_desc`
--

INSERT INTO `job_desc` (`id`, `institute_name`, `address`, `institute_phone`, `job`) VALUES
('20220618000011655536862911', NULL, '20220618000011655536862904C', NULL, NULL),
('20220618000011655536899164', NULL, '20220618000011655536899155C', NULL, NULL),
('20220618000011655536964766', NULL, '20220618000011655536964759C', NULL, NULL),
('20220618000011655537041418', NULL, '20220618000011655537041410C', NULL, NULL),
('20220618000011655537176133', NULL, '20220618000011655537176126C', NULL, NULL),
('20220618000011655537218275', NULL, '20220618000011655537218268C', NULL, NULL),
('20220618000011655537278343', NULL, '20220618000011655537278335C', NULL, NULL),
('20220618000011655537319437', NULL, '20220618000011655537319430C', NULL, NULL),
('20220618000011655537359302', NULL, '20220618000011655537359294C', NULL, NULL),
('20220618000011655537374011', NULL, '20220618000011655537374004C', NULL, NULL),
('20220618000011655537401935', NULL, '20220618000011655537401928C', NULL, NULL),
('20220618000011655537435691', NULL, '20220618000011655537435686C', NULL, NULL),
('20220618000011655566461907', NULL, '20220618000011655566461893C', NULL, NULL),
('20220618000011655566791301', NULL, '20220618000011655566791287C', NULL, NULL),
('20220618000011655566841011', NULL, '20220618000011655566840994C', NULL, NULL),
('20220618000011655567011744', NULL, '20220618000011655567011735C', NULL, NULL),
('20220618000011655567206799', NULL, '20220618000011655567206784C', NULL, NULL),
('20220618000011655567436868', NULL, '20220618000011655567436843C', NULL, NULL),
('20220619000001655622611744', NULL, '20220619000001655622611737C', NULL, NULL),
('20220619000011655602939481', NULL, '20220619000011655602939473C', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `librarian`
--

CREATE TABLE `librarian` (
  `nip` varchar(16) NOT NULL,
  `identity_number` varchar(16) NOT NULL,
  `full_name` int(100) NOT NULL,
  `position` varchar(40) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `address` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `member_number` varchar(100) NOT NULL,
  `identity_number` varchar(16) NOT NULL,
  `type_identity` int(11) NOT NULL DEFAULT 1,
  `full_name` varchar(100) NOT NULL,
  `place_of_birth` varchar(40) NOT NULL,
  `gender` int(11) NOT NULL,
  `home_address` varchar(100) NOT NULL,
  `phone_number` varchar(12) NOT NULL,
  `telephone_number` varchar(12) DEFAULT NULL,
  `last_education` int(11) NOT NULL,
  `job` varchar(100) NOT NULL,
  `marital_status` varchar(4) NOT NULL,
  `email` varchar(40) NOT NULL,
  `member_since` datetime NOT NULL,
  `date_of_birth` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`member_number`, `identity_number`, `type_identity`, `full_name`, `place_of_birth`, `gender`, `home_address`, `phone_number`, `telephone_number`, `last_education`, `job`, `marital_status`, `email`, `member_since`, `date_of_birth`) VALUES
('2022061900000', '1371115204970012', 1, 'Yolanda Parawita', 'Padang', 2, '20220619000001655622611704H', '081267866712', NULL, 5, '20220619000001655622611744', 'SGLE', 'nandanabang@gmail.com', '2022-06-19 14:10:11', '1997-04-12'),
('2022061900001', '1371115204970010', 1, 'Yolanda Parawita', 'Padang', 2, '20220619000011655602939379H', '081267866712', NULL, 5, '20220619000011655602939481', 'SGLE', 'parawitayolanda@gmail.com', '2022-06-19 08:42:19', '1997-04-12');

-- --------------------------------------------------------

--
-- Table structure for table `publisher`
--

CREATE TABLE `publisher` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `publisher`
--

INSERT INTO `publisher` (`id`, `name`) VALUES
(1, 'CEMARA'),
(2, 'DKK'),
(3, 'SUKAFAJAR');

-- --------------------------------------------------------

--
-- Table structure for table `return_books`
--

CREATE TABLE `return_books` (
  `book_code` varchar(255) NOT NULL,
  `booking_code` varchar(255) NOT NULL,
  `penalty_fine` double DEFAULT 0,
  `return_date` varchar(255) DEFAULT NULL,
  `update_date` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `return_books`
--

INSERT INTO `return_books` (`book_code`, `booking_code`, `penalty_fine`, `return_date`, `update_date`) VALUES
('Y00KKH', '1655630841493', NULL, NULL, NULL),
('Y00KKH', '1655632302969', NULL, NULL, NULL),
('Y00KKH', '1655632397295', NULL, NULL, NULL),
('Y00KKH', '1655632858205', NULL, NULL, NULL),
('Y00KKH', '1655633114790', 9000, '2022-06-19 19:18:06', '2022-06-19 12:18:06'),
('Y00KKH', '1655635046849', NULL, NULL, '2022-06-19 10:37:26'),
('Y00KKH', '1655637123306', NULL, NULL, '2022-06-19 11:12:03'),
('Y00KKH', '1655641076986', NULL, NULL, '2022-06-19 12:17:57'),
('Y00KKH', '1655641520775', 0, '2022-06-19 19:26:52', '2022-06-19 12:26:52'),
('Y00KKH', '1655691748574', NULL, NULL, '2022-06-20 02:22:28'),
('Y00KKH', '1655691799079', NULL, NULL, '2022-06-20 02:23:19'),
('Y00KKH', '1655691995194', NULL, NULL, '2022-06-20 02:26:35'),
('Y00KKH', '1655692041042', NULL, NULL, '2022-06-20 02:27:21'),
('Y00KKH', '1655695060873', NULL, NULL, '2022-06-20 03:17:40'),
('Y00KPH', '1655630841493', NULL, NULL, NULL),
('Y00KPH', '1655631606116', NULL, NULL, NULL),
('Y00KPH', '1655631638681', NULL, NULL, NULL),
('Y00KPH', '1655631905363', NULL, NULL, NULL),
('Y00KPH', '1655632072511', NULL, NULL, NULL),
('Y00KPH', '1655632218117', NULL, NULL, NULL),
('Y00KPH', '1655632258559', NULL, NULL, NULL),
('Y00KPH', '1655632302969', NULL, NULL, NULL),
('Y00KPH', '1655632397295', NULL, NULL, NULL),
('Y00KPH', '1655632858205', NULL, NULL, NULL),
('Y00KPH', '1655633114790', 9000, '2022-06-19 19:18:06', '2022-06-19 12:18:06'),
('Y00KPH', '1655635046849', NULL, NULL, '2022-06-19 10:37:26'),
('Y00KPH', '1655637070586', NULL, NULL, '2022-06-19 11:11:10'),
('Y00KPH', '1655637078838', NULL, NULL, '2022-06-19 11:11:18'),
('Y00KPH', '1655637123306', NULL, NULL, '2022-06-19 11:12:03'),
('Y00KPH', '1655641076986', NULL, NULL, '2022-06-19 12:17:57'),
('Y00KPH', '1655641520775', 0, '2022-06-19 19:26:17', '2022-06-19 12:26:17'),
('Y00KPH', '1655691748574', NULL, NULL, '2022-06-20 02:22:28'),
('Y00KPH', '1655691799079', NULL, NULL, '2022-06-20 02:23:19'),
('Y00KPH', '1655691995194', NULL, NULL, '2022-06-20 02:26:35'),
('Y00KPH', '1655692041042', NULL, NULL, '2022-06-20 02:27:21'),
('Y00KPH', '1655695060873', NULL, NULL, '2022-06-20 03:17:40');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `name`) VALUES
(1, 'ROLE_USER');

-- --------------------------------------------------------

--
-- Table structure for table `user_login`
--

CREATE TABLE `user_login` (
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `group_user` varchar(40) NOT NULL,
  `last_login` datetime NOT NULL,
  `date_created` timestamp NOT NULL DEFAULT current_timestamp(),
  `date_updated` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_login`
--

INSERT INTO `user_login` (`username`, `password`, `enabled`, `group_user`, `last_login`, `date_created`, `date_updated`) VALUES
('2022061900000', '$2a$10$1VYrsrtBeamN4XMQ/1Q3Rutey57DjKUk6k9GnceiqA2.do3tiQmHS', b'1', 'MEMBER', '2022-06-19 00:00:00', '2022-06-19 07:10:11', '2022-06-19 07:10:11'),
('2022061900001', '$2a$10$Wc01EImLaoCS9ZP2ln8aMuaSAL0X4jNObLtv0hls3NulcGsxvkaTa', b'1', 'MEMBER', '2022-06-19 00:00:00', '2022-06-19 01:42:19', '2022-06-19 01:42:19');

-- --------------------------------------------------------

--
-- Table structure for table `user_login_roles`
--

CREATE TABLE `user_login_roles` (
  `user_login_username` varchar(255) NOT NULL,
  `roles_role_id` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_login_roles`
--

INSERT INTO `user_login_roles` (`user_login_username`, `roles_role_id`) VALUES
('2022061900001', '1'),
('2022061900000', '1');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `writers`
--

CREATE TABLE `writers` (
  `id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`code`),
  ADD KEY `book_FK` (`book_type`),
  ADD KEY `book_FK_1` (`writer`),
  ADD KEY `book_FK_3` (`publisher`),
  ADD KEY `FK5vytamd1gjfvnp59bwh9hqqca` (`bookshelf`);

--
-- Indexes for table `bookshelf`
--
ALTER TABLE `bookshelf`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `book_category`
--
ALTER TABLE `book_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `borrowing_books`
--
ALTER TABLE `borrowing_books`
  ADD PRIMARY KEY (`booking_code`),
  ADD KEY `booking_books_FK` (`member_number`);

--
-- Indexes for table `borrowing_books_return_books`
--
ALTER TABLE `borrowing_books_return_books`
  ADD UNIQUE KEY `UK_qwsxwu7i8avuwdfko5jf0l6k7` (`return_books_book_code`,`return_books_booking_code`),
  ADD UNIQUE KEY `UK_t41p9rugxf20xo4lb6hkskukj` (`return_books_book_code`,`return_books_booking_code`),
  ADD KEY `FKp6530xqvlp6o4sf7jt8ukxdvl` (`booking_books_booking_code`);

--
-- Indexes for table `identity_type`
--
ALTER TABLE `identity_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `job_category`
--
ALTER TABLE `job_category`
  ADD PRIMARY KEY (`job_code`);

--
-- Indexes for table `job_desc`
--
ALTER TABLE `job_desc`
  ADD PRIMARY KEY (`id`),
  ADD KEY `address` (`address`);

--
-- Indexes for table `librarian`
--
ALTER TABLE `librarian`
  ADD PRIMARY KEY (`nip`),
  ADD UNIQUE KEY `identity_number` (`identity_number`),
  ADD KEY `address` (`address`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_number`),
  ADD UNIQUE KEY `nik` (`identity_number`),
  ADD UNIQUE KEY `identity_number` (`identity_number`),
  ADD KEY `type_identity` (`type_identity`),
  ADD KEY `home_address` (`home_address`),
  ADD KEY `job` (`job`);

--
-- Indexes for table `publisher`
--
ALTER TABLE `publisher`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `return_books`
--
ALTER TABLE `return_books`
  ADD PRIMARY KEY (`book_code`,`booking_code`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `user_login`
--
ALTER TABLE `user_login`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `user_login_roles`
--
ALTER TABLE `user_login_roles`
  ADD KEY `FK3v9gbn2olick5auo72qemr7ho` (`user_login_username`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `writers`
--
ALTER TABLE `writers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bookshelf`
--
ALTER TABLE `bookshelf`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `book_category`
--
ALTER TABLE `book_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `publisher`
--
ALTER TABLE `publisher`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `writers`
--
ALTER TABLE `writers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `book`
--
ALTER TABLE `book`
  ADD CONSTRAINT `FK5vytamd1gjfvnp59bwh9hqqca` FOREIGN KEY (`bookshelf`) REFERENCES `bookshelf` (`id`),
  ADD CONSTRAINT `book_FK` FOREIGN KEY (`book_type`) REFERENCES `book_category` (`id`),
  ADD CONSTRAINT `book_FK_1` FOREIGN KEY (`writer`) REFERENCES `writers` (`id`),
  ADD CONSTRAINT `book_FK_3` FOREIGN KEY (`publisher`) REFERENCES `publisher` (`id`);

--
-- Constraints for table `borrowing_books`
--
ALTER TABLE `borrowing_books`
  ADD CONSTRAINT `booking_books_FK` FOREIGN KEY (`member_number`) REFERENCES `member` (`member_number`);

--
-- Constraints for table `borrowing_books_return_books`
--
ALTER TABLE `borrowing_books_return_books`
  ADD CONSTRAINT `FK4vixqembqdxtjhnj4j6gkjgdj` FOREIGN KEY (`return_books_book_code`,`return_books_booking_code`) REFERENCES `return_books` (`book_code`, `booking_code`),
  ADD CONSTRAINT `FKp6530xqvlp6o4sf7jt8ukxdvl` FOREIGN KEY (`booking_books_booking_code`) REFERENCES `borrowing_books` (`booking_code`);

--
-- Constraints for table `job_desc`
--
ALTER TABLE `job_desc`
  ADD CONSTRAINT `job_desc_ibfk_1` FOREIGN KEY (`address`) REFERENCES `address` (`id`);

--
-- Constraints for table `librarian`
--
ALTER TABLE `librarian`
  ADD CONSTRAINT `librarian_ibfk_1` FOREIGN KEY (`address`) REFERENCES `address` (`id`);

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `identity_fk` FOREIGN KEY (`type_identity`) REFERENCES `identity_type` (`id`),
  ADD CONSTRAINT `member_ibfk_1` FOREIGN KEY (`home_address`) REFERENCES `address` (`id`),
  ADD CONSTRAINT `member_ibfk_3` FOREIGN KEY (`job`) REFERENCES `job_desc` (`id`);

--
-- Constraints for table `user_login_roles`
--
ALTER TABLE `user_login_roles`
  ADD CONSTRAINT `FK3v9gbn2olick5auo72qemr7ho` FOREIGN KEY (`user_login_username`) REFERENCES `user_login` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
