-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-01-2022 a las 20:23:16
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
CREATE DATABASE IF NOT EXISTS `productosdb` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `productosdb`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `catalogo`
--

CREATE TABLE `catalogo` (
  `CODART` int(11) NOT NULL,
  `CATEGORIA` varchar(40) CHARACTER SET utf8mb4 NOT NULL,
  `DENOMINACION` varchar(100) CHARACTER SET utf8mb4 NOT NULL,
  `PRECIO` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `catalogo`
--

INSERT INTO `catalogo` (`CODART`, `CATEGORIA`, `DENOMINACION`, `PRECIO`) VALUES
(1, 'InformÃ¡tica', 'Portatil Asus', 520),
(2, 'Imagen y Sonido', 'Televisor Sony', 700),
(3, 'Imagen y Sonido', 'Televisor Samsung', 650),
(4, 'Telefonia movil', 'IPhone 12', 700),
(5, 'Telefonia movil', 'LG ', 280),
(6, 'Telefonia movil', 'LG G4', 300),
(7, 'Informatica', 'Portatil HP', 700),
(8, 'Informatica', 'Portatil Lenovo', 600),
(21, 'INFORMATICA', 'PC PORTATIL', 500),
(22, 'INFORMATICA', 'PC PORTATIL', 500),
(23, 'INFORMATICA', 'PC PORTATIL', 500),
(25, 'Informática', 'Prueba', 999),
(26, 'Informática', 'Casa', 74),
(27, 'Informática', 'Harold', 12),
(37, 'as', 'as', 6),
(38, 'aw', 'aw', 1212);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `nombre` varchar(100) CHARACTER SET utf8mb4 NOT NULL,
  `password` varchar(100) CHARACTER SET utf8mb4 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `password`) VALUES
(1, 'Marius', '1234'),
(2, 'andress', '1234'),
(3, 'Juan', '1234'),
(4, 'admin', '1234'),
(5, 'Paco', '1234'),
(6, 'Margarita', '1234'),
(7, 'Trini', '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `venta`
--

CREATE TABLE `venta` (
  `idVenta` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL,
  `precio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `venta`
--

INSERT INTO `venta` (`idVenta`, `idUsuario`, `idProducto`, `precio`) VALUES
(2, 3, 1, 550),
(3, 3, 1, 555),
(4, 3, 2, 700);

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
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `venta`
--
ALTER TABLE `venta`
  ADD PRIMARY KEY (`idVenta`),
  ADD KEY `FK_catalogo_venta` (`idProducto`),
  ADD KEY `FK_usuario_venta` (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `catalogo`
--
ALTER TABLE `catalogo`
  MODIFY `CODART` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `venta`
--
ALTER TABLE `venta`
  MODIFY `idVenta` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `venta`
--
ALTER TABLE `venta`
  ADD CONSTRAINT `FK_catalogo_venta` FOREIGN KEY (`idProducto`) REFERENCES `catalogo` (`CODART`) ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_usuario_venta` FOREIGN KEY (`idUsuario`) REFERENCES `usuarios` (`id`) ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
