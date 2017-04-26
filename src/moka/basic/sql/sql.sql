/*
Navicat MySQL Data Transfer

Source Server         : moka
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : moka

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-24 22:47:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for branch
-- ----------------------------
DROP TABLE IF EXISTS `branch`;
CREATE TABLE `branch` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分支',
  `lineId` int(11) DEFAULT NULL COMMENT '线路id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `introduce` varchar(255) DEFAULT NULL COMMENT '简介',
  `url` varchar(255) DEFAULT NULL COMMENT '图片地址',
  `lng` varchar(255) DEFAULT NULL COMMENT '纬度',
  `lat` varchar(255) DEFAULT NULL COMMENT '经度',
  `scope` varchar(255) DEFAULT NULL COMMENT '范围',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='分支';

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论',
  `branchId` int(11) DEFAULT NULL,
  `lineId` int(11) DEFAULT NULL,
  `lineSendId` int(11) DEFAULT NULL COMMENT '线路转发id',
  `userId` int(11) DEFAULT NULL,
  `context` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `praised` int(11) DEFAULT NULL COMMENT '赞数',
  `review` int(11) DEFAULT NULL COMMENT '评论数',
  `forward` int(11) DEFAULT NULL COMMENT '分享数',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Table structure for commentrelation
-- ----------------------------
DROP TABLE IF EXISTS `commentrelation`;
CREATE TABLE `commentrelation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户线路评论',
  `type` int(11) DEFAULT NULL COMMENT '1-reply 2-lineSned 2-comment',
  `userId` int(11) DEFAULT NULL,
  `lineSendId` int(11) DEFAULT NULL COMMENT '线路转发id',
  `lineId` int(11) DEFAULT NULL,
  `commentId` int(11) DEFAULT NULL,
  `comType` int(11) NOT NULL COMMENT '1-点赞 2-评论 3-分享',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户线路评论';

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '线路',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `introduce` varchar(255) DEFAULT NULL COMMENT '简介',
  `privacy` int(11) DEFAULT NULL COMMENT '隐私',
  `praised` int(11) DEFAULT NULL COMMENT '赞',
  `review` int(11) DEFAULT NULL COMMENT '评论',
  `forward` int(11) DEFAULT NULL COMMENT '分享',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='线路';

-- ----------------------------
-- Table structure for linesend
-- ----------------------------
DROP TABLE IF EXISTS `linesend`;
CREATE TABLE `linesend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '转发线路',
  `lineSendId` int(11) DEFAULT NULL COMMENT '之父关系',
  `lineId` int(11) DEFAULT NULL COMMENT '线路id',
  `context` varchar(255) DEFAULT NULL COMMENT '转发内容',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `introduce` varchar(255) DEFAULT NULL COMMENT '简介',
  `privacy` int(11) DEFAULT NULL COMMENT '隐私',
  `praised` int(11) DEFAULT NULL COMMENT '赞',
  `review` int(11) DEFAULT NULL COMMENT '评论',
  `forward` int(11) DEFAULT NULL COMMENT '分享',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='转发线路';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户',
  `userDetailId` int(11) DEFAULT NULL COMMENT '用户详情id',
  `user` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `nickName` varchar(255) DEFAULT NULL COMMENT '昵称',
  `url` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Table structure for userdetail
-- ----------------------------
DROP TABLE IF EXISTS `userdetail`;
CREATE TABLE `userdetail` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户详情',
  `school` varchar(255) DEFAULT NULL COMMENT '学校',
  `hobby` varchar(255) DEFAULT NULL COMMENT '爱好',
  `diploma` varchar(255) DEFAULT NULL COMMENT '专业',
  `idCard` varchar(255) DEFAULT NULL COMMENT '身份证',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='用户详情';
