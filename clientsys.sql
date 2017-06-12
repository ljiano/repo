/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : clientsys

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2017-06-09 17:35:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for um_access
-- ----------------------------
DROP TABLE IF EXISTS `um_access`;
CREATE TABLE `um_access` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `companyid` int(11) DEFAULT NULL,
  `accesstime` datetime DEFAULT NULL,
  `istaking` int(11) DEFAULT NULL,
  `takingname` varchar(200) DEFAULT NULL,
  `record` varchar(2000) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `cost` decimal(32,8) DEFAULT NULL,
  `endtime` datetime DEFAULT NULL,
  `isok` int(11) DEFAULT NULL,
  `contractid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of um_access
-- ----------------------------

-- ----------------------------
-- Table structure for um_attachment
-- ----------------------------
DROP TABLE IF EXISTS `um_attachment`;
CREATE TABLE `um_attachment` (
  `id` int(11) NOT NULL,
  `umid` int(11) DEFAULT NULL,
  `umentity` varchar(30) DEFAULT NULL,
  `content` longblob,
  `type` int(11) DEFAULT NULL,
  `name` varchar(500) DEFAULT NULL,
  `contentsize` decimal(32,8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of um_attachment
-- ----------------------------

-- ----------------------------
-- Table structure for um_company
-- ----------------------------
DROP TABLE IF EXISTS `um_company`;
CREATE TABLE `um_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `companyname` varchar(50) DEFAULT NULL,
  `companycode` varchar(20) DEFAULT NULL,
  `companytypecode` varchar(20) DEFAULT NULL,
  `area` varchar(50) DEFAULT NULL,
  `parentid` int(11) DEFAULT NULL,
  `legal` varchar(50) DEFAULT NULL,
  `capital` decimal(32,8) DEFAULT NULL,
  `industrycode` varchar(20) DEFAULT NULL,
  `industryname` varchar(30) DEFAULT NULL,
  `setuptime` datetime DEFAULT NULL,
  `cratetime` datetime DEFAULT NULL,
  `updatetime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of um_company
-- ----------------------------
INSERT INTO `um_company` VALUES ('1', '腾讯', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `um_company` VALUES ('2', '华为', '', null, null, null, null, null, null, null, null, null, null);
INSERT INTO `um_company` VALUES ('3', '谷歌', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `um_company` VALUES ('4', '百度', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `um_company` VALUES ('5', '阿里', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `um_company` VALUES ('6', '联想', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `um_company` VALUES ('7', '360', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `um_company` VALUES ('8', '金山', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `um_company` VALUES ('9', '万达', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `um_company` VALUES ('10', '华谊', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `um_company` VALUES ('11', '天天', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for um_companyrela
-- ----------------------------
DROP TABLE IF EXISTS `um_companyrela`;
CREATE TABLE `um_companyrela` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `companyid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of um_companyrela
-- ----------------------------
INSERT INTO `um_companyrela` VALUES ('1', '1', '1');
INSERT INTO `um_companyrela` VALUES ('2', '1', '2');
INSERT INTO `um_companyrela` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for um_contract
-- ----------------------------
DROP TABLE IF EXISTS `um_contract`;
CREATE TABLE `um_contract` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(30) DEFAULT NULL,
  `name` varchar(150) DEFAULT NULL,
  `companyid` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  `capital` decimal(32,8) DEFAULT NULL,
  `bcapital` decimal(32,8) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `bcapitalrate` decimal(32,8) DEFAULT NULL,
  `income` decimal(32,8) DEFAULT NULL,
  `incomerate` decimal(32,8) DEFAULT NULL,
  `taxrate` decimal(32,8) DEFAULT NULL,
  `tax` decimal(32,8) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `deleteflag` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of um_contract
-- ----------------------------

-- ----------------------------
-- Table structure for um_contractdetail
-- ----------------------------
DROP TABLE IF EXISTS `um_contractdetail`;
CREATE TABLE `um_contractdetail` (
  `id` int(11) NOT NULL,
  `contractid` int(11) DEFAULT NULL,
  `pmid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `price` decimal(32,8) DEFAULT NULL,
  `total` decimal(32,8) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `range` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of um_contractdetail
-- ----------------------------

-- ----------------------------
-- Table structure for um_product
-- ----------------------------
DROP TABLE IF EXISTS `um_product`;
CREATE TABLE `um_product` (
  `id` int(11) NOT NULL,
  `name` varchar(500) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `price` decimal(32,8) DEFAULT NULL,
  `description` varchar(3000) DEFAULT NULL,
  `creditid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of um_product
-- ----------------------------

-- ----------------------------
-- Table structure for um_user
-- ----------------------------
DROP TABLE IF EXISTS `um_user`;
CREATE TABLE `um_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of um_user
-- ----------------------------
INSERT INTO `um_user` VALUES ('1', 'ljo', '111');
INSERT INTO `um_user` VALUES ('2', 'cCCC', '123');
INSERT INTO `um_user` VALUES ('3', 'GGG', '2412');
INSERT INTO `um_user` VALUES ('4', 'HHH', '123');
INSERT INTO `um_user` VALUES ('5', 'bbb', 'bbb');
INSERT INTO `um_user` VALUES ('6', 'nnn', 'nn');
INSERT INTO `um_user` VALUES ('7', 'gg', 'e');
INSERT INTO `um_user` VALUES ('8', 'ggg', 'ee');
INSERT INTO `um_user` VALUES ('9', 'hhhr', 'rr');
INSERT INTO `um_user` VALUES ('10', 'eeeeeeeeeee', 'ww');
INSERT INTO `um_user` VALUES ('11', 'tttttttt', 'tte');
INSERT INTO `um_user` VALUES ('12', 'nnnnnnnn', 'nnn');
INSERT INTO `um_user` VALUES ('13', 'nnnnn', 'mmm');
