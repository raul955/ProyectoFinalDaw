-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 21-12-2020 a las 17:51:53
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `servirepv1`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificaciones`
--

CREATE TABLE `calificaciones` (
  `idcalificaciones` int(11) NOT NULL,
  `calificacion` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `calificaciones_usuario`
--

CREATE TABLE `calificaciones_usuario` (
  `calificaciones_idcalificaciones` int(11) NOT NULL,
  `usuario_idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario`
--

CREATE TABLE `comentario` (
  `idcomentario` int(11) NOT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario_tema`
--

CREATE TABLE `comentario_tema` (
  `comentario_idcomentario` int(11) NOT NULL,
  `tema_idtema` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comentario_us`
--

CREATE TABLE `comentario_us` (
  `comentario_idcomentario` int(11) NOT NULL,
  `us_idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidencia`
--

CREATE TABLE `incidencia` (
  `idincidencia` int(11) NOT NULL,
  `activo` bit(1) DEFAULT NULL,
  `asunto` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `incidencia_us`
--

CREATE TABLE `incidencia_us` (
  `incidencia_idincidencia` int(11) NOT NULL,
  `us_idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tema`
--

CREATE TABLE `tema` (
  `idtema` int(11) NOT NULL,
  `asunto` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `estado` bit(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tema_us`
--

CREATE TABLE `tema_us` (
  `tema_idtema` int(11) NOT NULL,
  `us_idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket`
--

CREATE TABLE `ticket` (
  `idticket` int(11) NOT NULL,
  `comentarioemp` varchar(255) DEFAULT NULL,
  `comentarious` varchar(255) DEFAULT NULL,
  `detalle` varchar(255) DEFAULT NULL,
  `estado` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket_inc`
--

CREATE TABLE `ticket_inc` (
  `ticket_idticket` int(11) NOT NULL,
  `inc_idincidencia` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ticket_us`
--

CREATE TABLE `ticket_us` (
  `ticket_idticket` int(11) NOT NULL,
  `us_idusuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `calificacion_media` int(11) DEFAULT NULL,
  `correo` varchar(255) NOT NULL,
  `nick` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `pass` varchar(255) NOT NULL,
  `roll` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  ADD PRIMARY KEY (`idcalificaciones`);

--
-- Indices de la tabla `calificaciones_usuario`
--
ALTER TABLE `calificaciones_usuario`
  ADD PRIMARY KEY (`calificaciones_idcalificaciones`,`usuario_idusuario`),
  ADD UNIQUE KEY `UK_is5i1hgbbbe45md5f6x6kstqb` (`usuario_idusuario`);

--
-- Indices de la tabla `comentario`
--
ALTER TABLE `comentario`
  ADD PRIMARY KEY (`idcomentario`);

--
-- Indices de la tabla `comentario_tema`
--
ALTER TABLE `comentario_tema`
  ADD PRIMARY KEY (`comentario_idcomentario`,`tema_idtema`),
  ADD UNIQUE KEY `UK_hie231cx8vhgkcey8ya1sf74s` (`tema_idtema`);

--
-- Indices de la tabla `comentario_us`
--
ALTER TABLE `comentario_us`
  ADD PRIMARY KEY (`comentario_idcomentario`,`us_idusuario`),
  ADD UNIQUE KEY `UK_oe2j4qxoatsbfd3jwfpu2q3rm` (`us_idusuario`);

--
-- Indices de la tabla `incidencia`
--
ALTER TABLE `incidencia`
  ADD PRIMARY KEY (`idincidencia`);

--
-- Indices de la tabla `incidencia_us`
--
ALTER TABLE `incidencia_us`
  ADD PRIMARY KEY (`incidencia_idincidencia`,`us_idusuario`),
  ADD UNIQUE KEY `UK_hwsy0axwjesmrnbiymtqru7uw` (`us_idusuario`);

--
-- Indices de la tabla `tema`
--
ALTER TABLE `tema`
  ADD PRIMARY KEY (`idtema`);

--
-- Indices de la tabla `tema_us`
--
ALTER TABLE `tema_us`
  ADD PRIMARY KEY (`tema_idtema`,`us_idusuario`),
  ADD UNIQUE KEY `UK_758xmcldjg7wd9b1yxdnjfum8` (`us_idusuario`);

--
-- Indices de la tabla `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`idticket`);

--
-- Indices de la tabla `ticket_inc`
--
ALTER TABLE `ticket_inc`
  ADD PRIMARY KEY (`ticket_idticket`,`inc_idincidencia`),
  ADD UNIQUE KEY `UK_93hjps8cxh1p9n5nv574synxk` (`inc_idincidencia`);

--
-- Indices de la tabla `ticket_us`
--
ALTER TABLE `ticket_us`
  ADD PRIMARY KEY (`ticket_idticket`,`us_idusuario`),
  ADD UNIQUE KEY `UK_8noel79g6xwnsr1fth313cu05` (`us_idusuario`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idusuario`),
  ADD UNIQUE KEY `UK_2mlfr087gb1ce55f2j87o74t` (`correo`),
  ADD UNIQUE KEY `UK_c73frfmnb66qdcnki0xc5mj59` (`nick`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `calificaciones`
--
ALTER TABLE `calificaciones`
  MODIFY `idcalificaciones` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comentario`
--
ALTER TABLE `comentario`
  MODIFY `idcomentario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `incidencia`
--
ALTER TABLE `incidencia`
  MODIFY `idincidencia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tema`
--
ALTER TABLE `tema`
  MODIFY `idtema` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ticket`
--
ALTER TABLE `ticket`
  MODIFY `idticket` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `idusuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `calificaciones_usuario`
--
ALTER TABLE `calificaciones_usuario`
  ADD CONSTRAINT `FKc5ri57pain823h6m36rh7ngbf` FOREIGN KEY (`usuario_idusuario`) REFERENCES `usuario` (`idusuario`),
  ADD CONSTRAINT `FKowwclvcypd3fhx7thwgn4ai11` FOREIGN KEY (`calificaciones_idcalificaciones`) REFERENCES `calificaciones` (`idcalificaciones`);

--
-- Filtros para la tabla `comentario_tema`
--
ALTER TABLE `comentario_tema`
  ADD CONSTRAINT `FKm67va2iw4r48obqknkkhsi574` FOREIGN KEY (`tema_idtema`) REFERENCES `tema` (`idtema`),
  ADD CONSTRAINT `FKsetld3drowsiwgslqt7w3h4c7` FOREIGN KEY (`comentario_idcomentario`) REFERENCES `comentario` (`idcomentario`);

--
-- Filtros para la tabla `comentario_us`
--
ALTER TABLE `comentario_us`
  ADD CONSTRAINT `FK80s5fnp6r5b1vf2cjx453mvv0` FOREIGN KEY (`us_idusuario`) REFERENCES `usuario` (`idusuario`),
  ADD CONSTRAINT `FKc0ixr74wsi7r2k5ogpnhoucxc` FOREIGN KEY (`comentario_idcomentario`) REFERENCES `comentario` (`idcomentario`);

--
-- Filtros para la tabla `incidencia_us`
--
ALTER TABLE `incidencia_us`
  ADD CONSTRAINT `FK7oq8lxwnyohf3pup0aqfuvqw0` FOREIGN KEY (`us_idusuario`) REFERENCES `usuario` (`idusuario`),
  ADD CONSTRAINT `FKk54kuiumoysdmo5h8go3w2hho` FOREIGN KEY (`incidencia_idincidencia`) REFERENCES `incidencia` (`idincidencia`);

--
-- Filtros para la tabla `tema_us`
--
ALTER TABLE `tema_us`
  ADD CONSTRAINT `FKqx3hayjyada9odkaq236mwkpf` FOREIGN KEY (`tema_idtema`) REFERENCES `tema` (`idtema`),
  ADD CONSTRAINT `FKsbkjw2rglttyqnelqhk9y4yoh` FOREIGN KEY (`us_idusuario`) REFERENCES `usuario` (`idusuario`);

--
-- Filtros para la tabla `ticket_inc`
--
ALTER TABLE `ticket_inc`
  ADD CONSTRAINT `FKl3k293hnl5x4poltp3m3qytij` FOREIGN KEY (`inc_idincidencia`) REFERENCES `incidencia` (`idincidencia`),
  ADD CONSTRAINT `FKladcwlsx93kx0gt7u07yiwvfh` FOREIGN KEY (`ticket_idticket`) REFERENCES `ticket` (`idticket`);

--
-- Filtros para la tabla `ticket_us`
--
ALTER TABLE `ticket_us`
  ADD CONSTRAINT `FK4b66w3lse15l9fjrgln4ixdyr` FOREIGN KEY (`us_idusuario`) REFERENCES `usuario` (`idusuario`),
  ADD CONSTRAINT `FKptcrbsddxbfwsrdbwhxs22pm` FOREIGN KEY (`ticket_idticket`) REFERENCES `ticket` (`idticket`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
