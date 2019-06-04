/*
Navicat MySQL Data Transfer

Source Server         : 192.168.115.142
Source Server Version : 50022
Source Host           : 127.0.0.1:3306
Source Database       : springcloud_sell

Target Server Type    : MYSQL
Target Server Version : 50022
File Encoding         : 65001

Date: 2019-06-04 15:17:52
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `detail_id` varchar(32) NOT NULL,
  `order_id` varchar(32) NOT NULL,
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '当前价格,单位分',
  `product_quantity` int(11) NOT NULL COMMENT '数量',
  `product_icon` varchar(512) default NULL COMMENT '小图',
  `create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY  (`detail_id`),
  KEY `idx_order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------
INSERT INTO order_detail VALUES ('1234567', '123456', '157875196366160022', '皮蛋粥', '0.01', '2', 'http://', '2019-04-29 11:28:23', '2019-04-29 11:28:23');

-- ----------------------------
-- Table structure for `order_master`
-- ----------------------------
DROP TABLE IF EXISTS `order_master`;
CREATE TABLE `order_master` (
  `order_id` varchar(32) NOT NULL,
  `buyer_name` varchar(32) NOT NULL COMMENT '买家名字',
  `buyer_phone` varchar(32) NOT NULL COMMENT '买家电话',
  `buyer_address` varchar(128) NOT NULL COMMENT '买家地址',
  `buyer_openid` varchar(64) NOT NULL COMMENT '买家微信openid',
  `order_amount` decimal(8,2) NOT NULL COMMENT '订单总金额',
  `order_status` tinyint(3) NOT NULL default '0' COMMENT '订单状态, 默认为新下单',
  `pay_status` tinyint(3) NOT NULL default '0' COMMENT '支付状态, 默认未支付',
  `create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY  (`order_id`),
  KEY `idx_buyer_openid` (`buyer_openid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_master
-- ----------------------------
INSERT INTO order_master VALUES ('1234567', '张三', '13800138000', '朝阳', 'weixinhao111', '2.50', '0', '0', '2019-04-29 11:05:35', '2019-04-29 11:05:35');
INSERT INTO order_master VALUES ('1234568', '张三', '13800138000', '朝阳', 'weixinhao111', '2.50', '0', '0', '2019-04-29 11:06:39', '2019-04-29 11:06:39');
INSERT INTO order_master VALUES ('1557129618402195797', '赵先生', '13800138000', '北京', 'locker777', '5.00', '0', '0', '2019-05-06 16:00:14', '2019-05-06 16:00:14');

-- ----------------------------
-- Table structure for `product_category`
-- ----------------------------
DROP TABLE IF EXISTS `product_category`;
CREATE TABLE `product_category` (
  `category_id` int(11) NOT NULL auto_increment,
  `category_name` varchar(64) NOT NULL COMMENT '类目名字',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NULL default NULL COMMENT '创建时间',
  `update_time` timestamp NULL default NULL COMMENT '修改时间',
  PRIMARY KEY  (`category_id`),
  UNIQUE KEY `uqe_category_type` (`category_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_category
-- ----------------------------
INSERT INTO product_category VALUES ('1', '热榜', '1', '2017-03-28 16:40:22', '2017-11-26 23:39:36');
INSERT INTO product_category VALUES ('2', '好吃的', '2', '2017-03-14 17:38:46', '2017-11-26 23:39:40');

-- ----------------------------
-- Table structure for `product_info`
-- ----------------------------
DROP TABLE IF EXISTS `product_info`;
CREATE TABLE `product_info` (
  `product_id` varchar(32) NOT NULL,
  `product_name` varchar(64) NOT NULL COMMENT '商品名称',
  `product_price` decimal(8,2) NOT NULL COMMENT '单价',
  `product_stock` int(11) NOT NULL COMMENT '库存',
  `product_description` varchar(64) default NULL COMMENT '描述',
  `product_icon` varchar(512) default NULL COMMENT '小图',
  `product_status` int(3) default '0' COMMENT '商品状态,0正常1下架',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY  (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_info
-- ----------------------------
INSERT INTO product_info VALUES ('157875196366160022', '皮蛋粥', '0.01', '38', '好吃的皮蛋粥', '//fuss10.elemecdn.com/0/49/65d10ef215d3c770ebb2b5ea962a7jpeg.jpeg', '0', '1', '2017-03-28 19:39:15', '2017-07-02 11:45:44');
INSERT INTO product_info VALUES ('157875227953464068', '慕斯蛋糕', '10.90', '200', '美味爽口', '//fuss10.elemecdn.com/9/93/91994e8456818dfe7b0bd95f10a50jpeg.jpeg', '0', '1', '2019-04-23 14:15:24', '2017-04-21 10:05:57');
INSERT INTO product_info VALUES ('164103465734242707', '蜜汁鸡翅', '0.02', '900', '好吃', '//fuss10.elemecdn.com/7/4a/f307f56216b03f067155aec8b124ejpeg.jpeg', '0', '2', '2019-05-31 16:02:23', '2017-06-24 19:20:54');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` varchar(32) NOT NULL,
  `username` varchar(32) default '',
  `password` varchar(32) default '',
  `openid` varchar(64) default '' COMMENT '微信openid',
  `role` tinyint(1) NOT NULL COMMENT '1买家2卖家',
  `create_time` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL default '0000-00-00 00:00:00' COMMENT '修改时间',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
