-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2020 at 10:07 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `skool`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `time` int(11) NOT NULL,
  `lecturer_name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`ID`, `name`, `time`, `lecturer_name`) VALUES
(3000, 'Operating Systems', 45, 'Geoffrey WAmbugu'),
(3001, 'Object Oriented Programming', 50, 'Samuel Tully'),
(3002, 'Cooking', 30, 'Jesse Esseinberg'),
(3003, 'Human resource management', 45, 'Lex Luthor'),
(3004, 'Calculus 1', 50, 'Alfred Kamau'),
(3005, 'Linear Algebra', 45, 'Lex Luthor'),
(3006, 'Electricity and Magnetism', 45, 'Alfred kamau'),
(3007, 'Environmental Law', 45, 'Geoffrey Wambugu'),
(3008, 'Structured Programming', 45, 'Jesse Esseinberg'),
(3009, 'Database', 45, 'Muthengi'),
(3010, 'communication', 45, 'Wambugu'),
(3011, 'Data', 45, 'communication'),
(3012, 'Data', 45, 'communication');

-- --------------------------------------------------------

--
-- Table structure for table `lecturer`
--

CREATE TABLE `lecturer` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `idnum` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lecturer`
--

INSERT INTO `lecturer` (`id`, `name`, `idnum`) VALUES
(5000, 'Lex Luthor', 'EB105'),
(5001, 'Geoffrey Wambugu', 'EB104'),
(5002, 'Alfred Kamau', 'EB103'),
(5003, 'Jesse Esseinbug', 'EB102'),
(5004, 'SAmuel Tully', 'EB101'),
(5005, 'MUTHENGI', 'eB107'),
(5008, 'wambugu', 'Eb212'),
(5010, 'Baratheon', 'EB109');

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `ID` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `program` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`ID`, `name`, `program`) VALUES
(1000, 'Kevin Wambugu', 'Computer Science'),
(1001, 'Gregorr Gitau', ' Applied Computer Science'),
(1002, 'Cersi Wanjiku', 'Hotel and Tourism'),
(1003, 'Mercy Ondara', 'Agriculture and something'),
(1004, 'Faith maina', 'pharmacy'),
(1005, 'Jonny Sexton', 'Education'),
(1006, 'George Mwangi', 'Environmental Science'),
(1007, 'Joyce Wanjiru', 'Bachelor of Commerce'),
(1008, 'GLoria  Sanai', 'Nursing'),
(1009, 'Brenda Jemutai', 'Nursing'),
(1011, 'Suzzana', 'Tourism'),
(1012, 'Suzzana', 'Tourism');

-- --------------------------------------------------------

--
-- Table structure for table `take_course`
--

CREATE TABLE `take_course` (
  `course_id` int(11) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `grade` char(1) DEFAULT NULL,
  `lecturer_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `take_course`
--

INSERT INTO `take_course` (`course_id`, `student_id`, `grade`, `lecturer_id`) VALUES
(3000, 1000, NULL, 5001),
(3001, 1000, NULL, 5004),
(3004, 1000, NULL, 5002),
(3008, 1000, 'C', 5003),
(3010, 1000, NULL, 5008),
(3000, 1001, NULL, 5001),
(3001, 1001, 'D', 5004),
(3006, 1001, NULL, 5002),
(3008, 1001, 'B', 5003),
(3010, 1001, NULL, 5008),
(3000, 1000, NULL, 5001),
(3001, 1000, NULL, 5004),
(3004, 1000, NULL, 5002),
(3008, 1000, 'C', 5003),
(3010, 1000, NULL, 5008),
(3002, 1003, 'B', 5003),
(3007, 1003, 'B', 5001),
(3004, 1003, 'B', 5002),
(3008, 1003, 'B', 5003),
(3010, 1003, 'B', 5008),
(3000, 1007, NULL, 5001),
(3001, 1007, 'C', 5004),
(3004, 1007, NULL, 5002),
(3008, 1007, NULL, 5003),
(3010, 1007, NULL, 5008);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `lecturer`
--
ALTER TABLE `lecturer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3013;

--
-- AUTO_INCREMENT for table `lecturer`
--
ALTER TABLE `lecturer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5011;

--
-- AUTO_INCREMENT for table `students`
--
ALTER TABLE `students`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1013;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
