/*
Navicat MySQL Data Transfer

Source Server         : myDB
Source Server Version : 50614
Source Host           : 127.0.0.1:3306
Source Database       : heroworld

Target Server Type    : MYSQL
Target Server Version : 50614
File Encoding         : 65001

Date: 2019-11-15 12:51:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for hero
-- ----------------------------
DROP TABLE IF EXISTS `hero`;
CREATE TABLE `hero` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `level` int(10) unsigned NOT NULL DEFAULT '1' COMMENT '等级',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='英雄';

-- ----------------------------
-- Records of hero
-- ----------------------------
INSERT INTO `hero` VALUES ('1', '剑圣', '1');
INSERT INTO `hero` VALUES ('2', '德玛', '1');

-- ----------------------------
-- Table structure for heroskill
-- ----------------------------
DROP TABLE IF EXISTS `heroskill`;
CREATE TABLE `heroskill` (
  `heroId` int(11) NOT NULL,
  `skillId` int(11) NOT NULL,
  PRIMARY KEY (`heroId`,`skillId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of heroskill
-- ----------------------------
INSERT INTO `heroskill` VALUES ('1', '1');
INSERT INTO `heroskill` VALUES ('1', '2');
INSERT INTO `heroskill` VALUES ('2', '3');

-- ----------------------------
-- Table structure for skill
-- ----------------------------
DROP TABLE IF EXISTS `skill`;
CREATE TABLE `skill` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(45) NOT NULL COMMENT '名称',
  `damage` int(11) NOT NULL DEFAULT '0' COMMENT '伤害',
  `consume` int(11) NOT NULL DEFAULT '0' COMMENT '消耗',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='技能';

-- ----------------------------
-- Records of skill
-- ----------------------------
INSERT INTO `skill` VALUES ('1', '治疗术', '-30', '0');
INSERT INTO `skill` VALUES ('2', '神圣打击', '20', '5');
INSERT INTO `skill` VALUES ('3', '冰霜打击', '10', '5');
