-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 31, 2024 at 05:12 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `scores`
--

-- --------------------------------------------------------

--
-- Table structure for table `scores_details`
--

CREATE TABLE `scores_details` (
  `name1` varchar(100) NOT NULL,
  `password1` varchar(100) NOT NULL,
  `email1` varchar(100) NOT NULL,
  `number1` varchar(100) NOT NULL,
  `scores` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `scores_details`
--

INSERT INTO `scores_details` (`name1`, `password1`, `email1`, `number1`, `scores`) VALUES
('John Doe', 'password123', 'john@example.com', '1234567890', 85),
('Alice Smith', 'alicepass', 'alice@example.com', '9876543210', 70),
('Bob Johnson', 'bobpassword', 'bob@example.com', '5551234567', 95),
('Emily Davis', 'emilypass', 'emily@example.com', '1112223333', 80);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
