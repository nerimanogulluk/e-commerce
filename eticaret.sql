-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Aug 01, 2021 at 05:29 PM
-- Server version: 5.7.32
-- PHP Version: 7.4.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eticaret`
--

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `aid` int(11) NOT NULL,
  `address_details` varchar(255) DEFAULT NULL,
  `address_title` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `county` varchar(255) DEFAULT NULL,
  `id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `basket`
--

CREATE TABLE `basket` (
  `bid` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `uuid` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `basket`
--

INSERT INTO `basket` (`bid`, `pid`, `uuid`) VALUES
(5, 10, '755083de-6af8-4a46-bdc9-bf3939dc1e3d');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `cid` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`cid`, `status`, `title`) VALUES
(1, 0, 'Kozmetik'),
(2, 0, 'Elektronik'),
(3, 0, 'Tekstil'),
(4, 0, 'Ev & Yaşam'),
(5, 0, 'Aksesuar');

-- --------------------------------------------------------

--
-- Table structure for table `content`
--

CREATE TABLE `content` (
  `content_id` int(11) NOT NULL,
  `content_description` text,
  `content_detail` text,
  `content_title` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `content`
--

INSERT INTO `content` (`content_id`, `content_description`, `content_detail`, `content_title`) VALUES
(1, 'Dijital Dönüşüm', '<p style=\"text-align: center;\"><img src=\"http://blue-ram.net/Content/Site/images/about.jpg\" style=\"width: 640px;\"><b style=\"color: rgb(32, 33, 34); font-family: sans-serif; font-size: 14px;\"><br></b></p><p><b style=\"color: rgb(32, 33, 34); font-family: sans-serif; font-size: 14px;\">Dijital dönüşüm</b><span style=\"color: rgb(32, 33, 34); font-family: sans-serif; font-size: 14px;\">, toplumsal ve sektörel ihtiyaçlara <span style=\"background-color: rgb(255, 255, 255); font-family: Tahoma;\">dijital</span> teknolojilerin entegrasyonuyla çözüm bulmanın ve buna bağlı olarak iş akışlarının ve kültürün gelişmesi ve değişmesi sürecini tanımlayan bir kavramdır. Yaratıcılığı ve inovasyonu merkeze alan dijital dönüşüm, geleneksel metodlardan daha verimli sonuçlar elde etmek için ortaya çıkmıştır.</span><br></p>', 'Dijital Dönüşüm'),
(2, 'Sitemiz üzerinden saat 16:00 a(cumartesi 12:00 a) kadar verilen siparişler aynı gün kargolanır. Saat 16:00 dan sonra verilen siparişler ve tatil günlerine denk gelen siparişler takip eden ilk iş günü kargolanır. Siparişiniz kargoya verildiğinde size mail yoluyla bilgilendirme yapılacaktır.', '<p style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; outline: 0px; padding: 0px; color: rgb(0, 0, 0); font-family: poppins, sans-serif; font-size: 12.8px;\"><strong style=\"margin: 0px; outline: 0px; padding: 0px;\">Siparişim ne zaman teslim olur?</strong>&nbsp;</p><p style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; outline: 0px; padding: 0px; color: rgb(0, 0, 0); font-family: poppins, sans-serif; font-size: 12.8px;\">Siparişinizin kargoya teslim edilmesinden itibaren mesafeye bağlı olarak 1-3 gün içinde teslim olur. Belirttiğiniz adreste bulunamadığınız durumda, Kargo şirketi paketinizin bulunduğu şubeyi belirten bir not bırakır ve paketiniz şubeden teslim almanız için üç (3)&nbsp; gün bekletilir. Üç gün içinde teslim alınmayan kargolar bize iade edilir.</p><p style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; outline: 0px; padding: 0px; color: rgb(0, 0, 0); font-family: poppins, sans-serif; font-size: 12.8px;\">&nbsp;</p><p style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; outline: 0px; padding: 0px; color: rgb(0, 0, 0); font-family: poppins, sans-serif; font-size: 12.8px;\"><strong style=\"margin: 0px; outline: 0px; padding: 0px;\">Siparişinizin durumunu nasıl kontrol edebilirim?</strong></p><p style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; outline: 0px; padding: 0px; color: rgb(0, 0, 0); font-family: poppins, sans-serif; font-size: 12.8px;\">Siparişiniz kargoya verildikten sonra size gelen bilgilendirme mailinde “kargo takip” numaranızda olacaktır. Bu kargo takip numarası ile https://www.yurticikargo.com/&nbsp;adresinden kargonuzu durumunu izleyebilirsiniz.</p><p style=\"margin-right: 0px; margin-bottom: 0px; margin-left: 0px; outline: 0px; padding: 0px; color: rgb(0, 0, 0); font-family: poppins, sans-serif; font-size: 12.8px;\">Sipariş teslimat bilgilerimi değiştirebilir miyim? Siparişinizin durumu “sipariş hazırlanıyor”&nbsp;şeklinde ise Teslimat adresi, alıcı adı gibi değişiklikleri yapabilirsiniz. Değişiklik yapmak&nbsp; için bizi arayabilir yada mail atabilirsiniz.</p>', 'Sipariş ve Teslimat');

-- --------------------------------------------------------

--
-- Table structure for table `image`
--

CREATE TABLE `image` (
  `image_id` int(11) NOT NULL,
  `image_date` date DEFAULT NULL,
  `image_name` varchar(255) DEFAULT NULL,
  `pid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `image`
--

INSERT INTO `image` (`image_id`, `image_date`, `image_name`, `pid`) VALUES
(15, '2021-07-05', 'fb113a25-9033-4544-ab39-7c7675462bf9_size780x780_quality60_cropCenter.jpg', 2),
(21, '2021-07-26', '23bcab1c-2b00-4717-9971-e627fa018d58.jpg', 1),
(22, '2021-07-26', '0c951722-7e34-475e-957a-fd26db093b69.jpg', 1),
(23, '2021-07-26', '4756689d-704c-46b5-89b3-b16b8a08cf79.jpg', 1),
(24, '2021-07-26', 'bcd3fd72-87bc-4847-8f5f-4dad13627711.jpg', 1),
(25, '2021-07-26', 'bd35be38-8e62-42aa-8903-3235c04413d7.jpg', 3),
(26, '2021-07-26', 'b6ed1552-3ff1-48e1-b36f-5d53e499b0a2.jpg', 3),
(27, '2021-07-26', '67125f6c-e12f-4fc3-9f7d-51651392c9bd.jpg', 3),
(28, '2021-07-26', 'dfeec18e-54a2-470a-b425-0758a1778f00.jpg', 3),
(29, '2021-07-26', '974c88c6-317b-402a-9f26-21c85767dd56.jpg', 4),
(30, '2021-07-26', '2c0b9062-ca35-410b-b06e-9f1d6a97bd1e.jpg', 4),
(31, '2021-07-26', '57eda2e5-cb92-4f1f-96bb-98b8b3159be5.jpg', 4),
(32, '2021-07-26', '4e319e5a-6809-4d94-9455-d7b3b6684e51.jpg', 4),
(33, '2021-07-26', 'c0df1d84-65a6-4044-bfb1-1460c05dc499.jpg', 5),
(34, '2021-07-26', 'a62bcc07-0702-45d1-ac3f-40467f959fd3.jpg', 5),
(35, '2021-07-26', 'c400e9c8-a64a-44d1-88b4-8ebd33ca2647.jpg', 5),
(36, '2021-07-26', 'f50bb97b-5f2d-4a20-999c-215fdaaf2ec3.jpg', 5),
(37, '2021-07-26', 'b1e53d55-51b6-417f-9bc7-710c2e743642.jpg', 8),
(38, '2021-07-26', '7da5b365-9449-425b-bec4-02e7ce8d05c2.jpg', 8),
(39, '2021-07-26', 'cae40a55-3b8d-4747-92eb-03ce79d1cbdb.jpg', 8),
(40, '2021-07-26', '82d8adb2-cddc-4e0a-9462-c7d8f491ddbe.jpg', 8),
(41, '2021-07-26', '9a6610a0-1d75-4f6d-ba51-5f6024914246.jpg', 9),
(42, '2021-07-26', '0b5d28b8-4a44-445c-bb3b-42ded36e4f15.jpg', 9),
(43, '2021-07-26', '96dfc604-7b22-454d-a53c-3685d20ab41e.jpg', 9),
(44, '2021-07-26', 'fdf1472b-8af5-48d6-a484-0914c8ae3569.jpg', 9),
(45, '2021-07-26', '8a351ece-689f-41fc-b276-129ce947145e.jpg', 10),
(46, '2021-07-26', '604f1c58-4715-4821-bdae-bbbd92e0ac72.jpg', 10),
(47, '2021-07-26', '76a5f075-e732-4d0a-b53e-c501bac79d3e.jpg', 10),
(48, '2021-07-26', 'f77fb6ab-0bdf-478e-87fe-d0ff69bc136d.jpg', 10),
(49, '2021-07-26', '169a7b9f-1298-45dd-b82d-509449a4fc76.jpg', 11),
(50, '2021-07-26', '05ab1609-50ee-4970-81c2-b33f05260a26.jpg', 11),
(51, '2021-07-26', '32818fdc-0284-4c78-ae44-d78e93f8a4c5.jpg', 11),
(52, '2021-07-26', '2887e6e6-929f-485b-9ea5-e7eeaa32f761.jpg', 11),
(53, '2021-07-26', 'f73320ae-1711-4907-a580-19fed226b3a2.jpg', 12),
(54, '2021-07-26', '805d4074-463f-40d7-965b-ffe11edbfdf2.jpg', 12),
(55, '2021-07-26', 'af98ede9-1b29-4c13-a00d-0cc9cf658ed4.jpg', 12),
(56, '2021-07-26', 'd17d7a2d-7417-49ad-adbf-81877bef6ea8.jpg', 12);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `pid` int(11) NOT NULL,
  `cid` int(11) NOT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  `ptitle` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`pid`, `cid`, `detail`, `price`, `ptitle`) VALUES
(1, 1, 'Fondöten', 300, 'Fondöten'),
(3, 1, 'Süper Etkili&nbsp;Saç bakım', 100, 'Saç bakım'),
(4, 2, 'Ürün Bilgi Detay', 200, 'Bilgisayar Kılıfı Kırmızı'),
(5, 4, 'Sehba detay', 1000, 'Sehba'),
(8, 2, '<p>128 Gb siyah<br></p>', 17000, 'Iphone 12'),
(9, 2, '<p>1,5 saat <span style=\"background-color: rgb(255, 0, 0);\">sarj</span> süresi vardır.</p>', 3000, 'Şarjlı Süpürge'),
(10, 4, '<p>Çiçekli<br></p>', 200, 'Nevresim takımı'),
(11, 4, '<p>Antrasit, Ahşap detaylı<br></p>', 4000, 'Köşe Koltuk'),
(12, 2, '<p>6 programlı<br></p>', 5600, 'Bulaşık Makinesi');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `user_role_user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`role_id`, `name`, `user_role_user_id`) VALUES
(1, 'ADMIN', 1),
(2, 'ADMIN', 2);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `user_id` bigint(20) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `full_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`user_id`, `email`, `enabled`, `full_name`, `password`, `status`, `username`) VALUES
(1, 'ali@mail.com', b'1', 'ali', '$2a$10$kZ1pSDKv6UtSSsudQ9K9d.DgCXqjIZZnPKSV56y1EoFnWJW5t.EHK', 1, 'ali'),
(2, 'nerimanogulluk@gmail.com', b'1', 'Neriman Oğulluk', '$2a$10$BORXs5knPYlEEQ.W/QY4DOIcOpKlMctywww5b4RfrHaff0cDiOTyi', 1, 'neri');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`aid`);

--
-- Indexes for table `basket`
--
ALTER TABLE `basket`
  ADD PRIMARY KEY (`bid`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`cid`);

--
-- Indexes for table `content`
--
ALTER TABLE `content`
  ADD PRIMARY KEY (`content_id`);

--
-- Indexes for table `image`
--
ALTER TABLE `image`
  ADD PRIMARY KEY (`image_id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`pid`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`role_id`),
  ADD KEY `FKff0aa9iqvc14keclserpdmcn` (`user_role_user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `aid` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `basket`
--
ALTER TABLE `basket`
  MODIFY `bid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `cid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `content`
--
ALTER TABLE `content`
  MODIFY `content_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `image`
--
ALTER TABLE `image`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `pid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `user_id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `roles`
--
ALTER TABLE `roles`
  ADD CONSTRAINT `FKff0aa9iqvc14keclserpdmcn` FOREIGN KEY (`user_role_user_id`) REFERENCES `users` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
