-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 19, 2015 at 06:37 PM
-- Server version: 5.5.43-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `ITS`
--

-- --------------------------------------------------------

--
-- Table structure for table `cinsiyet`
--

CREATE TABLE IF NOT EXISTS `cinsiyet` (
  `id` tinyint(4) NOT NULL,
  `isim` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cinsiyet`
--

INSERT INTO `cinsiyet` (`id`, `isim`) VALUES
(1, 'Bay'),
(2, 'Bayan');

-- --------------------------------------------------------

--
-- Table structure for table `izinler`
--

CREATE TABLE IF NOT EXISTS `izinler` (
  `kayit_no` int(11) NOT NULL AUTO_INCREMENT,
  `birim` varchar(50) NOT NULL,
  `kalan` int(11) NOT NULL,
  `baslangic` date NOT NULL,
  `bitis` date NOT NULL,
  `kullanilan` int(11) NOT NULL,
  `turu` varchar(50) NOT NULL,
  `tcno` bigint(11) NOT NULL,
  PRIMARY KEY (`kayit_no`),
  KEY `kayit` (`kayit_no`),
  KEY `tcno` (`tcno`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=45 ;

--
-- Dumping data for table `izinler`
--

INSERT INTO `izinler` (`kayit_no`, `birim`, `kalan`, `baslangic`, `bitis`, `kullanilan`, `turu`, `tcno`) VALUES
(21, 'Sekreter', 10, '2015-05-01', '2015-05-15', 15, 'Yıllık', 17737270380),
(22, 'Sekreter', 17, '2015-05-20', '2015-06-10', 3, 'Yıllık', 48148174074),
(23, 'Muhasebe', 15, '2015-04-22', '2015-05-17', 10, 'Yıllık', 10399407411),
(24, 'Muharebe', 8, '2015-05-01', '2015-05-10', 2, 'Rapor', 10344037951),
(25, 'Muhasebe', 13, '2015-05-01', '2015-05-20', 7, 'Mazeret', 10344037951),
(26, 'Lojistik', 12, '2015-06-08', '2015-06-20', 0, 'Ucretsiz', 18916313020),
(27, 'Lojistik', 10, '2015-07-01', '2015-07-10', 0, 'Mazeret', 19158980382),
(28, 'Lojistik', 0, '2015-03-01', '2015-05-30', 30, 'Yıllık', 21754328980),
(29, 'Güvenlik', 17, '2015-05-06', '2015-05-26', 3, 'Rapor', 28410931641),
(30, 'Güvenlik', 30, '2015-08-09', '2015-09-03', 0, 'Yıllık', 31495209371),
(31, 'Temizlik', 14, '2015-05-01', '2015-05-19', 5, 'Mazeret', 48148174074),
(32, 'Temizlik', 17, '2015-05-15', '2015-06-07', 6, 'Ucretsiz', 49610407576),
(33, 'Lojistik', 14, '2015-05-14', '2015-06-03', 6, 'Ucretsiz', 66952614164),
(34, 'Muhasebe', 0, '2015-01-01', '2015-01-30', 30, 'Yıllık', 70313590657),
(35, 'Güvenlik', 15, '2015-05-01', '2015-05-20', 5, 'Mazeret', 70531284058),
(36, 'Lojistik', 12, '2015-05-25', '2015-06-25', 18, 'Yıllık', 77313989942),
(37, 'Güvenlik', 1, '2015-04-01', '2015-05-30', 29, 'Yıllık', 78848537942),
(38, 'Muharebe', 12, '2015-05-07', '2015-05-25', 6, 'Ucretsiz', 81167298905),
(39, 'Muhasebe', 18, '2015-05-28', '2015-06-27', 12, 'Yıllık', 82395904724),
(40, 'Muhasebe', 13, '2015-05-12', '2015-06-02', 7, 'Mazeret', 85189668913),
(41, 'Muhabere', 10, '2015-05-20', '2015-06-19', 20, 'Yıllık', 92965972712),
(42, 'Lojistik', 16, '2015-05-27', '2015-06-17', 4, 'Rapor', 95365039877),
(43, 'Lojistik', 15, '2015-06-11', '2015-07-11', 15, 'Ucretsiz', 21754328980);

-- --------------------------------------------------------

--
-- Table structure for table `personel`
--

CREATE TABLE IF NOT EXISTS `personel` (
  `tcno` bigint(11) NOT NULL,
  `sicilno` int(11) NOT NULL,
  `ad` varchar(30) NOT NULL,
  `soyad` varchar(30) NOT NULL,
  `cinsiyet` tinyint(4) NOT NULL,
  `dogum_tarihi` date NOT NULL,
  `sehir` varchar(30) NOT NULL,
  PRIMARY KEY (`tcno`),
  KEY `cinsiyet` (`cinsiyet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `personel`
--

INSERT INTO `personel` (`tcno`, `sicilno`, `ad`, `soyad`, `cinsiyet`, `dogum_tarihi`, `sehir`) VALUES
(10344037951, 88930, 'Zeynepp', 'Peker', 2, '1977-11-11', 'Ankara'),
(10399407411, 88633, 'Deniz', 'Beyaz', 1, '1958-03-05', 'Ankara'),
(17737270380, 71327, 'Filiz', 'Saman', 2, '1981-07-18', 'Istanbul'),
(18916313020, 85965, 'Cansu', 'Dere', 2, '1973-05-08', 'Manisa'),
(19158980382, 40297, 'Su', 'Yavuz', 2, '1974-06-09', 'Yozgat'),
(21754328980, 27239, 'Nuri', 'Taş', 1, '1988-05-19', 'Isparta'),
(28410931641, 57819, 'Şükrü', 'Yıldırım', 1, '1970-03-20', 'Kayseri'),
(31495209371, 87047, 'Nigan', 'Kol', 2, '1964-12-17', 'Batman'),
(48148174074, 13720, 'Elif', 'Derin', 2, '1982-06-07', 'İzmir'),
(49610407576, 31235, 'Tarkan', 'Turan', 1, '1983-05-29', 'Istanbul'),
(66952614164, 35968, 'Taner', 'Akdag', 1, '1962-04-09', 'Isparta'),
(70313590657, 42890, 'Ceren', 'Dumanlı', 2, '1976-09-22', 'Nigde'),
(70531284058, 31090, 'Haydar', 'Yalçın', 1, '1974-11-14', 'Isparta'),
(77313989942, 54934, 'Murat', 'Yerebakan', 1, '1977-03-03', 'Kayseri'),
(78848537942, 76513, 'Zeki', 'Kara', 1, '1963-11-02', 'Istanbul'),
(81167298905, 13758, 'Şerafettin', 'Karaca', 1, '1973-11-28', 'Ankara'),
(82395904724, 68403, 'Zeliha', 'Yelken', 2, '1978-04-04', 'Isparta'),
(85189668913, 58604, 'Veli', 'Küçük', 1, '1965-09-26', 'Istanbul'),
(92965972712, 10496, 'Kazım', 'Yürek', 1, '1966-10-12', 'Isparta'),
(95365039877, 40989, 'Osman', 'Tatar', 1, '1979-04-19', 'Burdur');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `izinler`
--
ALTER TABLE `izinler`
  ADD CONSTRAINT `izinler_ibfk_1` FOREIGN KEY (`tcno`) REFERENCES `personel` (`tcno`);

--
-- Constraints for table `personel`
--
ALTER TABLE `personel`
  ADD CONSTRAINT `personel_ibfk_4` FOREIGN KEY (`cinsiyet`) REFERENCES `cinsiyet` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
