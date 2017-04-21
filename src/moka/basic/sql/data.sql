/*
Navicat MySQL Data Transfer

Source Server         : moka
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : moka

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-21 18:44:55
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
-- Records of branch
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论',
  `branchId` int(11) DEFAULT NULL,
  `lineId` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  `context` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `praised` int(11) DEFAULT NULL COMMENT '赞数',
  `review` int(11) DEFAULT NULL COMMENT '评论数',
  `forward` int(11) DEFAULT NULL COMMENT '分享数',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '0', '1', '1', '好了歌，中国著名古典章回体小说《红楼梦》中经典诗词，小说中为跛足道人所做，甄士隐彻悟后进行进一步注解，表现了作者现实主义和宗教思想。文中还有与之相和的《好了歌注》，承接并引申了《好了歌》的思想。诗歌内容隐射小说情节，表达了作者对现实的愤懑和失望，以及对自由的追求和向往![1] ', '3', '0', '2', '2017-04-20 04:46:24');
INSERT INTO `comment` VALUES ('2', '0', '1', '2', '测试测绘师', '2', '0', '2', '2017-04-20 05:12:22');
INSERT INTO `comment` VALUES ('3', '0', '1', '3', '蓝牙5是蓝牙技术联盟 （Bluetooth Special Interest Group）于2016年6月16日发布的新一代蓝牙标准。', '2', '0', '2', '2017-04-20 08:24:42');
INSERT INTO `comment` VALUES ('4', '0', '1', '4', '部门与组织是manytoone和onetomany的关系，并且两张表都有自关联，查询部门信息时会级联查询上级部门以及他的组织结构，然后返回json数据时，会出现$ref ', '2', '0', '2', '2017-04-20 08:36:02');
INSERT INTO `comment` VALUES ('5', '0', '1', '3', '别名在子查询及联接查询中的应用有着很好效果，当两张表有相同列名或者为了加强可读性，给表加上不同的别名，就能很好的区分哪些列属于哪张表。', '2', '0', '2', '2017-04-20 17:19:37');
INSERT INTO `comment` VALUES ('6', '0', '1', '5', '陋室1空堂，当年笏满床2；衰草枯杨，曾为歌舞场。蛛丝儿结满雕梁3，绿纱今又糊在蓬窗上。说什么脂正浓，粉正香，如何两鬓又成霜？', '1', '0', '0', '2017-04-21 07:01:56');

-- ----------------------------
-- Table structure for commentrelation
-- ----------------------------
DROP TABLE IF EXISTS `commentrelation`;
CREATE TABLE `commentrelation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户线路评论',
  `userId` int(11) DEFAULT NULL,
  `lineId` int(11) DEFAULT NULL,
  `commentId` int(11) DEFAULT NULL,
  `comType` int(11) DEFAULT NULL COMMENT '1-点赞 2-评论 3-分享',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8 COMMENT='用户线路评论';

-- ----------------------------
-- Records of commentrelation
-- ----------------------------
INSERT INTO `commentrelation` VALUES ('77', '1', '1', '0', '1');
INSERT INTO `commentrelation` VALUES ('78', '1', '1', '0', '3');
INSERT INTO `commentrelation` VALUES ('79', '1', '0', '1', '1');
INSERT INTO `commentrelation` VALUES ('80', '1', '0', '2', '1');
INSERT INTO `commentrelation` VALUES ('81', '1', '0', '2', '3');
INSERT INTO `commentrelation` VALUES ('82', '1', '0', '1', '3');
INSERT INTO `commentrelation` VALUES ('83', '1', '0', '3', '3');
INSERT INTO `commentrelation` VALUES ('84', '1', '0', '3', '1');
INSERT INTO `commentrelation` VALUES ('85', '1', '0', '4', '1');
INSERT INTO `commentrelation` VALUES ('86', '1', '0', '4', '3');
INSERT INTO `commentrelation` VALUES ('87', '1', '0', '5', '3');
INSERT INTO `commentrelation` VALUES ('88', '1', '0', '5', '1');
INSERT INTO `commentrelation` VALUES ('89', '2', '1', '0', '1');
INSERT INTO `commentrelation` VALUES ('90', '2', '1', '0', '3');
INSERT INTO `commentrelation` VALUES ('91', '2', '0', '1', '1');
INSERT INTO `commentrelation` VALUES ('92', '2', '0', '1', '3');
INSERT INTO `commentrelation` VALUES ('93', '2', '0', '2', '3');
INSERT INTO `commentrelation` VALUES ('94', '2', '0', '2', '1');
INSERT INTO `commentrelation` VALUES ('95', '2', '0', '3', '1');
INSERT INTO `commentrelation` VALUES ('96', '2', '0', '3', '3');
INSERT INTO `commentrelation` VALUES ('97', '2', '0', '4', '3');
INSERT INTO `commentrelation` VALUES ('98', '2', '0', '4', '1');
INSERT INTO `commentrelation` VALUES ('99', '2', '0', '5', '1');
INSERT INTO `commentrelation` VALUES ('100', '2', '0', '5', '3');
INSERT INTO `commentrelation` VALUES ('102', '5', '0', '1', '1');
INSERT INTO `commentrelation` VALUES ('103', '5', '0', '6', '1');
INSERT INTO `commentrelation` VALUES ('105', '5', '1', '0', '1');

-- ----------------------------
-- Table structure for line
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='线路';

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('1', '1', '好了歌', '世人都晓神仙好，惟有功名忘不了！\n古今将相在何方？荒冢一堆草没了。\n世人都晓神仙好，只有金银忘不了！\n终朝只恨聚无多，及到多时眼闭了。\n世人都晓神仙好，只有娇妻忘不了！\n君生日日说恩情，君死又随人去了。\n世人都晓神仙好，只有儿孙忘不了！\n痴心父母古来多，孝顺儿孙谁见了？', '0', '3', '6', '1', '2017-04-20 04:43:31');

-- ----------------------------
-- Table structure for linesend
-- ----------------------------
DROP TABLE IF EXISTS `linesend`;
CREATE TABLE `linesend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '转发线路',
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='转发线路';

-- ----------------------------
-- Records of linesend
-- ----------------------------
INSERT INTO `linesend` VALUES ('1', '1', '测试分享', '5', null, null, '0', '0', '0', '0', '2017-04-21 12:01:51');

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'admin', 'admin', '465716992@qq.com', '17770085046', 'moka', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('2', '2', 'gaoyuan1', 'gaoyuan', '465716992@qq.com', '17770085046', '小清', 'http://180.97.75.144:8035/hig/201704200233074692.jpg');
INSERT INTO `user` VALUES ('3', '3', 'gaoyuan2', 'gaoyuan', '465716992@qq.com', '17770085046', '小明', 'http://180.97.75.144:8035/hig/201704200234148315.jpg');
INSERT INTO `user` VALUES ('4', '4', 'gaoyuan3', 'gaoyuan', '465716992@qq.com', '17770085046', '小节', 'http://180.97.75.144:8035/hig/201704200234406352.jpg');
INSERT INTO `user` VALUES ('5', '5', 'gaoyuan4', 'gaoyuan', '465716992@qq.com', '17770085046', '小国', 'http://180.97.75.144:8035/hig/201704200234531006.jpg');
INSERT INTO `user` VALUES ('6', '6', 'gaoyuan5', 'gaoyuan', '465716992@qq.com', '17770085046', '完颜香梅', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('7', '7', 'gaoyuan6', 'gaoyuan', '465716992@qq.com', '17770085046', '壤驷瑞锦', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('8', '8', 'gaoyuan7', 'gaoyuan', '465716992@qq.com', '17770085046', '碧鲁海瑶', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('9', '9', 'gaoyuan8', 'gaoyuan', '465716992@qq.com', '17770085046', '仙阳霁', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('10', '10', 'gaoyuan9', 'gaoyuan', '465716992@qq.com', '17770085046', '亓官弘懿', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('11', '11', 'gaoyuan10', 'gaoyuan', '465716992@qq.com', '17770085046', '司马凝远', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('12', '12', 'gaoyuan11', 'gaoyuan', '465716992@qq.com', '17770085046', '闾丘惜萱', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('13', '13', 'gaoyuan12', 'gaoyuan', '465716992@qq.com', '17770085046', '鲍平萱', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('14', '14', 'gaoyuan13', 'gaoyuan', '465716992@qq.com', '17770085046', '訾叶芳', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('15', '15', 'gaoyuan14', 'gaoyuan', '465716992@qq.com', '17770085046', '公孙奇玮', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('16', '16', 'gaoyuan15', 'gaoyuan', '465716992@qq.com', '17770085046', '拓跋吉星', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('17', '17', 'gaoyuan16', 'gaoyuan', '465716992@qq.com', '17770085046', '欧阳浩大', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('18', '18', 'gaoyuan17', 'gaoyuan', '465716992@qq.com', '17770085046', '诸葛慧雅', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('19', '19', 'gaoyuan18', 'gaoyuan', '465716992@qq.com', '17770085046', '万俟碧春', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('20', '20', 'gaoyuan19', 'gaoyuan', '465716992@qq.com', '17770085046', '南门和怡', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('21', '21', 'gaoyuan20', 'gaoyuan', '465716992@qq.com', '17770085046', '管飞双', 'http://180.97.75.144:8035/hig/201704200123565375.png');
INSERT INTO `user` VALUES ('22', '22', 'gaoyuan21', 'gaoyuan', '465716992@qq.com', '17770085046', '管飞双次', 'http://180.97.75.144:8035/hig/201704200123565375.png');

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='用户详情';

-- ----------------------------
-- Records of userdetail
-- ----------------------------
INSERT INTO `userdetail` VALUES ('1', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('2', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('3', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('4', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('5', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('6', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('7', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('8', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('9', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('10', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('11', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('12', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('13', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('14', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('15', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('16', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('17', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('18', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('19', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('20', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('21', '1', null, null, null, null);
INSERT INTO `userdetail` VALUES ('22', '1', null, null, null, null);
