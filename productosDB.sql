-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-11-2021 a las 19:58:28
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `productosdb`
--
CREATE DATABASE IF NOT EXISTS `productosdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `productosdb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `catalogo`
--

CREATE TABLE `catalogo` (
  `CODART` int(11) NOT NULL,
  `CATEGORIA` varchar(40) DEFAULT NULL,
  `DENOMINACION` varchar(100) DEFAULT NULL,
  `PRECIO` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `catalogo`
--

INSERT INTO `catalogo` (`CODART`, `CATEGORIA`, `DENOMINACION`, `PRECIO`) VALUES
(1, 'Informática', 'Portatil Asus', 550),
(2, 'Imagen y Sonido', 'Televisor Sony', 700),
(3, 'Imagen y Sonido', 'Televisor Samsung', 650),
(4, 'Telefonia movil', 'IPhone 12', 700),
(5, 'Telefonia movil', 'LG ', 280),
(6, 'Telefonia movil', 'LG G4', 300),
(7, 'Informatica', 'Portatil HP', 700),
(8, 'Informatica', 'Portatil Lenovo', 600),
(21, 'Informatica', 'PcPortatil', 500),
(24, 'INFORMATICA', 'PC PORTATIL', 500),
(28, 'Informatica', 'PcPortatil Juanmi', 500);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nombreUsuario` varchar(100) NOT NULL,
  `passUsuario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nombreUsuario`, `passUsuario`) VALUES
('Juan', '1234');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `catalogo`
--
ALTER TABLE `catalogo`
  ADD PRIMARY KEY (`CODART`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nombreUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
