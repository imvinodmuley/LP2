-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2020 at 03:20 PM
-- Server version: 10.4.13-MariaDB
-- PHP Version: 7.2.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `faculty`
--

-- --------------------------------------------------------

--
-- Table structure for table `books`
--

CREATE TABLE `books` (
  `id` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `author` varchar(60) NOT NULL,
  `year` int(4) NOT NULL,
  `book_details` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `books`
--

INSERT INTO `books` (`id`, `email`, `author`, `year`, `book_details`) VALUES
(14, 'sau.kekade@gmail.com', 'A', 2019, 'b');

-- --------------------------------------------------------

--
-- Table structure for table `conference`
--

CREATE TABLE `conference` (
  `id` int(10) NOT NULL,
  `email` varchar(40) NOT NULL,
  `title` varchar(60) NOT NULL,
  `type` varchar(60) NOT NULL,
  `details` varchar(200) NOT NULL,
  `year` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `conference`
--

INSERT INTO `conference` (`id`, `email`, `title`, `type`, `details`, `year`) VALUES
(6, 'sau.kekade@gmail.com', 'b', 'b', 'b', 2018);

-- --------------------------------------------------------

--
-- Table structure for table `journal`
--

CREATE TABLE `journal` (
  `id` int(11) NOT NULL,
  `email` text NOT NULL,
  `title` text NOT NULL,
  `author` text NOT NULL,
  `type` text NOT NULL,
  `description` text NOT NULL,
  `year` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `journal`
--

INSERT INTO `journal` (`id`, `email`, `title`, `author`, `type`, `description`, `year`) VALUES
(21, 'sau.kekade@gmail.com', 'a', 'a', 'a', 'a', 2019),
(22, 'sau.kekade@gmail.com', 'b', 'b', 'b', 'b', 2019);

-- --------------------------------------------------------

--
-- Table structure for table `patent`
--

CREATE TABLE `patent` (
  `id` int(11) NOT NULL,
  `email` varchar(30) NOT NULL,
  `patent_author` varchar(50) NOT NULL,
  `patent_description` varchar(200) NOT NULL,
  `year` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `personal_info`
--

CREATE TABLE `personal_info` (
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phoneno` int(11) NOT NULL,
  `department` varchar(30) NOT NULL,
  `designation` varchar(30) NOT NULL,
  `responsibility` text NOT NULL,
  `area_of_interest` varchar(30) NOT NULL,
  `teaching_experience_year` int(5) NOT NULL,
  `teaching_experience_month` int(2) NOT NULL,
  `industrial_experience_year` int(5) NOT NULL,
  `industrial_experience_month` int(2) NOT NULL,
  `upload_cv` text NOT NULL,
  `upload_photo` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `personal_info`
--

INSERT INTO `personal_info` (`firstname`, `lastname`, `email`, `phoneno`, `department`, `designation`, `responsibility`, `area_of_interest`, `teaching_experience_year`, `teaching_experience_month`, `industrial_experience_year`, `industrial_experience_month`, `upload_cv`, `upload_photo`) VALUES
('Sourabh', 'Kekade', 'sau.kekade@gmail.com', 2147483647, '2', 'Student', 'Na', 'Na', 1, 1, 11, 1, '', '');

-- --------------------------------------------------------

--
-- Table structure for table `qualification`
--

CREATE TABLE `qualification` (
  `id` int(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `degree` varchar(30) NOT NULL,
  `specialization` varchar(50) NOT NULL,
  `college` text NOT NULL,
  `university` varchar(50) NOT NULL,
  `year_of_passing` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `qualification`
--

INSERT INTO `qualification` (`id`, `email`, `degree`, `specialization`, `college`, `university`, `year_of_passing`) VALUES
(24, 'sau.kekade@gmail.com', 'PHD', 'Computer', 'PICT', 'Sppu', 2020),
(25, 'sau.kekade@gmail.com', 'ME/M.Tech', 'COmp', 'PICT', 'SPPU', 2018),
(26, 'sau.kekade@gmail.com', 'BE/B.Tech', 'Comp', 'PICT', 'SPPU', 2015);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books`
--
ALTER TABLE `books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `conference`
--
ALTER TABLE `conference`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `journal`
--
ALTER TABLE `journal`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `patent`
--
ALTER TABLE `patent`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `personal_info`
--
ALTER TABLE `personal_info`
  ADD PRIMARY KEY (`email`(30));

--
-- Indexes for table `qualification`
--
ALTER TABLE `qualification`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books`
--
ALTER TABLE `books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `conference`
--
ALTER TABLE `conference`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `journal`
--
ALTER TABLE `journal`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `patent`
--
ALTER TABLE `patent`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `qualification`
--
ALTER TABLE `qualification`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
