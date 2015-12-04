-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 04, 2015 at 06:32 AM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javadb`
--

-- --------------------------------------------------------

--
-- Table structure for table `candidato`
--

CREATE TABLE `candidato` (
  `id` int(11) NOT NULL,
  `nombre` varchar(120) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` int(11) DEFAULT NULL,
  `direccion` varchar(500) DEFAULT NULL,
  `puesto` varchar(100) DEFAULT NULL,
  `estudios` varchar(120) DEFAULT NULL,
  `universidad` varchar(100) DEFAULT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `certificados` varchar(400) DEFAULT NULL,
  `experiencia` int(11) DEFAULT NULL,
  `puestoAnterior` varchar(120) DEFAULT NULL,
  `expectativaSalario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `candidato`
--

INSERT INTO `candidato` (`id`, `nombre`, `email`, `telefono`, `direccion`, `puesto`, `estudios`, `universidad`, `titulo`, `certificados`, `experiencia`, `puestoAnterior`, `expectativaSalario`) VALUES
(3, 'Roberto Ruiz', 'rroberto.rruiz@gmail.com', 123, 'Cerro de las mitras 235\r\nLas puentes 1er sector', 'dsafasd', 'fdsaf', 'fd', 'fd', 'f', 32, 'ff', 2323),
(5, 'Mayra Ruiz', 'Mey@gmi.com', 9319319, 'Monterrey NL', 'Todos', 'abcd', 'asfdfd', 'abcc', 'gaga', 31, 'CEO', 313131);

-- --------------------------------------------------------

--
-- Table structure for table `empleado`
--

CREATE TABLE `empleado` (
  `id` int(11) NOT NULL,
  `idCandidato` int(11) DEFAULT NULL,
  `salario` int(11) DEFAULT NULL,
  `diasVacaciones` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `empleado`
--

INSERT INTO `empleado` (`id`, `idCandidato`, `salario`, `diasVacaciones`) VALUES
(2, 5, 13131, 155321512);

-- --------------------------------------------------------

--
-- Table structure for table `entrevista`
--

CREATE TABLE `entrevista` (
  `id` int(11) NOT NULL,
  `idCandidato` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `plataforma` varchar(70) DEFAULT NULL,
  `feedback` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `entrevista`
--

INSERT INTO `entrevista` (`id`, `idCandidato`, `idUsuario`, `fecha`, `plataforma`, `feedback`) VALUES
(8, 3, 1, '1994-04-17', 'fdafdsafas', 'fdsafdasf');

-- --------------------------------------------------------

--
-- Table structure for table `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(120) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `email`, `password`) VALUES
(1, 'Roberto Ruiz', 'rroberto.rruiz@gmail.com', '123');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `candidato`
--
ALTER TABLE `candidato`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `empleado_ibfk_1` (`idCandidato`);

--
-- Indexes for table `entrevista`
--
ALTER TABLE `entrevista`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`),
  ADD KEY `idCandidato` (`idCandidato`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id` (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `candidato`
--
ALTER TABLE `candidato`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `empleado`
--
ALTER TABLE `empleado`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `entrevista`
--
ALTER TABLE `entrevista`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`idCandidato`) REFERENCES `candidato` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `entrevista`
--
ALTER TABLE `entrevista`
  ADD CONSTRAINT `entrevista_ibfk_1` FOREIGN KEY (`idCandidato`) REFERENCES `candidato` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `entrevista_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
