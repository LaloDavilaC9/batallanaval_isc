-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 06, 2022 at 05:50 PM
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

-- --------------------------------------------------------

--
-- Table structure for table `barco`
--

CREATE TABLE `barco` (
  `id_barco` int(11) NOT NULL,
  `casillas` int(11) NOT NULL,
  `posx` int(11) NOT NULL,
  `posy` int(11) NOT NULL,
  `vivo` int(11) NOT NULL,
  `num_jug` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barco`
--

INSERT INTO `barco` (`id_barco`, `casillas`, `posx`, `posy`, `vivo`, `num_jug`) VALUES
(1, 2, 0, 0, 1, 1),
(1, 2, 0, 1, 1, 1);

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
(2, 'david@gmail.com', 'adrian@gmail.com', 0),
(5, 'adrian@gmail.com', 'david@gmail.com', 0);

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

-- --------------------------------------------------------

--
-- Table structure for table `tablero1`
--

CREATE TABLE `tablero1` (
  `indice` int(11) NOT NULL,
  `col1` int(11) DEFAULT NULL,
  `col2` int(11) DEFAULT NULL,
  `col3` int(11) DEFAULT NULL,
  `col4` int(11) DEFAULT NULL,
  `col5` int(11) DEFAULT NULL,
  `col6` int(11) DEFAULT NULL,
  `col7` int(11) DEFAULT NULL,
  `col8` int(11) DEFAULT NULL,
  `col9` int(11) DEFAULT NULL,
  `col10` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tablero1`
--

INSERT INTO `tablero1` (`indice`, `col1`, `col2`, `col3`, `col4`, `col5`, `col6`, `col7`, `col8`, `col9`, `col10`) VALUES
(0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0),
(1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0),
(2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `tablero2`
--

CREATE TABLE `tablero2` (
  `indice` int(11) NOT NULL,
  `col1` int(11) DEFAULT NULL,
  `col2` int(11) DEFAULT NULL,
  `col3` int(11) DEFAULT NULL,
  `col4` int(11) DEFAULT NULL,
  `col5` int(11) DEFAULT NULL,
  `col6` int(11) DEFAULT NULL,
  `col7` int(11) DEFAULT NULL,
  `col8` int(11) DEFAULT NULL,
  `col9` int(11) DEFAULT NULL,
  `col10` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tablero2`
--

INSERT INTO `tablero2` (`indice`, `col1`, `col2`, `col3`, `col4`, `col5`, `col6`, `col7`, `col8`, `col9`, `col10`) VALUES
(1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(7, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
(10, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ataques`
--
ALTER TABLE `ataques`
  ADD PRIMARY KEY (`indice`),
  ADD KEY `no_jugada` (`no_jugada`);

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
-- Indexes for table `tablero1`
--
ALTER TABLE `tablero1`
  ADD PRIMARY KEY (`indice`);

--
-- Indexes for table `tablero2`
--
ALTER TABLE `tablero2`
  ADD PRIMARY KEY (`indice`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ataques`
--
ALTER TABLE `ataques`
  MODIFY `indice` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `invitacion`
--
ALTER TABLE `invitacion`
  MODIFY `id_invitacion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `jugada`
--
ALTER TABLE `jugada`
  MODIFY `numero_jugada` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id_jugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `tablero1`
--
ALTER TABLE `tablero1`
  MODIFY `indice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=78;

--
-- AUTO_INCREMENT for table `tablero2`
--
ALTER TABLE `tablero2`
  MODIFY `indice` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `ataques`
--
ALTER TABLE `ataques`
  ADD CONSTRAINT `ataques_ibfk_1` FOREIGN KEY (`no_jugada`) REFERENCES `jugada` (`numero_jugada`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
