-- phpMyAdmin SQL Dump
-- version 4.4.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 07, 2019 at 11:55 PM
-- Server version: 5.6.26
-- PHP Version: 5.6.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbkoperasi`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_anggota`
--

CREATE TABLE IF NOT EXISTS `tb_anggota` (
  `id_anggota` int(11) NOT NULL,
  `nama_anggota` varchar(100) NOT NULL,
  `alamat_anggota` text NOT NULL,
  `tgl_lahir_anggota` date NOT NULL,
  `tempat_lahir_anggota` varchar(11) NOT NULL,
  `jenis_kelamin_anggota` enum('Pria','Wanita') NOT NULL,
  `status_anggota` varchar(14) NOT NULL,
  `no_telepo_anggota` int(11) NOT NULL,
  `keterangan_anggota` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_angsuran`
--

CREATE TABLE IF NOT EXISTS `tb_angsuran` (
  `id_angsuran` int(10) NOT NULL,
  `id_pinjaman` int(11) NOT NULL,
  `tgl_pembayaran` date NOT NULL,
  `angsuran_ke` int(11) NOT NULL,
  `besar_angsuran` varchar(200) NOT NULL,
  `keterangan_angsuran` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_angsuran_detail`
--

CREATE TABLE IF NOT EXISTS `tb_angsuran_detail` (
  `id_angsuran-detail` int(11) unsigned NOT NULL,
  `id_angsuran` int(11) NOT NULL,
  `tgl-jatuh_tempo` date NOT NULL,
  `besar_angsuran_detail` varchar(200) NOT NULL,
  `keterangan_angsuran` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_petugas`
--

CREATE TABLE IF NOT EXISTS `tb_petugas` (
  `Nama_petugas` varchar(100) NOT NULL,
  `Alamat_petugas` text NOT NULL,
  `No_telp_petugas` varchar(14) NOT NULL,
  `Tempat_lahir_petugas` varchar(100) NOT NULL,
  `tgl_lahir_petugas` date NOT NULL,
  `ket_petugas` text NOT NULL,
  `id_petugas` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tb_petugas`
--

INSERT INTO `tb_petugas` (`Nama_petugas`, `Alamat_petugas`, `No_telp_petugas`, `Tempat_lahir_petugas`, `tgl_lahir_petugas`, `ket_petugas`, `id_petugas`) VALUES
('Agus', 'Tabanan', '081288288388', 'Cengkareng', '2019-01-09', 'Aktif', 1),
('Pak Oka', 'Jl. Gunung', '081882887377', 'Tabanan', '2019-01-08', 'Aktif', 2),
('Made Lu Bu', 'Bangli', '082883882771', 'Tabanan', '2019-01-08', 'Aktif', 3),
('Eko Dan Guang', 'Jl. Riverwood, Province of Skyrim', '081882772887', 'Hammerfel', '2019-01-08', 'Nonaktif', 6);

-- --------------------------------------------------------

--
-- Table structure for table `tb_pinjaman`
--

CREATE TABLE IF NOT EXISTS `tb_pinjaman` (
  `id_pinjaman` int(10) NOT NULL,
  `id_pinajaman_katagori` int(11) NOT NULL,
  `id_anggota` int(11) NOT NULL,
  `besar_pinjaman` varchar(100) NOT NULL,
  `tgl_pengajuan_pinjaman` date NOT NULL,
  `tgl_acc_pinjaman` date NOT NULL,
  `tgl_pinjaman` date NOT NULL,
  `tgl_pelunasan` date NOT NULL,
  `keterangan_pinjaman` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_pinjaman_katagori`
--

CREATE TABLE IF NOT EXISTS `tb_pinjaman_katagori` (
  `id_pinjaman_katagori` int(11) NOT NULL,
  `nama_pinjaman` varchar(150) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_simpanan`
--

CREATE TABLE IF NOT EXISTS `tb_simpanan` (
  `id_simpanan` int(11) NOT NULL,
  `nama_simpanan` varchar(150) NOT NULL,
  `id_anggota` int(11) NOT NULL,
  `tgl_simpanan` date NOT NULL,
  `besar_simpanan` varchar(200) NOT NULL,
  `keterangan_simpanan` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tb_user`
--

CREATE TABLE IF NOT EXISTS `tb_user` (
  `id_user` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `id_petugas` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_anggota`
--
ALTER TABLE `tb_anggota`
  ADD PRIMARY KEY (`id_anggota`);

--
-- Indexes for table `tb_angsuran`
--
ALTER TABLE `tb_angsuran`
  ADD PRIMARY KEY (`id_angsuran`),
  ADD KEY `id_pinjaman` (`id_pinjaman`);

--
-- Indexes for table `tb_angsuran_detail`
--
ALTER TABLE `tb_angsuran_detail`
  ADD PRIMARY KEY (`id_angsuran-detail`),
  ADD KEY `id_angsuran` (`id_angsuran`);

--
-- Indexes for table `tb_petugas`
--
ALTER TABLE `tb_petugas`
  ADD PRIMARY KEY (`id_petugas`);

--
-- Indexes for table `tb_pinjaman`
--
ALTER TABLE `tb_pinjaman`
  ADD PRIMARY KEY (`id_pinjaman`),
  ADD KEY `id_pinajaman_katagori` (`id_pinajaman_katagori`),
  ADD KEY `id_anggota` (`id_anggota`);

--
-- Indexes for table `tb_pinjaman_katagori`
--
ALTER TABLE `tb_pinjaman_katagori`
  ADD PRIMARY KEY (`id_pinjaman_katagori`);

--
-- Indexes for table `tb_simpanan`
--
ALTER TABLE `tb_simpanan`
  ADD PRIMARY KEY (`id_simpanan`),
  ADD KEY `id_anggota` (`id_anggota`);

--
-- Indexes for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD PRIMARY KEY (`id_user`),
  ADD KEY `id_petugas` (`id_petugas`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_anggota`
--
ALTER TABLE `tb_anggota`
  MODIFY `id_anggota` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_angsuran`
--
ALTER TABLE `tb_angsuran`
  MODIFY `id_angsuran` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_angsuran_detail`
--
ALTER TABLE `tb_angsuran_detail`
  MODIFY `id_angsuran-detail` int(11) unsigned NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_petugas`
--
ALTER TABLE `tb_petugas`
  MODIFY `id_petugas` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT for table `tb_pinjaman`
--
ALTER TABLE `tb_pinjaman`
  MODIFY `id_pinjaman` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_pinjaman_katagori`
--
ALTER TABLE `tb_pinjaman_katagori`
  MODIFY `id_pinjaman_katagori` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_simpanan`
--
ALTER TABLE `tb_simpanan`
  MODIFY `id_simpanan` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tb_user`
--
ALTER TABLE `tb_user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `tb_angsuran`
--
ALTER TABLE `tb_angsuran`
  ADD CONSTRAINT `tb_angsuran_ibfk_1` FOREIGN KEY (`id_pinjaman`) REFERENCES `tb_pinjaman` (`id_pinjaman`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_angsuran_detail`
--
ALTER TABLE `tb_angsuran_detail`
  ADD CONSTRAINT `tb_angsuran_detail_ibfk_1` FOREIGN KEY (`id_angsuran`) REFERENCES `tb_angsuran` (`id_angsuran`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_pinjaman`
--
ALTER TABLE `tb_pinjaman`
  ADD CONSTRAINT `tb_pinjaman_ibfk_1` FOREIGN KEY (`id_pinajaman_katagori`) REFERENCES `tb_pinjaman_katagori` (`id_pinjaman_katagori`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `tb_pinjaman_ibfk_2` FOREIGN KEY (`id_anggota`) REFERENCES `tb_anggota` (`id_anggota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_simpanan`
--
ALTER TABLE `tb_simpanan`
  ADD CONSTRAINT `tb_simpanan_ibfk_1` FOREIGN KEY (`id_anggota`) REFERENCES `tb_anggota` (`id_anggota`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tb_user`
--
ALTER TABLE `tb_user`
  ADD CONSTRAINT `tb_user_ibfk_1` FOREIGN KEY (`id_petugas`) REFERENCES `tb_petugas` (`id_petugas`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
