-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 07, 2022 at 07:53 AM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.3.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `batallanaval`
--

-- --------------------------------------------------------

--
-- Table structure for table `ataques`
--

CREATE TABLE `ataques` (
  `indice` int(11) NOT NULL,
  `no_jugada` int(11) NOT NULL,
  `ataqueCertero` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ataques`
--

INSERT INTO `ataques` (`indice`, `no_jugada`, `ataqueCertero`) VALUES
(8, 1, 1),
(9, 2, 1),
(10, 3, 0),
(11, 4, 0);

-- --------------------------------------------------------

--
-- Table structure for table `invitacion`
--

CREATE TABLE `invitacion` (
  `id_invitacion` int(11) NOT NULL,
  `invita` varchar(255) NOT NULL,
  `invitado` varchar(255) NOT NULL,
  `enlazado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `invitacion`
--

INSERT INTO `invitacion` (`id_invitacion`, `invita`, `invitado`, `enlazado`) VALUES
(6, 'adrian@gmail.com', 'david@gmail.com', 1);

-- --------------------------------------------------------

--
-- Table structure for table `jugada`
--

CREATE TABLE `jugada` (
  `numero_jugada` int(11) NOT NULL,
  `turno_jugada` int(11) NOT NULL,
  `pos_x` int(11) NOT NULL,
  `pos_y` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jugada`
--

INSERT INTO `jugada` (`numero_jugada`, `turno_jugada`, `pos_x`, `pos_y`) VALUES
(1, 1, 3, 4),
(2, 2, 5, 7),
(3, 1, 9, 0),
(4, 2, 5, 3);

-- --------------------------------------------------------

--
-- Table structure for table `jugador`
--

CREATE TABLE `jugador` (
  `id_jugador` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `jugador`
--

INSERT INTO `jugador` (`id_jugador`, `nombre`, `correo`, `password`) VALUES
(1, 'ANDRES DAVID', 'david@gmail.com', '1234'),
(2, 'LUIS ADRIÁN', 'adrian@gmail.com', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ataques`
--
ALTER TABLE `ataques`
  ADD PRIMARY KEY (`indice`);

--
-- Indexes for table `invitacion`
--
ALTER TABLE `invitacion`
  ADD PRIMARY KEY (`id_invitacion`);

--
-- Indexes for table `jugada`
--
ALTER TABLE `jugada`
  ADD PRIMARY KEY (`numero_jugada`);

--
-- Indexes for table `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`id_jugador`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ataques`
--
ALTER TABLE `ataques`
  MODIFY `indice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `invitacion`
--
ALTER TABLE `invitacion`
  MODIFY `id_invitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `jugada`
--
ALTER TABLE `jugada`
  MODIFY `numero_jugada` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id_jugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
