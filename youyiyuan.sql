/*
Navicat MySQL Data Transfer

Source Server         : demo
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : youyiyuan

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-12-18 14:19:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address` varchar(255) DEFAULT NULL,
  `add_id` int(11) NOT NULL,
  PRIMARY KEY (`add_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of address
-- ----------------------------
INSERT INTO `address` VALUES ('朝阳区三环以内', '11');
INSERT INTO `address` VALUES ('西城区二环以内', '22');
INSERT INTO `address` VALUES ('昌平区六环以外', '33');

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `a_name` varchar(20) DEFAULT NULL,
  `a_age` int(11) DEFAULT NULL,
  `a_sex` int(11) DEFAULT NULL,
  `a_pwd` varchar(16) DEFAULT NULL,
  `a_phone` varchar(20) DEFAULT NULL,
  `a_email` varchar(20) DEFAULT NULL,
  `a_address` varchar(30) DEFAULT NULL,
  `a_birthday` date DEFAULT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '渣男', '23', '1', '123', '1733987XXXX', '169001475@qq.com', '邓庄', '2019-09-22');

-- ----------------------------
-- Table structure for books
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `b_id` int(11) NOT NULL AUTO_INCREMENT,
  `bname` varchar(20) DEFAULT NULL,
  `bauto` varchar(20) DEFAULT NULL,
  `bk_id` int(11) DEFAULT NULL,
  `b_press` varchar(255) DEFAULT NULL,
  `b_press_time` date DEFAULT NULL,
  `bimg` varchar(255) DEFAULT NULL,
  `bprice` double DEFAULT NULL,
  PRIMARY KEY (`b_id`),
  KEY `FK_Reference_1` (`bk_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`bk_id`) REFERENCES `book_kind` (`bk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', 'C程序设计的抽象思维', '（美国）罗伯茨', '1', '鼓励学生开发强大的软件工程技巧和掌握基础知识', '2004-06-01', '1001.jpg', '69.9');
INSERT INTO `books` VALUES ('2', 'IT不再重要', null, '1', '无', null, '1002.jpg', '56.9');
INSERT INTO `books` VALUES ('3', 'IT产品销售与服务', null, '1', '无', null, '1003.jpg', '55.9');
INSERT INTO `books` VALUES ('4', 'IT行业英语', null, '1', '无', null, '1004.jpg', '49.9');
INSERT INTO `books` VALUES ('5', 'IT架构设计', null, '1', '无', null, '1005.jpg', '78.9');
INSERT INTO `books` VALUES ('6', 'IT经理世界', null, '1', '无', null, '1006.jpg', '76.6');
INSERT INTO `books` VALUES ('7', 'IT素养', null, '1', '无', null, '1007.jpg', '53.6');
INSERT INTO `books` VALUES ('8', 'IT项目管理', null, '1', '无', null, '1008.jpg', '55.9');
INSERT INTO `books` VALUES ('9', 'Java程序员面试宝典', null, '1', '无', null, '1009.jpg', '54.9');
INSERT INTO `books` VALUES ('10', 'Java面向对象编程', null, '1', '无', null, '1010.jpg', '79.9');
INSERT INTO `books` VALUES ('11', 'Spring源码深度解析', null, '1', '无', null, '1011.jpg', '89.9');
INSERT INTO `books` VALUES ('12', '程序员的英语', null, '1', '无', null, '1012.jpg', '66.9');
INSERT INTO `books` VALUES ('13', '大数据时代', null, '1', '无', null, '1013.jpg', '55.9');
INSERT INTO `books` VALUES ('14', '大数据资产化', null, '1', '无', null, '1014.jpg', '100');
INSERT INTO `books` VALUES ('15', '电脑爱好者', null, '1', '无', null, '1015.jpg', '124.9');
INSERT INTO `books` VALUES ('16', '黑客攻防', null, '1', '无', null, '1016.jpg', '119.9');
INSERT INTO `books` VALUES ('17', '简历', null, '5', '无', null, '5001.jpg', '99.9');
INSERT INTO `books` VALUES ('18', 'JavaWeb从入门到精通', null, '2', '入门到精通', null, '2001.jpg', '56.9');
INSERT INTO `books` VALUES ('19', 'JavaWeb应用开发', null, '2', '应用与开发', null, '2002.jpg', '55.9');
INSERT INTO `books` VALUES ('20', '蝴蝶的日记', null, '5', '蝴蝶的日记', null, '5002.jpg', '29.9');
INSERT INTO `books` VALUES ('21', '基于工作任务的JavaWeb', null, '2', '基于工作任务的JavaWeb', null, '2003.jpg', '69.8');
INSERT INTO `books` VALUES ('22', '魔法数学', null, '5', '魔法数学', null, '5003.jpg', '35.5');
INSERT INTO `books` VALUES ('23', '趣味阅读与作文训练', null, '5', '趣味阅读与作文训练', null, '5004.jpg', '42.9');
INSERT INTO `books` VALUES ('24', '深入分析JavaWeb', null, '2', '深入分析JavaWeb', null, '2004.jpg', '59.9');
INSERT INTO `books` VALUES ('25', '同步作文与阅读', null, '5', '同步作文与阅读', null, '5005.jpg', '19.9');

-- ----------------------------
-- Table structure for book_kind
-- ----------------------------
DROP TABLE IF EXISTS `book_kind`;
CREATE TABLE `book_kind` (
  `bk_id` int(11) NOT NULL AUTO_INCREMENT,
  `bk_img` varchar(255) DEFAULT NULL,
  `bk_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`bk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of book_kind
-- ----------------------------
INSERT INTO `book_kind` VALUES ('1', 'java_bk.jpg', 'Java');
INSERT INTO `book_kind` VALUES ('2', 'javaweb_bk.jpg', 'JavaWeb');
INSERT INTO `book_kind` VALUES ('3', 'database_bk.jpg', 'DataBase');
INSERT INTO `book_kind` VALUES ('5', 'fun_bk.jpg', '趣味阅读');
INSERT INTO `book_kind` VALUES ('6', 'say_bk.jpg', '谚语故事');

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `b_id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`),
  KEY `FK_Reference_4` (`b_id`),
  KEY `FK_Reference_5` (`uid`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`b_id`) REFERENCES `books` (`b_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('45', '18', '1', '4');
INSERT INTO `cart` VALUES ('46', '18', '4', '4');
INSERT INTO `cart` VALUES ('47', '18', '3', '8');
INSERT INTO `cart` VALUES ('48', '18', '2', '13');
INSERT INTO `cart` VALUES ('49', '18', '22', '1');
INSERT INTO `cart` VALUES ('50', '18', '25', '1');
INSERT INTO `cart` VALUES ('51', '22', '2', '4');
INSERT INTO `cart` VALUES ('53', '22', '1', '1');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` varchar(255) NOT NULL,
  `otime` datetime DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  `uremark` varchar(255) DEFAULT NULL,
  `state` varchar(10) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`oid`),
  KEY `FK_Reference_6` (`uid`),
  CONSTRAINT `FK_Reference_6` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('0a182786-a2a2-4934-ae29-19ea073b4a7e', '2019-11-23 10:43:02', '22', '请用顺丰', '已提交', '55.9');
INSERT INTO `orders` VALUES ('14e68b46-55bd-42b1-9322-e8f1c5cbf20b', '2019-09-25 22:37:28', '18', null, '已提交', '227.6');
INSERT INTO `orders` VALUES ('16604a31-ce20-4bee-ad57-9d9b68b24c3d', '2019-09-27 20:44:40', '21', '请用顺丰', '已提交', '284.70000000000005');
INSERT INTO `orders` VALUES ('917df43e-68cb-41ca-944e-8036f3ef5230', '2019-11-25 14:49:21', '23', '请用顺丰', '已提交', '569');

-- ----------------------------
-- Table structure for orders_detail
-- ----------------------------
DROP TABLE IF EXISTS `orders_detail`;
CREATE TABLE `orders_detail` (
  `odid` int(11) NOT NULL AUTO_INCREMENT,
  `b_id` int(11) DEFAULT NULL,
  `odcount` int(11) DEFAULT NULL,
  `oid` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`odid`),
  KEY `FK_Reference_7` (`b_id`),
  KEY `FK_Reference_8` (`oid`),
  CONSTRAINT `FK_Reference_7` FOREIGN KEY (`b_id`) REFERENCES `books` (`b_id`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`oid`) REFERENCES `orders` (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders_detail
-- ----------------------------
INSERT INTO `orders_detail` VALUES ('32', '2', '4', '14e68b46-55bd-42b1-9322-e8f1c5cbf20b', null, '227.6');
INSERT INTO `orders_detail` VALUES ('33', '10', '2', '16604a31-ce20-4bee-ad57-9d9b68b24c3d', '朝阳区三环以内', '79.9');
INSERT INTO `orders_detail` VALUES ('34', '15', '1', '16604a31-ce20-4bee-ad57-9d9b68b24c3d', '朝阳区三环以内', '124.9');
INSERT INTO `orders_detail` VALUES ('35', '3', '1', '0a182786-a2a2-4934-ae29-19ea073b4a7e', '朝阳区三环以内', '55.9');
INSERT INTO `orders_detail` VALUES ('36', '18', '10', '917df43e-68cb-41ca-944e-8036f3ef5230', '朝阳区三环以内', '56.9');

-- ----------------------------
-- Table structure for recorder
-- ----------------------------
DROP TABLE IF EXISTS `recorder`;
CREATE TABLE `recorder` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `r_time` datetime DEFAULT NULL,
  `b_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`r_id`),
  KEY `FK_Reference_3` (`b_id`),
  CONSTRAINT `FK_Reference_3` FOREIGN KEY (`b_id`) REFERENCES `books` (`b_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of recorder
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(20) DEFAULT NULL,
  `uage` int(11) DEFAULT NULL,
  `usex` int(11) DEFAULT '1',
  `upwd` varchar(16) DEFAULT NULL,
  `uphone` varchar(20) DEFAULT NULL,
  `uemail` varchar(20) DEFAULT NULL,
  `uaddress` varchar(30) DEFAULT NULL,
  `ubirthday` date DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '令狐冲', '23', '1', 'lhc123', '17339872165', 'lhc@qq.com', '华山', '1970-05-02');
INSERT INTO `user` VALUES ('2', '韦小宝', '24', '1', 'wxb123', '18339872165', 'wxb@qq.com', '皇宫', '1969-07-12');
INSERT INTO `user` VALUES ('3', '郭靖', '22', '1', 'gj123', '15839872165', 'gj@qq.com', '大漠', '1971-05-16');
INSERT INTO `user` VALUES ('4', '乔峰', '26', '1', 'qf123', '13939872165', 'qf@qq.com', '四海为家', '1967-03-02');
INSERT INTO `user` VALUES ('5', '渣男', null, '1', 'abc123', '17339872165', 'zsg@qq.com', '中软', null);
INSERT INTO `user` VALUES ('6', '虚竹', '23', '1', '123', '15639872165', 'xz@qq.com', '梅园', null);
INSERT INTO `user` VALUES ('16', '杨过', '22', '1', '123', '173*********', 'yg@qq.com', '墓地', null);
INSERT INTO `user` VALUES ('17', '小龙女', '20', '0', '123', '158**********', 'xln@qq.com', '墓地', null);
INSERT INTO `user` VALUES ('18', '123', '123', '1', '123', null, null, null, null);
INSERT INTO `user` VALUES ('20', '张三', null, '0', 'Zs@123', '17339872165', '1690014753@qq.com', null, null);
INSERT INTO `user` VALUES ('21', '渣男', null, '0', 'Xyf@123', '17222222222', '1690014753@qq.com', null, null);
INSERT INTO `user` VALUES ('22', '曹操', null, '0', 'caocao@123456', '17339872165', '1690014753@qq.com', null, null);
INSERT INTO `user` VALUES ('23', '渣男', null, '0', 'adb@123456', '17339872165', '1690014753@qq.com', null, null);

-- ----------------------------
-- Table structure for u_resume
-- ----------------------------
DROP TABLE IF EXISTS `u_resume`;
CREATE TABLE `u_resume` (
  `ur_id` int(11) NOT NULL AUTO_INCREMENT,
  `uid` int(11) DEFAULT NULL,
  `u_educational_background` blob,
  `u_work_experience` blob,
  `u_ohter` blob,
  `u_marital` int(11) DEFAULT NULL,
  `u_nation` varchar(10) DEFAULT NULL,
  `u_ico` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ur_id`),
  KEY `FK_Reference_2` (`uid`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`uid`) REFERENCES `user` (`uid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of u_resume
-- ----------------------------
