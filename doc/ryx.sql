/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50527
Source Host           : 127.0.0.1:3306
Source Database       : ryx

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2015-11-26 14:38:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL COMMENT '唯一标识的主键',
  `parentId` int(11) DEFAULT '0' COMMENT '上级编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限资源名称',
  `url` varchar(50) DEFAULT '' COMMENT '访问权限的资源文件路径',
  `type` tinyint(4) DEFAULT '1' COMMENT '权限类型  1 接口 ，2 菜单',
  `describe` varchar(50) DEFAULT '' COMMENT '描述',
  `weight` tinyint(8) DEFAULT '0' COMMENT '同级权限的排序或者显示顺序，值越大，就越靠前显示',
  `status` tinyint(4) DEFAULT '0' COMMENT '1,正常状态，2，取消关注,3默认(首选)状态,4锁定状态(用户锁定)',
  `createTime` varchar(0) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission_name_index` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '0', '权限资源管理', '', '2', '菜单', '0', '1', null, null);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，在文档中对应\nRESID\n',
  `pid` int(11) NOT NULL COMMENT '父节点',
  `class` int(11) NOT NULL DEFAULT '1' COMMENT '用于用户浏览权限分类\\n',
  `type` int(11) NOT NULL COMMENT '资源类型,见文档2.4',
  `name` varchar(45) NOT NULL COMMENT '名称',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '资源状态(可用还是不可用)\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n0不可用，1可用',
  `ord` int(11) NOT NULL DEFAULT '1' COMMENT '排序的编号',
  PRIMARY KEY (`id`),
  KEY `fk_resource_res_class` (`class`),
  KEY `fk_resource_res_type` (`type`),
  CONSTRAINT `fk_resource_res_class` FOREIGN KEY (`class`) REFERENCES `res_class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_resource_res_type` FOREIGN KEY (`type`) REFERENCES `res_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8 COMMENT='资源列表';

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('39', '1', '1', '9', '1号定位点', '39', '1');
INSERT INTO `resource` VALUES ('40', '1', '1', '9', '2号定位点', '40', '1');
INSERT INTO `resource` VALUES ('41', '1', '1', '9', '3号定位点', '41', '1');
INSERT INTO `resource` VALUES ('42', '1', '1', '9', '4号定位点', '42', '1');
INSERT INTO `resource` VALUES ('112', '1', '1', '8', '231-风速', '107', '1');
INSERT INTO `resource` VALUES ('113', '1', '1', '12', '231-SF6', '108', '1');
INSERT INTO `resource` VALUES ('114', '1', '1', '5', '231-空调', '109', '1');
INSERT INTO `resource` VALUES ('115', '1', '1', '6', '231-温湿度', '110', '1');
INSERT INTO `resource` VALUES ('116', '1', '1', '13', '231-氧气', '111', '1');
INSERT INTO `resource` VALUES ('123', '1', '1', '10', '241-水位', '123', '1');
INSERT INTO `resource` VALUES ('124', '1', '1', '2', '241-红外周界', '125', '1');
INSERT INTO `resource` VALUES ('125', '1', '1', '3', '241-烟感', '124', '1');
INSERT INTO `resource` VALUES ('126', '1', '1', '3', '231-烟感', '126', '1');
INSERT INTO `resource` VALUES ('127', '1', '1', '7', '231-灯光', '127', '1');
INSERT INTO `resource` VALUES ('128', '1', '1', '5', 'v1空调', '132', '1');
INSERT INTO `resource` VALUES ('129', '1', '1', '4', 'v1风机', '133', '1');
INSERT INTO `resource` VALUES ('132', '1', '1', '6', 'v1温湿度', '134', '1');
INSERT INTO `resource` VALUES ('150', '1', '1', '6', '232-温湿度', '154', '1');
INSERT INTO `resource` VALUES ('151', '1', '1', '12', '232-SF6', '153', '1');
INSERT INTO `resource` VALUES ('152', '1', '1', '13', '232-O2', '155', '1');
INSERT INTO `resource` VALUES ('153', '1', '1', '7', '232-灯光', '151', '1');
INSERT INTO `resource` VALUES ('154', '1', '1', '4', '232-风机', '152', '1');
INSERT INTO `resource` VALUES ('155', '1', '1', '7', '241-灯光', '89', '1');
INSERT INTO `resource` VALUES ('158', '1', '1', '9', '5号定位点', '45', '1');
INSERT INTO `resource` VALUES ('159', '1', '1', '9', '定位点测试1', '83', '1');
INSERT INTO `resource` VALUES ('163', '1', '1', '5', '232-空调', '157', '1');
INSERT INTO `resource` VALUES ('164', '1', '1', '1', '视频1', '158', '1');
INSERT INTO `resource` VALUES ('165', '1', '1', '1', '视频3', '160', '1');
INSERT INTO `resource` VALUES ('166', '1', '1', '1', '视频2', '159', '1');
INSERT INTO `resource` VALUES ('167', '1', '1', '8', '241-风速', '162', '1');

-- ----------------------------
-- Table structure for res_type
-- ----------------------------
DROP TABLE IF EXISTS `res_type`;
CREATE TABLE `res_type` (
  `id` int(11) NOT NULL COMMENT '资源分类ID',
  `name` varchar(45) NOT NULL COMMENT '资源分类名',
  `state` varchar(10) NOT NULL COMMENT '1:告警规则资源,2:联动动作资源,3:既是告警规则资源也是联动动作资源,4:两者都不是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of res_type
-- ----------------------------
INSERT INTO `res_type` VALUES ('0', '文件夹', '4');
INSERT INTO `res_type` VALUES ('1', '摄像机', '3');
INSERT INTO `res_type` VALUES ('2', '红外周界', '1');
INSERT INTO `res_type` VALUES ('3', '消防', '1');
INSERT INTO `res_type` VALUES ('4', '风机', '2');
INSERT INTO `res_type` VALUES ('5', '空调', '2');
INSERT INTO `res_type` VALUES ('6', '温湿度传感', '1');
INSERT INTO `res_type` VALUES ('7', '灯光', '2');
INSERT INTO `res_type` VALUES ('8', '风速', '1');
INSERT INTO `res_type` VALUES ('9', '人员定位', '2');
INSERT INTO `res_type` VALUES ('10', '水浸', '1');
INSERT INTO `res_type` VALUES ('11', '通用开关量', '2');
INSERT INTO `res_type` VALUES ('12', 'SF6传感器', '1');
INSERT INTO `res_type` VALUES ('13', 'O2传感器', '1');
INSERT INTO `res_type` VALUES ('101', '室外刀闸', '2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识的主键',
  `parentId` int(11) NOT NULL DEFAULT '0' COMMENT '父角色编码',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称 唯一约束，不允许为空',
  `status` tinyint(4) DEFAULT '1' COMMENT '记录状态 1 可用 2 不可用',
  `createTime` varchar(20) DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '记录修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_index` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission_link
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_link`;
CREATE TABLE `role_permission_link` (
  `roleId` int(11) NOT NULL COMMENT '角色唯一标识，外键（与permissionUuid组成联合主键）',
  `permissionId` int(11) NOT NULL COMMENT '权限唯一约束，外键',
  `status` tinyint(4) DEFAULT '1' COMMENT '1 可用 2 不可用',
  `createTime` varchar(20) DEFAULT '',
  `updateTime` varchar(20) DEFAULT '',
  PRIMARY KEY (`roleId`,`permissionId`),
  KEY `role_permissioin_link_permissionUuid` (`permissionId`),
  KEY `role_permission_link_roleid` (`roleId`),
  CONSTRAINT `perId_fk` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`),
  CONSTRAINT `roleId_per_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission_link
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识的主键；不允许为空',
  `loginName` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号(登陆名)唯一约束，不允许为空，用户登陆名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '不允许为空；使用MD5加密后保存',
  `token` varchar(40) DEFAULT '' COMMENT '用户的令牌码token',
  `realName` varchar(20) DEFAULT '' COMMENT '真实姓名',
  `nickname` varchar(20) DEFAULT '' COMMENT '昵称',
  `portraitPath` varchar(50) DEFAULT '' COMMENT '头像图片的相对路径',
  `status` tinyint(8) NOT NULL DEFAULT '1' COMMENT '1,正常状态，2，取消关注(冻结状态),',
  `createTime` varchar(20) NOT NULL DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '记录修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_loginName_index` (`loginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_role_link
-- ----------------------------
DROP TABLE IF EXISTS `user_role_link`;
CREATE TABLE `user_role_link` (
  `userId` bigint(20) NOT NULL COMMENT '用户唯一标识，外键 ',
  `roleId` int(11) NOT NULL COMMENT '角色唯一标识，外键',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态 1 可用  2 不可用 ',
  `createTime` varchar(20) DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '修改时间',
  PRIMARY KEY (`userId`,`roleId`),
  KEY `user_role_link_roleUuid` (`roleId`),
  KEY `user_role_link_userId` (`userId`),
  CONSTRAINT `roleId_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`),
  CONSTRAINT `userId_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_link
-- ----------------------------
DROP TRIGGER IF EXISTS `resource_after_insert`;
DELIMITER ;;
CREATE TRIGGER `resource_after_insert` AFTER INSERT ON `resource` FOR EACH ROW BEGIN
/*
该触发器用于添加资源的时候自动更新相应的编码器、控制器通道，以及定位点的resid
注意：使用了state来传递源表的ID
*/

update eqp_cha set resid=NEW.id where id=NEW.state;


END
;;
DELIMITER ;
