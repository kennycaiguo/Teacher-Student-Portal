-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 15, 2019 at 02:40 PM
-- Server version: 10.1.37-MariaDB
-- PHP Version: 7.3.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `student_portal`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `EMAIL` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `NAME` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`EMAIL`, `PASSWORD`, `NAME`) VALUES
('admin@gmail.com', 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--
-- Error reading structure for table student_portal.class: #1932 - Table 'student_portal.class' doesn't exist in engine
-- Error reading data for table student_portal.class: #1064 - You have an error in your SQL syntax; check the manual that corresponds to your MariaDB server version for the right syntax to use near 'FROM `student_portal`.`class`' at line 1

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `COU_ID` varchar(20) NOT NULL,
  `COU_TITLE` varchar(20) NOT NULL,
  `COU_DESC` varchar(20) NOT NULL,
  `COU_CREDIT` varchar(20) NOT NULL,
  `DEP_ID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`COU_ID`, `COU_TITLE`, `COU_DESC`, `COU_CREDIT`, `DEP_ID`) VALUES
('111', 'Network Programming', 'JAVA Sevlet', '3', '100'),
('112', 'Pattern Recognition ', 'SVM', '3', '100'),
('113', 'Computer Graphics', 'Fragment Shader', '3', '100'),
('221', 'Basic Electronics', 'Circuit ', '3', '200'),
('771', 'Basic Drawing', 'Free Hand Drawing', '3', '700'),
('881', 'Basic English', 'Phonetics', '3', '800');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `dep_id` varchar(20) NOT NULL,
  `dep_name` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dep_id`, `dep_name`) VALUES
('100', 'CSE'),
('1000', 'Chemical'),
('200', 'EEE'),
('300', 'Civil'),
('400', 'Mechanical'),
('500', 'IPE'),
('600', 'Textile'),
('700', 'Architecture'),
('800', 'English'),
('900', 'XYZ');

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `GRADE` varchar(20) NOT NULL,
  `STU_ID` varchar(20) NOT NULL,
  `CLA_ID` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`GRADE`, `STU_ID`, `CLA_ID`) VALUES
('a+', '007', '501'),
('a+', '102', '450');

-- --------------------------------------------------------

--
-- Table structure for table `instructor`
--

CREATE TABLE `instructor` (
  `INS_ID` varchar(20) NOT NULL,
  `INS_FIRST_NAME` varchar(20) NOT NULL,
  `INS_LAST_NAME` varchar(20) NOT NULL,
  `INS_DOB` varchar(20) NOT NULL,
  `INS_SEX` varchar(20) NOT NULL,
  `INS_ADDRESS` varchar(20) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `DEP_ID` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  `INS_PHONE` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `instructor`
--

INSERT INTO `instructor` (`INS_ID`, `INS_FIRST_NAME`, `INS_LAST_NAME`, `INS_DOB`, `INS_SEX`, `INS_ADDRESS`, `EMAIL`, `DEP_ID`, `PASSWORD`, `INS_PHONE`) VALUES
('201', 'Tonmoy', 'Banik', '2-2-1978', 'female', 'Sylhet', 'tonmoy@yahoo.com', '100', 'tonmoy', '01645332843'),
('202', 'Durzoy', 'Roy', '2-2-1978', 'male', 'Hobigonj', 'durzoy@hotmail.com', '100', 'durzoy', '01844768854'),
('203', 'Ashraful', 'Islam', '5-7-1996', 'male', 'Dhaka', 'sohag@gmail.com', '100', 'sohag', '01913456612'),
('204', 'Gennady', 'Kortokorevich', '25-07-1994', 'male', 'Belarush, Russia', 'tourist@gmail.com', '100', 'tourist', '9999');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `STU_ID` varchar(20) NOT NULL,
  `STU_FIRST_NAME` varchar(20) NOT NULL,
  `STU_LAST_NAME` varchar(20) NOT NULL,
  `STU_DOB` varchar(20) NOT NULL,
  `STU_SEX` varchar(20) NOT NULL,
  `STU_ADDRESS` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  `STU_PHONE` varchar(20) NOT NULL,
  `INS_ID` varchar(20) NOT NULL,
  `DEP_ID` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`STU_ID`, `STU_FIRST_NAME`, `STU_LAST_NAME`, `STU_DOB`, `STU_SEX`, `STU_ADDRESS`, `EMAIL`, `STU_PHONE`, `INS_ID`, `DEP_ID`, `PASSWORD`) VALUES
('007', 'Atik', 'Ch', '2-2-1994', 'male', 'Farmgate, Tejgaon collegeroad-1012', 'atik@gmail.com', '01946374251', '204', '100', 'student'),
('102', 'Nitol Das', 'Neel', '2-2-1978', 'male', 'Banani', 'nitoldasneel@yahoo.com', '01718090035', '202', '100', 'nitol'),
('103', 'Robin', 'Ahmed', '2-2-1978', 'male', 'Mohanagar', 'robin@gmail.com', '01711345664', '201', '100', 'robin'),
('104', 'Galib', 'Ahmed', '4-3-1990', 'male', 'Niketon', 'galib@gmail.com', '01714110967', '202', '100', 'galib'),
('105', 'Rumman', 'Ali', '4-1-1995', 'male', 'Dhaka', 'rumman@gmail.com', '01713223345', '203', '100', 'rumman'),
('220', 'Galib', 'Asadullahhil', '4-4-96', 'male', 'niketon', 'galib@gmail.com', '0987665', '203', '100', 'galib');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`COU_ID`),
  ADD UNIQUE KEY `COURSE_PK` (`COU_ID`),
  ADD KEY `DEP_CLA_FK` (`DEP_ID`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dep_id`),
  ADD UNIQUE KEY `DEPARTMENT_PK` (`dep_id`);

--
-- Indexes for table `instructor`
--
ALTER TABLE `instructor`
  ADD PRIMARY KEY (`INS_ID`),
  ADD UNIQUE KEY `INSTRUCTOR_PK` (`INS_ID`),
  ADD KEY `DEP_INS_FK` (`DEP_ID`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`STU_ID`),
  ADD UNIQUE KEY `STUDENT_PK` (`STU_ID`),
  ADD KEY `DEP_STU_FK` (`DEP_ID`),
  ADD KEY `INS_STU_FK` (`INS_ID`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `DEP_CLA_FK` FOREIGN KEY (`DEP_ID`) REFERENCES `department` (`DEP_ID`) ON DELETE CASCADE;

--
-- Constraints for table `instructor`
--
ALTER TABLE `instructor`
  ADD CONSTRAINT `DEP_INS_FK` FOREIGN KEY (`DEP_ID`) REFERENCES `department` (`DEP_ID`) ON DELETE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `DEP_STU_FK` FOREIGN KEY (`DEP_ID`) REFERENCES `department` (`DEP_ID`) ON DELETE CASCADE,
  ADD CONSTRAINT `INS_STU_FK` FOREIGN KEY (`INS_ID`) REFERENCES `instructor` (`INS_ID`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
