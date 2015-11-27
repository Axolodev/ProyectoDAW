-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-11-2015 a las 19:01:48
-- Versión del servidor: 10.1.8-MariaDB
-- Versión de PHP: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `javadb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `candidato`
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE `empleado` (
  `id` int(11) NOT NULL,
  `idCandidato` int(11) DEFAULT NULL,
  `salario` int(11) DEFAULT NULL,
  `diasVacaciones` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrevista`
--

CREATE TABLE `entrevista` (
  `id` int(11) NOT NULL,
  `idCandidato` int(11) DEFAULT NULL,
  `idUsuario` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `plataforma` varchar(70) DEFAULT NULL,
  `feedback` varchar(400) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(120) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `viewentrevista`
--
CREATE TABLE `viewentrevista` (
`nombreCandidato` varchar(120)
,`nombreUsuario` varchar(120)
,`puesto` varchar(100)
,`fecha` date
,`plataforma` varchar(70)
,`feedback` varchar(400)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `viewreporte`
--
CREATE TABLE `viewreporte` (
`nombre` varchar(120)
,`titulo` varchar(100)
,`certificados` varchar(400)
,`puesto` varchar(100)
,`entrevistador` varchar(120)
,`tipo` varchar(9)
);

-- --------------------------------------------------------

--
-- Estructura Stand-in para la vista `vistaempleado`
--
CREATE TABLE `vistaempleado` (
`nombre` varchar(120)
,`email` varchar(100)
,`telefono` int(11)
,`direccion` varchar(500)
,`titulo` varchar(100)
,`universidad` varchar(100)
,`certificados` varchar(400)
,`puesto` varchar(100)
,`salario` int(11)
,`diasVacaciones` int(11)
);

-- --------------------------------------------------------

--
-- Estructura para la vista `viewentrevista`
--
DROP TABLE IF EXISTS `viewentrevista`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewentrevista`  AS  select `a`.`nombre` AS `nombreCandidato`,`b`.`nombre` AS `nombreUsuario`,`a`.`puesto` AS `puesto`,`c`.`fecha` AS `fecha`,`c`.`plataforma` AS `plataforma`,`c`.`feedback` AS `feedback` from ((`candidato` `a` join `usuario` `b`) join `entrevista` `c`) where ((`c`.`idCandidato` = `a`.`id`) and (`c`.`idUsuario` = `b`.`id`)) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `viewreporte`
--
DROP TABLE IF EXISTS `viewreporte`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viewreporte`  AS  select `a`.`nombre` AS `nombre`,`a`.`titulo` AS `titulo`,`a`.`certificados` AS `certificados`,`a`.`puesto` AS `puesto`,`c`.`nombre` AS `entrevistador`,(case when `a`.`id` in (select `b`.`idCandidato` from `empleado`) then 'empleado' else 'candidato' end) AS `tipo` from (((`candidato` `a` join `empleado` `b`) join `usuario` `c`) join `entrevista` `d`) ;

-- --------------------------------------------------------

--
-- Estructura para la vista `vistaempleado`
--
DROP TABLE IF EXISTS `vistaempleado`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `vistaempleado`  AS  select `b`.`nombre` AS `nombre`,`b`.`email` AS `email`,`b`.`telefono` AS `telefono`,`b`.`direccion` AS `direccion`,`b`.`titulo` AS `titulo`,`b`.`universidad` AS `universidad`,`b`.`certificados` AS `certificados`,`b`.`puesto` AS `puesto`,`a`.`salario` AS `salario`,`a`.`diasVacaciones` AS `diasVacaciones` from (`empleado` `a` join `candidato` `b`) where (`a`.`idCandidato` = `b`.`id`) ;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `candidato`
--
ALTER TABLE `candidato`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCandidato` (`idCandidato`);

--
-- Indices de la tabla `entrevista`
--
ALTER TABLE `entrevista`
  ADD PRIMARY KEY (`id`),
  ADD KEY `idCandidato` (`idCandidato`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `empleado`
--
ALTER TABLE `empleado`
  ADD CONSTRAINT `empleado_ibfk_1` FOREIGN KEY (`idCandidato`) REFERENCES `candidato` (`id`);

--
-- Filtros para la tabla `entrevista`
--
ALTER TABLE `entrevista`
  ADD CONSTRAINT `entrevista_ibfk_1` FOREIGN KEY (`idCandidato`) REFERENCES `candidato` (`id`),
  ADD CONSTRAINT `entrevista_ibfk_2` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
