/*
Navicat MySQL Data Transfer

Source Server         : moka
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : moka

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-05-03 23:12:28
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
  `url` longtext COMMENT '图片地址',
  `lng` varchar(255) DEFAULT NULL COMMENT '纬度',
  `lat` varchar(255) DEFAULT NULL COMMENT '经度',
  `scope` varchar(255) DEFAULT NULL COMMENT '范围',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `praised` int(11) DEFAULT NULL,
  `review` int(11) DEFAULT NULL,
  `privacy` int(11) DEFAULT NULL,
  `userId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='分支';

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO `branch` VALUES ('1', '1', '熊思思', '告白气球', 'http://127.0.0.1:8082/photo/2017-05-03/6dbcdfe2c8bb79e1f565f6e767962d92.jpg,http://127.0.0.1:8082/photo/2017-05-03/f95b1b246870798934113089d4119c39.jpg,http://127.0.0.1:8082/photo/2017-05-03/27e0e8ac64246a4fa728ed6071a17a47.jpg', null, null, '0', '2017-05-03 17:12:08', null, '0', '0', '0', '0', '1');

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
  `review` int(11) DEFAULT NULL COMMENT '评论数,子类为回复数',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL COMMENT '修改时间',
  `state` int(11) DEFAULT NULL COMMENT '状态 1为无效',
  `type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for commentrelation
-- ----------------------------
DROP TABLE IF EXISTS `commentrelation`;
CREATE TABLE `commentrelation` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户线路评论',
  `type` int(11) DEFAULT NULL COMMENT '1-line 2-lineSned 3-comment 4-reply 5-branchId',
  `userId` int(11) DEFAULT NULL,
  `lineSendId` int(11) DEFAULT NULL COMMENT '线路转发id',
  `lineId` int(11) DEFAULT NULL,
  `branchId` int(11) DEFAULT NULL,
  `commentId` int(11) DEFAULT NULL,
  `replyId` int(11) DEFAULT NULL,
  `comType` int(11) NOT NULL COMMENT '1-点赞 2-评论 3-分享',
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户线路评论';

-- ----------------------------
-- Records of commentrelation
-- ----------------------------

-- ----------------------------
-- Table structure for line
-- ----------------------------
DROP TABLE IF EXISTS `line`;
CREATE TABLE `line` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '线路',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `introduce` varchar(1000) DEFAULT NULL COMMENT '简介',
  `privacy` int(11) DEFAULT NULL COMMENT '隐私',
  `praised` int(11) DEFAULT NULL COMMENT '赞',
  `review` int(11) DEFAULT NULL COMMENT '评论',
  `forward` int(11) DEFAULT NULL COMMENT '分享',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='线路';

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('1', '1', '告白气球', '塞纳河畔 左岸的咖啡\n我手一杯 品尝你的美\n留下唇印的嘴\n花店玫瑰 名字写错谁\n告白气球 风吹到对街\n微笑在天上飞\n你说你有点难追 想让我知难而退\n礼物不需挑最贵 只要香榭的落叶\n喔 营造浪漫的约会 不害怕搞砸一切\n拥有你就拥有 全世界\n亲爱的 爱上你 从那天起\n甜蜜的很轻易\n亲爱的 别任性 你的眼睛\n在说我愿意\n塞纳河畔 左岸的咖啡\n我手一杯 品尝你的美\n留下唇印的嘴\n花店玫瑰 名字写错谁\n告白气球 风吹到对街\n微笑在天上飞\n你说你有点难追 想让我知难而退\n礼物不需挑最贵 只要香榭的落叶\n喔 营造浪漫的约会 不害怕搞砸一切\n拥有你就拥有 全世界\n亲爱的 爱上你 从那天起\n甜蜜的很轻易\n亲爱的 别任性 你的眼睛\n在说我愿意\n亲爱的 爱上你 恋爱日记\n飘香水的回忆\n一整瓶 的梦境 全都有你\n搅拌在一起\n亲爱的别任性 你的眼睛\n在说我愿意', '0', '0', '0', '0', '2017-05-03 17:07:16', null, '0');

-- ----------------------------
-- Table structure for linesend
-- ----------------------------
DROP TABLE IF EXISTS `linesend`;
CREATE TABLE `linesend` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '转发线路',
  `lineSendId` int(11) DEFAULT NULL COMMENT '之父关系',
  `lineId` int(11) DEFAULT NULL COMMENT '线路id',
  `context` varchar(1000) DEFAULT NULL COMMENT '转发内容',
  `userId` int(11) DEFAULT NULL COMMENT '用户id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `introduce` varchar(255) DEFAULT NULL COMMENT '简介',
  `privacy` int(11) DEFAULT NULL COMMENT '隐私',
  `praised` int(11) DEFAULT NULL COMMENT '赞',
  `review` int(11) DEFAULT NULL COMMENT '评论',
  `forward` int(11) DEFAULT NULL COMMENT '分享',
  `sort` int(11) DEFAULT NULL COMMENT '排序 展现转发阶梯效果',
  `lft` int(11) DEFAULT NULL COMMENT '左值 排序',
  `rgt` int(11) DEFAULT NULL COMMENT '右值 排序',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `business` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='转发线路';

-- ----------------------------
-- Records of linesend
-- ----------------------------

-- ----------------------------
-- Table structure for reply
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branchId` int(11) DEFAULT NULL COMMENT '线路转发id',
  `lineId` int(11) DEFAULT NULL COMMENT '线路id',
  `lineSendId` int(11) DEFAULT NULL COMMENT '线路转发id',
  `commentId` int(11) DEFAULT NULL COMMENT '评论id',
  `userId` int(11) DEFAULT NULL COMMENT '用户评论id',
  `userToId` int(11) DEFAULT NULL COMMENT '被评论用户id',
  `context` varchar(255) DEFAULT NULL COMMENT '评论内容',
  `praised` varchar(255) DEFAULT NULL COMMENT '点赞数量',
  `createDate` datetime DEFAULT NULL COMMENT '创建时间',
  `updateDate` datetime DEFAULT NULL COMMENT '修改时间',
  `state` int(11) DEFAULT NULL COMMENT '状态 1为无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of reply
-- ----------------------------

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
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='用户';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1', 'admin', 'admin', '465716992@qq.com', '17770085046', 'moka', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('2', '2', 'gaoyuan1', 'gaoyuan', '465716992@qq.com', '17770085046', '小清', 'http://180.97.75.144:8035/hig/201704200233074692.jpg', null, null, null);
INSERT INTO `user` VALUES ('3', '3', 'gaoyuan2', 'gaoyuan', '465716992@qq.com', '17770085046', '小明', 'http://180.97.75.144:8035/hig/201704200234148315.jpg', null, null, null);
INSERT INTO `user` VALUES ('4', '4', 'gaoyuan3', 'gaoyuan', '465716992@qq.com', '17770085046', '小节', 'http://180.97.75.144:8035/hig/201704200234406352.jpg', null, null, null);
INSERT INTO `user` VALUES ('5', '5', 'gaoyuan4', 'gaoyuan', '465716992@qq.com', '17770085046', '小国', 'http://180.97.75.144:8035/hig/201704200234531006.jpg', null, null, null);
INSERT INTO `user` VALUES ('6', '6', 'gaoyuan5', 'gaoyuan', '465716992@qq.com', '17770085046', '完颜香梅', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('7', '7', 'gaoyuan6', 'gaoyuan', '465716992@qq.com', '17770085046', '壤驷瑞锦', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('8', '8', 'gaoyuan7', 'gaoyuan', '465716992@qq.com', '17770085046', '碧鲁海瑶', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('9', '9', 'gaoyuan8', 'gaoyuan', '465716992@qq.com', '17770085046', '仙阳霁', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('10', '10', 'gaoyuan9', 'gaoyuan', '465716992@qq.com', '17770085046', '亓官弘懿', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('11', '11', 'gaoyuan10', 'gaoyuan', '465716992@qq.com', '17770085046', '司马凝远', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('12', '12', 'gaoyuan11', 'gaoyuan', '465716992@qq.com', '17770085046', '闾丘惜萱', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('13', '13', 'gaoyuan12', 'gaoyuan', '465716992@qq.com', '17770085046', '鲍平萱', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('14', '14', 'gaoyuan13', 'gaoyuan', '465716992@qq.com', '17770085046', '訾叶芳', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('15', '15', 'gaoyuan14', 'gaoyuan', '465716992@qq.com', '17770085046', '公孙奇玮', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('16', '16', 'gaoyuan15', 'gaoyuan', '465716992@qq.com', '17770085046', '拓跋吉星', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('17', '17', 'gaoyuan16', 'gaoyuan', '465716992@qq.com', '17770085046', '欧阳浩大', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('18', '18', 'gaoyuan17', 'gaoyuan', '465716992@qq.com', '17770085046', '诸葛慧雅', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('19', '19', 'gaoyuan18', 'gaoyuan', '465716992@qq.com', '17770085046', '万俟碧春', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('20', '20', 'gaoyuan19', 'gaoyuan', '465716992@qq.com', '17770085046', '南门和怡', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('21', '21', 'gaoyuan20', 'gaoyuan', '465716992@qq.com', '17770085046', '管飞双', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);
INSERT INTO `user` VALUES ('22', '22', 'gaoyuan21', 'gaoyuan', '465716992@qq.com', '17770085046', '管飞双次', 'http://180.97.75.144:8035/hig/201704200123565375.png', null, null, null);

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
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8 COMMENT='用户详情';

-- ----------------------------
-- Records of userdetail
-- ----------------------------
INSERT INTO `userdetail` VALUES ('1', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('2', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('3', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('4', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('5', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('6', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('7', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('8', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('9', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('10', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('11', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('12', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('13', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('14', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('15', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('16', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('17', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('18', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('19', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('20', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('21', '1', null, null, null, null, null, null, null);
INSERT INTO `userdetail` VALUES ('22', '1', null, null, null, null, null, null, null);
