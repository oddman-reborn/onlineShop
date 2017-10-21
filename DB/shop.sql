-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 21, 2017 at 09:12 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(20) NOT NULL,
  `role` varchar(50) NOT NULL,
  `designation` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `username`, `password`, `role`, `designation`) VALUES
(1, 'Monirul Islam', 'monir', '123', 'Admin', 'Admin');

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `order_status` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `credit_card`
--

CREATE TABLE `credit_card` (
  `id` int(10) NOT NULL,
  `code` varchar(20) NOT NULL,
  `pin` varchar(20) NOT NULL,
  `balance` varchar(10) NOT NULL,
  `status` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `credit_card`
--

INSERT INTO `credit_card` (`id`, `code`, `pin`, `balance`, `status`) VALUES
(8, 'asbhbha', '1223545', '5000', 1),
(9, 'kmckvnd', '8785565', '1000', 0),
(10, 'iajudhb', '1235455', '5000', 1),
(11, 'jnasjcn', '5412203', '5000', 1),
(12, 'asncaud', '5113231', '2000', 0),
(13, 'kasknca', '7894512', '1000', 0),
(14, 'asdfghj', '123456', '10000', 1);

-- --------------------------------------------------------

--
-- Table structure for table `order_list`
--

CREATE TABLE `order_list` (
  `id` int(10) NOT NULL,
  `user_id` int(10) NOT NULL,
  `product_id` int(10) NOT NULL,
  `quantity` int(10) NOT NULL,
  `delivery_type` varchar(20) NOT NULL,
  `address` varchar(100) NOT NULL,
  `contact_no` varchar(20) NOT NULL,
  `price` int(10) NOT NULL,
  `name` varchar(50) NOT NULL,
  `date` varchar(30) NOT NULL,
  `status` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `order_list`
--

INSERT INTO `order_list` (`id`, `user_id`, `product_id`, `quantity`, `delivery_type`, `address`, `contact_no`, `price`, `name`, `date`, `status`) VALUES
(1, 5, 3, 2, 'Home Delivery', 'fdsfsdghhjj', '32134243', 46000, 'sdfsdf', '21/10/2017', 2);

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `category` varchar(100) NOT NULL,
  `price` int(10) NOT NULL,
  `unit_available` int(10) NOT NULL,
  `image_path` varchar(100) NOT NULL,
  `detail` varchar(500) NOT NULL,
  `brand` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `category`, `price`, `unit_available`, `image_path`, `detail`, `brand`) VALUES
(3, 'demo2', 'Computer(Desktop)', 23000, 11, 'resources\\product_image\\laptop.jpg', 'fgdbhfbhdsvbhasdfdsa', 'Sony'),
(4, 'Demo laptop', 'Computer(Laptop)', 42000, 10, 'resources\\product_image\\hp_ubuntu_laptop.jpg', 'bdcnckmkcmkemcfe\r\newcnenjceubuebcbjbcibeiiuhcsa', 'HP');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(20) NOT NULL,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(20) NOT NULL,
  `contact` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `name`, `email`, `password`, `contact`) VALUES
(5, 'Monirul Islam', 'monir9968@gmail.com', '123', '1612'),
(6, 'demo3', 'demo@gmail.com', '123', '41221124');

-- --------------------------------------------------------

--
-- Table structure for table `user_balance`
--

CREATE TABLE `user_balance` (
  `id` int(10) NOT NULL,
  `userId` int(10) NOT NULL,
  `credit` int(10) NOT NULL,
  `debit` int(10) NOT NULL,
  `date` varchar(20) NOT NULL,
  `productId` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_balance`
--

INSERT INTO `user_balance` (`id`, `userId`, `credit`, `debit`, `date`, `productId`) VALUES
(1, 5, 500, 0, '14/10/2017', '0'),
(2, 5, 5000, 0, '17/10/2017', '0'),
(3, 5, 5000, 0, '18/10/2017', '0'),
(4, 5, 10000, 0, '18/10/2017', '0'),
(5, 5, 5000, 0, '18/10/2017', '0'),
(6, 5, 0, 23000, '18/10/2017', '3'),
(7, 5, 250000, 0, '20/10/2017', '0'),
(8, 5, 0, 84000, '20/10/2017', '4'),
(10, 5, 23000, 0, '20/10/2017', '3(Refund)'),
(11, 5, 0, 46000, '21/10/2017', '3');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `credit_card`
--
ALTER TABLE `credit_card`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `order_list`
--
ALTER TABLE `order_list`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_balance`
--
ALTER TABLE `user_balance`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `credit_card`
--
ALTER TABLE `credit_card`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `order_list`
--
ALTER TABLE `order_list`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `user_balance`
--
ALTER TABLE `user_balance`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
