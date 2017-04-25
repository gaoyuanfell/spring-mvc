SELECT * FROM tree WHERE lft BETWEEN 1 AND 18;

-- 查询没有节点
SELECT * FROM tree WHERE rgt = lft + 1

-- 查询子节点到根的路径
SELECT e.* FROM tree as t, tree as e WHERE t.lft BETWEEN e.lft AND e.rgt AND t.title = "Banana" ORDER By e.lft


-- 添加同层次
LOCK TABLE tree WRITE;
SELECT @myRight := rgt FROM tree
WHERE title = 'Banana' AND id = 6;
UPDATE tree SET rgt = rgt + 2 WHERE rgt > @myRight;
UPDATE tree SET lft = lft + 2 WHERE lft > @myRight;
INSERT INTO tree(parent, title , lft, rgt) VALUES('Banana', 'asd', @myRight + 1,@myRight + 2);
UNLOCK TABLES;

-- 添加子节点
LOCK TABLE tree WRITE;
SELECT @myRight := lft FROM tree
WHERE title = 'Banana' AND id = 6;
UPDATE tree SET rgt = rgt + 2 WHERE rgt > @myRight;
UPDATE tree SET lft = lft + 2 WHERE lft > @myRight;
INSERT INTO tree(parent, title , lft, rgt) VALUES('Banana', 'asd', @myRight + 1,@myRight + 2);
UNLOCK TABLES;

-- 删除节点
LOCK TABLE tree WRITE;
SELECT @myLeft := lft, @myRight := rgt, @myWidth := rgt - lft + 1
FROM tree
WHERE title = 'asd';
DELETE FROM tree WHERE lft BETWEEN @myLeft AND @myRight;
UPDATE tree SET rgt = rgt - @myWidth WHERE rgt > @myRight;
UPDATE tree SET lft = lft - @myWidth WHERE lft > @myRight;
UNLOCK TABLES;


/*
Navicat MySQL Data Transfer

Source Server         : moka
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-04-25 18:15:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tree
-- ----------------------------
DROP TABLE IF EXISTS `tree`;
CREATE TABLE `tree` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parent` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `lft` int(11) DEFAULT NULL,
  `rgt` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tree
-- ----------------------------
INSERT INTO `tree` VALUES ('1', null, 'Food', '1', '18');
INSERT INTO `tree` VALUES ('2', 'Food', 'Fruit', '2', '11');
INSERT INTO `tree` VALUES ('3', 'Fruit', 'Red', '3', '6');
INSERT INTO `tree` VALUES ('4', 'Red', 'Cherry', '4', '5');
INSERT INTO `tree` VALUES ('5', 'Fruit', 'Yellow', '7', '10');
INSERT INTO `tree` VALUES ('6', 'Yellow', 'Banana', '8', '9');
INSERT INTO `tree` VALUES ('7', 'Food', 'Meat', '12', '17');
INSERT INTO `tree` VALUES ('8', 'Meat', 'Beef', '13', '14');
INSERT INTO `tree` VALUES ('9', 'Meat', 'Pork', '15', '16');
