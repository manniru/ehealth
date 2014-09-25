/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : ehealth

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2014-09-25 14:56:19
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `appointment`
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctorid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `slot1` int(11) DEFAULT NULL,
  `slot2` int(11) DEFAULT NULL,
  `slot3` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES ('1', '2', 'Ismail', null, '4', null);
INSERT INTO `appointment` VALUES ('2', '3', 'Ibrahim', null, null, null);

-- ----------------------------
-- Table structure for `appointment1`
-- ----------------------------
DROP TABLE IF EXISTS `appointment1`;
CREATE TABLE `appointment1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctorid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `slot1` int(11) DEFAULT NULL,
  `slot2` int(11) DEFAULT NULL,
  `slot3` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of appointment1
-- ----------------------------
INSERT INTO `appointment1` VALUES ('1', '2', 'Ismail', null, '4', null);
INSERT INTO `appointment1` VALUES ('2', '3', 'Ibrahim', null, null, null);

-- ----------------------------
-- Table structure for `diagnosis`
-- ----------------------------
DROP TABLE IF EXISTS `diagnosis`;
CREATE TABLE `diagnosis` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctorid` int(11) NOT NULL,
  `patientid` int(11) NOT NULL,
  `patientname` varchar(25) NOT NULL,
  `diagnosis` varchar(50) NOT NULL,
  `notes` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of diagnosis
-- ----------------------------
INSERT INTO `diagnosis` VALUES ('1', '2', '1', 'Test One', 'Acute Migrane', 'Lasted 2 weeks before seeing d');

-- ----------------------------
-- Table structure for `doctor`
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `mobile` varchar(20) NOT NULL,
  `department` varchar(30) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of doctor
-- ----------------------------
INSERT INTO `doctor` VALUES ('1', 'Dr. Ibrahim Said', 'Bukit Jalil', '6059393933', 'Information Technolgy', '8');
INSERT INTO `doctor` VALUES ('4', '1', '5', '3', '2', '12');
INSERT INTO `doctor` VALUES ('5', '', '', '', 'd', '13');
INSERT INTO `doctor` VALUES ('6', '', '', '', '', '14');
INSERT INTO `doctor` VALUES ('7', '', '', '', '', '15');

-- ----------------------------
-- Table structure for `patient`
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fullname` varchar(50) NOT NULL,
  `dob` date NOT NULL,
  `gender` varchar(10) NOT NULL,
  `weight` int(11) NOT NULL,
  `height` int(11) NOT NULL,
  `address` varchar(50) NOT NULL,
  `mobileno` varchar(15) NOT NULL,
  `datereg` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of patient
-- ----------------------------
INSERT INTO `patient` VALUES ('1', 'Test One', '1990-05-03', 'Male', '62', '170', 'Endah Regal', '60122272726', '2014-09-13 14:00:44', '4');
INSERT INTO `patient` VALUES ('2', 'Test Two2', '1990-05-03', 'Male', '56', '56', 'nn', '601111111111', '2014-09-25 14:52:52', '5');
INSERT INTO `patient` VALUES ('3', 'Test Three', '1995-08-21', 'Female', '56', '155', 'Savanna Sri Pettaling', '01123765837', '2014-09-15 12:07:13', '6');

-- ----------------------------
-- Table structure for `patients1`
-- ----------------------------
DROP TABLE IF EXISTS `patients1`;
CREATE TABLE `patients1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `weight` int(11) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `mobileno` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of patients1
-- ----------------------------
INSERT INTO `patients1` VALUES ('1', '2', 'Auwalu Sani', '1994-07-20', 'Male', '165', '54', 'Ftms College', '604039330393');

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `ptype` text,
  `reasons` text,
  `status` varchar(20) NOT NULL DEFAULT 'Not use',
  `patientid` int(11) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of permission
-- ----------------------------

-- ----------------------------
-- Table structure for `prescription`
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patientid` int(11) NOT NULL,
  `patientname` varchar(20) NOT NULL,
  `drugname` varchar(30) NOT NULL,
  `dosage` varchar(10) NOT NULL,
  `intake` varchar(10) NOT NULL,
  `duration` varchar(10) NOT NULL,
  `notes` varchar(30) DEFAULT NULL,
  `status` varchar(10) NOT NULL DEFAULT 'unfiled',
  `pharmid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of prescription
-- ----------------------------
INSERT INTO `prescription` VALUES ('1', '1', 'Test One', 'Paracetamol', '2 pill', '3/day', '3months', 'avoid mixing with pain killers', 'unfiled', null);
INSERT INTO `prescription` VALUES ('2', '1', 'Test One', 'Panadol', '2 pill', '3/day', '3months', 'quit any pain killers', 'unfiled', null);

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  `department` varchar(50) DEFAULT NULL,
  `mobileno` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '123', 'admin', 'Super Admin', null, null, null, null);
INSERT INTO `users` VALUES ('2', 'doctor1', 'doctor1', 'doctor', 'Dr. Ibrahim Said', null, null, null, null);
INSERT INTO `users` VALUES ('3', 'doctor2', 'doctor2', 'doctor', 'Dr. Ismail Umar', null, null, null, null);
INSERT INTO `users` VALUES ('4', 'patient1', 'patient1', 'patient', 'Test One', null, null, null, null);
INSERT INTO `users` VALUES ('5', 'patient2', 'patient2', 'patient', 'Test Two', null, null, null, null);
INSERT INTO `users` VALUES ('6', 'patient3', 'patient3', 'patient', 'Test Three', null, null, null, null);

-- ----------------------------
-- Table structure for `users1`
-- ----------------------------
DROP TABLE IF EXISTS `users1`;
CREATE TABLE `users1` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `fullname` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users1
-- ----------------------------
INSERT INTO `users1` VALUES ('1', 'admin', '123', 'admin', 'Super Admin');
INSERT INTO `users1` VALUES ('2', 'doctor1', 'doctor1', 'patient', 'Dr. Ibrahim Said');
INSERT INTO `users1` VALUES ('3', 'doctor2', 'doctor2', 'doctor', 'Dr. Ismail Umar');
INSERT INTO `users1` VALUES ('4', 'patient1', 'patient1', 'patient', 'Abdullahi Auwal');
INSERT INTO `users1` VALUES ('5', 'patient2', 'patient2', 'patient', 'Auwalu Sani');
INSERT INTO `users1` VALUES ('6', 'patient3', 'patient3', 'patient', 'Sani Salisu');
