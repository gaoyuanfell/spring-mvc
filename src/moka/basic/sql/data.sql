/*
Navicat MySQL Data Transfer

Source Server         : moka
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : moka

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-05-07 21:56:47
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
  `wh` longtext COMMENT 'width*height',
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
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COMMENT='分支';

-- ----------------------------
-- Records of branch
-- ----------------------------
INSERT INTO `branch` VALUES ('19', '4', '风景优美', '风景优美', 'http://127.0.0.1:8082/photo/2017-05-07/65cd901480c5e1558edc1cfad0f2a1bc.jpg,http://127.0.0.1:8082/photo/2017-05-07/5f470b64a8dc0f6e485ee606ed99d046.jpg,http://127.0.0.1:8082/photo/2017-05-07/af8c78719e59c82fbd252fd20985eb6d.jpg,http://127.0.0.1:8082/photo/2017-05-07/fe174d1d2784c7194140957927bfae37.jpg', '1331*887,640*640,612*612,1535*1024', null, null, '0', '2017-05-07 11:36:35', null, '0', '0', '0', '0', '2');

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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='评论';

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '0', '4', '0', '2', '死去的时候世界开始变得沉默，沸腾的心跳开始减弱', '0', '0', '2017-05-07 10:54:13', null, null, '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='用户线路评论';

-- ----------------------------
-- Records of commentrelation
-- ----------------------------
INSERT INTO `commentrelation` VALUES ('1', '5', '1', '0', '0', '17', '0', '0', '1', null, null, null);
INSERT INTO `commentrelation` VALUES ('2', '5', '1', '0', '0', '18', '0', '0', '1', null, null, null);
INSERT INTO `commentrelation` VALUES ('3', '5', '1', '0', '0', '1', '0', '0', '1', null, null, null);
INSERT INTO `commentrelation` VALUES ('11', '1', '1', '0', '4', '0', '0', '0', '1', null, null, null);
INSERT INTO `commentrelation` VALUES ('12', '1', '1', '0', '1', '0', '0', '0', '1', null, null, null);
INSERT INTO `commentrelation` VALUES ('13', '1', '1', '0', '3', '0', '0', '0', '1', null, null, null);
INSERT INTO `commentrelation` VALUES ('14', '1', '1', '0', '2', '0', '0', '0', '1', null, null, null);
INSERT INTO `commentrelation` VALUES ('15', '1', '2', '0', '4', '0', '0', '0', '1', null, null, null);

-- ----------------------------
-- Table structure for image
-- ----------------------------
DROP TABLE IF EXISTS `image`;
CREATE TABLE `image` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `branchId` int(11) DEFAULT NULL COMMENT '分支id',
  `url` varchar(1000) DEFAULT NULL COMMENT '线上地址',
  `path` varchar(1000) DEFAULT NULL,
  `lng` varchar(255) DEFAULT NULL COMMENT '经度',
  `lat` varchar(255) DEFAULT NULL COMMENT '纬度',
  `width` int(11) DEFAULT NULL COMMENT '图片宽',
  `height` int(11) DEFAULT NULL COMMENT '图片高',
  `model` varchar(255) DEFAULT NULL COMMENT '手机型号',
  `make` varchar(255) DEFAULT NULL COMMENT '制造商',
  `time` datetime DEFAULT NULL COMMENT '拍摄时间',
  `fileSize` int(11) DEFAULT NULL COMMENT '文件大小',
  `fileName` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `scope` int(11) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of image
-- ----------------------------
INSERT INTO `image` VALUES ('6', '17', 'http://127.0.0.1:8082/photo/2017-05-04/a45bcaae7a2d324268247bfcf151ee1f.jpg', null, '121.25502', '31.11895', '4160', '3120', 'Smartisan T2', 'Smartisan', '2017-05-03 18:09:43', '6567157', 'a45bcaae7a2d324268247bfcf151ee1f.jpg', '0', '2017-05-04 09:56:47', null, '0');
INSERT INTO `image` VALUES ('7', '18', 'http://127.0.0.1:8082/photo/2017-05-04/52f9782e9961e230313ed4b7370c189d.jpg', null, null, null, '700', '1243', null, null, null, '60153', '52f9782e9961e230313ed4b7370c189d.jpg', '0', '2017-05-04 10:34:33', null, '0');
INSERT INTO `image` VALUES ('8', '18', 'http://127.0.0.1:8082/photo/2017-05-04/d09e827d26fa696b42170cd00a8881b8.jpg', null, null, null, '720', '1280', null, null, null, '126135', 'd09e827d26fa696b42170cd00a8881b8.jpg', '0', '2017-05-04 10:34:33', null, '0');
INSERT INTO `image` VALUES ('9', '18', 'http://127.0.0.1:8082/photo/2017-05-04/9d37488ee96f1c48c5d53d8bb42491e2.jpg', null, null, null, '1080', '1920', null, null, null, '218814', '9d37488ee96f1c48c5d53d8bb42491e2.jpg', '0', '2017-05-04 10:34:33', null, '0');
INSERT INTO `image` VALUES ('10', '18', 'http://127.0.0.1:8082/photo/2017-05-04/404299fac2f44c1a5a2c8b0e8e281698.jpg', null, null, null, '862', '1612', null, null, null, '125941', '404299fac2f44c1a5a2c8b0e8e281698.jpg', '0', '2017-05-04 10:34:33', null, '0');
INSERT INTO `image` VALUES ('11', '18', 'http://127.0.0.1:8082/photo/2017-05-04/4b79c42a54cba349423546ace8cc463f.jpg', null, null, null, '700', '1244', null, null, null, '76113', '4b79c42a54cba349423546ace8cc463f.jpg', '0', '2017-05-04 10:34:33', null, '0');
INSERT INTO `image` VALUES ('12', '18', 'http://127.0.0.1:8082/photo/2017-05-04/69f4ca3b312f9e8fc5cdca93b022b736.jpg', null, null, null, '700', '1167', null, null, null, '22746', '69f4ca3b312f9e8fc5cdca93b022b736.jpg', '0', '2017-05-04 10:34:33', null, '0');
INSERT INTO `image` VALUES ('13', '18', 'http://127.0.0.1:8082/photo/2017-05-04/82a21eed99b3f5e7affce88e3f296212.jpg', null, null, null, '700', '1243', null, null, null, '61565', '82a21eed99b3f5e7affce88e3f296212.jpg', '0', '2017-05-04 10:34:33', null, '0');
INSERT INTO `image` VALUES ('14', '18', 'http://127.0.0.1:8082/photo/2017-05-04/67b613e41db36a99fb664f89589f640a.jpg', null, null, null, '710', '1262', null, null, null, '42480', '67b613e41db36a99fb664f89589f640a.jpg', '0', '2017-05-04 10:34:33', null, '0');
INSERT INTO `image` VALUES ('15', '18', 'http://127.0.0.1:8082/photo/2017-05-04/ff243e7d5ea21c606e79f110e4c7c922.jpg', null, null, null, '279', '419', null, null, null, '12722', 'ff243e7d5ea21c606e79f110e4c7c922.jpg', '0', '2017-05-04 10:34:33', null, '0');
INSERT INTO `image` VALUES ('16', '19', 'http://127.0.0.1:8082/photo/2017-05-07/65cd901480c5e1558edc1cfad0f2a1bc.jpg', '/photo/2017-05-07/65cd901480c5e1558edc1cfad0f2a1bc.jpg', null, null, '1331', '887', null, null, null, '257327', '65cd901480c5e1558edc1cfad0f2a1bc.jpg', '0', '2017-05-07 11:36:35', null, '0');
INSERT INTO `image` VALUES ('17', '19', 'http://127.0.0.1:8082/photo/2017-05-07/5f470b64a8dc0f6e485ee606ed99d046.jpg', '/photo/2017-05-07/5f470b64a8dc0f6e485ee606ed99d046.jpg', null, null, '640', '640', null, null, null, '119355', '5f470b64a8dc0f6e485ee606ed99d046.jpg', '0', '2017-05-07 11:36:35', null, '0');
INSERT INTO `image` VALUES ('18', '19', 'http://127.0.0.1:8082/photo/2017-05-07/af8c78719e59c82fbd252fd20985eb6d.jpg', '/photo/2017-05-07/af8c78719e59c82fbd252fd20985eb6d.jpg', null, null, '612', '612', null, null, null, '85955', 'af8c78719e59c82fbd252fd20985eb6d.jpg', '0', '2017-05-07 11:36:35', null, '0');
INSERT INTO `image` VALUES ('19', '19', 'http://127.0.0.1:8082/photo/2017-05-07/fe174d1d2784c7194140957927bfae37.jpg', '/photo/2017-05-07/fe174d1d2784c7194140957927bfae37.jpg', null, null, '1535', '1024', null, null, null, '592898', 'fe174d1d2784c7194140957927bfae37.jpg', '0', '2017-05-07 11:36:35', null, '0');

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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='线路';

-- ----------------------------
-- Records of line
-- ----------------------------
INSERT INTO `line` VALUES ('1', '1', '告白气球', '塞纳河畔 左岸的咖啡\n我手一杯 品尝你的美\n留下唇印的嘴\n花店玫瑰 名字写错谁\n告白气球 风吹到对街\n微笑在天上飞\n你说你有点难追 想让我知难而退\n礼物不需挑最贵 只要香榭的落叶\n喔 营造浪漫的约会 不害怕搞砸一切\n拥有你就拥有 全世界\n亲爱的 爱上你 从那天起\n甜蜜的很轻易\n亲爱的 别任性 你的眼睛\n在说我愿意\n塞纳河畔 左岸的咖啡\n我手一杯 品尝你的美\n留下唇印的嘴\n花店玫瑰 名字写错谁\n告白气球 风吹到对街\n微笑在天上飞\n你说你有点难追 想让我知难而退\n礼物不需挑最贵 只要香榭的落叶\n喔 营造浪漫的约会 不害怕搞砸一切\n拥有你就拥有 全世界\n亲爱的 爱上你 从那天起\n甜蜜的很轻易\n亲爱的 别任性 你的眼睛\n在说我愿意\n亲爱的 爱上你 恋爱日记\n飘香水的回忆\n一整瓶 的梦境 全都有你\n搅拌在一起\n亲爱的别任性 你的眼睛\n在说我愿意', '0', '1', '0', '0', '2017-05-03 17:07:16', null, '0');
INSERT INTO `line` VALUES ('2', '1', '短歌行', '对酒当歌， 人生几何！\n譬如朝露， 去日苦多。\n慨当以慷， 忧思难忘。\n何以解忧？ 唯有杜康。\n青青子衿， 悠悠我心。\n但为君故， 沉吟至今。\n呦呦鹿鸣， 食野之苹。\n我有嘉宾， 鼓瑟吹笙。\n明明如月， 何时可掇？\n忧从中来， 不可断绝。\n越陌度阡， 枉用相存。\n契阔谈， 心念旧恩。\n月明星稀， 乌鹊南飞。\n绕树三匝， 何枝可依？\n山不厌高， 海不厌深。\n周公吐哺， 天下归心。', '0', '1', '0', '0', '2017-05-06 17:42:16', null, '0');
INSERT INTO `line` VALUES ('3', '1', '长歌行', '青青园中葵，朝露待日晞。\n阳春布德泽，万物生光辉。\n常恐秋节至，焜黄华叶衰。\n百川东到海，何时复西归?\n少壮不努力，老大徒伤悲。', '0', '1', '0', '0', '2017-05-06 17:43:36', null, '0');
INSERT INTO `line` VALUES ('4', '1', '北方的城市', '死去的时候世界开始变得沉默，沸腾的心跳开始减弱。我们开始了怀念，那一幕幕，犹如昨日，苟延残喘的等了很久，还好终究你还是来了。\n\n你不曾明白我对于你的心，假若我能陪你走到生命尽头，我想我是幸福的，是幸运的，可是却是没有如果。\n\n短暂的告别将要为我们的一生画上句号，离别之痛久久不肯散去，滴落的泪水啊，在心头泛滥，苦涩。好久之后，我们还能再次见面？\n\n河水从桥底流过，倒映蓝天白云，羞涩的华年，波光粼粼，迎面的风带走所有，随着流水一一远去。\n\n你说最北的地方会有星河，会有春光和明媚。我放手让你离开，过了这么久，你是否还会记得我。一张迷茫的车票，带着我沿着铁轨，一路北上。\n\n忘记了你的名字，还好我记起了你的样貌。无论黎明，午后，黄昏，黑夜，我泪流满面。\n\n你曾经牵着我的手，你告诉过我，你将不会离我而去，你失言了，而我的心也就破碎了一地。\n\n昏昏沉沉的落日余晖照射在脸上，彼此沉默不言，或许早就猜到，彼此并不是自己的唯一。\n\n我想清楚了，从明天开始做一个为了自己而活着的人，不必理会那些悲伤，痛苦，忧愁，感伤，毕竟要悲伤难过的事情那么多，又何必自寻苦恼。\n\n你的微笑烙在了我的心中，不瞒你说，见到你的第一眼我就喜欢上了你。', '0', '2', '1', '0', '2017-05-06 17:45:44', null, '0');

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
