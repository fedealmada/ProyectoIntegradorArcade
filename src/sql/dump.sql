-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-07-2024 a las 07:56:12
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `arcade`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `items`
--

CREATE TABLE `items` (
  `id` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `type` varchar(15) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `items`
--

INSERT INTO `items` (`id`, `name`, `type`, `price`) VALUES
(1, 'Caja de Guaymallen x40', 'comidas', 12),
(2, 'Medialunas x60', 'comidas', 30),
(3, 'M&M 1Kg', 'comidas', 25),
(4, 'Manzana mordida', 'comidas', 25),
(5, 'Secco Cola 2L x4', 'bebidas', 4),
(6, 'Manaos Uva 2L x6', 'bebidas', 12),
(7, 'Play Station 5', 'electronicos', 500),
(8, 'PC Gamer', 'electronicos', 1400),
(9, 'Dron', 'electronicos', 250),
(10, 'Silla Gamer', 'electronicos', 125),
(11, 'Fifa 25 por 24h', 'servicios', 7),
(12, 'The Last of Us por 24h', 'servicios', 8),
(13, '\n    Sparking Zero por 24h', 'servicios', 9),
(14, 'Goat Simulator por 48h', 'servicios', 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sales`
--

CREATE TABLE `sales` (
  `id` int(11) NOT NULL,
  `users_id` int(11) NOT NULL,
  `items_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(24) NOT NULL,
  `password` varchar(64) NOT NULL,
  `answer` varchar(64) NOT NULL,
  `question` int(2) NOT NULL,
  `registrationDate` datetime DEFAULT NULL,
  `lastLoginDate` datetime DEFAULT NULL,
  `scorePacman` int(11) NOT NULL DEFAULT 0,
  `scoreTateti` int(11) NOT NULL DEFAULT 0,
  `coins` int(11) NOT NULL DEFAULT 0,
  `scoreTetris` int(11) NOT NULL DEFAULT 0,
  `logged` int(2) NOT NULL DEFAULT 0,
  `scoreAtari` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `answer`, `question`, `registrationDate`, `lastLoginDate`, `scorePacman`, `scoreTateti`, `coins`, `scoreTetris`, `logged`, `scoreAtari`) VALUES
(1, 'Fede', '3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '559aead08264d5795d399718cdd5abd49572e84fe55590eef31a88a08fdffd', 1, '2024-06-24 01:04:19', '2024-07-03 02:51:23', 19030, 23, 155, 10, 1, 90),
(2, 'Mermelada', '3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'df7e70e521544f4834bbee64a9e3789febc4be81470df629cad6ddb332a5c', 1, '2024-06-24 01:04:40', '2024-06-27 21:13:39', 0, 0, 0, 0, 0, 0),
(3, 'Maldo', '3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '559aead08264d5795d399718cdd5abd49572e84fe55590eef31a88a08fdffd', 1, '2024-06-24 01:10:19', '2024-06-24 01:10:19', 0, 0, 0, 0, 0, 0),
(4, 'Marta', '3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '559aead08264d5795d399718cdd5abd49572e84fe55590eef31a88a08fdffd', 1, '2024-06-24 01:13:06', '2024-07-03 02:11:20', 14330, 12004, 2, 0, 0, 15),
(5, 'Santino', '3ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', 'e82e87958042ad4ab370954c8925b7ec3d4b2a8a43562b4a5ab624118b23d4f9', 1, '2024-06-24 19:56:51', '2024-06-24 19:56:59', 0, 0, 0, 0, 0, 0),
(6, 'Nicolas', '5994471abb1112afcc18159f6cc74b4f511b9986da59b3caf5a9c173cacfc5', '559aead08264d5795d399718cdd5abd49572e84fe55590eef31a88a08fdffd', 1, '2024-06-24 20:47:45', '2024-06-24 20:48:12', 0, 0, 0, 0, 0, 0),
(7, 'Jorge', '6b51d431df5d7f141cbececcf79edf3dd861c3b469fb11661a3eefacbba918', 'ba7816bf8f1cfea414140de5dae2223b0361a396177a9cb410ff61f2015ad', 1, '2024-06-27 21:14:21', '2024-06-27 21:15:20', 0, 0, 0, 0, 0, 0),
(8, 'Jorge2', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '559aead08264d5795d399718cdd5abd49572e84fe55590eef31a88a08fdffd', 1, '2024-07-03 02:34:13', '2024-07-03 02:50:04', 2330, 4, 5, 0, 0, 0);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `items`
--
ALTER TABLE `items`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `sales`
--
ALTER TABLE `sales`
  ADD PRIMARY KEY (`id`),
  ADD KEY `users_id` (`users_id`),
  ADD KEY `items_id` (`items_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `items`
--
ALTER TABLE `items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT de la tabla `sales`
--
ALTER TABLE `sales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `sales`
--
ALTER TABLE `sales`
  ADD CONSTRAINT `sales_ibfk_1` FOREIGN KEY (`users_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `sales_ibfk_2` FOREIGN KEY (`items_id`) REFERENCES `items` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
